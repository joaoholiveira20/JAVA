import java.util.Scanner;

public class WQ03 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Qual o professor mais fofo do senai: ");
            String nome=sc.nextLine();

            if (nome.equals("anderson")){
                break;
            }
        }

        sc.close();
    }
}
