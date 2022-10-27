#ifndef __LISTADUPLAMENTEENCADEADA_HPP
#define __LISTADUPLAMENTEENCADEADA_HPP

class ListaDuplamenteEncadeada{

    private:
    // definição do elemento base da lista encadeadam
        class Nodo{
            private:
                int valor; // valor do nodo da lista
                Nodo * proximo; //referencia o proximo elemento
                Nodo * anterior; //referencia o elemento anterior
            public:
                int getValor();
                Nodo(int valor);
                void setValor(int valor);
                Nodo * getProximo();
                void setProximo(Nodo* referencia);
                Nodo * getAnterior();
                void setAnterior(Nodo* referencia);
        };
        Nodo * inicio;
        Nodo * fim;
        int nElementos;


    public:
        ListaDuplamenteEncadeada();
        bool add(int value);
        bool remove(int pos);
        int size();
        bool isEmpty();
        int get(int pos);
        void clear();
        bool swap(int idx01, int idx02);
};

#endif