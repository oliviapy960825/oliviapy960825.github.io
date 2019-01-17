/*
 * AVLTree.cpp
 *
 *  Created on: Oct 31, 2017
 *      Author: wangpeiyu
 */
#include "AVLTree.hpp"
using namespace std;
AVLTree::AVLTree(bool flag) {
	root = NULL;
	AVLflag = flag;
}//This is the constructor of the AVL Tree
/*AVLTree::~AVLTree(NodeT *r){
	if(r->left==NULL&&r->right==NULL){
		cout<<"deleting"<<r<<endl;
		delete r;
	}
	else{
		~AVLTree(r->left);
		~AVLTree(r->right);
	}
}//This is the desconstructor for AVL Tree*/
bool AVLTree::findWord(string s, NodeT *n) {
	if (n == NULL) {
		return false;
	} else {
		return (s == n->word) || findWord(s, n->left) || findWord(s, n->right);
	}
} //This function uses recursion to find if the word given is already in the AVL Tree
void AVLTree::addNode(string s, NodeT *r) {
	if (findWord(s, root) == false) {
		if (root == NULL) {
			cout << "made root" << endl;
			NodeT *node = new NodeT(s);
			root = node;
			root->height = 1;
			root->left = NULL;
			root->right = NULL;
		} else if (s < r->word) {
			cout << "looking left of " << r->word << endl;
			if (r->left != NULL) {
				addNode(s, r->left);
			} else {
				NodeT *node = new NodeT(s);
				r->left = node;
				node->parent = r;
				node->left = NULL;
				node->right = NULL;
				node->height = 1;
				cout << "inserting to the left of " << r->word << endl;
				adjustHeights(node);
			}
		} else if (s > r->word) {
			cout << "looking right of " << r->word << endl;
			if (r->right != NULL) {
				addNode(s, r->right);
			} else {
				cout << "inserting to the right of " << r->word << endl;
				NodeT *node = new NodeT(s);
				r->right = node;
				node->parent = r;
				node->left = NULL;
				node->right = NULL;
				node->height = 1;
				adjustHeights(node);
			}
		} else {
			return;
		}
	}
} //This function is used to add new nodes to the AVL Tree
void AVLTree::printIO(NodeT *r) {
	if (r == NULL) {
		return;
	} else {
		printIO(r->left);
		r->printTNode();
		printIO(r->right);

	}
} //This function is used to use the in-order traversal way to print the AVL Tree
void AVLTree::printPre(NodeT *root) {
	if (root == NULL) {
		return;
	} else {
		root->printTNode();
		printPre(root->left);
		printPre(root->right);
	}
} //This function is used to use the pre-order traversal way to print the AVL Tree
void AVLTree::printPost(NodeT *root) {
	if (root == NULL) {
		return;
	} else {
		printPost(root->left);
		printPost(root->right);
		root->printTNode();
	}
} //This function is used to use the post-order traversal way to print the AVL Tree
void AVLTree::adjustHeights(NodeT *n) {
	if (n == NULL) {
		return;
	} else {
		n->height = getMax(n) + 1;
		cout << n->word << ":" << getDiff(n) << endl;
		if (AVLflag == true) { //only when the children of the lowest-level nodes are not NULL, call rotateHelper
			rotateHelper(n);
		}
		if (n->parent != NULL) {
			adjustHeights(n->parent);
		} else {
			return;
		}
	} //This function is used to adjust the heights after new nodes are added into the AVL Tree. When the AVL flag is true, it will call rotateHelper function

}
void AVLTree::readjustHeights(NodeT *n) {
	if (n == NULL) {
		return;
	} else {
		n->height = getMax(n) + 1;
		if (n->parent != NULL) {
			n=n->parent;
			readjustHeights(n);
		} else {
			return;
		}
	}
}//This function is used to adjust the heights of nodes after the rotation

