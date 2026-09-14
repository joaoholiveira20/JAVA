package Agendacontatos;

import java.util.ArrayList;
import java.util.Scanner;

public class CadastroContatos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Contato> contatos = new ArrayList<>();

        while (true) {
            System.out.println("\n========= AGENDA DE CONTATOS =========");
            System.out.println("1 - Cadastrar contato pessoal");
            System.out.println("2 - Cadastrar contato profissional");
            System.out.println("3 - Listar todos os contatos");
            System.out.println("4 - Pesquisar contato");
            System.out.println("5 - Alterar contato");
            System.out.println("6 - Excluir contato");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Cadastrar Contato Pessoal ---");
                    System.out.print("Nome: ");
                    String nomeP = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telP = sc.nextLine();
                    System.out.print("Parentesco: ");
                    String parentesco = sc.nextLine();

                    contatos.add(new ContatoPessoal(nomeP, telP, parentesco));
                    System.out.println("Contato Pessoal cadastrado!");
                    break;

                case 2:
                    System.out.println("\n--- Cadastrar Contato Profissional ---");
                    System.out.print("Nome: ");
                    String nomeProf = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telProf = sc.nextLine();
                    System.out.print("Empresa: ");
                    String empresa = sc.nextLine();
                    System.out.print("Cargo: ");
                    String cargo = sc.nextLine();

                    contatos.add(new ContatoProfissional(nomeProf, telProf, empresa, cargo));
                    System.out.println("Contato Profissional cadastrado!");
                    break;

                case 3:
                    System.out.println("\n--- Listar Todos os Contatos ---");
                    if (contatos.isEmpty()) {
                        System.out.println("Nenhum contato cadastrado.");
                    } else {
                        for (int i = 0; i < contatos.size(); i++) {
                            System.out.println((i + 1) + " - " + contatos.get(i).exibirDados());
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n--- Pesquisar Contato ---");
                    System.out.print("Digite o nome para pesquisar: ");
                    String nomeBusca = sc.nextLine();
                    boolean encontrado = false;

                    for (Contato c : contatos) {
                        if (c.getNome().equalsIgnoreCase(nomeBusca)) {
                            System.out.println("Contato encontrado!");
                            System.out.println(c.exibirDados());
                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Contato não encontrado!");
                    }
                    break;

                case 5:
                    System.out.println("\n--- Alterar Contato ---");
                    if (contatos.isEmpty()) {
                        System.out.println("Nenhum contato para alterar.");
                        break;
                    }

                    for (int i = 0; i < contatos.size(); i++) {
                        System.out.println((i + 1) + " - " + contatos.get(i).getNome());
                    }

                    System.out.print("Informe o número do contato que deseja alterar: ");
                    int posAlterar = sc.nextInt();
                    sc.nextLine();

                    if (posAlterar > 0 && posAlterar <= contatos.size()) {
                        Contato contatoParaAlterar = contatos.get(posAlterar - 1);

                        System.out.print("Novo Nome: ");
                        String novoNome = sc.nextLine();
                        System.out.print("Novo Telefone: ");
                        String novoTel = sc.nextLine();

                        contatoParaAlterar.setNome(novoNome);
                        contatoParaAlterar.setNumero(novoTel);

                        System.out.println("Contato alterado com sucesso!");
                    } else {
                        System.out.println("Contato inválido!");
                    }
                    break;

                case 6:
                    System.out.println("\n--- Excluir Contato ---");
                    if (contatos.isEmpty()) {
                        System.out.println("Nenhum contato para excluir.");
                        break;
                    }

                    for (int i = 0; i < contatos.size(); i++) {
                        System.out.println((i + 1) + " - " + contatos.get(i).getNome());
                    }

                    System.out.print("Informe o número do contato que deseja excluir: ");
                    int posExcluir = sc.nextInt();
                    sc.nextLine();

                    if (posExcluir > 0 && posExcluir <= contatos.size()) {
                        contatos.remove(posExcluir - 1);
                        System.out.println("Contato excluído com sucesso!");
                    } else {
                        System.out.println("Contato inválido!");
                    }
                    break;

                case 7:
                    System.out.println("Saindo do sistema...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
    }
}