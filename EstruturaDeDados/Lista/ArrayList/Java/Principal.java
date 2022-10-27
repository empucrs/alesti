import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        int operacao;
        do{
            operacao=menu();

            switch(operacao){
                case 0:
                    System.out.println("Fim de execucao do programa");
                    break;
                case 1: // add
                    break;
                case 2: // captura
                    break;
                case 3: // size
                    break;
                case 4:  //vazia
                    break;
                case 5:  // lista cheia
                    break;
                case 6:  //capacidade
                    break;
                case 7:  // limpa lista
                    break;
                default:
                    System.out.println("Operacão não prevista  => "+operacao);
            }

        }while(operacao!=0);

        
    }

    private static int menu(){
        Scanner usr = new Scanner(System.in);
        int opcao=-1;
        do{
            System.out.println("Menu de operacoes com a alista");
            System.out.println("  1 - Adiciona valor");
            System.out.println("  2 - Captura valor");
            System.out.println("  3 - Captura num elementos na lista");
            System.out.println("  4 - Verifica se a lista está vazia");
            System.out.println("  5 - Verifica se a lista está cheia");
            System.out.println("  6 - Captura a capacidade da lista");
            System.out.println("  7 - Limpa a lista");
            System.out.println("  0 - Sair do programa");
            System.out.print("Escolha a opcao: ");
            opcao=usr.nextInt();
        }while((opcao<0) && (opcao>7));
        return opcao;
    }
    
}
