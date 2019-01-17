/*
 * mainWordHub.cpp
 *
 *  Created on: Oct 25, 2017
 *      Author: Debra
 */


//#include "AVLTree.hpp"
#include <iostream>
#include <stdlib.h>
#include <time.h>
#include <fstream>
#include <string>
#include "Game.hpp"

using namespace std;

int main() {
	//srand(time(NULL));
	//Game *game = new Game("testdict.txt", false);
	//game->startGame();
/*string s1="mug";
string *s2=&s1;
s1="wump";
//cout<<*s2<<endl;
*s2="glub";
cout<<s1<<endl;*/
int a=12;
cout<<&a<<endl;
int *b=&a;
cout<<b<<endl;
cout<<&b<<endl;
int *d=b;
cout<<d<<endl;
*d=4;
cout<<a<<endl;
cout<<*b<<endl;
	return 0;
}

