/*
 * AVLTree.hpp
 *
 *  Created on: Oct 31, 2017
 *      Author: wangpeiyu
 */

#ifndef AVLTREE_HPP_
#define AVLTREE_HPP_
#include <iostream>
#include <stdlib.h>
#include <string>
#include "NodeT.hpp"
#include <fstream>
class AVLTree{
	friend class Game;
	NodeT *root;
	bool AVLflag;
	public:
	AVLTree(bool flag);
	//~AVLTree(NodeT *r);
	bool findWord(string s, NodeT *n);
	void addNode(string s, NodeT *r);
	void printIO(NodeT *root);
	void printPre(NodeT *root);
	void printPost(NodeT *root);
	void adjustHeights(NodeT *n);
	void rotateHelper(NodeT *n);
	int getMax(NodeT *n);
	NodeT *rotateRight(NodeT *n);
	NodeT *rotateLeft(NodeT *n);
	int getDiff(NodeT *n);
	void readjustHeights(NodeT *n);
};



#endif /* AVLTREE_HPP_ */
