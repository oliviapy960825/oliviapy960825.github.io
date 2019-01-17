/*
 * header.hpp
 *
 *  Created on: Sep 21, 2017
 *      Author: wangpeiyu
 */

#ifndef HEADER_HPP_
#define HEADER_HPP_
#include <iostream>
#include<stdlib.h>
#include<math.h>
#include<string>
#include<time.h>

using namespace std;
class arrayFilter {
	int arr;
	int *size;
	int *highValue;
	int *lowValue;
	int filteredArr;
	int windowSize;
public:

	int* fillTheArray(int *size, int *highValue, int *lowValue);
	int* recursion(int newArr[], int size, int highValue, int lowValue);
	int *fillTheArray2(int *size, int *highValue, int *lowValue);
	void printOutTheArray(int arr[], int size);
	int hanningWindow(int arr[], int windowSize);
	int *filteringTheArray(int arr[], int size);
	void printTheGraph(int arr[], int size, int highValue, int lowValue);
};

#endif /* HEADER_HPP_ */
