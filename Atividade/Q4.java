import java.util.Scanner;

public class Q4 {
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.println("Informe a força aplicada: ");
        double F=sc.nextDouble();
        
        System.out.println("Informe a distância percorrida: ");
        double D=sc.nextDouble();


        double trabalho = F * D;

        System.out.println("O trabalho realizado foi: "+trabalho);

        sc.close();
    }
}