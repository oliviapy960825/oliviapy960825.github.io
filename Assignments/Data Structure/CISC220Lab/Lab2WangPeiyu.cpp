/* name: Wang Peiyu
 * email address: oliviapy@udel.edu
 * office hour of my TA: Eeshita Biswas Friday 10:00-12:00
 */
#include <iostream>
#include <stdlib.h>
#include <math.h>
#include <string>
#include <time.h>
using std::string;
using namespace std;
string reverseString(string inputString, string outputString);
int sumOfInteger(int inputNum, int sum);
int minNumber(int a[], int size, int minNum);
bool isElfish(string inputString, int stringDigits, bool isE, bool isL,
		bool isF);
bool isPerfect(int inputNum, int sum, int divisor);
int printX(int num, int size);
bool isSwapped(int *a, int *b);
bool isSwapped2(int &a, int &b);
void callByPointerWithInteger(int *g);
void callByReferenceWithInteger(int &a);
void fillTheArray(int a[], int size);
void printOutAnArray(int a[], int size);
void printOutTheSmallest(int a[], int size, int &smallestValue, int &address);
void printOutAllTheAddress(int a[], int size);
void printOutAllTheAddress2(double a[], int size);
int checkTwoArrays(int a[], int b[], int sizeOfA, int sizeOfB, int *sumOfA,
		int *sumOfB);
