public class Principal {

    public static void main(String[] args) {
        try {

            RoundQueue rq = new RoundQueue(4);

            System.out.println("A fila tem "+rq.size()+ " elementos");

            rq.enqueue(13);
            System.out.println("A fila tem "+rq.size()+ " elementos");
            System.out.println("O primeiro elemento da fila eh  "+rq.head());

            rq.enqueue(14);
            System.out.println("A fila tem "+rq.size()+ " elementos");
            System.out.println("O primeiro elemento da fila eh  "+rq.head());

            rq.enqueue(15);
            System.out.println("A fila tem "+rq.size()+ " elementos");
            System.out.println("O primeiro elemento da fila eh  "+rq.head());

            int valor = rq.dequeue();
            System.out.println("A fila tem "+rq.size()+ " elementos");
            System.out.println("O elemento removido da fila eh  "+valor);
            System.out.println("O primeiro elemento da fila eh  "+rq.head());

            rq.enqueue(16);
            System.out.println("A fila tem "+rq.size()+ " elementos");
            System.out.println("O primeiro elemento da fila eh  "+rq.head());

            rq.enqueue(17);
            System.out.println("A fila tem "+rq.size()+ " elementos");
            System.out.println("O primeiro elemento da fila eh  "+rq.head());

            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
}
