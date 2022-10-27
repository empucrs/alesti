#include "LinkedListStack.hpp"
#include <iostream>

using namespace std;

int main(int argc, char const *argv[])
{
    LinkedListStack * ls = new LinkedListStack();

    cout << "Nro de elementos da pilha: " << ls->size() << endl << endl;

    ls->push(14);
    cout << "Nro de elementos da pilha: " << ls->size() << endl;
    cout << "Elementos no topo da pilh : " << ls->head() << endl << endl;

    ls->push(15);
    cout << "Nro de elementos da pilha: " << ls->size() << endl;
    cout << "Elementos no topo da pilh : " << ls->head() << endl << endl;

    ls->push(16);
    cout << "Nro de elementos da pilha: " << ls->size() << endl;
    cout << "Elementos no topo da pilh : " << ls->head() << endl << endl;

    int valor = ls->pop();
    cout << "Nro de elementos da pilha: " << ls->size() << endl;
    cout << "Elementos capturado da pilha : " << valor << endl;
    cout << "Elementos no topo da pilh : " << ls->head() << endl << endl;

    ls->push(17);
    cout << "Nro de elementos da pilha: " << ls->size() << endl;
    cout << "Elementos no topo da pilh : " << ls->head() << endl << endl;

    valor = ls->pop();
    cout << "Nro de elementos da pilha: " << ls->size() << endl;
    cout << "Elementos capturado da pilha : " << valor << endl;
    cout << "Elementos no topo da pilh : " << ls->head() << endl << endl;

    valor = ls->pop();
    cout << "Nro de elementos da pilha: " << ls->size() << endl;
    cout << "Elementos capturado da pilha : " << valor << endl;
    cout << "Elementos no topo da pilh : " << ls->head() << endl << endl;

    valor = ls->pop();
    cout << "Nro de elementos da pilha: " << ls->size() << endl;
    cout << "Elementos capturado da pilha : " << valor << endl;
    cout << "Elementos no topo da pilh : " << ls->head() << endl << endl;

    valor = ls->pop();
    cout << "Nro de elementos da pilha: " << ls->size() << endl;
    cout << "Elementos capturado da pilha : " << valor << endl;
    cout << "Elementos no topo da pilh : " << ls->head() << endl << endl;

    valor = ls->pop();
    cout << "Nro de elementos da pilha: " << ls->size() << endl;
    cout << "Elementos capturado da pilha : " << valor << endl;
    cout << "Elementos no topo da pilh : " << ls->head() << endl << endl;



    return 0;
}
