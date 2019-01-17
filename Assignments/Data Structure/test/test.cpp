/*
 * test.cpp
 *
 *  Created on: Oct 9, 2017
 *      Author: wangpeiyu
 */
#include <iostream>
#include <stdlib.h>
#include<list>
#include <math.h>
#include<list>
#include<stack>
#include<queue>
using namespace std;
using std::string;
void arrfunc2(char *arr, char arr2[], int x);
char *arrfunc(char arr[], int &x);
int main(){
	char a[] = {'a','h','p','o','r','e','c','a','l','t','b' ,'r', 'y','p', 's', 'e' ,'k'};
	int a_len = 17;
	char *b = arrfunc(a,a_len);
	for (int i = 0; i < a_len; i++) {
	cout << b[i] << " "; }
	cout << endl; return 0;
}
void arrfunc2(char *arr, char arr2[], int x) {
	for(int i = 0; i< x; i++) {
arr2[i] = arr[i];
}
}
char *arrfunc(char arr[], int &x) {
int len = 1;
int size = 0; int ct = 0; while (ct < x) {
ct += len*2; size+=len; len += 1;
}
char *arr2 = new char[size];
len = 1;
size = 0;
ct = 0;
while (ct < x) {
arrfunc2(&arr[ct],&arr2[size],len);
ct += len*2; size+=len; len+=1;
}
x = size; return arr2;
}