int main() {
	cout << "Call By Problem 5 test case 1" << endl;
	int k[20];
	fillTheArray(k, 20); //given the input of an empty array k and the size of it, the output should be a randomly filled array k
	cout << "****************************************" << endl;
	cout << "Recursion Problem 1" << endl;
	cout << reverseString("amri", "") << endl; //given the input of the string "amri", the expected output should be "irma"
	cout << reverseString("emma", "") << endl; //given the input of the string "emma", the expected output should be "amme"
	cout << reverseString("love", "") << endl; //given the input of the string "love", the expected output should be "evol"
	cout << "****************************************" << endl;
	cout << "Recursion Problem 2" << endl;
	cout << sumOfInteger(100, 0) << endl; //given the input of the integer 100, the expected output of sum should be 1+0+0=1
	cout << sumOfInteger(210, 0) << endl; //given the input of the integer 210, the expected output of sum should be 2+1+0=3
	cout << sumOfInteger(4567, 0) << endl; //given the input of the integer 4567, the expected output of sum should be 4+5+6+7=22
	cout << "****************************************" << endl;
	cout << "Recursion Problem 3" << endl;
	int a[3];
	a[0] = 1;
	a[1] = 2;
	a[2] = 3;
	cout << minNumber(a, 3, 3) << endl; //given the input of the array a, its size 3 and the last number in the array, the expected output should be the minimum number in this array which is 1
	int b[4];
	b[0] = 5;
	b[1] = 3;
	b[2] = 1;
	b[3] = 7;
	cout << minNumber(b, 3, 7) << endl; //given the input of the array b, its size 3 and the last number in the array, the expected output should be the minimum number in this array which is 1
	int j[5];
	j[0] = -1;
	j[1] = 7;
	j[2] = 5;
	j[3] = 8;
	j[4] = 0;
	cout << minNumber(j, 5, 0) << endl; //given the input of the array j, its size 5 and the last number in the array, the expected output should be the minimum number in this array which is -1
	cout << "****************************************" << endl;
	cout << "Recursion Problem 4" << endl;
	cout << isElfish("whiteleaf", 9, false, false, false) << endl; //given the input string "whiteleaf", its size and the initialized boolean value, the expected output should be true, which is 1
	cout << isElfish("tasteful", 8, false, false, false) << endl; //given the input string "tasteful", its size and the initialized boolean value, the expected output should be true, which is 1
	cout << isElfish("orange", 6, false, false, false) << endl; //given the input string "orange", its size and the initialized boolean value, the expected output should be true, which is 0
	cout << "****************************************" << endl;
	cout << "Recursion Problem 5" << endl;
	cout << isPerfect(6, 0, 1) << endl; //given the input integer, initialized sum which is 0 and the first divisor which is 1, the output should be true, which is 1
	cout << isPerfect(28, 0, 1) << endl; //given the input integer, initialized sum which is 0 and the first divisor which is 1, the output should be true, which is 1
	cout << isPerfect(29, 0, 1) << endl; //given the input integer, initialized sum which is 0 and the first divisor which is 1, the output should be false, which is 0
	cout << "****************************************" << endl;
	cout << "Recursion Problem 6" << endl; //?
	printX(0, 5); //given the input value num and size, the output should be an "x" with 9 rows in total
	cout << endl;
	printX(0, 6); //given the input value num and size, the output should be an "x" with 11 rows in total
	cout << endl;
	printX(0, 7); //given the input value num and size, the output should be an "x" with 13 rows in total
	cout << "****************************************" << endl;
	cout << "Call By Problem 1" << endl;
	srand(time(NULL));
	int c = rand() % 51;
	int d = rand() % 51;
	cout << c << endl;
	cout << d << endl;
	cout << isSwapped(&c, &d) << endl; //if the first number is 13 and the second number is 41, the output should be 0
	cout << c << endl;
	cout << d << endl; //now c=13, d=41
	c = rand() % 51;
	d = rand() % 51;
	cout << c << endl;
	cout << d << endl;
	cout << isSwapped(&c, &d) << endl; //if the first number is 50 and the second number is 34, the output should be 1
	cout << c << endl;
	cout << d << endl; //now c=34, d=50
	c = rand() % 51;
	d = rand() % 51;
	cout << c << endl;
	cout << d << endl;
	cout << isSwapped(&c, &d) << endl; //if the first number is 36 and the second number is 13, the outputs should be 1
	cout << c << endl;
	cout << d << endl; //now c=13,d=36
	cout << "****************************************" << endl;
	cout << "Call By Problem 2" << endl;
	int e = rand() % 51;
	int f = rand() % 51;
	cout << e << endl;
	cout << f << endl;
	cout << isSwapped2(e, f) << endl; //if the first number is 28 and the second number is 39, the output should be 0
	cout << e << endl;
	cout << f << endl; //now e=28, f=39
	e = rand() % 51;
	f = rand() % 51;
	cout << e << endl;
	cout << f << endl;
	cout << isSwapped2(e, f) << endl; //if the first number is 5 and the second number is 26, the output should be 0
	cout << e << endl;
	cout << f << endl; //now e=5, f=26
	e = rand() % 51;
	f = rand() % 51;
	cout << e << endl;
	cout << f << endl;
	cout << isSwapped2(e, f) << endl; //if the first number is 30 and the second number is 9, the output should be 1
	cout << e << endl;
	cout << f << endl; //now e=9, f=30
	cout << "****************************************" << endl;
	cout << "Call By Problem 3" << endl;
	int x = 233;
	cout << &x << endl; //the expected output should be the address of the value stored in x
	callByPointerWithInteger(&x); //the expected output should be the value of x, the address of this value stored in x, and the address of the address that holds the value stored in x
	cout << endl;
	int x1 = 12;
	cout << &x1 << endl; //the expected output should be the address of the value stored in x1
	callByPointerWithInteger(&x1); //the expected output should be the value of x1, the address of this value stored in x1, and the address of the address that holds the value stored in x1
	cout << endl;
	int x2 = 23;
	cout << &x2 << endl; //the expected output should be the address of the value stored in x2
	callByPointerWithInteger(&x2); //the expected output should be the value of x2, the address of this value stored in x2, and the address of the address that holds the value stored in x2
	cout << "****************************************" << endl;
	cout << "Call By Problem 4" << endl;
	int y = 2020;
	cout << y << endl; //the output should be the value of y
	cout << &y << endl; //the output should be the address of y
	callByReferenceWithInteger(y); // the output should be the address and value of the input y
	int y1 = 1122;
	cout << y1 << endl; //the output should be the value of y1
	cout << &y1 << endl; //the output should be the address of y1
	callByReferenceWithInteger(y1); // the output should be the address and value of the input y1
	int y2 = 21;
	cout << y2 << endl; //the output should be the value of y2
	cout << &y2 << endl; //the output should be the address of y2
	callByReferenceWithInteger(y2); // the output should be the address and value of the input y2
	cout << "****************************************" << endl;
	cout << "Call By Problem 5 test case 2" << endl; //is there any possibility that I can fill k, k1 and k2 with different randomly generated number at the same time?
	int k1[20];
	fillTheArray(k1, 20); //given the input of an empty array k1 and the size of it, the output should be a randomly filled array k1
//given the input of an empty array k1 and the size of it, the output should be a randomly filled array k1
	cout << endl;
	cout << "****************************************" << endl;
	cout << "Call By Problem 6" << endl;
	int l[5];
	l[0] = 1;
	l[1] = 2;
	l[2] = 3;
	l[3] = 4;
	l[4] = 5;
	printOutAnArray(l, 5); //given the array l and its size, the expected output should be every element inside the array
	int l1[3];
	l1[0] = 12;
	l1[1] = 20;
	l1[2] = 0;
	printOutAnArray(l1, 3); //given the array l1 and its size, the expected output should be every element inside the array
	int l2[2];
	l2[0] = 1;
	l2[1] = 2;
	printOutAnArray(l2, 2); //given the array l2 and its size, the expected output should be every element inside the array
	cout << "****************************************" << endl;
	cout << "Call By Problem 7" << endl; //the address didn't change
	int ab = -1;
	int ac = -1;
	int m[5];
	m[0] = 7;
	m[1] = 5;
	m[2] = 3;
	m[3] = 9;
	m[4] = 1;
	printOutTheSmallest(m, 5, ab, ac); //given an array and its size and 2 initialized values, the expected output should be the smallest value in this array and its address
	cout << endl;
	int m1[3];
	m1[0] = 3;
	m1[1] = 9;
	m1[2] = 0;
	printOutTheSmallest(m1, 3, ab, ac); //given an array and its size and 2 initialized values, the expected output should be the smallest value in this array and its address
	cout << endl;
	int m2[4];
	m2[0] = 9;
	m2[1] = 2;
	m2[2] = 1;
	m2[3] = 10;
	printOutTheSmallest(m2, 4, ab, ac); //given an array and its size and 2 initialized values, the expected output should be the smallest value in this array and its address
	cout << "****************************************" << endl;
	cout << "Call By Problem 8" << endl;
	int n[4];
	n[0] = 5;
	n[1] = 6;
	n[2] = 10;
	n[3] = 23;
	printOutAllTheAddress(n, 4); //given an array and its size, the expected output should be the addresses of the elements inside the array
	cout << endl;
	int n1[2];
	n1[0] = 0;
	n1[1] = 1;
	printOutAllTheAddress(n1, 2); //given an array and its size, the expected output should be the addresses of the elements inside the array
	cout << endl;
	int n2[3];
	n2[0] = 2;
	n2[1] = 3;
	n2[2] = 4;
	printOutAllTheAddress(n2, 3); //given an array and its size, the expected output should be the addresses of the elements inside the array
	cout << "****************************************" << endl;
	cout << "Call By Problem 9" << endl;
	double o[5];
	o[0] = 2.4;
	o[1] = 3.5;
	o[2] = 4.0;
	o[3] = 5.6;
	o[4] = 1.0;
	printOutAllTheAddress2(o, 5); //given an array and its size, the expected output should be the addresses of the elements inside the array
	cout << endl;
	double o1[4];
	o1[0] = 0.0;
	o1[1] = 0.1;
	o1[2] = 0.2;
	o1[3] = 0.3;
	printOutAllTheAddress2(o1, 4); //given an array and its size, the expected output should be the addresses of the elements inside the array
	cout << endl;
	double o2[3];
	o2[0] = 0.4;
	o2[1] = 0.5;
	o2[2] = 0.6;
	printOutAllTheAddress2(o2, 3); //given an array and its size, the expected output should be the addresses of the elements inside the array
	cout << "****************************************" << endl;
	cout << "Call By Problem 10" << endl;
	int sumOfA = 0;
	int sumOfB = 0;
	int p[3];
	p[0] = 3;
	p[1] = 7;
	p[2] = 12;
	int q[6];
	q[0] = 1;
	q[1] = 2;
	q[2] = 3;
	q[3] = 4;
	q[4] = 5;
	q[5] = 6;
	cout << checkTwoArrays(p, q, 3, 6, &sumOfA, &sumOfB) << endl; //given the 2 arrays and their sizes and 2 initialized numbers, the expected output should be 1
	cout << endl;
	for (int i = 0; i < 3; i++) {
		cout << p[i] << endl;
	}
	cout << endl;
	for (int i = 0; i < 6; i++) {
		cout << q[i] << endl;
	}
	cout << endl;
	cout << sumOfA << endl; //the expected output should be 3+7+12=22
	cout << sumOfB << endl; //the expected output should be 1+2+3+4+5+6=21
	cout << endl;
	int p1[2];
	p1[0] = 1;
	p1[1] = 2;
	int q1[5];
	q1[0] = 1;
	q1[1] = 1;
	q1[2] = 1;
	q1[3] = 1;
	q1[4] = 1;
	cout << checkTwoArrays(p1, q1, 2, 5, &sumOfA, &sumOfB) << endl; //given the 2 arrays and their sizes and 2 initialized numbers, the expected output should be -1
	cout << endl;
	for (int i = 0; i < 2; i++) {
		cout << p1[i] << endl;
	}
	cout << endl;
	for (int i = 0; i < 5; i++) {
		cout << q1[i] << endl;
	}
	cout << endl;
	cout << sumOfA << endl; //the expected output should be 1+2=3
	cout << sumOfB << endl; //the expected output should be 1+1+1+1+1=5
	cout << endl;
	int p2[1];
	p2[0] = 4;
	int q2[4];
	q2[0] = 1;
	q2[1] = 0;
	q2[2] = 3;
	q2[3] = 0;
	cout << checkTwoArrays(p2, q2, 1, 4, &sumOfA, &sumOfB) << endl; //given the 2 arrays and their sizes and 2 initialized numbers, the expected output should be 0
	cout << endl;
	for (int i = 0; i < 1; i++) {
		cout << p2[i] << endl;
	}
	cout << endl;
	for (int i = 0; i < 4; i++) {
		cout << q2[i] << endl;
	}
	cout << endl;
	cout << sumOfA << endl; //the expected output should be 4
	cout << sumOfB << endl; //the expected output should be 1+3=4
	cout << "****************************************" << endl;
	cout << "Call By Problem 5 test case 3" << endl;
	int k2[20];
	fillTheArray(k2, 20); //given the input of an empty array k2 and the size of it, the output should be a randomly filled array k2
string s="";
cout<<s<<"hi"<<endl;
}
string reverseString(string inputString, string outputString) {
	if (inputString == "") {
		return "";
	} else {
		if (inputString.size() == outputString.size()) {
			return outputString;
		} else {
			return reverseString(inputString,
					outputString
							+ inputString[inputString.size()
									- outputString.size() - 1]);
		}
	}
} // this function is used to reverse the input string parameter.
//for example, if the input parameter is amri, the output should be irma
int sumOfInteger(int inputNum, int sum) {
	if (inputNum == 0) {
		return sum;
	} else {
		return sumOfInteger(inputNum / 10,
				(sum + inputNum - (inputNum / 10) * 10));
	}
}/*This function is used to calculate the sum of the digits of a number.
 for example, if the input number is 123, then the output should be 1+2+3=6
 */

