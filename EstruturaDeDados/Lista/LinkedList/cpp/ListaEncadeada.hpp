#ifndef __LISTAENCADEADA_HPP
#define __LISTAENCADEADA_HPP

class ListaEncadeada{

    private:
    // definição do elemento base da lista encadeada
        class Nodo{
            private:
                int valor; // valor do nodo da lista
                Nodo * proximo; //referencia o proximo elemento
            public:
                int getValor();
                Nodo(int valor);
                void setValor(int valor);
                Nodo * getProximo();
                void setProximo(Nodo* proximo);
        };
        Nodo * inicio;
        Nodo * fim;
        int nElementos;


    public:
        ListaEncadeada();
        bool add(int value);
        bool remove(int pos);
        int size();
        bool isEmpty();
        int get(int pos);
        void clear();
};

#endif