#include "ListaEncadeada.hpp"

ListaEncadeada::ListaEncadeada(){
    nElementos=0;
    fim=inicio=nullptr;
};

bool ListaEncadeada::add(int value){
    if(this -> isEmpty()){
        inicio = new Nodo(value);
        fim = inicio;
        nElementos++;
    }
    else{
        Nodo * auxiliar = new Nodo(value);
        nElementos++;

        //tem ao menos 1 elemento na minha lista
        //inicio aponta para o primeiro elemento
        //auxiliar está referenciando o nodo a ser incluido na lista
        Nodo * amyrKlink = inicio;
        while(amyrKlink->getProximo()!=nullptr)
            amyrKlink = amyrKlink->getProximo();

        amyrKlink->setProximo(auxiliar);

        fim=auxiliar;
    }
    return true;
}

bool ListaEncadeada::remove(int idx){
    if((idx>0) && (idx<nElementos)){
        Nodo * amyrKlink=inicio;
        if(idx==0){
            inicio=amyrKlink->getProximo();
            amyrKlink->setProximo(nullptr);
        }
        else{
            idx--;
            while(idx>0){
                amyrKlink=amyrKlink->getProximo();
                idx--;
            }
            Nodo * nodoAEliminar = amyrKlink->getProximo();
            amyrKlink->setProximo(nodoAEliminar->getProximo());
            nodoAEliminar->setProximo(nullptr);
        }

        nElementos--;
        return true;
    }
    else
        return false;
}

int ListaEncadeada::size(){
    return nElementos;
}

bool ListaEncadeada::isEmpty(){
    return (nElementos==0);
}

int ListaEncadeada::get(int idx){
    // o índice é inválido
    if((idx<0)||(idx>=nElementos))
        return -1;
    else {
        Nodo * amyrKlink = inicio;
        for(int i=0; i<idx; i++)
            amyrKlink = amyrKlink->getProximo();
        return amyrKlink->getValor();
    }
}

void ListaEncadeada::clear(){
    while (nElementos>0)
    {
        Nodo * auxiliar = inicio;
        inicio->setProximo(inicio->getProximo());
        delete auxiliar;
        nElementos--;
    }
    inicio=fim=nullptr;
}

ListaEncadeada::Nodo::Nodo(int valor){
    this->valor = valor;
    this->proximo=nullptr;
}
int ListaEncadeada::Nodo::getValor(){
    return this->valor;
}
void ListaEncadeada::Nodo::setValor(int valor){
    this->valor = valor;    
}
ListaEncadeada::Nodo * ListaEncadeada::Nodo::getProximo(){
    return this->proximo;
}
void ListaEncadeada::Nodo::setProximo(Nodo* proximo){
    this->proximo = proximo;
}
