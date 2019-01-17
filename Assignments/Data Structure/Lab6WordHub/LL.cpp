/*
 * LL.cpp
 *
 *  Created on: Oct 31, 2017
 *      Author: wangpeiyu
 */
#include "LL.hpp"

LL::LL(){
first=NULL;
last=NULL;
size=0;
score=0;
}

void LL::push(string s){
	if(last==NULL){
		addFirst(s);
	}
	else{
		NodeL *n = new NodeL(s);
		last->next = n;
				last = n;
				last->next = NULL;
				size++;
	}

}

void LL::addFirst(string s){
	NodeL *n = new NodeL(s);
		first = n;
		last = n;
		size++;
}

void LL::printList(){
	if (size > 0) {
			NodeL *tmp = first;
			while (tmp != NULL) {
				cout << tmp->word << ":";
				cout << tmp->wscore << ", ";
				tmp = tmp->next;
			}
			cout << endl;
		}
}

void LL::getScore(){
	if (size > 0) {
				NodeL *tmp = first;
				while (tmp != NULL) {
					score+=tmp->wscore;
					tmp = tmp->next;
				}
				cout<<score<<endl;
			}
}
