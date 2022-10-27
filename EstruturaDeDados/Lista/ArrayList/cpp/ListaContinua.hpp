#ifndef __LISTACONTINUA_HPP
#define __LISTACONTINUA_HPP

class ListaContinua{

    private:
        int * armazenamento;
        int tamVet;
        int prox;

    public:
        ListaContinua();
        bool add(int value);
        bool remove(int pos);
        int size();
        bool isEmpty();
        bool isFull();
        int capacity();
        int get(int pos);
        void clear();
};

#endif