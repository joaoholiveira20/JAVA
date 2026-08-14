

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.println("Informe o 1º número:");
        double n1=sc.nextDouble();

        System.out.println("Informe o 2] número:");
        double n2=sc.nextDouble();

        double media= (n1 + n2) / 2;

        System.out.println("A média é: "+media);


        sc.close();
    }

}