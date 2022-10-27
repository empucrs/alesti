public class ListaEncadeada{

    private class nodo{
        private int valor;
        private nodo referencia;
        public nodo(int valor) {
            this.valor = valor;
            this.referencia = null;
        }
        public int getValor() {
            return valor;
        }
        public void setValor(int valor) {
            this.valor = valor;
        }
        public nodo getReferencia() {
            return referencia;
        }
        public void setReferencia(nodo referencia) {
            this.referencia = referencia;
        }        
    }

    private nodo inicio, fim;
    private int size;

    public ListaEncadeada(){
        clear();
    }

    public boolean addAt(int idx, int value){

        if(idx==0){
            //incluir o primeiro elemento
            return add_01_inicio(value);
        }
        else if(idx==size){
            return add_O1_fim(value);
        }
        else if((idx>0) && (idx<size)){
            nodo amyrKlink=inicio;
            idx--;
            while(idx>0){
                amyrKlink=amyrKlink.getReferencia();
                idx--;
            }

            nodo novoNodo = new nodo(value);
            novoNodo.setReferencia(amyrKlink.getReferencia());
            amyrKlink.setReferencia(novoNodo);
            size++;
            return true;
        }

        return false;

    }

    public boolean removeAt(int idx){
        if(isEmpty() || (idx<0) || (idx>=size))
            return false;
        else{

            nodo nodoASerEliminado=inicio;

            if(idx==0){
                inicio=inicio.getReferencia();
                nodoASerEliminado.setReferencia(null);
                if(size==1) fim=inicio;
            }
            else if(idx<size){
                for(int i=0; i<idx-1; i++)
                    nodoASerEliminado=nodoASerEliminado.getReferencia();

                nodo anterior=nodoASerEliminado;                
                nodoASerEliminado=nodoASerEliminado.getReferencia();

                anterior.setReferencia(nodoASerEliminado.getReferencia());
                nodoASerEliminado.setReferencia(null);
            }

            size--;
            return true;
        }
        
    }

    public boolean swapValor(int idx01, int idx02){
        if((idx01<0)||(idx01>=size))
            return false;
        if((idx02<0)||(idx02>=size))
            return false;

            nodo refIdx01=inicio;
            for(int i=0; i<idx01; i++)
                refIdx01=refIdx01.getReferencia();
    
            nodo refIdx02=inicio;
            for(int i=0; i<idx02; i++)
                refIdx02=refIdx02.getReferencia();

            // trocando só o valor
            int aux=refIdx01.getValor();
            refIdx01.setValor(refIdx02.getValor());
            refIdx02.setValor(aux);

            return true;

    }

    public boolean swapNodo(int idx01, int idx02){
        if((idx01<0)||(idx01>=size))
            return false;
        if((idx02<0)||(idx02>=size))
            return false;

        nodo prevIdx01=inicio;
        for(int i=0; i<idx01-1; i++)
            prevIdx01=prevIdx01.getReferencia();

        nodo prevIdx02=inicio;
        for(int i=0; i<idx02-1; i++)
            prevIdx02=prevIdx02.getReferencia();

        // trocar os nodos de lugar
        nodo refIdx01, refIdx02;
        refIdx01=prevIdx01.getReferencia();
        refIdx02=prevIdx02.getReferencia();

        // PARAMOS AQUI....


    }


    public boolean add_On(int value){
        if(isEmpty()){
            fim = inicio = new nodo(value);
            size++;
        }
        else{            
            nodo amyrKlink = inicio;
            while(amyrKlink.getReferencia()!=null)
                amyrKlink=amyrKlink.getReferencia();
            nodo auxiliar = new nodo(value);
            amyrKlink.setReferencia(auxiliar);
            fim = amyrKlink;
            size++;
        }
    }

    public boolean add_O1_fim(int value){
        if(isEmpty()){
            fim  = inicio = new nodo(value);
            size++;
        }
        else{            
            nodo auxiliar = new nodo(value);
            fim.setReferencia(auxiliar);
            fim = auxiliar;
            size++;
        }
    }

    public boolean add_01_inicio(int value){

        if(isEmpty()){
            fim  = inicio = new nodo(value);
            size++;
        }
        else{
            nodo auxiliar = new nodo(value);
            auxiliar.setReferencia(inicio);
            inicio=auxiliar;
            size++;
        }


    }

    public boolean add_01_inicio_Alternativo(int value){

        size++;
        nodo auxiliar = new nodo(value);
        
        if(isEmpty())
            fim  = inicio = auxiliar;
        else{
            auxiliar.setReferencia(inicio);
            inicio=auxiliar;
        }
    }

    public boolean remove(int pos){

        //1. confere se pos é valido
        //1.1 se for válida entao
        if(pos>=0 && pos<size){
        //  --> achar o nodo da posicao pos (nodoPos)
        //  --> nodoAnterior ao nodoPos (nodoAnt)
        //  --> Passar ref do nodoPos para referencia do nodoAnt
            if(pos>0){
                nodo nodoAnt, nodoPos;
                nodoAnt=inicio;
                while(pos>1){
                    nodoAnt=nodoAnt.getReferencia();
                    pos--;
                }
                nodoPos=nodoAnt.getReferencia();
                nodoAnt.setReferencia(nodoPos.getReferencia());
                nodoPos.setReferencia(null);
                nodoPos=null;
            }
            else{
                nodo nodoPos = inicio;
                inicio = inicio.getReferencia();
                nodoPos.setReferencia(null);
                nodoPos=null;
            }

            size--;

            return true;
        }
        else
        //1.2 se não for válida (return false)
            return false;



    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return (size==0);
    }

    public int get(int pos){
        if((pos>=0) && (pos<size)){
            nodo amyrKlink=inicio;
            while(pos>0){
                amyrKlink=amyrKlink.getReferencia();
                pos--;
            }
            return amyrKlink.getValor();
        }
        else
            return -1;

    }

    public void clear(){
        inicio=fim=null;
        size=0;
    }

}