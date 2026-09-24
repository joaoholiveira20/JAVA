import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("        CADASTRO INICIAL BANCO      ");
        System.out.println("====================================");

        System.out.print("Número da agência: ");
        String numAgencia = scanner.nextLine();

        System.out.print("Nome da agência: ");
        String nomeAgencia = scanner.nextLine();

        Agencia agencia = new Agencia(numAgencia, nomeAgencia);

        System.out.print("Número da conta: ");
        String numConta = scanner.nextLine();

        System.out.print("Nome do titular: ");
        String titular = scanner.nextLine();

        System.out.print("Saldo inicial: ");
        double saldoInicial = Double.parseDouble(scanner.nextLine().replace(",", "."));

        ContaCorrente conta = new ContaCorrente(numConta, titular, saldoInicial, agencia);

        int opcao = -1;

        do {
            System.out.println("\n------------------------------------");
            System.out.println("                MENU                ");
            System.out.println("------------------------------------");
            System.out.println("1 - Mostrar dados da conta");
            System.out.println("2 - Consultar saldo");
            System.out.println("3 - Depositar");
            System.out.println("4 - Pagar com PIX");
            System.out.println("5 - Pagar com cartão");
            System.out.println("6 - Pagar em dinheiro");
            System.out.println("7 - Transferir (Desafio)");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Digite um número do menu.");
                continue;
            }

            System.out.println();

            switch (opcao) {
                case 1:
                    conta.exibirDados();
                    break;

                case 2:
                    conta.consultarSaldo();
                    break;

                case 3:
                    System.out.print("Informe o valor do depósito: R$ ");
                    double valorDeposito = Double.parseDouble(scanner.nextLine().replace(",", "."));
                    conta.depositar(valorDeposito);
                    break;

                case 4:
                    System.out.print("Informe o valor do pagamento PIX: R$ ");
                    double valorPix = Double.parseDouble(scanner.nextLine().replace(",", "."));
                    System.out.print("Informe a chave PIX: ");
                    String chavePix = scanner.nextLine();
                    conta.pagar(valorPix, chavePix);
                    break;

                case 5:
                    System.out.print("Informe o valor da compra no cartão: R$ ");
                    double valorCartao = Double.parseDouble(scanner.nextLine().replace(",", "."));
                    System.out.print("Informe a quantidade de parcelas: ");
                    int parcelas = Integer.parseInt(scanner.nextLine());
                    conta.pagar(valorCartao, parcelas);
                    break;

                case 6:
                    System.out.print("Informe o valor do pagamento em dinheiro: R$ ");
                    double valorDinheiro = Double.parseDouble(scanner.nextLine().replace(",", "."));
                    conta.pagar(valorDinheiro);
                    break;

                case 7:
                    System.out.print("Informe o número da conta de destino: ");
                    String contaDestino = scanner.nextLine();
                    System.out.print("Informe o valor da transferência: R$ ");
                    double valorTransf = Double.parseDouble(scanner.nextLine().replace(",", "."));
                    conta.transferir(valorTransf, contaDestino);
                    break;

                case 0:
                    System.out.println("Encerrando o programa. Sistema finalizado com sucesso!");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }

        } while (opcao != 0);

        scanner.close();
    }
}
