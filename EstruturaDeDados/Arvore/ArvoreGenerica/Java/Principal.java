public class Principal {

    public static void main(String[] args) {

        GenericTree gt = new GenericTree();

        gt.add(3, null);
        gt.add(1, 3);
        gt.add(7, 3);
        gt.add(4, 3);
        gt.doTheString();
        System.out.println();
        gt.add(5, 7);
        gt.doTheString();
        System.out.println();

       
    }

    
}