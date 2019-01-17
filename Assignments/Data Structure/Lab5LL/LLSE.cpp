/*
 * LLSE.cpp
 *
 *  Created on: Oct 17, 2017
 *      Author: wangpeiyu
 */
#include "LLSE.hpp"
#include <iostream>
#include <stdlib.h>
#include <string>
using namespace std;
LLSE::LLSE() {
	first = NULL;
	last = NULL;
	size = 0;
	wordcount = 0;
} //constructor, it sets the first pointer to NULL and the last pointer to NULL and initialize the size and the wordcount of the list to 0
LLSE::~LLSE() {
	while (size > 0) {
		Node *tmp = first;
		for (int i = 0; i < size - 1; i++) {
			tmp = tmp->next;
		}
		delete last;
		last = tmp;
		last->next = NULL;
		size--;
	}
} //this is the destructor, after the program is done, it will be called automatically
void LLSE::printLL() {
	if (size > 0) {
		Node *tmp = first;
		while (tmp != NULL) {
			cout << tmp->word << ":";
			cout << tmp->count << ", ";
			tmp = tmp->next;
		}
		cout << endl;
	}

} //this function will print out all the words and the count of words in the list
void LLSE::addFirst(string x) {
	Node *n = new Node(x);
	first = n;
	last = n;
	size++;
} //this function will be called when the list is still empty, and it will add the first word to first of the list
void LLSE::addAtFirst(string x) {
	Node *n = new Node(x);
	n->next = first;
	first = n;
	size++;
} //this function will check the new word, if the word is alphabetically prior to the first word, this function will add the new word to the beginning of the list
void LLSE::push(string x) {
	Node *n = new Node(x);
	last->next = n;
	last = n;
	last->next = NULL;
	size++;
} //this method will add the new word to the end of the list
void LLSE::insertUnique(string w) {
	if (size == 0) {
		addFirst(w);
		//cout << "first:" << first->word << endl;
	} else if (w < first->word) {
		addAtFirst(w);
		//cout << "atFirst" << endl;
	} else {
		Node *n = new Node(w);
		//cout << "findInsert " << n->word << endl;
		Node *tmp = findInsert(w);
		//cout << "tmp:" << tmp << endl;
		if (tmp == last) {
			//cout << "last" << endl;
			push(w);
		} else if (tmp == NULL) {

		} else {
			//cout << "else" << endl;
			Node *tmp2 = first;
			while (tmp2 != tmp->next) {
				tmp2 = tmp2->next;
			}

			tmp->next = n;
			n->next = tmp2;
			size++;
			//cout << "insert completed" << endl;
		}
	}
} // this method is the heart of the linked list class. It inserts
// each word alphabetically into the linked list as follows:
// If the word is the first in the list, it calls addFirst to
// create the very first node for the list
// If the word occurs alphabetically before the first word in the
// list, it calls addAtFirst to add anew node to the beginning of
// the list.
// Otherwise it calls the findInsert method (below), which should
// return the address of the Node that occurs alphabetically right before where you should insert your words
Node *LLSE::findInsert(string x) {
	Node *tmp = first;

	for (int i = 0; i < size; i++) {
		if (x == tmp->word) {
			tmp->count++;
			return NULL;
			//cout << "wordcount adding completed" << endl;	//stuck here
		}

		tmp = tmp->next;
	}
	tmp = first;
	for (int j = 0; j < size; j++) {
		//cout<<tmp->word<<endl;
		if (x < tmp->word) {
			Node *tmp2 = first;
			while (tmp2->next != tmp) {
				tmp2 = tmp2->next;
			}
			return tmp2;
		}
		tmp = tmp->next;

	}
	return last;//run till the last word in the current list, if there's no match in the current list, it should be inserted in the end, what node should we return in this case?
}	//This method finds and returns the node right before where you
// should insert the new word into the list. If the word is
// already in the list, it increases that word’s count and
// returns NULL.
void LLSE::normalizeCounts() {
	Node *tmp = first;
	for (int i = 0; i < size; i++) {
		wordcount = wordcount + tmp->count;
		tmp = tmp->next;
	}//should we calculate the wordcount here? Otherwise where should we put the calculation of wordcount? I don't think the list will calculate wordcount by itself
	tmp = first;
	for (int i = 0; i < size; i++) {
		tmp->count = (tmp->count) / wordcount;
		tmp = tmp->next;
	}
}//this function will calculate the total of the words and wordcount of the list, then it will divide every count of the word with the total wordcount to normalize the wordcount

string LLSE::remFirst() {
	Node *tmp = first;
	tmp = tmp->next;
	string x = first->word;
	delete first;
	first = tmp;
	size--;
	return x;
}//this function is used to remove the first word in the list

string LLSE::pop() {
	Node *tmp = first;
	for (int i = 0; i < size - 1; i++) {
		tmp = tmp->next;
	}
	string x = last->word;
	delete last;
	last = tmp;
	last->next = NULL;
	size--;
	return x;
}//this function is used to remove the last word in the list

string LLSE::remNext(Node * n) {
	Node *tmp = NULL;
	tmp = n->next;
	string x = tmp->word;
	n->next = n->next->next;
	delete tmp;
	size--;
	cout << "Removing: " << x << endl;
	return x;
}//this function will take a node as its parameter and remove the next node of the parameter node

void LLSE::eliminateLowWords() {
	Node *tmp = first;
	while (tmp->count <= 0.004) {
		remFirst();
		tmp = tmp->next;
	}
	tmp = first;
	while (tmp != NULL) {
		if (tmp->count <= 0.004) {
			Node *tmp2 = first;
			while (tmp2->next->word != tmp->word) {
				tmp2 = tmp2->next;
			}
			remNext(tmp2);
		}
		tmp = tmp->next;
	}
}//this function will check every count of every word in the list, and remove all the words whose count is smaller than 0.004

