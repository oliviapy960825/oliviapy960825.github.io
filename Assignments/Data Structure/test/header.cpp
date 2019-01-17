/*
 * header.cpp
 *
 *  Created on: Oct 9, 2017
 *      Author: wangpeiyu
 */


#include "header.hpp"
#include <iostream>
#include<stdlib.h>
#include<math.h>
#include<string>
#include<time.h>
using std::string;
using namespace std;

MyClass::MyClass(int x,string s) {
i = x;
j = s; }
MyClass::~MyClass() {
       cout << j;
}

