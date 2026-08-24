import java.util.Scanner;

public class ForQ6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int op = -1; 
        
        while (op != 0) { 
            System.out.println("Menu de opções: ");
            System.out.println("1 - Calcular Tabuada");
            System.out.println("2 - Realizar Contagem Regressiva");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.print("Escreva um número: ");
                    int numTabuada = sc.nextInt();
                    System.out.println("\nTABUADA");
                    for (int i = 1; i <= 10; i++) {
                        System.out.println(numTabuada + " x " + i + " = " + (numTabuada * i));
                    }
                    break;
                case 2:
                    System.out.print("Escreva um número: ");
                    int numContagem = sc.nextInt();
                    System.out.println("\nContagem Regressiva");
                    for (int i = numContagem; i >= 0; i--) {
                        System.out.println(i);
                    }
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            System.out.println();
        }

        sc.close();
    }
}