/*
 * matrix.hpp
 *
 *  Created on: Oct 4, 2017
 *      Author: wangpeiyu
 */

#ifndef MATRIX_HPP_
#define MATRIX_HPP_

#endif /* MATRIX_HPP_ */
#include <iostream>
#include<stdlib.h>
#include<math.h>
#include<string>
#include<time.h>

using namespace std;
class matrix1 {

public:
	char **mat;
	int row;
	int col;
	matrix1();
	int getRow();
	int getCol();
	char **getMat();
	char **fillWithZero();
	void printOutTheMatrix();
	void fillWithXs();
	~matrix1();
};
