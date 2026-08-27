import java.util.Scanner;

public class ARQ1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int capacidade = 5;
        String[] nomes = new String[capacidade];
        int[] quantidades = new int[capacidade];
        int qtd = 0;
        int opcao = 0;

        do {
            System.out.println("\n=== Sistema de Controle de Estoque ===");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Pesquisar produto");
            System.out.println("4 - Alterar produto");
            System.out.println("5 - Remover produto");
            System.out.println("6 - Sair do sistema");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    if (qtd < capacidade) {
                        System.out.print("Digite o nome do produto: ");
                        nomes[qtd] = sc.nextLine();
                        System.out.print("Digite a quantidade em estoque: ");
                        quantidades[qtd] = sc.nextInt();
                        qtd++;
                        System.out.println("Produto cadastrado com sucesso!");
                    } else {
                        System.out.println("Capacidade máxima (" + capacidade + ") atingida!");
                    }
                    break;

                case 2:
                    listar(nomes, quantidades, qtd);
                    break;

                case 3:
                    System.out.print("Digite o nome do produto para pesquisar: ");
                    String busca = sc.nextLine();
                    boolean encontrado = false;
                    for (int i = 0; i < qtd; i++) {
                        if (nomes[i].equalsIgnoreCase(busca)) {
                            System.out.println("Produto encontrado: Índice [" + i + "] | " + nomes[i] + " - " + quantidades[i] + " unidades");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) System.out.println("Produto não encontrado.");
                    break;

                case 4:
                    System.out.print("Digite o nome do produto para alterar: ");
                    String buscaAlterar = sc.nextLine();
                    int posAlterar = -1;

                    for (int i = 0; i < qtd; i++) {
                        if (nomes[i].equalsIgnoreCase(buscaAlterar)) {
                            posAlterar = i;
                            break;
                        }
                    }

                    if (posAlterar != -1) {
                        System.out.print("Digite o novo nome: ");
                        nomes[posAlterar] = sc.nextLine();
                        System.out.print("Digite a nova quantidade: ");
                        quantidades[posAlterar] = sc.nextInt();
                        System.out.println("Produto alterado com sucesso!");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("Digite o nome do produto para remover: ");
                    String buscaRemover = sc.nextLine();
                    int posRemover = -1;

                    for (int i = 0; i < qtd; i++) {
                        if (nomes[i].equalsIgnoreCase(buscaRemover)) {
                            posRemover = i;
                            break;
                        }
                    }

                    if (posRemover != -1) {
                        for (int i = posRemover; i < qtd - 1; i++) {
                            nomes[i] = nomes[i + 1];
                            quantidades[i] = quantidades[i + 1];
                        }
                        nomes[qtd - 1] = null;
                        quantidades[qtd - 1] = 0;
                        qtd--;
                        System.out.println("Produto removido com sucesso!");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 6:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);

        sc.close();
    }

    public static void listar(String[] nomes, int[] quantidades, int qtd) {
        System.out.println("\n--- Lista Atual ---");
        if (qtd == 0) {
            System.out.println("Nenhum produto cadastrado.");
        }
        for (int i = 0; i < qtd; i++) {
            System.out.println("Índice [" + i + "] | " + nomes[i] + " - " + quantidades[i] + " unidades");
        }
    }
}