import java.util.Scanner;

public class Questao01 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um número: ");
        int numero = sc.nextInt();

        if (numero > 0) {
            System.out.println("O número é POSITIVO.");
        } else if(numero < 0 ){
            System.out.println("O número é NEGATIVO");
        } else {
            System.out.println("o número é nulo");
        }


        sc.close();
    }
}
