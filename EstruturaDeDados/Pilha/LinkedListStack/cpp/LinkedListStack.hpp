#ifndef _LINKEDLISTSTACK_HPP
#define _LINKEDLISTSTACK_HPP

class LinkedListStack
{
private:
    class Nodo
    {
        private:
            int valor;
            Nodo * prox;
        public:
            Nodo(int value);
            int getValor();
            void setValor(int value);
            Nodo * getProx();
            void setProx(Nodo * ref);
    };
    Nodo * topoDaPilha;
    int nElementos;
    
public:
    LinkedListStack(/* args */);
    void push(int value);
    int pop();
    int head();

    int size();
    bool isEmpty();
    void clear();
};

#endif
