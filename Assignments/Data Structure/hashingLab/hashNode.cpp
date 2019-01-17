#include "hashNode.hpp"
#include <time.h>
#include <cstdlib>

static const int DEFSIZE = 50;

hashNode::~hashNode() {
    delete[] values;
}

hashNode::hashNode() {
    keyword = "";
    values = NULL;
    valuesSize = 0;
    currSize = 0;
}

hashNode::hashNode(string s) {
    keyword = s;
    values = new string[DEFSIZE];
    currSize = 0;
    valuesSize = DEFSIZE;
}

hashNode::hashNode(string s, string v) {
    keyword = s;
    values = new string[DEFSIZE];
    currSize = 1;
    values[0] = v;
    valuesSize = DEFSIZE;
}

void hashNode::addValue(string v) {
    if (currSize >= valuesSize)
        dblArray();

    values[currSize] = v;
    currSize++;
}

void hashNode::dblArray() {
    valuesSize *= 2;
    string *tmpArr = new string[valuesSize];
    for (int i = 0; i < currSize; i++)
        tmpArr[i] = values[i];

    delete[] values;
    values = tmpArr;
}

string hashNode::getRandValue() {
    if (currSize != 0)
        return values[rand() % currSize];
    else
        return string();
}
