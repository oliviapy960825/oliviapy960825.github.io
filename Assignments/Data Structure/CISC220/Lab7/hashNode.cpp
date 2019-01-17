/*
 * hashNode.cpp
 *
 *  Created on: Nov 26, 2017
 *      Author: wangpeiyu
 */
#include "hashNode.hpp"
#include <iostream>
#include <string>
using namespace std;

hashNode::~hashNode() {
	delete[] values;
}//This is the destructor for hashNode

hashNode::hashNode() {
	keyword = "";
	values = NULL;
	valuesSize = 0;
	currSize = 0;
}//This is the constructor with no parameters for hashNode, it initialize the keyword of hashNode to "", and the values to be NULL
//then it sets valuesSize and currentSize to 0

hashNode::hashNode(string s) {
	keyword = s;
	values = new string[100];
	valuesSize = 100;
	currSize = 0;
}//This is the constructor with one string type parameter s for hashNode, it initialize the keyword to be s
//and make the values an array with the size of 50, then it sets the valuesSize to be 50 and the currSize to be 0

hashNode::hashNode(string s, string v) {
	keyword = s;
	values = new string[100];
	values[0] = v;
	valuesSize = 100;
	currSize = 1;
}//This is the constructor with 2 string type parameters s and v. It initialize the keyword to be s and the values
//to be an array with the size of 50. Then it sets the first value in the values array to be v. After that it sets
//the valuesSize to be 50 and the currSize to be 1

void hashNode::addValue(string v) {
	if (currSize >= valuesSize)
		dblArray();

	values[currSize] = v;
	currSize++;
}//This is the add value function for hashNode. It takes a string type parameter v, and check if the currSize is greater
//than or equal to 70% of the total size of the values array. If yes, then it will double the array first, then add new value
//v into the current array

void hashNode::dblArray() {
	valuesSize *= 2;
	string *tmpArr = new string[valuesSize];
	for (int i = 0; i < currSize; i++)
		tmpArr[i] = values[i];
	delete[] values;
	values = tmpArr;
}//This is the double array function for hashNode, what it does is to double the current valueSize, and create a new array which has
//the size of the new valueSize. Then it copies everything in the previous values array into the new value array and delete the previous array

string hashNode::getRandValue() {
	if (currSize > 0) {
		return values[rand() % currSize];
	} else {
		cout << 0 << endl;
		return string();
	}
}//This is the getRandValue function for hashNode, what it does is to return a random value from the values array, and if the values array is
//empty, it will return an empty string.
