import java.util.Scanner;

public class Questao03 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite sua idade: ");
        int idade = sc.nextInt();

        if (idade <= 12) {
            System.out.println("Você é Criança");
        }else if(idade>=13 && idade<=17){
            System.out.println("Você é adolescente");
        }else if(idade>=18 && idade<=59){
            System.out.println("Você é adulto");
        }else{
            System.out.println("Você é idoso");
        }

        sc.close();
    }
}
