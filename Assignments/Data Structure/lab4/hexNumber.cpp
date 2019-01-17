/*
 * hexNumber.cpp
 *
 *  Created on: Oct 4, 2017
 *      Author: wangpeiyu
 */
#include "hexNumber.hpp"
#include <iostream>
#include<stdlib.h>
#include<math.h>
#include<string>
#include<time.h>
using std::string;
using namespace std;

transform1::transform1(int num) {
	number = num;
}
transform1::transform1(string hexNum) {
	hexNumber = hexNum;
}

int transform1::getNumber() {
	return number;
}
void transform1::setNumber(int num) {
	number = num;
}

string transform1::getString() {
	return hexNumber;
}

void transform1::setString(string hexNum) {
	hexNumber = hexNum;
}
string transform1::intToString(int num, string hexNum) {
	if (num <= 0) {
		return hexNum;
	} else {
		if (num % 16 == 10) {
			return intToString(num / 16, ('A' + hexNum));
		} else if (num % 16 == 11) {
			return intToString(num / 16, ('B' + hexNum));
		} else if (num % 16 == 12) {
			return intToString(num / 16, ('C' + hexNum));
		} else if (num % 16 == 13) {
			return intToString(num / 16, ('D' + hexNum));
		} else if (num % 16 == 14) {
			return intToString(num / 16, ('E' + hexNum));
		} else if (num % 16 == 15) {
			return intToString(num / 16, ('F' + hexNum));
		} else {
			return intToString(num / 16, (char('0' + (num % 16)) + hexNum));
		}
	}
}/*This function is used to convert the hex number to numbers. For characters, A=10, B=11, C=12, D=13, E=14, and F=15,
 and the calculation process is, for example, if the hexnumber is 6A4C (hex value), to convert you’d do the following:
 Cx160 (or 12x160) + 4x161 + Ax162 (or 10x162) + 6x163 = 27212.
 */

int transform1::stringToInt(string str, int length, int strIndex, int num) {
	if (strIndex <= 0) {
		return num;
	} else {
		if (hexNumber[strIndex - 1] == 'A') {
			return stringToInt(str, length, strIndex - 1,
					(num + 10 * pow(16.0, (length - strIndex))));
		} else if (str[strIndex - 1] == 'B') {
			return stringToInt(str, length, strIndex - 1,
					(num + 11 * pow(16.0, (length - strIndex))));
		} else if (str[strIndex - 1] == 'C') {
			return stringToInt(str, length, strIndex - 1,
					(num + 12 * pow(16.0, (length - strIndex))));
		} else if (str[strIndex - 1] == 'D') {
			return stringToInt(str, length, strIndex - 1,
					(num + 13 * pow(16.0, (length - strIndex))));
		} else if (str[strIndex - 1] == 'E') {
			return stringToInt(str, length, strIndex - 1,
					(num + 14 * pow(16.0, (length - strIndex))));
		} else if (str[strIndex - 1] == 'F') {
			return stringToInt(str, length, strIndex - 1,
					(num + 15 * pow(16.0, (length - strIndex))));
		} else {
			return stringToInt(str, length, strIndex - 1,
					(num
							+ int(str[strIndex - 1] - 48)
									* pow(16.0, (length - strIndex))));
		}
	}
}/* This function uses recursion to convert the number taken from the input parameter to a hexNumber.
 10=’A’, 11=’B’, 12=’C’, etc.) Then divide the int by 16 and repeat the process with the result.
 So, for example, to convert 590 to hex, 590 %16 =14, so E, 590/16=36, 36%16 =4, 36/16=2, 2%16 =2,2/16=0.
 So the resulting hex number (in the form of a string) would be 24E */
