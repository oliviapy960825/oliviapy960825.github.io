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
}
bool AVLTree::findWord(string s, NodeT *n) {
	if (n == NULL) {
		return false;
	} else {
		return (s == n->word) || findWord(s, n->left) || findWord(s, n->right);
	}
} //ok
void AVLTree::addNode(string s, NodeT *r) { //ok except adjustingHeights part
	if (findWord(s, root) == false) { //should we call this function? can a bst has duplicated words?
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
				node->height = 0;
				adjustHeights(node);
				printIO(root);
				cout << "inserting to the left of " << r->word << endl;
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
				node->height = 0;
				adjustHeights(node);
				printIO(root);
			}
		} else {
			return;
		}
	}
}
void AVLTree::printIO(NodeT *root) {
	if (root == NULL) {
		return;
	} else {
		printIO(root->left);
		root->printTNode();
		printIO(root->right);

	}
}
void AVLTree::printPre(NodeT *root) {
	if (root == NULL) {
		return;
	} else {
		root->printTNode();
		printPre(root->left);
		printPre(root->right);
	}
}
void AVLTree::printPost(NodeT *root) {
	if (root == NULL) {
		return;
	} else {
		printPost(root->left);
		printPost(root->right);
		root->printTNode();
	}
}
void AVLTree::adjustHeights(NodeT *n) {
	if (n->height==getMax(n)+1) {
		return;
	} else {
		n->height = getMax(n) + 1;
		if (n->parent != NULL) {
			adjustHeights(n->parent);
		}
	}
		if (AVLflag == true) {
			rotateHelper(n);
	}
}
void AVLTree::rotateHelper(NodeT *n) {
	if (getDiff(n) == 2) {
		if (getDiff(n->left) == 1) {
			rotateRight(n);
			adjustHeights(n);
		} else if (getDiff(n->left) == -1) {
			rotateLeft(n->left);
			rotateRight(n->left);
			adjustHeights(n->left);
		}
	} else if (getDiff(n) == -2) {
		if (getDiff(n->right) == -1) {
			cout << "rotate left around " << n->word << endl;
			rotateLeft(n);
			adjustHeights(n);
		} else if (getDiff(n->right) == 1) {
			rotateRight(n->right);
			rotateLeft(n->right);
			adjustHeights(n->right);
		}
	}
}
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
} //ok
NodeT *AVLTree::rotateRight(NodeT *n) {
	NodeT *x = n->left;
	NodeT *tmp = x->right;
	if (n->parent != NULL) {
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
		x->parent = n->parent;
		cout << x->parent->word << endl;
		x->right = n;
		n->parent = x;
		if (tmp != NULL) {
			n->left = tmp;
			tmp->parent = n;
			adjustHeights(tmp);
		} else {
			n->left = NULL;
			adjustHeights(n);
		}

	} else {
		cout << "hi there rotate right 2 around " << n->word << endl;
		x->parent = n->parent;
		x->right = n;
		n->parent = x;
		if (tmp != NULL) {
			n->left = tmp;
			tmp->parent = n;
		} else {
			n->left = NULL;
		}

		root = x; //RENEW THE HEIGHT
		//make sure you always link to the parent and make sure your parent always link to you on the right side
	}
	/*if (n->left == NULL && n->right == NULL) {
	 n->height = 1;
	 } else if (n->left != NULL && n->right == NULL) {
	 n->height = n->left->height + 1;
	 } else if (n->left == NULL && n->right != NULL) {
	 n->height = n->right->height + 1;
	 } else if (n->left->height > n->right->height) {
	 n->height = n->left->height + 1;
	 } else {
	 n->height = n->right->height + 1;
	 }
	 if (x->left == NULL && x->right != NULL) {
	 x->height = x->right->height + 1;
	 } else if (x->left != NULL && x->right == NULL) {
	 x->height = x->left->height + 1;
	 } else if (x->left->height > x->right->height) {
	 x->height = x->left->height + 1;
	 } else {
	 x->height = x->right->height + 1;
	 }*/
	return x;
}
NodeT *AVLTree::rotateLeft(NodeT *n) {
	NodeT *x = n->right;
	NodeT *tmp = x->left;
	if (n->parent != NULL) {
		cout << "hi there rotate Left 1 around " << n->word << endl;
		if (n->parent->left == NULL) {
			n->parent->right = x;
		} else if (n->parent->right == NULL) {
			n->parent->left = x;
		} else if (n->parent->left->word == n->word) {
			n->parent->left = x;
		} else if (n->parent->right->word == n->word) {
			n->parent->right = x;
		}
		x->parent = n->parent;
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
		x->left = n;
		n->parent = x;
		if (tmp != NULL) {
			n->right = tmp;
			tmp->parent = n;
		} else {
			n->right = NULL;
		}
		adjustHeights(n);
		root = x;
	}
	return x;
}
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
}		//ok now

