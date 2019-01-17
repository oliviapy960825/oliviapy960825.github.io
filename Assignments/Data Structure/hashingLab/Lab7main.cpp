#include "hashMap.hpp"
#include "hashNode.hpp"
#include "makeSeuss.hpp"
#include <cstdlib>
#include <ctime>
using namespace std;

int main() {
    srand((unsigned)time(NULL));
    makeSeuss("DrSeuss.txt","output-h1c1.txt", true, true);
    makeSeuss("DrSeuss.txt","output-h1c2.txt", true, false);
    makeSeuss("DrSeuss.txt","output-h2c1.txt", false, true);
    makeSeuss("DrSeuss.txt","output-h2c2.txt", false, false);
}
