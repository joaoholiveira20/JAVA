import java.util.Scanner;

public class Questao06 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o 1º número: ");
        int num1 = sc.nextInt();

        System.out.println("Digite o 2º número: ");
        int num2 = sc.nextInt();

        double soma = num1 + num2;
        double subtracao = num1 - num2;
        double divisao = num1 / num2;
        double multiplicacao = num1 * num2;

        System.out.println("------------------------------------");
        System.out.printf("SOMA: %s%n", soma);
        System.out.printf("SUBTRAÇÃO = %s%n", subtracao);
        System.out.printf("DIVISÂO: %s%n", divisao);
        System.out.printf("MULTIPLICAÇÃO: %s", multiplicacao);



        sc.close();
    }
}
