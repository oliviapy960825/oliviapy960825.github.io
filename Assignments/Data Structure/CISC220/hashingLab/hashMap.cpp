#include <iostream>
#include "hashMap.hpp"

static const int DEFSIZE = 89; // prime, large, not close to 2^N

hashMap::~hashMap() {
    for (int i = 0; i < mapSize; i++)
        delete map[i];
    delete[] map;
}

hashMap::hashMap(bool hash1, bool coll1) {
    h1 = hash1;
    c1 = coll1;
    mapSize = DEFSIZE;
    map = new hashNode*[mapSize];
    for (int i = 0; i < mapSize; i++)
        map[i] = NULL;
    numKeys = 0;
    collisionct1 = 0;
    collisionct2 = 0;
}

void hashMap::addKeyValue(string k, string v) {
    int i = getIndex(k, true);

    if (map[i] == NULL) {
        map[i] = new hashNode(k);
        numKeys++;
    }
    map[i]->addValue(v);

    return;
}

int hashMap::getIndex(string k, bool addKeyValue) {
    if (numKeys > 0.7 * mapSize) // why call getIndex() instead of findKey()?
        reHash();

    int h = h1 ? calcHash(k) : calcHash2(k);
    int i = h % mapSize;
    if (addKeyValue && map[i] != NULL && map[i]->keyword != k)
    // original collisions, ignore reHash()
        collisionct1 += 1;

    int pw2 = 1;
    while (map[i] != NULL && map[i]->keyword != k) {
        i = c1 ? collHash1(i) : collHash2(i, pw2);
        //cout << i << " " << pw2 << endl;
        if (!c1) pw2 = pw2 * 2  % mapSize;
        if (addKeyValue && map[i] != NULL && map[i]->keyword != k)
        // collisions caused by collision methods, ignore reHash()
            collisionct2 += 1;
    }

    return i;
}

// Compute h(k) = (k[0] + 31*k[1] + 31^2*k[2] + ...) % n using Horner's rule
int hashMap::calcHash(string k) {
    int hash = 0;
    static const int base = 31;

    for (int i = (int)k.size() - 1; i >= 0; i--)
        hash = (base * hash + (unsigned) k[i]) % mapSize;

    return hash;
}

// Compute h(k) = (k[0] + k[1] + k[2] + ...) % n
int hashMap::calcHash2(string k) {
    int hash = 0;

    for (int i = 0; i < (int)k.size(); i++)
        hash = (hash + (unsigned) k[i]) % mapSize;

    return hash;
}

void hashMap::getClosestPrime() {
    for (int n = mapSize * 2 - 1; n > mapSize; n -= 2) {
        bool not_prime = false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) {
                not_prime = true;
                break;
            }
        if (!not_prime) {
            mapSize = n;
            return;
        }
    }
}

// By Bertrand's postulate, there is always a prime number between n and 2*n
void hashMap::reHash() {
    int mapSize0 = mapSize;
    hashNode **map0 = map;

    getClosestPrime();
    map = new hashNode*[mapSize];
    for (int i = 0; i < mapSize; i++)
        map[i] = NULL;

    for (int j = 0; j < mapSize0; j++) {
        if (map0[j] != NULL) {
            int i = getIndex(map0[j]->keyword); // recursion?
            map[i] = map0[j];
        }
    }

    delete[] map0;
}

/* linear probing */
int hashMap::collHash1(int i) {
    return ++i % mapSize;
}

/* quadratic probing */
int hashMap::collHash2(int i, int pw2) {
    return (i + pw2) % mapSize;
}

int hashMap::findKey(string k) {
    int h = h1 ? calcHash(k) : calcHash2(k);
    int i = (h + mapSize) % mapSize;

    int count = 0;
    int pw2 = 1;
    while ((map[i] == NULL || map[i]->keyword != k) && ++count < mapSize) {
        i = c1 ? collHash1(i) : collHash2(i, pw2);
        if (!c1) pw2 = pw2 * 2  % mapSize;
    }
    return count < mapSize ? i : -1;
}

void hashMap::printMap() {
    cout << "%%%%%%%%%" << endl;
    cout << "mapSize: " << mapSize << endl;
    cout << "numKeys: " << numKeys << endl;

    for (int i = 0; i < mapSize; i++) {
        cout << i << " : ";
        if (map[i] == NULL)
            cout << "None";
        else {
            cout << map[i]->keyword << ": ";
            for (int j = 0; j < map[i]->currSize; j++){
                if (j > 0) cout << " ,";
                cout << map[i]->values[j];
            }
        }
        cout << endl;
    }
    cout << "%%%%%%%%%" << endl;
}

bool hashMap::getH1() {
    return h1;
}

bool hashMap::getC1() {
    return c1;
}

int hashMap::getCCt1() {
    return collisionct1;
}

int hashMap::getCCt2() {
    return collisionct2;
}
