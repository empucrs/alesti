public class Principal {

    public static void main(String[] args) {

        ArvoreBinariaDePesquisa abp = new ArvoreBinariaDePesquisa();
        try 
        {
            abp.add(10);
            abp.add(8);
            abp.add(15);
            abp.add(9);
            abp.add(12);
            abp.add(5);
            abp.add(7);
            abp.add(6);
            abp.add(1);
        } 
        catch (Exception e) {
            System.err.println("erro durante a criação da árvore");
        }

        int [] vetor = abp.positionsCentral();
        System.out.println("-=CENTRAL=-");
        for (int i : vetor)
            System.out.print(i+"L["+abp.level(i)+"], ");
        System.out.println("\n-=-=-=-=-=-==-=-=-=-==-");

        vetor = abp.positionsWidth();
        System.out.println("-=WIDTH=-");
        for (int i : vetor)
            System.out.print(i+"L["+abp.level(i)+"], ");            
        System.out.println("\n-=-=-=-=-=-==-=-=-=-==-");

        vetor = abp.positionsPos();
        System.out.println("-=POS=-");
        for (int i : vetor)
            System.out.print(i+"L["+abp.level(i)+"], ");            
        System.out.println("\n-=-=-=-=-=-==-=-=-=-==-");

        vetor = abp.positionsPre();
        System.out.println("-=PRE=-");
        for (int i : vetor)
            System.out.print(i+"L["+abp.level(i)+"], ");            
        System.out.println("\n-=-=-=-=-=-==-=-=-=-==-");

        System.out.println("\n-=-=-=-=-=-==-=-=-=-==-\n");
        System.out.print(abp.graphvizDiagram());
        System.out.println("\n-=-=-=-=-=-==-=-=-=-==-\n");

        abp.remove(8);
        vetor = abp.positionsWidth();
        System.out.println("-=WIDTH=-");
        for (int i : vetor)
            System.out.print(i+"L["+abp.level(i)+"], ");            
        System.out.println("\n-=-=-=-=-=-==-=-=-=-==-");

        System.out.println("\n-=-=-=-=-=-==-=-=-=-==-\n");
        System.out.print(abp.graphvizDiagram());
        System.out.println("\n-=-=-=-=-=-==-=-=-=-==-\n");



   }

}