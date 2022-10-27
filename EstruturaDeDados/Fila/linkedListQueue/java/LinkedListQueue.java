public class LinkedListQueue{

    private class Nodo{
        private int valor;
        private Nodo prox;
        public Nodo(int value){
            this.valor=value;
            this.prox=null;
        }
        public int getValor(){
            return this.valor;
        }
        public void setValor(int value){
            this.valor=value;
        }
        public Nodo getProx(){
            return this.prox;
        }
        public void setProx(Nodo ref){
            this.prox=ref;
        }
    }

    Nodo inicio, fim;
    int nElementos;

    public LinkedListQueue(){
        nElementos=0;
        inicio=null;
        fim=null;        
    }

    public void enqueue(int value){
        Nodo novoObjeto = new Nodo(value);

        if(nElementos==0)
            inicio=novoObjeto;
        else
            fim.setProx(novoObjeto);

        fim=novoObjeto;
        nElementos++;                
    }
    public int dequeue() throws Exception{
        if(nElementos>0){
            int valor = inicio.getValor();
            Nodo objetoADeletar=inicio;
            inicio=inicio.getProx();
            nElementos--;
            objetoADeletar.setProx(null);
            return valor;
        }
        else
            throw new Exception("Fila vazia");
        
    }
    public int head() throws Exception{
        if(nElementos>0)
            return inicio.getValor();
        else
            throw new Exception("A fila está vazia");        
    }

    public boolean isEmpty(){
        return (nElementos==0);

    }
    public int size(){
        return nElementos;        
    }
    public void clear(){
        nElementos=0;
        fim=inicio=null;        
    }

}