/*
 * funct.cpp
 *
 *  Created on: May 3, 2018
 *      Author: wangpeiyu
 */

#include <iostream>
#include<stdlib.h>
#include<math.h>
#include<string>
#include<time.h>
using std::string;
using namespace std;
class funct{
	funct(){}
public:
int funct1(int x, int y){
if(x<=0)
	return y;
else if(x&0x1){ //what does x&0x1 do—bitwise AND
return funct1(x-1, x+y);}
else{
return funct1(x-1, x-y);}}//if the number is odd, then return x+ funct(x-1), if the number is even, then return x-funct(x-1)

};

int main(){
	cout<<funct1(2)<<endl;
	//funct1(2);
}

