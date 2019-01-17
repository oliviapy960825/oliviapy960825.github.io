/*
 * LL.hpp
 *
 *  Created on: Oct 31, 2017
 *      Author: wangpeiyu
 */

#ifndef LL_HPP_
#define LL_HPP_
#include <iostream>
//#include "Game.hpp"
//#include "AVLTree.hpp"
#include "NodeL.hpp"
//#include "NodeT.hpp"
#include <stdlib.h>
#include <string>
#include <fstream>

class LL{
	friend class Game;
	NodeL *first;
	NodeL *last;
	int size;
	int score;
	public:
	LL();
	~LL();
	void push(string s);
	void addFirst(string s);
	void printList();
	void getScore();
};



#endif /* LL_HPP_ */
