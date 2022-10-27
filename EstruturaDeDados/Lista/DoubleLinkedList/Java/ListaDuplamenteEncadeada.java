public class ListaDuplamenteEncadeada{

    private class Nodo{
        private int valor;
        private Nodo prox;
        private Nodo prev;
        public Nodo(int valor) {
            this.valor = valor;
            this.prox = null;
            this.prev = null;
        }
        public int getValor() {
            return valor;
        }
        public void setValor(int valor) {
            this.valor = valor;
        }
        public Nodo getProx() {
            return this.prox;
        }
        public void setProx(Nodo referencia) {
            this.prox = referencia;
        }        
        public Nodo getPrev() {
            return this.prox;
        }
        public void setPrev(Nodo referencia) {
            this.prev = referencia;
        }        
    }

    private Nodo inicio, fim;
    private int size;

    public ListaDuplamenteEncadeada(){
        clear();
    }

    public boolean add(int value){
        Nodo novoObjeto = new Nodo(value);

        if(isEmpty()){
            inicio=novoObjeto;            
        }
        else{
            fim.setProx(novoObjeto);
            novoObjeto.setPrev(fim);
        }
        fim=novoObjeto;
        size++;
        return true;
    }

    // remove o último elemento da lista
    public boolean remove(){
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return (this.size==0);
    }

    public int getDoInicio(int idx){
        if( (idx>=0) && (idx<size) ){
            Nodo amyrKlink = inicio;
            while(idx>0){
                amyrKlink=amyrKlink.getProx();
                idx--;
            }
            return amyrKlink.getValor();
        }
        return -1;
    }

    public int getDoFim(int idx){swapNodo
            while(novoIdx>0){
                amyrKlink=amyrKlink.getPrev();
                novoIdx--;
            }
            return amyrKlink.getValor();

        }
        return -1;
    }

    public void clear(){
        inicio=fim=null;
        size=0;
    }

    public boolean addAt(int idx, int value){
        if((idx>=0) && (idx<=size)){

            if(idx==0){
                if(isEmpty())
                  add(value);
                else{
                    Nodo novoNodo = new Nodo(value);
                    inicio.setPrev(novoNodo);
                    novoNodo.setProx(inicio);
                    inicio=novoNodo;
                    size++;
                }
            }
            else if(idx==size()){
                add(value);
            }
            else{
                Nodo amyrKlink = inicio;
                while(idx>0){
                    amyrKlink=amyrKlink.getProx();
                    idx--;
                }
                Nodo novoObjeto = new Nodo(value);
                novoObjeto.setProx(amyrKlink);
                novoObjeto.setPrev(amyrKlink.getPrev());
                amyrKlink.setPrev(novoObjeto);
                novoObjeto.getPrev().setProx(novoObjeto);

                size++;
            }
            

            return true;
        }
        return false;
    }

    public boolean removeAt(int idx){        
    }

    public boolean swapValor(int idx01, int idx02){
    }

    public boolean swapNodo(int idx01, int idx02){

        if(
            (idx01>=0 && idx01<size) && 
            (idx02>=0 && idx02<size) &&
            (idx01 != idx02)
          )
          {
            // swap de nodos no meio (nem fim nem início)

            Nodo A, B;
            A=inicio;
            while(idx01>0){
                A=A.getProx();
                idx01--;
            }

            B=inicio;
            while(idx02>0){
                B=B.getProx();
                idx02--;
            }

            //swap de fato
            if(A!=fim)
                A.getProx().setPrev(B);
            if(B!=fim)
                B.getProx().setPrev(A);

            if(A!=inicio)
                A.getPrev().setProx(B);
            if(B!=inicio)
                B.getPrev().setProx(A);

            Nodo auxiliar = A.getPrev();
            A.setPrev(B.getPrev());
            B.setPrev(auxiliar);

            auxiliar= A.getProx();
            A.setProx(B.getProx());
            B.setProx(auxiliar);

            // Ajustes do inicio e fim da lista
            if(A==inicio || A==fim){                
                if(B==inicio || B==fim){
                    if(A==inicio && B==fim){
                        inicio=B;
                        fim=A;
                    }
                    else{
                        inicio=A;
                        fim=B;
                    }
                }
                else{
                    if(A==inicio)
                        inicio=B;
                    else
                        fim=B;
                }
            }
            else if(B==inicio || B==fim){
                if(B==inicio)
                    inicio=A;
                else
                    fim=A;
    }




          }

    }

}