import java.util.Scanner;

public class Q1 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o 1ª número: ");
        double N1=sc.nextDouble();

        System.out.println("Informe o 2ª número: ");
        double N2=sc.nextDouble();

        double soma=N1 + N2;
        double sub= N1 - N2;
        double div= N1 / N2;
        double mult= N1 * N2;

        System.out.print("SOMA: "+soma);
        System.out.println("SUBTRAÇÃO: "+sub);
        System.out.print("DIVISÃO: "+div);
        System.out.print("MULTIPLICAÇÃO: "+mult);




        sc.close();
    }
}