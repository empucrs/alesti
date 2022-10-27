#include "ListaDuplamenteEncadeada.hpp"

ListaDuplamenteEncadeada::ListaDuplamenteEncadeada(){
    nElementos=0;
    fim=inicio=nullptr;
};

bool ListaDuplamenteEncadeada::add(int value){

    if(isEmpty()){
        fim = inicio = new Nodo(value);
    }
    else{
        Nodo * novoNodo = new Nodo(value);
        novoNodo->setAnterior(fim);
        fim->setProximo(novoNodo);
        fim=novoNodo;
    }
    nElementos++;
}

bool ListaDuplamenteEncadeada::remove(int pos){
    if(pos>=0 && pos<nElementos){
        //busca do nodo a ser eliminado
        Nodo * buscaNodo = inicio;
        while(pos<0){
            buscaNodo=buscaNodo->getProximo();
            pos--;
        }

        if(buscaNodo!=fim)
            buscaNodo->getProximo()->setAnterior(buscaNodo->getAnterior());

        if(buscaNodo!=inicio)
            buscaNodo->getAnterior()->setProximo(buscaNodo->getProximo());

        if(buscaNodo==inicio)
            inicio=buscaNodo->getProximo();
        if(buscaNodo==fim)
            fim=buscaNodo->getAnterior();

        buscaNodo->setAnterior(nullptr);
        buscaNodo->setProximo(nullptr);
        delete buscaNodo;

        nElementos--;

        return true;

    }
    else
        return false;       

}

bool ListaDuplamenteEncadeada::swap(int idx01, int idx02){

    if(
        // indice 1 é valido
        (idx01>=0 && idx01<nElementos) &&
        // indice 2 é valido
        (idx02>=0 && idx02<nElementos) &&
        // indice 1 é diferente de indice 2
        (idx01!=idx02)
    ){
        //busca o primeiro nodo
        Nodo * A=inicio;
        while(idx01>0){
            A=A->getProximo();
            idx01--;
        }

        //busca o segundo nodo
        Nodo * B=inicio;
        while(idx02>0){
            B=B->getProximo();
            idx02--;
        }

        if(A->getProximo()!=nullptr)
            A->getProximo()->setAnterior(B);
        if(B->getProximo()!=nullptr)
            B->getProximo()->setAnterior(A);
        if(A->getAnterior()!=nullptr)
            A->getAnterior()->setProximo(B);
        if(B->getAnterior()!=nullptr)
            B->getAnterior()->setProximo(A);

        Nodo * aux;
        aux=A->getProximo();
        A->setProximo(B->getProximo());
        B->setProximo(aux);

        aux=A->getAnterior();
        A->setAnterior(B->getAnterior());
        B->setAnterior(aux); 

        if(A==inicio || A==fim){
            if(B==inicio || B==fim){
                if(A==fim){
                    fim=B;
                    inicio=A;
                }
                else{
                    fim=A;
                    inicio=B
                }
            }
            else{
                if(A==fim)
                    fim=B;
                else
                    inicio=B;
            }
        }
        else if(B==inicio || B==fim){
            if(B==fim)
                fim=A;
            else
                inicio=A;
        }


        return true;
    }
    else
        return false;

}

int ListaDuplamenteEncadeada::size(){
}

bool ListaDuplamenteEncadeada::isEmpty(){
    return (nElementos==0);
}

int ListaDuplamenteEncadeada::get(int idx){
}

void ListaDuplamenteEncadeada::clear(){
}
// ==> métodos do nodo base da lista
ListaDuplamenteEncadeada::Nodo::Nodo(int valor){
    this->valor=valor;
    this->proximo=this->anterior=nullptr;
}
int ListaDuplamenteEncadeada::Nodo::getValor(){
    return this->valor;
}
void ListaDuplamenteEncadeada::Nodo::setValor(int valor){
    this->valor = valor;    
}
ListaDuplamenteEncadeada::Nodo * ListaDuplamenteEncadeada::Nodo::getProximo(){
    return this->proximo;
}
void ListaDuplamenteEncadeada::Nodo::setProximo(Nodo* referencia){
    this->proximo = referencia;
}
ListaDuplamenteEncadeada::Nodo * ListaDuplamenteEncadeada::Nodo::getAnterior(){
    return this->anterior;
}
void ListaDuplamenteEncadeada::Nodo::setAnterior(Nodo* referencia){
    this->anterior = referencia;
}
