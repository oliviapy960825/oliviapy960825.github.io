#include "makeSeuss.hpp"
#include "hashMap.hpp"

#include <iostream>
#include <stdlib.h>
#include <string>
#include <fstream>

using namespace std;

makeSeuss::~makeSeuss() {
    delete ht;
}

makeSeuss::makeSeuss(string f1, string f2, bool h1, bool c1) {
    ht = new hashMap(h1, c1);
    newfile = f2;
    fn = f1;
    readFile();
    writeFile();
}

void makeSeuss::readFile() {
    ifstream infile(fn.c_str(),ios::in); // open file
    string key = "";
    string value = "";
    infile >> key;
    ht->first = key;
    while (infile >> value) { // loop getting single characters
        cout << key << ": " << value << endl;
        ht->addKeyValue(key,value);
        key = value;
        value = "";
    }
    ht->addKeyValue(key,value);
    cout << endl;
    infile.close();

    cerr << "Input file: " << fn << endl;
    cerr << "Output file: " << newfile << endl;
    cerr << "Method: " << ht->getH1() << ", " << ht->getH1() << endl;
    cerr << "Number of original colissions: " << ht->getCCt1() << endl;
    cerr << "Number of secondary collisions: " << ht->getCCt1() << endl;
    //ht->printMap();
}

void makeSeuss::writeFile() {
    ofstream outfile(newfile.c_str(),ios::out);

    outfile << ht->first << " ";
    string key = "";
    string value = ht->map[ht->getIndex(ht->first)]->getRandValue();
    int ct = 0;
    int len = 0;
    while (ct < 500 && value != "") {
        key = value;
        outfile << key << " ";
        if (len == 11) {
            outfile << "\n";
            len = 0;
        }
        else len++;
        value = ht->map[ht->getIndex(key)]->getRandValue();
        ct ++;
    }
    outfile.close();
}
