/*
 * header.cpp
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
int *arrayFilter::fillTheArray(int *size, int *highValue, int *lowValue) {
	srand(time(NULL));
	*size = rand() % 25 + 25;
	int* newArr = new int[*size];
	//int &Arr[]=*newArr;
	*highValue = rand() % 5 + 5;
	*lowValue = rand() % 5 - 10;
	for (int i = 0; i < *size; i++) {
		newArr[i] = rand() % (*highValue - *lowValue) - abs(*lowValue);
	}
	return newArr;
}/*This function takes into 3 parameters, one is the length of the array, the other two are the high
 value and the low value which will be randomly generated inside this function. This function will
 generate the size of this array and fill the array with randomly generated values between the high value
 and low value. Then it will return the entire array
 */
int *arrayFilter::recursion(int newArr[], int size, int highValue,
		int lowValue) {
	if (size < 0) {
		return newArr;
	} else {
		newArr[size - 1] = rand() % (highValue - lowValue) - abs(lowValue);
		return recursion(newArr, size - 1, highValue, lowValue);
	}
}
/*This function is the recursion part which will be used to replace the loop in the first question. It takes
 * 4 parameters, the array, the size of the array, the highValue and the lowValue from the fillTheArray2 function
 * It will call this recursion over and over again to fill the array.
 */
int *arrayFilter::fillTheArray2(int *size, int *highValue, int *lowValue) {
	srand(time(NULL));
	*size = rand() % 25 + 25;
	int *newArr = new int[*size];
	*highValue = rand() % 5 + 5;
	*lowValue = rand() % 5 - 10;
	int *newArray = new int[*size];
	newArray = recursion(newArr, *size, *highValue, *lowValue);
	return newArray;
}/*This function is the main part of the part 1 question 2. It will take in 3 parameters, which are the size of the
 array, the highValue of this array and the lowValue of this array. Inside this function, the size, highValue and the lowValue
 will be randomly generated, and it will fill the array with randomly generated numbers. After that, it will return this array.
 */

void arrayFilter::printOutTheArray(int arr[], int size) {
	for (int i = 0; i < size; i++) {
		cout << arr[i] << " ";
	}
}/*This function takes two parameters, one is the array and the other is the size of the array. Then it will print the array
 */

int arrayFilter::hanningWindow(int arr[], int windowSize) {
	int weights = 0;
	int weightedValue = 0;
	for (int i = 0; i < windowSize / 2; i++) {
		weightedValue += arr[i] * (i + 1);
		weights += (i + 1);
	}
	for (int i = windowSize / 2; i < windowSize; i++) {
		weightedValue += arr[i] * (windowSize - i);
		weights += (windowSize - i);
	}
	weightedValue = weightedValue / weights;
	return weightedValue;
}
/*This function takes two parameters, one is the part of the array you want to screen, the other is the window size of this window
 * This function will take in the part of the array you put in and find all the numbers you want to put in the window, then it will
 * calculate the weighted total of them, and the weights, then it will generate the weighted average using the weighted total divided
 * by the weights
 */

int *arrayFilter::filteringTheArray(int arr[], int size) {
	int *newArr = new int[size];
	int windowSize = 3;
	for (int i = 0; i < size; i++) {
		if (i == 0) {
			newArr[i] = 0;
		} else if (i == size - 1) {
			newArr[i] = 0;
		} else {
			newArr[i] = hanningWindow(&arr[i - 1], 3);
		}
	}
	return newArr;
}
/*This function takes 2 parameters, one is the array you want to filter using the hanning window, and one is the size of that array.
 * This function will create a new array to store the filtered array. The first and last elements of this filtered array will be 0,
 * others will be the number it gets using the hanning window function with a size of 3.
 */
void arrayFilter::printTheGraph(int arr[], int size, int highValue,
		int lowValue) {
	for (int i = -9; i < 10; i++) {
		cout << i;
		for (int j = 0; j < size; j++) {
			if (arr[j] == i) {
				cout << "*";
			} else {
				cout << " ";
			}
		}
		cout << endl;
	}
	cout << endl;
	int *newArr = new int[size];
	newArr = filteringTheArray(arr, size);
	for (int i = -9; i < 10; i++) {
		cout << i;
		for (int j = 0; j < size; j++) {
			if (newArr[j] == i) {
				cout << "*";
			} else {
				cout << " ";
			}
		}
		cout << endl;
	}
}
/*This function takes 4 parameters, one is the array you want to print the graph for, one is the size of that array, one is the
 * high value of that array and the last one is the low value of that array. It will print out a graphy of the array you take in,
 * and another graphy for the array after the filtering.
 */
