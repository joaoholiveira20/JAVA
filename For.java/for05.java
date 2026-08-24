import java.util.Scanner;

public class for05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i=1;i<=100;i++){
            System.out.println("informe o nome: "+i);
            String nome=sc.nextLine();
            System.out.println("O nome cadastrado é: "+nome);
        }

        sc.close();
    }
}