int minNumber(int a[], int size, int minNum) {
	if (size < 1) {
		return minNum;
	} else {
		size = size - 1;
		minNum = std::min(minNum, a[size]);
		return minNumber(a, size, minNum);
	}
}/*This function is used to get the minumum number in an array of integers.
 For example, if the input array is {1,2,3,0}, then the output should be 0
 */
bool isElfish(string inputString, int stringDigits, bool isE, bool isL,
		bool isF) {
	if (stringDigits < 0) {
		return (isE && isL && isF);
	} else {
		stringDigits -= 1;
		isE = isE || (inputString[stringDigits] == 'e');
		isL = isL || (inputString[stringDigits] == 'l');
		isF = isF || (inputString[stringDigits] == 'f');
		return isElfish(inputString, stringDigits, isE, isL, isF);
	}
}/*This function is used to check if an input string is "elfish" or not, which means if it contains 'e','l' and 'f' at the same time.
 For example, if the input string is "whiteleaf", the return value should be true, which is 1. If the input value is "orange", the output should be false, which is 0
 */

bool isPerfect(int inputNum, int sum, int divisor) {
	if (divisor >= inputNum) {
		return (inputNum == sum);
	} else {
		if (inputNum % divisor == 0) {
			sum += divisor;
			return isPerfect(inputNum, sum, (divisor + 1));
		} else {
			return isPerfect(inputNum, sum, (divisor + 1));
		}
	}
}/*This function is used to see if an input number is perfect or not. By perfect, it means that the number equals the sum of its divisor (except itself).
 For example, if the input number is 6, the output should be true, which is 1. If the output is 29, the output should be false, which is 0
 */
