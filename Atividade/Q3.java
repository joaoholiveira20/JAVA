import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe p 1ª número: ");
        double N1=sc.nextDouble();

        System.out.println("Informe p 2ª número: ");
        double N2=sc.nextDouble();
        
        System.out.println("Informe p 3ª número: ");
        double N3=sc.nextDouble();

        double media = (N1 + N2 + N3)/3;    

        System.out.println("A média é: "+media);



        sc.close();
    }
}