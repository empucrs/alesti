public class Lista{

    int armazenamento[];
    int prox;

    public Lista(){
        armazenamento = new int[10];
        prox=0;
    }

    public boolean add(int value){
        if( isFull() ){
            // redimensionar minha lista
            int novoVetor [] = new int[armazenamento.length*2];
            for(int i=0; i<armazenamento.length; i++)
                novoVetor[i]=armazenamento[i];
            armazenamento=novoVetor;
        }
        armazenamento[prox]=value;
        prox++;

        return true;
            
    }

    public boolean remove(int pos){
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

    public int size(){
        return prox;
    }

    public boolean isEmpty(){
        return (prox==0);
    }

    private boolean isFull(){
        return(prox==armazenamento.length);
    }

    public int capacity(){
        return armazenamento.length;
    }
    public int get(int pos){
        if((pos<prox)&&(pos>=0)){
            return armazenamento[pos];
        }
        else
            return armazenamento[0];
    }
    public void clear(){
        prox=0;
    }

}