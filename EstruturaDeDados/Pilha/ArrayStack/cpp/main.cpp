#include "Pilha.hpp"
#include <iostream>

using namespace std;

int main(int argc, char const *argv[])
{
    Pilha minhaPilha(2);
    minhaPilha.push(10);
    minhaPilha.push(11);
    minhaPilha.push(12);
    minhaPilha.push(13);
    cout << minhaPilha.pop() << endl;
    cout << minhaPilha.pop() << endl;
    cout << minhaPilha.pop() << endl;
    cout << minhaPilha.pop() << endl;
    cout << minhaPilha.pop() << endl;
    
    return 0;
}
