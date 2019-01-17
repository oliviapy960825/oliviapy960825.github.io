/*
 * hashMap.cpp
 *
 *  Created on: Nov 26, 2017
 *      Author: wangpeiyu
 */
#include "hashMap.hpp"
#include <iostream>
#include <string>
#include <stdio.h>
#include <math.h>
using namespace std;

hashMap::~hashMap() {
	for (int i = 0; i < mapSize; i++)
		delete map[i];
	delete[] map;
}//This is the destructor for hashMap

hashMap::hashMap(bool hash1, bool coll1) {
	mapSize = 89;
	map = new hashNode *[mapSize];
	for (int i = 0; i < mapSize; i++) {
		map[i] = NULL;
	}
	first="You're";
	numKeys = 0;
	h1 = hash1;
	c1 = coll1;
	collisionct1 = 0;
	collisionct2 = 0;
} // when creating the map, make sure you initialize the values to NULL so you know whether that index has a key in it or not already.  The Boolean values initialize the h1 and the c1 boolean values, making it easier to control which hash and which collision methods you use.
//This is the constructor for hashMap. It has 2 parameters, one is hash1 and one is coll1. Basically it initialize the fields of hashMap.
//It sets the mapSize to 37, and create a whole double array named map. Then it sets the first to "You're", the number of keys to 0, h1 to hash1, and c1 to coll1,
//collisionct1 to 0 and collisionct2 to 0.

void hashMap::addKeyValue(string k, string v) {
	int i = getIndex(k);

	if (map[i] == NULL) {
		map[i] = new hashNode(k);
		numKeys++;
	}
	map[i]->addValue(v);

	return;

}
// adds a node  to the map at the correct index based on the key string, and then inserts the value into the value field of the hashNode
// Must check to see whether there's a node at that location.  If there's nothing there (it's NULL), add the hashNode with the keyword and value.
// If the node has the same keyword, just add the value to the list of values.
//If the node has a different keyword, keep calculating a new hash index until either the keyword matches the node at that index's keyword, or until the
// map at that index is NULL, in which case you'll add the node there.
//This method also checks for load, and if the load is over 70%, it calls the reHash method to create a new longer map array and rehash the values
//if h1 is true, the first hash function is used, and if it’s false, the second is used.
//if c1 is true, the first collision method is used, and if it’s false, the second is used

int hashMap::getIndex(string k) {
	if (numKeys > 0.7 * mapSize)
		reHash();
	//cout<<mapSize<<endl;
	int total;
	int index;
	if (h1 == true) {
		total = calcHash(k);
	} else {
		total = calcHash2(k);
	}
	index = total % mapSize;

	if (map[index] != NULL && map[index]->keyword != k){
		collisionct1++;}
	int count=1;
	while (map[index] != NULL && map[index]->keyword != k) {
		if (c1 == true) {
					//cout<<"index:"<<index<<endl;
					index = collHash1(index, k);

				} else {
					index = collHash2(index, count);
					count++;
				}
	        if (map[index] != NULL && map[index]->keyword != k)
	        // collisions caused by collision methods, ignore reHash()
	            collisionct2 ++;
	    }
	return index;
} // uses calcHash and reHash to calculate and return the index of where the keyword k should be inserted into the map array
//This is the getIndex function of hashMap. First of all, it will check if the map is 70% or more full. If so, it will call the rehash function
//and rehash the map to make sure there will be enough room for new values. Then it will calculate the index for the new key depending on
//which hashing function it will use. After getting the index, it will see if there is already something in the map at that index, if yes, it will
//increase the original collision count, and handle the collision depending on which collision handling function it is using. If after the collision handling function,
//the index returned is still occupied by some values, it will increase the secondary collision count.If no, it will add the key to that index.


int hashMap::calcHash(string k) {
	int h = 0;
	for (int i = 0; i < (int) k.size(); i++)
		h = (31 * h + k[i]) % mapSize;
	return h;
}//this is the first hashing function,
// Compute h(k) = (k[0] + 29*k[1] + 29^2*k[2] + ...) % n using Horner's rule

