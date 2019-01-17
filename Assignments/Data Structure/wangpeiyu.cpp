
/* Wang Peiyu
 * Eeshita Biswas
 * 8/31/17
 * This file contains functions for lab 1. The functions aren’t necessarily related * in any way other than that they are required for lab 1.
 */
#include <iostream>
#include <stdlib.h>
#include<list>
#include <math.h>
#include<list>
#include<stack>
#include<queue>
using namespace std;
typedef list<int> intList; //list declaration, this list will be used in the function below
bool isPrime(int k); // function declaration
int sum(int a, int b); // function declaration
void leapYear(); // function declaration
void cone(int row); // function declaration
void armstrongNumber(double num); // function declaration
int largestNumber(int a[], int size); // function declaration
void parlindrome(int a[], int size); // function declaration
int digitalRepresentation(intList a); // function declaration

int main() {
	/*cout << "Problem1" << endl << "Hello, world!" << endl;
	cout << "****************************************" << endl;
	cout << "Problem2" << endl;
	cout << isPrime(2) << endl << isPrime(3) << endl << isPrime(4) << endl;
	cout << "****************************************" << endl;
	cout << "Problem3" << endl;
	cout << sum(2, 2) << endl << sum(2, 3) << endl << sum(3, 2) << endl;
	cout << "****************************************" << endl;
	cout << "Problem4" << endl;
	leapYear();
	cout << "****************************************" << endl;
	cout << "Problem5" << endl;
	cone(4);
	cone(5);
	cone(6);
	cout << "****************************************" << endl;
	cout << "Problem6" << endl;
	armstrongNumber(100);
	armstrongNumber(1000);
	armstrongNumber(10000);
	cout << "****************************************" << endl;
	cout << "Problem7" << endl;
	int a[2];
	a[0] = 1;
	a[1] = 2; //create a new array a[2]={1,2}
	cout << largestNumber(a, 2) << endl;
	int b[2];
	b[0] = 2;
	b[1] = 1; //create a new array b[2]={2,1}
	cout << largestNumber(b, 2) << endl;
	int c[5];
	c[0] = 5;
	c[1] = 2;
	c[2] = 3;
	c[3] = 10;
	c[4] = 1; //create a new array c[5]={5,2,3,10,1}
	cout << largestNumber(c, 5) << endl;
	cout << "****************************************" << endl;
	cout << "Problem8" << endl;
	int d[3];
	d[0] = 1;
	d[1] = 2;
	d[2] = 1; //create a new array d[3]={1,2,1}
	parlindrome(d, 3);
	int e[4];
	e[0] = 0;
	e[1] = 2;
	e[2] = 2;
	c[3] = 0; //create a new array e[4]={1,2,2,1}
	parlindrome(e, 4);
	int f[3];
	f[0] = 1;
	f[1] = 2;
	f[2] = 3; //create a new array f[3]={1,2,3}
	parlindrome(f, 3);
	cout << "****************************************" << endl;
	cout << "Problem9" << endl;
	intList g;
	g.push_back(1);
	g.push_back(2);
	g.push_back(3); //create a new list g={1,2,3}
	cout << digitalRepresentation(g) << endl;
	intList h;
	h.push_back(3);
	h.push_back(2);
	h.push_back(1); //create a new list h={3,2,1}
	cout << digitalRepresentation(h) << endl;
	intList i;
	i.push_back(3);
	i.push_back(2);
	i.push_back(1);
	i.push_back(0); //create a new list i={3,2,1,0}
	cout << digitalRepresentation(i) << endl;
	cout << "****************************************" << endl;
	string s1 = "mug";
		       string *s2= &s1;
		       s1 = "wump";
		cout << *s2 << endl;
		*s2 = "glub";
		cout << s1 << endl;
		int a1=12;
		cout<<&a1<<endl;
		int *b1=&a1;
		cout<<b1<<endl;
		cout<<&b1<<endl;
		int *d1=b1;
		cout<<d1<<endl;
		*d1=4;
		cout<<a1<<endl;
		cout<<*b1<<endl;*/
	string a="able";
	string b="absorbed";
	bool isGreater=a<b;
	cout<<isGreater<<endl;
}