int printX(int num, int size) {
	if (num == size * 2 - 1) {
		return 1;
	} else {
		char a[100] = " ";
		for (int i = 0; i < size * 2 - 2; i++)
			a[i] = ' ';
		a[num] = '*';
		a[size * 2 - 2 - num] = '*';
		cout << a << endl;
		printX(num + 1, size);
		return 0;

	}
}/*This function is used to print an "X" according to the input number which indicates its size. For example, if the input number is 5, the output should be an "X"
 which has 9 rows in total. If the input number is 6, the output "X" should have a total of 11 rows.
 */

bool isSwapped(int *a, int *b) {
	if (*a > *b) {
		int c = *a;
		*a = *b;
		*b = c;
		return true;
	} else {
		return false;
	}
}/*This function is used to see if the input numbers need to be swapped or not. For example, if the first value is 0 and the second value is 1, then they don't need to
 be swapped and the return value should be false which is 0. If the input numbers are 1 and 0, then they need to be swapped and the return value should be true which is 1
 */
bool isSwapped2(int &a, int &b) {
	if (a > b) {
		int c = a;
		a = b;
		b = c;
		return true;
	} else {
		return false;
	}
}/*This function is used to see if the input numbers need to be swapped or not. For example, if the input numbers are 0 and 1, then they don't need to be swapped, and the
 output should be false which is 0. If the input numbers are 1 and 0, then they need to be swapped which means the output should be true, which is 1.
 */

