public class RoundQueue {

    private int [] queue;
    private int inicio, fim, nElementos;

    public RoundQueue(int size){
        if(size <=1)
            size=10;
        queue = new int[size];
        nElementos=inicio=fim=0;
    }

    public void enqueue(int value){
        if(nElementos>=queue.length)
            grow();
        queue[fim]=value;
        nElementos++;
        // ALTERNATIVA 1 DE MANUTENCAO DO COMPORTAMENTO CIRCULAR
        System.out.println("Enqueue -> valor:" +value+" na pos:"+fim);
        fim++;
        if(fim==queue.length)
            fim=0;
            
        System.out.println("prox pos => "+fim);
    }

    private void grow(){
        int [] newQueue = new int[queue.length*2];
        for(int i=0; i<queue.length; i++)
          newQueue[i]=queue[i];
        queue=newQueue;
    }

    public int dequeue() throws Exception{
        if(nElementos>=0){
            int pos= inicio;
            // ALTERNATIVA 2 DE MANUTENCAO DO COMPORTAMENTO CIRCULAR
            inicio=(inicio+1)%queue.length;
            nElementos--;
            return queue[pos];
        }
        else
            throw new Exception("A fila está vazia");

    }

    public int head() throws Exception{
        if(nElementos>0)
            return queue[inicio];
        else
            throw new Exception("A fila está vazia");
    }

    public boolean isEmpty(){
        return(nElementos==0);
    }

    public void clear(){
        queue = new int[10];
        nElementos=inicio=fim=0;
    }
    public int size(){
        return nElementos;
    }
    
}