import java.util.Scanner;

public class ATVHotel {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        final int CAPACIDADE = 5;
        String[] itens = new String[CAPACIDADE];
        int[] saldos = new int[CAPACIDADE];
        int totalCadastrados = 0;
        boolean executando = true;

        while (executando) {
            System.out.println("\n[ Painel de Controle de Estoque ]");
            System.out.println("1 - Incluir produto");
            System.out.println("2 - Exibir relatório");
            System.out.println("3 - Consultar item");
            System.out.println("4 - Atualizar registro");
            System.out.println("5 - Excluir registro");
            System.out.println("6 - Encerrar");
            System.out.print("Digite a opção pretendida: ");

            int escolha = leitor.nextInt();
            leitor.nextLine(); 

            switch (escolha) {
                case 1:
                    if (totalCadastrados < itens.length) {
                        System.out.print("Informe a descrição do produto: ");
                        itens[totalCadastrados] = leitor.nextLine();
                        System.out.print("Informe o saldo inicial: ");
                        saldos[totalCadastrados] = leitor.nextInt();
                        leitor.nextLine(); 
                        totalCadastrados++;
                        System.out.println("Item gravado com sucesso.");
                    } else {
                        System.out.println("Erro: Limite de armazenamento atingido.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- ITENS CADASTRADOS ---");
                    if (totalCadastrados == 0) {
                        System.out.println("Nenhum registro encontrado.");
                    } else {
                        for (int k = 0; k < totalCadastrados; k++) {
                            System.out.println("Posição [" + k + "] -> Item: " + itens[k] + " | Saldo: " + saldos[k]);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Digite o nome do produto para busca: ");
                    String termoBusca = leitor.nextLine();
                    boolean achou = false;

                    for (int k = 0; k < totalCadastrados; k++) {
                        if (itens[k].equalsIgnoreCase(termoBusca)) {
                            System.out.println("Item localizado! Posição: " + k + " | Nome: " + itens[k] + " | Saldo: " + saldos[k]);
                            achou = true;
                            break;
                        }
                    }

                    if (!achou) {
                        System.out.println("Aviso: Registro não localizado.");
                    }
                    break;

                case 4:
                    System.out.print("Digite o nome do item que deseja modificar: ");
                    String termoAlterar = leitor.nextLine();
                    boolean modificado = false;

                    for (int k = 0; k < totalCadastrados; k++) {
                        if (itens[k].equalsIgnoreCase(termoAlterar)) {
                            System.out.print("Novo nome: ");
                            itens[k] = leitor.nextLine();
                            System.out.print("Novo saldo: ");
                            saldos[k] = leitor.nextInt();
                            leitor.nextLine(); 
                            modificado = true;
                            System.out.println("Dados atualizados com sucesso.");
                            break;
                        }
                    }

                    if (!modificado) {
                        System.out.println("Aviso: Registro não localizado.");
                    }
                    break;

                case 5:
                    System.out.print("Digite o nome do produto a remover: ");
                    String termoRemover = leitor.nextLine();
                    boolean apagado = false;

                    for (int k = 0; k < totalCadastrados; k++) {
                        if (itens[k].equalsIgnoreCase(termoRemover)) {
                            for (int idx = k; idx < totalCadastrados - 1; idx++) {
                                itens[idx] = itens[idx + 1];
                                saldos[idx] = saldos[idx + 1];
                            }
                            itens[totalCadastrados - 1] = null;
                            saldos[totalCadastrados - 1] = 0;
                            totalCadastrados--;
                            apagado = true;
                            System.out.println("Produto removido.");
                            break;
                        }
                    }

                    if (!apagado) {
                        System.out.println("Aviso: Registro não localizado.");
                    }
                    break;

                case 6:
                    System.out.println("Finalizando a aplicação...");
                    executando = false;
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
        leitor.close();
    }
}