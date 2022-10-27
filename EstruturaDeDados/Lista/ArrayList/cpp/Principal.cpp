#include <iostream>

#include "ListaContinua.hpp"

using namespace std;

int main(int argc, char const *argv[])
{
    ListaContinua lc = ListaContinua();

    lc.add(1);
    lc.add(10);
    lc.add(5);
    lc.add(12);
    lc.add(2);

    cout << "A lista continua contém " << lc.size() << " valores." << endl;

    return 0;
}
