package Conta;
import java.util.Scanner;

import Conta;

public class ContaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CadastroConta cadastro = new CadastroConta();
        boolean executando = true;

        while (executando) {
            exibirMenu();
            System.out.print("Escolha uma opção: ");
            String opcaoInput = scanner.nextLine().trim();

            switch (opcaoInput) {
                case "1":
                    cadastrarConta(scanner, cadastro);
                    break;
                case "2":
                    buscarConta(scanner, cadastro);
                    break;
                case "3":
                    removerConta(scanner, cadastro);
                    break;
                case "4":
                    System.out.println("\nSaindo do sistema... Até logo!");
                    executando = false;
                    break;
                default:
                    System.out.println("\n[ERRO] Opção inválida. Escolha entre 1 e 4.\n");
                    break;
            }
        }

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("=================================");
        System.out.println("    SISTEMA DE CONTAS BANCÁRIAS   ");
        System.out.println("=================================");
        System.out.println("1. Cadastrar Conta");
        System.out.println("2. Buscar Conta");
        System.out.println("3. Remover Conta");
        System.out.println("4. Sair");
        System.out.println("=================================");
    }

    private static void cadastrarConta(Scanner scanner, CadastroConta cadastro) {
        System.out.println("\n--- CADASTRO DE CONTA ---");
        try {
            System.out.print("Número da Conta: ");
            String numero = scanner.nextLine();

            System.out.print("Nome do Titular: ");
            String titular = scanner.nextLine();

            System.out.print("Saldo Inicial: ");
            double saldo;
            try {
                saldo = Double.parseDouble(scanner.nextLine().replace(",", "."));
            } catch (NumberFormatException e) {
                throw new ExcecaoDadoInvalido("O saldo digitado deve ser um número válido.");
            }

            // Instanciação ativa as validações da classe Conta
            Conta novaConta = new Conta(numero, titular, saldo);

            // Inserção ativa as validações de duplicidade e limite de 100
            cadastro.inserir(novaConta);

            System.out.println("\n[SUCESSO] Conta cadastrada com sucesso!");

        } catch (ExcecaoDadoInvalido | ExcecaoElementoJaExistente | ExcecaoRepositorio e) {
            System.out.println("\n[ERRO] " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\n[ERRO INESPERADO] " + e.getMessage());
        }
        System.out.println();
    }

    private static void buscarConta(Scanner scanner, CadastroConta cadastro) {
        System.out.println("\n--- BUSCAR CONTA ---");
        try {
            System.out.print("Informe o número da conta: ");
            String numero = scanner.nextLine();

            Conta conta = cadastro.buscar(numero);

            System.out.println("\n--- DADOS DA CONTA ---");
            System.out.println("Titular: " + conta.getTitular());
            System.out.printf("Saldo: R$ %.2f\n", conta.getSaldo());

        } catch (ExcecaoElementoInexistente e) {
            System.out.println("\n[ERRO] " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\n[ERRO INESPERADO] " + e.getMessage());
        }
        System.out.println();
    }

    private static void removerConta(Scanner scanner, CadastroConta cadastro) {
        System.out.println("\n--- REMOVER CONTA ---");
        try {
            System.out.print("Informe o número da conta a ser removida: ");
            String numero = scanner.nextLine();

            cadastro.remover(numero);
            System.out.println("\n[SUCESSO] Conta removida com sucesso!");

        } catch (ExcecaoElementoInexistente e) {
            System.out.println("\n[ERRO] " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\n[ERRO INESPERADO] " + e.getMessage());
        }
        System.out.println();
    }
}