int hashMap::calcHash2(string k) {
	int h = 0;
	for (int i = 0; i < (int) k.size(); i++)
		h = (h+k[i]) % mapSize;
	return h;
}//This is the second hashing function,
// Compute h(k) = (k[0] + k[1] + k[2] + ...) % n


void hashMap::getClosestPrime() {
	for (int n = mapSize * 2 - 1; n > mapSize; n -= 2) {
	        bool not_prime = false;
	        for (int i = 2; i * i <= n; i++)
	            if (n % i == 0) {
	                not_prime = true;
	                break;
	            }
	        if (!not_prime) {
	            mapSize = n;
	            return;
	        }
	    }
} // I used a binary search on an array of prime numbers to find the closest prime to double the map Size, and then set mapSize to that new prime.  You can include as one of the fields an array of prime numbers, or you can write a function that calculates the next prime number.  Whichever you prefer.
//this function is used to get the smallest prime number which is a little bigger than double the number of the current map size.


void hashMap::reHash() {
	int previousMapSize = mapSize;
	getClosestPrime();
	hashNode **newHashMap = map;
	map = new hashNode *[mapSize];
	for (int i = 0; i < mapSize; i++) {
		map[i] = NULL;
	}
	collisionct1 = 0;
	collisionct2 = 0;
	for (int i = 0; i < previousMapSize; i++) {
		if (newHashMap[i] != NULL) {
			string keyword1 = newHashMap[i]->keyword;
			int newIndex = getIndex(keyword1);
			map[newIndex] = newHashMap[i];
		}
	}
} // when size of array is at 70%, double array size and rehash keys
//This is the rehash function, create a brand new map and hash everything over depending on the hashing function it is using.

int hashMap::collHash1(int i, string k) { //Linear probing
	//cout<<"i:"<<i<<endl;
			//cout<<"i:"<<i<<endl;
	//cout<<i<<endl;
	return ++i%mapSize;
} // getting index with collision method 1 (note – you may modify the parameters if you don’t need some/need more)

int hashMap::collHash2(int i, int count) {//Quadratic Probing
			i=(int)((float)i+pow((float)count,2))%mapSize;
return i;
} // getting index with collision method 2 (note – you may modify the parameters if you don’t need some/need more)

int hashMap::findKey(string k) {
	int h;
	int i;
	if(h1==true){
		h=calcHash(k);
	}
	else{
		h=calcHash2(k);
	}
	i = h % mapSize;
	int count = 0;
	int c=1;
	while ((map[i] == NULL || map[i]->keyword != k) && ++count < mapSize) {
		if(c1==true){
			i=collHash1(i, k);
		}
		else{
			i=collHash2(i, c);
			c++;
		}
	}
	if(count<mapSize){
		return i;
	}
	else{
		return -1;
	}
} //finds the key in the array and returns its index.  If it's not in the array, returns -1

void hashMap::printMap() {
	cout << "%%%%%%%%%" << endl;
	cout << "mapSize: " << mapSize << endl;
	cout << "numKeys: " << numKeys << endl;
	for (int i = 0; i < mapSize; i++) {
		cout << i << " : ";
		if (map[i] == NULL)
			cout << "None";
		else {
			cout << map[i]->keyword << ": ";
			for (int j = 0; j < map[i]->currSize; j++) {
				if (j > 0)
					cout << " ,";
				cout << map[i]->values[j];
			}
		}
		cout << endl;
	}
	cout << "%%%%%%%%%" << endl;
	if(h1==true){
	cout<<"The number of the original collisions using hashing function 1 is: "<<collisionct1<<endl;
	}
	else{
	cout<<"The number of the original collisions using hashing function 2 is: "<<collisionct1<<endl;
	}
	if(c1==true){
	cout<<"The number of the secondary collisions using collision handling function 1 is: "<<collisionct2<<endl;
	}
	else{
	cout<<"The number of the secondary collisions using collision handling function 2 is: "<<collisionct2<<endl;
	}
}
//this function is used to print out the whole map, I added more print-out lines after the whole map so I can know
//how many original collisions and secondary collisions there are, and which hashing function and collision handling
//function it is using.
