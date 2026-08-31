import java.util.Scanner;

public class ATVNumeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numeros = new int[5];
        int numerosTotal = 0;
        boolean executando = true; 

        while (executando) { 
            System.out.println("=== MENU INTERATIVO ===");
            System.out.println("1 - Inserir número");
            System.out.println("2 - Listar números");
            System.out.println("3 - Remover número");
            System.out.println("4 - Sair");
            System.out.print("Digite uma opção: ");
            int opcao = sc.nextInt();

            switch (opcao) { 
                case 1:
                    if (numerosTotal < numeros.length) {
                        System.out.print("Digite o número para inserir: ");
                        numeros[numerosTotal] = sc.nextInt();
                        numerosTotal++;
                        System.out.println("Número inserido com sucesso!\n");
                    } else {
                        System.out.println("Erro: O array está cheio. Não é possível inserir mais números.\n");
                    }
                    break;

                case 2:
                    System.out.println("\n--- LISTA DE NÚMEROS ---");
                    if (numerosTotal == 0){
                        System.out.println("Não há números cadastrados.\n");
                    } else {
                        for (int i = 0; i < numerosTotal; i++) {
                            System.out.println("Índice [" + i + "]: " + numeros[i]);
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    if (numerosTotal == 0){
                        System.out.println("O array está vazio.\n");
                    } else {
                        System.out.print("Digite o índice do número que deseja remover: ");
                        int indice = sc.nextInt();

                        if (indice >= 0 &&  indice < numerosTotal) {
                            for (int i = indice; i < numerosTotal - 1; i++) {
                                numeros[i] = numeros[i + 1];
                            }
                            numerosTotal--;
                            System.out.println("Número removido com sucesso!\n");
                        } else {
                            System.out.println("Índice inválido!\n");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Encerrando o programa...");
                    executando = false; 
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.\n");
                    break;
            }
        }
        
        sc.close();
    }
}