import java.util.Scanner;

public class Questao07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Cores disponíveis: Verde, Azul, Amarelo, Vermelho");
        System.out.print("Digite a cor da etiqueta do CD: ");
        String cor = sc.nextLine();

        if (cor.equals("verde")){
            System.out.println("Preço do CD verde é: R$ 10,00");
        }else if(cor.equals("azul")){
            System.out.println("Preço do CD azul é: R$ 20,00");
        }else if(cor.equals("amarelo")){
            System.out.println("Preço do CD amarelo é: R$ 30,00");
        }else if(cor.equals("vermelho")){
            System.out.println("Preço do CD vermelho é: R$ 40,00");
        }
        
        
        sc.close();
    }
}
