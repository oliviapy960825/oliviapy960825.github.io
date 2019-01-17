/*
 * lab4CommonProblem.cpp
 *
 *  Created on: Oct 6, 2017
 *      Author: wangpeiyu
 */
/*
 * Lab3wangpeiyu.cpp
 *
 *  Created on: Sep 19, 2017
 *      Author: wangpeiyu
 */
/* name: Wang Peiyu
 * email address: oliviapy@udel.edu
 * office hour of my TA: Eeshita Biswas Friday 10:00-12:00
 */
#include <iostream>
#include<stdlib.h>
#include<math.h>
#include<string>
#include<time.h>
using std::string;
using namespace std;
string problem1(string str, int &length);
int problem2(string str, int length, int strIndex, int number);
string problem3(int number, string hexNumber);
char **problem5(int *row, int *col);
void problem52b(char **arr, int row, int col);
char **problem52c(char **x, int row, int col, int xNumber);
void problem52d(char **x, int row, int col);
int main() {
	srand(time(NULL));
	int length1 = 3;
	string str = "";
	str = problem1("cat", length1);
	cout << str << endl;
	cout << length1 << endl;
	int length2 = 5;
	str = problem1("cover", length2);
	cout << str << endl;
	cout << length2 << endl;
	int length3 = 8;
	str = problem1("balsamic", length3);
	cout << str << endl;
	cout << length3 << endl;
	cout << problem2("6A4C", 4, 4, 0) << endl; //expected output should be 27212
	cout << problem2("A1B2C3", 6, 6, 0) << endl; //expected output should be 10597059
	cout << problem2("A2", 2, 2, 0) << endl; //expected output should be 162
	cout << problem3(590, "") << endl; //expected output should be 24E
	cout << problem3(591, "") << endl; //expected output should be 24F
	cout << problem3(592, "") << endl; //expected output should be 250
	int row = 0;
	int col = 0;
	char **x1;
	x1 = new char*[row];
	for (int i = 0; i < row; i++) {
		x1[i] = new char[col];
	}
	x1 = problem5(&row, &col);
	problem52b(x1, row, col);

	cout << "*********************" << endl;
	char **x2;
	/*x2=new char*[row];
	 for(int i=0;i<row;i++){
	 x2[i]=new char[col];
	 }*/
	x2 = problem52c(x1, row, col, 0);
	problem52d(x2, row, col);
	return 0;
	for (int i = 0; i < row; i++) {
		delete[] x1[i];
	}
	delete[] x2;
	for (int i = 0; i < row; i++) {
		delete[] x2[i];
	}
	delete[] x2;
}

string problem1(string str, int &length) {
	string newStr = "";
	for (int i = 0; i < length; i++) {
		if (str[i] == 'a' || str[i] == 'A' || str[i] == 'e' || str[i] == 'E'
				|| str[i] == 'i' || str[i] == 'I' || str[i] == 'o'
				|| str[i] == 'O' || str[i] == 'u' || str[i] == 'U'
				|| str[i] == 'y' || str[i] == 'Y') {
			newStr = newStr + "ithag" + str[i];
			length += 5;
		} else {
			newStr = newStr + str[i];
		}
	}
	return newStr;
}/*This function is used to modify the input string and the length of that string. It would go over every element of that string to see if the string contains vowels.
 If a character of the string is a vowel, it would add the string "ithag" before that character, and return the new string after modification. It would also add 5 to
 the length of the the string each time it has a vowel character. Since the input parameter length is using call by reference, the change of the length would be stored in
 that variable.
 */
int problem2(string str, int length, int strIndex, int number) {
	if (strIndex <= 0) {
		return number;
	} else {
		if (str[strIndex - 1] == 'A') {
			return problem2(str, length, strIndex - 1,
					(number + 10 * pow(16.0, (length - strIndex))));
		} else if (str[strIndex - 1] == 'B') {
			return problem2(str, length, strIndex - 1,
					(number + 11 * pow(16.0, (length - strIndex))));
		} else if (str[strIndex - 1] == 'C') {
			return problem2(str, length, strIndex - 1,
					(number + 12 * pow(16.0, (length - strIndex))));
		} else if (str[strIndex - 1] == 'D') {
			return problem2(str, length, strIndex - 1,
					(number + 13 * pow(16.0, (length - strIndex))));
		} else if (str[strIndex - 1] == 'E') {
			return problem2(str, length, strIndex - 1,
					(number + 14 * pow(16.0, (length - strIndex))));
		} else if (str[strIndex - 1] == 'F') {
			return problem2(str, length, strIndex - 1,
					(number + 15 * pow(16.0, (length - strIndex))));
		} else {
			return problem2(str, length, strIndex - 1,
					(number
							+ int(str[strIndex - 1] - 48)
									* pow(16.0, (length - strIndex))));
		}
	}
}/*This function is used to convert the hex number to numbers. For characters, A=10, B=11, C=12, D=13, E=14, and F=15,
 and the calculation process is, for example, if the hexnumber is 6A4C (hex value), to convert you’d do the following:
 Cx160 (or 12x160) + 4x161 + Ax162 (or 10x162) + 6x163 = 27212.
 */

