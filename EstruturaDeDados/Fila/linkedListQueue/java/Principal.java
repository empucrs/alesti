public class Principal {

    public static void main(String[] args) {

        try{

            LinkedListQueue lq = new LinkedListQueue();

            System.out.println("O nro de elementos da fila é: "+ lq.size());
            System.out.println();

            lq.enqueue(14);
            System.out.println("O nro de elementos da fila é: "+ lq.size());
            System.out.println("O primeiro elementos da fila é: "+ lq.head());
            System.out.println();
            
            lq.enqueue(15);
            System.out.println("O nro de elementos da fila é: "+ lq.size());
            System.out.println("O primeiro elementos da fila é: "+ lq.head());
            System.out.println();
            
            lq.enqueue(16);
            System.out.println("O nro de elementos da fila é: "+ lq.size());
            System.out.println("O primeiro elementos da fila é: "+ lq.head());
            System.out.println();
            
            int valor=lq.dequeue();
            System.out.println("O nro de elementos da fila é: "+ lq.size());
            System.out.println("O elemento removido da fila é: "+ valor);
            System.out.println("O primeiro elementos da fila é: "+ lq.head());
            System.out.println();
            
            lq.enqueue(17);
            System.out.println("O nro de elementos da fila é: "+ lq.size());
            System.out.println("O primeiro elementos da fila é: "+ lq.head());
            System.out.println();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        
    }

    
}