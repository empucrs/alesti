#include "LinkedListStack.hpp"

LinkedListStack::LinkedListStack(){
    nElementos=0;
    topoDaPilha=nullptr;
}

void LinkedListStack::push(int value){    
    Nodo * newNodo = new Nodo(value);
    if(nElementos!=0)
        newNodo->setProx(topoDaPilha);
    topoDaPilha=newNodo;
    nElementos++;
}

int LinkedListStack::pop(){
    if(nElementos>0){
        int valorDeRetorno=topoDaPilha->getValor();
        Nodo * objetoADeletar=topoDaPilha;
        topoDaPilha=topoDaPilha->getProx();
        objetoADeletar->setProx(nullptr);
        delete objetoADeletar;
        nElementos--;
        return valorDeRetorno;
    }
    else
        throw "Pilha vazia";
}

int LinkedListStack::head(){    
    if(nElementos>0)
        return topoDaPilha->getValor();
    else
        throw "Pilha vazia";
}

int LinkedListStack::size(){
    return nElementos;    
}

bool LinkedListStack::isEmpty(){
    return (nElementos==0);    
}

void LinkedListStack::clear(){
    Nodo * aux;
    while(nElementos>0){
        aux = topoDaPilha;
        topoDaPilha=topoDaPilha->getProx();
        delete aux;
        nElementos--;
    }
}

//-=-=-=-=-=-=-=
LinkedListStack::Nodo::Nodo(int value){
    this->valor=value;
    this->prox=nullptr;    
}
int LinkedListStack::Nodo::getValor(){
    return this->valor;    
}

void LinkedListStack::Nodo::setValor(int value){
    this->valor=value;   
}

LinkedListStack::Nodo * LinkedListStack::Nodo::getProx(){
    return this->prox;    
}
void LinkedListStack::Nodo::setProx(Nodo * ref){
    this->prox=ref;    
}
