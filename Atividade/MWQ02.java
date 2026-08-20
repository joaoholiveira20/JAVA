import java.util.Scanner;



public class MWQ02 {
        public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
        int op=0;
        while (op != 4) {
            System.out.println("Menu de canetas: ");
            System.out.println("1 -  Caneta Esferográfica");
            System.out.println("2 - Caneta Gel");
            System.out.println("3 - Caneta Tinteiro");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("  Caneta Esferográfica: Econômica e de longa duração");
                    break;
                case 2:
                    System.out.println("Caneta Gel: Tinta mais pigmentada e escrita suave");
                    break;
                case 3:
                    System.out.println("Caneta Tinteiro: Clássica e elegante, usada para caligrafia");
                    break;
                case 4:
                    System.out.println("Sair");
                    break;
                   
                default:
                    break;
            }
        }
        sc.close();
    }
} 

