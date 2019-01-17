/*
 * matrix.cpp
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
matrix1::matrix1() {
	col = 0;
	row = 0;
	mat = NULL;
}
int matrix1::getRow() {
	return row;
}
int matrix1::getCol() {
	return col;
}

char **matrix1::getMat() {
	return mat;
}
char **matrix1::fillWithZero() {
	row = rand() % 7 + 3;
	col = rand() % 7 + 3;
	mat = new char *[row];
	for (int i = 0; i < row; i++) {
		mat[i] = new char[col];
	}
	for (int i = 0; i < row; i++) {
		for (int j = 0; j < col; j++) {
			mat[i][j] = '0';
		}
	}
	return mat;
}/*
 This problem takes 2 input parameter, one is the number of column, and one is the number of row, and it would
 change the value of the row and the column with 2 randomly generated numbers. Then it will create a matrix using
 them, and fill the newly created matrix with all 0s.
 */
void matrix1::printOutTheMatrix() {
	for (int i = 0; i < row; i++) {
		for (int j = 0; j < col; j++) {
			cout << mat[i][j] << " ";
		}
		cout << endl;
	}
}/*
 This function is used to print out the content of the matrix. It takes 3 parameters, one is the address of the first value
 in that matrix, the second one is the number of rows in that matrix, and the third one is the number of columns in that matrix.
 It will print out the matrix and return nothing
 */

void matrix1::fillWithXs() {
	int xNumber = 0;
	while (xNumber < 5) {
		int addRow = rand() % row;
		int addCol = rand() % col;
		if (mat[addRow][addCol] != 'x') {
			mat[addRow][addCol] = 'x';
			xNumber += 1;
		}

	}
}/*
 This function is used to add 'x's to the previous matrix. It takes 4 parameters, one is the address of the first value of that matrix,
 the second one is the number of rows of that matrix, the third one is the number of columns of that matrix, and the last one is the number
 of 'x's. When the number of 'x's reaches 5, this function will return the matrix. Otherwise it will continue to add 'x's to that matrix randomly.
 however, if the place randomly generated already has an 'x' there, then it will randomly generate another place to add 'x's.
 */
matrix1::~matrix1() {
	for (int i = 0; i < row; i++) {
		delete[] mat[i];
	}
	delete[] mat;
	cout << "destroying matrix" << endl;

}/*This is a destructor, the use of it is to destruct the matrix created above.*/
