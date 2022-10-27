#include <iostream>

#include "ListaEncadeada.hpp"

using namespace std;

int main(int argc, char const *argv[])
{
    ListaEncadeada le = ListaEncadeada();

    le.add(1);
    le.add(10);
    le.add(5);
    le.add(12);
    le.add(2);

    cout << "A lista continua contém " << le.size() << " valores." << endl;

    return 0;
}
