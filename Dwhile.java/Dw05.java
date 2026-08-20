import java.util.Scanner;

public class Dw05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int op;

        do{
            System.out.println("Menu de opções: ");
            System.out.println("1 - iniciar jogo");
            System.out.println("2 - Carregar jogo");
            System.out.println("3 - Configurações");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("iniciar jogo");
                    break;
                case 2:
                    System.out.println("Carregar jogo");
                    break;
                case 3:
                    System.out.println("Configurações");
                    break;
                case 0:
                    System.out.println("Sair");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }while (op!=0); 
        sc.close();
    }
}
