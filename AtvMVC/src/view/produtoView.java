package view;

import java.util.Scanner;

import controle.ClienteControle;
import controller.ProdutoController;
import model.Produto;
import modelo.Cliente;

// View: responsável pela interação com o usuário.
public class ProdutoView {

    private Scanner sc = new Scanner(System.in);
    private ClienteControle controller = new ClienteControle();

    // Exibe o menu principal.
    public void menu() {
        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE PRODUTOS =====");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar");
            System.out.println("4 - Alterar");
            System.out.println("5 - Remover");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    alterar();
                    break;
                case 5:
                    remover();
                    break;
                case 0:
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    // Cadastra um produto.
    private void cadastrar() {
        System.out.println("\n--- CADASTRO ---");

        System.out.print("Código: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Preço: ");
        double preco = sc.nextDouble();

        controller.cadastrar(codigo, nome, nome, nome);
        System.out.println("Produto cadastrado com sucesso!");
    }

    // Lista os produtos.
    private void listar() {
        System.out.println("\n--- PRODUTOS ---");

        if (controller.listar().isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (Cliente cliente : controller.listar()) {
                System.out.println("Código: " + cliente.getCodigo());
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("Telefone: R$ " + cliente.getTelefone());
                System.out.println("E-mail: R$ " + cliente.getEmail());
                System.out.println("--------------------");
            }
        }
    }

    // Busca um produto pelo código.
    private void buscar() {
        System.out.print("\nDigite o código: ");
        int codigo = sc.nextInt();

        Cliente cliente = controller.buscar(codigo);

        if (cliente != null) {
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Telefone: R$ " + cliente.getTelefone());
            System.out.println("E-mail: R$ " + cliente.getEmail());
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    // Altera um produto.
    private void alterar() {
        System.out.print("\nCódigo do produto: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        Produto produto = controller.buscar(codigo);

        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        System.out.print("Novo nome: ");
        String nome = sc.nextLine();

        System.out.print("Novo preço: ");
        double preco = sc.nextDouble();

        boolean alterado = controller.alterar(codigo, nome, nome, nome);

        if (alterado) {
            System.out.println("Produto alterado!");
        } else {
            System.out.println("Não foi possível alterar.");
        }
    }

    // Remove um produto.
    private void remover() {
        System.out.print("\nCódigo do produto: ");
        int codigo = sc.nextInt();

        boolean removido = controller.remover(codigo);

        if (removido) {
            System.out.println("Produto removido!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
}