#include <iostream>
#include "GenericTree.h"
using namespace std;

int main(){
    GenericTree * gt = new GenericTree();
    try
    {
        cout << "O valor do elemento da raiz é " << gt->getRoot() << endl;
    }
    catch(const std::exception& e)
    {        
        std::cerr << e.what() << "Exceção causada durnte leitura da raiz\n";
    }
    
    gt->add(3,0);
    cout << endl << "Nro de elementos agora: " << gt->size() << endl; 
    gt->add(1,3);
    cout << endl << "Nro de elementos agora: " << gt->size() << endl; 
    gt->add(7,3);
    cout << endl << "Nro de elementos agora: " << gt->size() << endl; 
    gt->add(4,3);
    cout << endl << "Nro de elementos agora: " << gt->size() << endl; 
    gt->add(5,7);
    cout << endl << "Nro de elementos agora: " << gt->size() << endl; 
    gt->add(6,7);
    cout << endl << "Nro de elementos agora: " << gt->size() << endl; 
    gt->printTree();
    cout << endl << "Nro de elementos agora: " << gt->size() << endl; 

    cout << "7 está presente? " << gt->contains(7) << endl;
    cout << endl << "Nro de elementos agora: " << gt->size() << endl; 
    cout << "14 está presente?" << gt->contains(14) << endl;
    cout << endl << "Nro de elementos agora: " << gt->size() << endl; 

    cout << "Qm é o pai de 7" << gt->getParent(7) << endl;
    cout << endl << "Nro de elementos agora: " << gt->size() << endl; 
    cout << "Eliminando o ramo 7" << endl;
    cout << "  lista pré eliminação" << endl;
    gt->printTree();
    cout << endl <<"Nro de elementos: " << gt->size() << endl;
    cout << "  lista pos eliminação" << endl;
    gt->removeBranch(7);
    gt->printTree();
    cout << endl << "Nro de elementos agora: " << gt->size() << endl; 

    return 1;
}
