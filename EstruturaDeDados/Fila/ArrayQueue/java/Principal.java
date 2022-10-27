public class Principal {

    public static void main(String[] args) {
        try {

            ArrayQueue aq = new ArrayQueue(4);

            System.out.println("A fila tem "+aq.size()+ " elementos");

            aq.enqueue(13);
            System.out.println("A fila tem "+aq.size()+ " elementos");
            System.out.println("O primeiro elemento da fila eh  "+aq.head());

            aq.enqueue(14);
            System.out.println("A fila tem "+aq.size()+ " elementos");
            System.out.println("O primeiro elemento da fila eh  "+aq.head());

            aq.enqueue(15);
            System.out.println("A fila tem "+aq.size()+ " elementos");
            System.out.println("O primeiro elemento da fila eh  "+aq.head());

            int valor = aq.dequeue();
            System.out.println("A fila tem "+aq.size()+ " elementos");
            System.out.println("O elemento removido da fila eh  "+valor);
            System.out.println("O primeiro elemento da fila eh  "+aq.head());

            aq.enqueue(16);
            System.out.println("A fila tem "+aq.size()+ " elementos");
            System.out.println("O primeiro elemento da fila eh  "+aq.head());

            aq.enqueue(17);
            System.out.println("A fila tem "+aq.size()+ " elementos");
            System.out.println("O primeiro elemento da fila eh  "+aq.head());

            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
}
