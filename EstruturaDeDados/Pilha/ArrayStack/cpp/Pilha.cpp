#include "Pilha.hpp"

Pilha::Pilha(int size){
    if(size<=0)
        size=10;
    this->pilha=new int[size];
    this->topo=0;
    this->capacidade=size;
}

bool Pilha::push(int value){
    if(this->topo==capacidade) grow();
    this->pilha[this->topo++]=value;
}

void Pilha::grow(){
    int *aux = new int[this->capacidade*2];
    for(int i=0; i<this->capacidade; i++)
      aux[i]=this->pilha[i];
    this->pilha=aux;
    this->capacidade*=2;
}

int  Pilha::pop(){
    if(this->topo<=0)
        throw "empty stack";
    else{
        this->topo--;
        return this->pilha[this->topo];
    }
}

int  Pilha::top(){    
    if(topo>0)
      return pilha[topo-1];
    else
      return -1;
}

int  Pilha::size(){
    return this->topo;
}

bool Pilha::isEmpty(){
    return(this->topo==0);
    
}

void Pilha::clear(){
    this->topo=0;
    delete this->pilha;    
    this->capacidade=10;
    this->pilha=new int[this->capacidade];
}