void AVLTree::rotateHelper(NodeT *n) {
	if (getDiff(n) == 2) {
		if (getDiff(n->left) == 1) {
			rotateRight(n);
			printIO(root);
		} else if (getDiff(n->left) == -1) {
			rotateLeft(n->left);
			rotateRight(n);
			printIO(root);
		}
	} else if (getDiff(n) == -2) {
		if (getDiff(n->right) == -1) {
			rotateLeft(n);
			readjustHeights(n);
			printIO(root);
		} else if (getDiff(n->right) == 1) {
			rotateRight(n->right);
			rotateLeft(n);
			printIO(root);
		}
	}
}//This function is used to check the balance of the nodes, and to see which rotation it needs to call

int AVLTree::getMax(NodeT *n) {
	if (n->left == NULL && n->right == NULL) {
		return 0;
	} else if (n->left != NULL && n->right == NULL) {
		return n->left->height;
	} else if (n->left == NULL && n->right != NULL) {
		return n->right->height;
	} else {
		return std::max(n->left->height, n->right->height);
	}
} // This function will get the maximum heights of a node's children and return it

NodeT *AVLTree::rotateRight(NodeT *n) {
	NodeT *x = n->left;
	NodeT *tmp = x->right;
	if (n->parent != NULL) {
		x->parent = n->parent;
		cout << "hi there rotate right 1 around " << n->word << endl;
		if (n->parent->left == NULL) {
			n->parent->right = x;
		} else if (n->parent->right == NULL) {
			n->parent->left = x;
		} else if (n->parent->left->word == n->word) {
			n->parent->left = x;
		} else if (n->parent->right->word == n->word) {
			n->parent->right = x;
		}
		x->right = n;
		n->parent = x;
		if (tmp != NULL) {
			n->left = tmp;
			tmp->parent = n;
		} else {
			n->left = NULL;
		}

	} else {
		cout << "hi there rotate right 2 around " << n->word << endl;
		root = x;
		x->right = n;
		x->parent = n->parent;
		n->parent = x;
		if (tmp != NULL) {
			n->left = tmp;
			tmp->parent = n;
		} else {
			n->left = NULL;
		} //RENEW THE HEIGHT
		  //make sure you always link to the parent and make sure your parent always link to you on the right side
	}
	readjustHeights(n);
	if(tmp!=NULL){
		readjustHeights(tmp);
	}
	return x;
}//This function is used to do the right rotation and adjust the heights of every node that is involved in this rotation afterwards

NodeT *AVLTree::rotateLeft(NodeT *n) {
	NodeT *x = n->right;
	NodeT *tmp = x->left;
	if (n->parent != NULL) {
		x->parent = n->parent;
		cout << "hi there rotate Left 1 around " << n->word << endl;
		if (n->parent->left == NULL) {
			n->parent->left = x;
		} else if (n->parent->right == NULL) {
			n->parent->left = x;
		} else if (n->parent->left->word == n->word) {
			n->parent->left = x;
		} else if (n->parent->right->word == n->word) {
			n->parent->right = x;
		}
		x->left = n;
		n->parent = x;
		if (tmp != NULL) {
			n->right = tmp;
			tmp->parent = n;
		} else {
			n->right = NULL;
		}
	} else {
		cout << "hi there rotate Left 2 around " << n->word << endl;
		root = x;
		x->left = n;
		x->parent = n->parent;
		n->parent = x;

		if (tmp != NULL) {
			n->right = tmp;
			tmp->parent = n;
		} else {
			n->right = NULL;
		}
	}
	readjustHeights(n);
		if(tmp!=NULL){
			readjustHeights(tmp);
		}
	return x;
}//This function is used to do the left rotation and adjust the heights of every node that is involved in this rotation afterwards

int AVLTree::getDiff(NodeT *n) {
	int difference = 0;
	if (n->left == NULL && n->right == NULL) {
		return difference;
	} else if (n->left == NULL && n->right != NULL) {
		difference = 0 - n->right->height;
		return difference;
	} else if (n->right == NULL && n->left != NULL) {
		difference = n->left->height;
		return difference;
	} else {
		difference = n->left->height - n->right->height;
		return difference;
	}
}//This function is used to calculate the balance of a particular node and return it

