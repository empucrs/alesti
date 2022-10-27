public class Principal {
    public static void main(String[] args) {
        try{
            StackArray sa = new StackArray(10);

            sa.push(12);
            sa.push(17);
            sa.push(33);
            sa.push(51);

            System.out.println("Quantidade de elementos na pilha: "+sa.size());
            System.out.println("Elementos no topo da pilha: "+sa.top());

            System.out.println(sa.pop());
            System.out.println(sa.pop());
            System.out.println(sa.pop());
            System.out.println(sa.pop());
            System.out.println(sa.pop());
        }
        catch(Exception e){
            System.err.println("Error: " + e.getMessage());

        }
    }
    
}
