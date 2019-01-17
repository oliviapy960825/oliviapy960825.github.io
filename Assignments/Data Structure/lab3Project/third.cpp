/*
 * third.cpp
 *
 *  Created on: Sep 21, 2017
 *      Author: wangpeiyu
 */
#include "header.hpp"
#include <iostream>
#include<stdlib.h>
#include<math.h>
#include<string>
#include<time.h>

using namespace std;
int main() {
	arrayFilter* newHeader = new arrayFilter();
	int highValue = 0;
	int lowValue = 0;
	int size = 0;
	int *x;
	x = newHeader->fillTheArray(&size, &highValue, &lowValue);
	cout << highValue << endl;
	cout << lowValue << endl;
	newHeader->printOutTheArray(x, size);
	cout << endl;
	x = newHeader->fillTheArray2(&size, &highValue, &lowValue);
	cout << highValue << endl;
	cout << lowValue << endl;
	newHeader->printOutTheArray(x, size);
	cout << endl;
	int *newArray;
	newArray = newHeader->filteringTheArray(x, size);
	newHeader->printOutTheArray(newArray, size);
	cout << endl;
	newHeader->printTheGraph(x, size, highValue, lowValue);
	delete []x;
	delete []newArray;
}