bool isPrime(int k) {
	int a = k - 1;
	int sum = 0;
	if (k < 2) {
		return false;
	} else if (k == 2) {
		return true;
	} else {
		while (a > 1) {
			if (k % a == 0) {
				sum++;
			}
			a--;
		}
		if (sum == 0) {
			return true;
		} else {
			return false;
		}
	}
} //This function has a parameter whose type is integer, and the purpose
//of it is to check if this parameter is a prime number. The return type
//is boolean, and if the input number is a prime number, it should return
//true, otherwise return false. In conclusion, this function is to check
//if the input parameter is a prime number or not.

int sum(int a, int b) {
	int start;
	int end;
	int sum = 0;
	if (a >= b) {
		start = b;
		end = a;
	} else {
		start = a;
		end = b;
	}
	while (start < end) {
		sum +=start;
		start++;
	}
	return sum;
} //This function takes 2 parameters whose types are integers, and the purpose
//of it is to calculate the total of the numbers between these two parameters.
//The return type is int, and it should return the total of numbers between the
//two parameters.

void leapYear() {
	int start = 2017;
	int end = 2417;
	while (start <= end) {
		if (start % 4 == 0) {
			if (start % 100 == 0) {
				if (start % 400 == 0) {
					cout << start << endl;
				}
			}
			cout << start << endl;
		}
		start++;
	}
} //This function takes no parameter and return nothing. Instead, it will check
//the leap years between 2017 and 2417, and print all the leap years.

void cone(int row) {
	int maxWidth = row * 2 - 1;
	int start = 1;
	while (start < row) {
		if (start == 1) {
			for (int i = 1; i <= maxWidth / 2; i++) {
				cout << " ";
			}
			cout << 1;
			for (int b = maxWidth / 2 + 1; b <= maxWidth; b++) {
				cout << " ";
			}
			start++;
			cout << endl;
		}

		else {
			for (int i = 1; i <= row - start; i++) {
				cout << " ";
			}

			cout << start;
			for (int a = 1; a <= maxWidth - (row - start) * 2 - 2; a++) {
				cout << " ";
			}
			cout << start;
			for (int j = maxWidth - start; j <= maxWidth; j++) {
				cout << " ";
			}
			start++;
			cout << endl;
		}
	}
	while (start == row) {
		for (int a = 1; a <= maxWidth; a++) {
			cout << row;
		}
		start++;
	}
	cout << endl;
} //This function takes an integer type input parameter, and the purpose
//of this parameter is to determine the rows of the cone. It returns nothing.
//Instead, it will just print the cone as required.
void armstrongNumber(double num) {
	double a;

	for (int j = 1; j <= num; j++) {
		double total = 0;
		double p = 1;
		int l = j;
		while (l /= 10) {
			p++;
		}
		double d = p;
		int k = j;
		for (int i = 1; i <= d; i++) {
			a = k % 10;
			total += pow(a, d);
			k /= 10;
		}
		if ((double) j == total)
			cout << j << endl;
	}
} //This function takes a double type input parameter, and the purpose of this
//parameter is to tell the end of this function. It returns nothing. Instead,
//it will print out all the armstrong numbers between 1 and the input parameter.

int largestNumber(int a[], int size) {
	int largeNumber = a[0];
	for (int i = 0; i < size; i++) {
		if (a[i] >= largeNumber) {
			largeNumber = a[i];
		}
	}
	return largeNumber;
} //This function takes an array as its input parameter. The purpose of it is to
//go through this array and find the largest integer in this array. The return type
//of this function is integer, and it should be the largest integer in this array.
//In conclusion, this function is used to find the largest number in an integer type array.

void parlindrome(int a[], int size) {
	int b[size];
	int num=1;
	for (int i = 0; i < size; i++) {
		b[i] = a[size - 1 - i];
	}
	for (int i = 0; i < size; i++) {
		if (b[i] != a[i]) {
			num++;
		}
		else{
			num+=0;
		}
	}
	if (num == 1) {
		cout << true << endl;
	} else {
		cout << false << endl;
	}
} //This function takes an array as its input parameter. The purpose of it is to
//check if this array is a parlindrome one or not. It returns nothing. Instead, it
//will print true if the input is a parlindrome one. Otherwise it will print false.

int digitalRepresentation(intList a) {
	int num = a.size() - 1;
	int total = 0;

	intList::iterator i;
	for (i = a.begin(); i != a.end(); i++) {
		total += (*i) * pow(10, num);
		num--;
	}
	return total;
} //This function takes a linked list as its input parameter. The purpose of it is to
//go through this list and present the result as the digital representation of the combination
//of the digits in this list. The return type of it is integer. The purpose of this function
//is to get the digital edition of the combination of the integers in this list.





