/*
 * matrix-main.cpp
 *
 *  Created on: Oct 6, 2017
 *      Author: wangpeiyu
 */
#include "matrix.hpp"
#include <iostream>
#include<stdlib.h>
#include<math.h>
#include<string>
#include<time.h>
using std::string;
using namespace std;
int main() {
	matrix1 *mat1 = new matrix1();
	int row = mat1->getRow();
	int col = mat1->getCol();
	char **mat = mat1->getMat();
	cout << row << endl;
	cout << col << endl;
	cout << mat << endl;
	mat = mat1->fillWithZero();
	mat1->printOutTheMatrix();
	mat1->fillWithXs();
	mat1->printOutTheMatrix();
	return 0;
	delete mat1;
}
