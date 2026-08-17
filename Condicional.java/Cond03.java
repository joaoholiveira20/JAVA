import java.util.Scanner;

public class Cond03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe a idade do aluno: ");
        int idade = sc.nextInt();

        System.out.println("É estudante? Digite 1 para SIM e 2 para NÃO: ");
        int estudante = sc.nextInt();

        // || sifgnifica "ou" e && significa "e"
        if (idade >=60 || estudante == 1) {
            System.out.println("Você tem o direito ao desconto");
        } else {
            System.out.println("Você não tem o direito ao desconto");
        }

        sc.close();
    }
}
