import java.util.Scanner;

public class Q5 {
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.println("Informe o seu peso em KG: ");
        double peso=sc.nextDouble();

        System.out.println("Informe a sua altura em CM: ");
        double altura=sc.nextDouble();

        double IMC = peso / altura;

        System.out.println("O seu IMC é: IMC ="+IMC);



        sc.close();
    }
}