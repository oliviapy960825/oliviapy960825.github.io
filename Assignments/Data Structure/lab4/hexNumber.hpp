/*
 * hexNumber.hpp
 *
 *  Created on: Oct 4, 2017
 *      Author: wangpeiyu
 */

#ifndef HEXNUMBER_HPP_
#define HEXNUMBER_HPP_

#include <iostream>
#include<stdlib.h>
#include<math.h>
#include<string>
#include<time.h>
using std::string;
using namespace std;

class transform1 {
	int number;
	string hexNumber;

public:
	transform1(int num);
	transform1(string hexNum);
	int getNumber();
	void setNumber(int num);
	string getString();
	void setString(string hexNum);
	string intToString(int num, string hexNum);
	int stringToInt(string str, int length, int strIndex, int num);

};
#endif /* HEXNUMBER_HPP_ */
