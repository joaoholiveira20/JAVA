import java.util.Scanner;

public class Questao04 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a sua idade: ");
        int idade = sc.nextInt();

        if (idade>=18) {
            System.out.println("Você é maior de idade.");
        } else {
            System.out.println("você é menor de idade.");
        }



        sc.close();
    }
}