void callByPointerWithInteger(int *g) {
	cout << *g << endl;
	cout << g << endl;
	cout << &(*g) << endl;
	cout<<*(&g)<<endl;
	cout<<&g<<endl;
}/*This function uses call by pointer to print out the value at that address, the address in the parameter and
 the address of the parameter, which is the address of the address which holds the value. For example, if the input number is *233,
 the value should be 233, the address of the value should be 0x7fff5c64d8b4, while the address of the parameter should be 0x7fff5c64d308
 */
void callByReferenceWithInteger(int &a) {
	cout << &a << endl;
	cout << a << endl;
}/*This function uses call by reference to print out the address and value of the input parameter. For example, if the input value is 2020,
 the address of the value should be 0x7fff5c64d8a8, and the value should be 2020
 */

void fillTheArray(int a[], int size) {
	srand(time(NULL));
	for (int i = 0; i < size; i++) {
		a[i] = rand() % 100;
		cout << a[i] << " ";
	}
	cout << endl;
}/*This function uses call by value to fill an array with randomly generated numbers.
 */

void printOutAnArray(int a[], int size) {
	for (int i = 0; i < size - 1; i++) {
		cout << a[i] << ",";
	}
	cout << a[size - 1] << endl;
}/*This function takes an array as its input parameter, and it will print out the array as a single line with a "," between every two elements
 */

void printOutTheSmallest(int a[], int size, int &smallestValue, int &address) {
	int smallestInArray = a[0];
	for (int i = 0; i < size; i++) {
		smallestInArray = std::min(smallestInArray, a[i]);
	}
	for (int i = 0; i < size; i++) {
		if (a[i] == smallestInArray) {
			address = i;
		}
	}
	smallestValue = smallestInArray;
	cout << smallestValue << endl;
	cout << address << endl;
}/*This function takes an array as its input parameter, and use call by reference. By going through every elements in this array, it will find
 the smallest one in this array and modify the 3rd parameter to be the value of that smallest value and the 4th elements to be the index number of the
 smallest number in the array.
 */

void printOutAllTheAddress(int a[], int size) {
	for (int i = 0; i < size; i++) {
		cout << &a[i] << endl;
	}
}/*This function takes an array as its input parameter and prints out the addresses of every element in that array.
 */

void printOutAllTheAddress2(double a[], int size) {
	for (int i = 0; i < size; i++) {
		cout << &a[i] << endl;
	}
}/*This function takes a double type array as its parameter and prints out the addresses of every element in that array.
 */

int checkTwoArrays(int a[], int b[], int sizeOfA, int sizeOfB, int *sumOfA,
		int *sumOfB) {
	*sumOfA = 0;
	*sumOfB = 0;
	for (int i = 0; i < sizeOfA; i++) {
		*sumOfA += a[i];
	}
	for (int i = 0; i < sizeOfB; i++) {
		*sumOfB += b[i];
	}
	if (*sumOfA > *sumOfB) {
		return 1;
	} else if (*sumOfA == *sumOfB) {
		return 0;
	} else {
		return -1;
	}
}/*This function uses call by pointer, it takes two arrays as its input parameters, and calculate the total of the elements in every array.
 Then it modifies the other two parameters to be the sum of the elements in the two arrays. If the sum of the first array is greater than that
 of the second array, then it returns 1, if they equal to each other, then it returns 0. Otherwise it returns -1. When the third parameter is
 printed out, it should be the sum of the elements inside the first array. When the fourth parameter is printed out, it should be the sum of the
 second array.
 */
