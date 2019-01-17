/*
 * LL.cpp
 *
 *  Created on: Oct 31, 2017
 *      Author: wangpeiyu
 */
#include "LL.hpp"

LL::LL() {
	first = NULL;
	last = NULL;
	size = 0;
	score = 0;
}//constructor, it sets the first pointer to NULL and the last pointer to NULL and initialize the size and the wordcount of the list to 0
LL::~LL(){
	while (size > 0) {
			NodeL *tmp = first;
			for (int i = 0; i < size - 1; i++) {
				tmp = tmp->next;
			}
			delete last;
			last = tmp;
			last->next = NULL;
			size--;
		}
}//this is the destructor, after the program is done, it will be called automatically
void LL::push(string s) {
	if (last == NULL) {
		addFirst(s);
	} else {
		NodeL *n = new NodeL(s);
		last->next = n;
		last = n;
		last->next = NULL;
		size++;
	}

}//this method will add the new word to the end of the list

void LL::addFirst(string s) {
	NodeL *n = new NodeL(s);
	first = n;
	last = n;
	size++;
}//this function will be called when the list is still empty, and it will add the first word to first of the list

void LL::printList() {
	if (size > 0) {
		NodeL *tmp = first;
		while (tmp != NULL) {
			cout << tmp->word << ":";
			cout << tmp->wscore << ", ";
			tmp = tmp->next;
		}
		cout << endl;
	}
}//this function will print out all the words and the count of words in the list

void LL::getScore() {
	if (size > 0) {
		NodeL *tmp = first;
		while (tmp != NULL) {
			score += tmp->wscore;
			tmp = tmp->next;
		}
		cout << score << endl;
	}
}//this function will get the total score of the nodes in the whole list
