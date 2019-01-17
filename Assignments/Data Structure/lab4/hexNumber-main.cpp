/*
 * hexNumber-main.cpp
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

int main() {
	transform1 trans(588);
	cout << trans.getNumber() << endl;
	trans.setNumber(589);
	int number = trans.getNumber();
	cout << number << endl;
	cout << trans.intToString(number, "") << endl;
	transform1 trans1(589);
	cout << trans1.getNumber() << endl;
	trans1.setNumber(590);
	number = trans1.getNumber();
	cout << trans1.getNumber() << endl;
	cout << trans1.intToString(number, "") << endl;
	transform1 trans2(590);
	cout << trans2.getNumber() << endl;
	trans2.setNumber(591);
	number = trans2.getNumber();
	cout << number << endl;
	cout << trans2.intToString(number, "") << endl;
	transform1 trans3("6A4B");
	cout << trans3.getString() << endl;
	trans3.setString("6A4C");
	string str = trans3.getString();
	cout << str << endl;
	cout << trans3.stringToInt(str, 4, 4, 0) << endl;
	transform1 trans4("6A4C");
	cout << trans4.getString() << endl;
	trans4.setString("A1B2C3");
	str = trans4.getString();
	cout << str << endl;
	cout << trans4.stringToInt(str, 6, 6, 0) << endl;
	transform1 trans5("A1B2C3");
	cout << trans5.getString() << endl;
	trans5.setString("A2");
	str = trans5.getString();
	cout << str << endl;
	cout << trans5.stringToInt(str, 2, 2, 0) << endl;
	return 0;
}

