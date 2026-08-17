import java.util.Scanner;

public class Cond05 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe a nome: ");
        String nome = sc.nextLine();

        System.out.println("Informe a senha: ");
        String senha = sc.nextLine();

        if (nome.equals("raquel") && senha.equals("1234")) {
            System.out.println("Login realizado com sucesso");
        } else if(nome.equals("maria") && senha.equals("5678")) {
            System.out.println("Login realizado com sucesso");
        } else {
            System.out.println("Dados incorretos");
        }



        sc.close();
    }
}
