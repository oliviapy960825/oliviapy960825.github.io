/*
 * Lab7main.cpp
 *
 *  Created on: Nov 26, 2017
 *      Author: wangpeiyu
 */


#include <iostream>
#include <stdlib.h>
#include <time.h>
#include <ctime>
#include <fstream>
#include "hashMap.hpp"
#include "makeSeuss.hpp"
#include "hashNode.hpp"

using namespace std;

int main(){
	srand(time(NULL));
	makeSeuss("DrSeuss.txt","h1c1.txt",true,true);//using the first hash function and the first collision handling function to write into the h1c1.txt file
	makeSeuss("DrSeuss.txt","h1c2.txt",true,false);//using the first hash function and the second collision handling function to write into the h1c2.txt file
	makeSeuss("DrSeuss.txt","h2c1.txt",false,true);//using the second hash function and the first collision handling function to write into the h2c1.txt file
	makeSeuss("DrSeuss.txt","h2c2.txt",false,false);//using the second hash function and the second collision handling function to write into the h2c2.txt file
	return 0;
}
