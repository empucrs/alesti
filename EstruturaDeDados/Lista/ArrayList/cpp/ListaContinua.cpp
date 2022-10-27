#include "ListaContinua.hpp"

ListaContinua::ListaContinua(){
    tamVet=10;
    armazenamento = new int[tamVet];
    prox=0;
};

bool ListaContinua::add(int value){
    if( isFull() ){
        // redimensionar minha lista
        tamVet *=2;
        int * novoVetor = new int[tamVet];
        for(int i=0; i<tamVet/2; i++)
            novoVetor[i]=armazenamento[i];
        armazenamento=novoVetor;
    }
    armazenamento[prox]=value;
    prox++;

    return true;
            
}

bool ListaContinua::remove(int pos){
    if(( pos>=0) && (pos<prox) ){
        if(pos!=prox-1){
            for(int i=pos; i<prox; i++)
                armazenamento[i]=armazenamento[i+1];
        }
        prox--;
        return true;
    }
    else
        return false;
}

int ListaContinua::size(){
    return prox;
}

bool ListaContinua::isEmpty(){
    return (prox==0);
}

bool ListaContinua::isFull(){
    return(prox==tamVet);
}

int ListaContinua::capacity(){
    return tamVet;
}

int ListaContinua::get(int pos){
    if((pos<prox)&&(pos>=0)){
        return armazenamento[pos];
    }
    else
        return armazenamento[0];
}

void ListaContinua::clear(){
    prox=0;
}