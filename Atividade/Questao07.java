import java.util.Scanner;

public class Questao07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Cores disponíveis: Verde, Azul, Amarelo, Vermelho");
        System.out.print("Digite a cor da etiqueta do CD: ");
        String cor = sc.nextLine().toLowerCase();
        
        
        switch (cor) {
            case "verde":
                System.out.println("O preço do CD Verde é: R$ 10,00");
                break; 
            case "azul":
                System.out.println("O preço do CD Azul é: R$ 20,00");
                break;
            case "amarelo":
                System.out.println("O preço do CD Amarelo é: R$ 30,00");
                break;
            case "vermelho":
                System.out.println("O preço do CD Vermelho é: R$ 40,00");
                break;
            default:
                
                System.out.println("Cor inválida! Essa cor não está na tabela de preços.");
                break;
        }
        
        sc.close();
    }
}