string problem3(int number, string hexNumber) {
	if (number <= 0) {
		return hexNumber;
	} else {
		if (number % 16 == 10) {
			return problem3(number / 16, ('A' + hexNumber));
		} else if (number % 16 == 11) {
			return problem3(number / 16, ('B' + hexNumber));
		} else if (number % 16 == 12) {
			return problem3(number / 16, ('C' + hexNumber));
		} else if (number % 16 == 13) {
			return problem3(number / 16, ('D' + hexNumber));
		} else if (number % 16 == 14) {
			return problem3(number / 16, ('E' + hexNumber));
		} else if (number % 16 == 15) {
			return problem3(number / 16, ('F' + hexNumber));
		} else {
			return problem3(number / 16,
					(char('0' + (number % 16)) + hexNumber));
		}
	}
}/* This function uses recursion to convert the number taken from the input parameter to a hexNumber.
 10=’A’, 11=’B’, 12=’C’, etc.) Then divide the int by 16 and repeat the process with the result.
 So, for example, to convert 590 to hex, 590 %16 =14, so E, 590/16=36, 36%16 =4, 36/16=2, 2%16 =2,2/16=0.
 So the resulting hex number (in the form of a string) would be 24E */

char **problem5(int *row, int *col) {
	*row = rand() % 7 + 3;
	*col = rand() % 7 + 3;
	char **x = NULL;
	x = new char*[*row];
	for (int i = 0; i < *row; i++) {
		x[i] = new char[*col];
	}
	for (int i = 0; i < *row; i++) {
		for (int j = 0; j < *col; j++) {
			x[i][j] = '0';
		}
	}
	return x;
}/*
 This problem takes 2 input parameter, one is the number of column, and one is the number of row, and it would
 change the value of the row and the column with 2 randomly generated numbers. Then it will create a matrix using
 them, and fill the newly created matrix with all 0s.
 */

void problem52b(char **arr, int row, int col) {
	for (int i = 0; i < row; i++) {
		for (int j = 0; j < col; j++) {
			cout << arr[i][j] << " ";
		}
		cout << endl;
	}
}/*
 This function is used to print out the content of the matrix. It takes 3 parameters, one is the address of the first value
 in that matrix, the second one is the number of rows in that matrix, and the third one is the number of columns in that matrix.
 It will print out the matrix and return nothing
 */

char **problem52c(char **x, int row, int col, int xNumber) {
	int addRow = rand() % row;
	int addCol = rand() % col;
	if (xNumber >= 5) {
		return x;
	} else {
		if (x[addRow][addCol] != 'x') {
			x[addRow][addCol] = 'x';
			return problem52c(x, row, col, xNumber + 1);

		} else {
			return problem52c(x, row, col, xNumber);
		}
	}
}/*
 This function is used to add 'x's to the previous matrix. It takes 4 parameters, one is the address of the first value of that matrix,
 the second one is the number of rows of that matrix, the third one is the number of columns of that matrix, and the last one is the number
 of 'x's. When the number of 'x's reaches 5, this function will return the matrix. Otherwise it will continue to add 'x's to that matrix randomly.
 however, if the place randomly generated already has an 'x' there, then it will randomly generate another place to add 'x's.
 */

void problem52d(char **x, int row, int col) {
	for (int i = 0; i < row; i++) {
		for (int j = 0; j < col; j++) {
			cout << x[i][j] << " ";
		}
		cout << endl;
	}
}/*This function is used to print out the content of the matrix. It takes 3 parameters, one is the address of the first value
 in that matrix, the second one is the number of rows in that matrix, and the third one is the number of columns in that matrix.
 It will print out the matrix and return nothing
 */

