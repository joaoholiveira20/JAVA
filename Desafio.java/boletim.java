import java.util.Scanner;

public class boletim {
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.print("Digite o seu nome: ");
        String nome=sc.nextLine();

        System.out.print("Digite a 1º nota: ");
        double n1=sc.nextDouble();

        System.out.print("Digite a 2º nota: ");
        double n2=sc.nextDouble();

        double media= (n1 + n2) / 2;

        System.out.printf(
            "Aluno: %s%nNota 1: %.2f%nNota 2: %.2f%nMédia: %.2f%n",
            nome, 
            n1, 
            n2, 
            media
        );
        sc.close();
    }
}
