public class ContaCorrente extends Conta implements Pagamento {

    public ContaCorrente(String numero, String titular, double saldoInicial, Agencia agencia) {
        super(numero, titular, saldoInicial, agencia);
    }

    // Método auxilar para validação de pagamentos
    private boolean validarPagamento(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: O valor do pagamento deve ser maior que zero!");
            return false;
        }
        if (valor > getSaldo()) {
            System.out.println("Erro: Saldo insuficiente para realizar a operação!");
            System.out.printf("Saldo disponível: R$ %.2f | Valor solicitado: R$ %.2f%n", getSaldo(), valor);
            return false;
        }
        return true;
    }

    // Sobrecarga 1: Pagamento em Dinheiro (Implementação da interface Pagamento)
    @Override
    public void pagar(double valor) {
        if (validarPagamento(valor)) {
            this.saldo -= valor;
            System.out.println("Pagamento em dinheiro realizado com sucesso!");
            System.out.printf("Saldo atualizado: R$ %.2f%n", this.saldo);
        }
    }

    // Sobrecarga 2: Pagamento via PIX
    public void pagar(double valor, String chavePix) {
        if (validarPagamento(valor)) {
            this.saldo -= valor;
            System.out.println("Pagamento via PIX realizado com sucesso!");
            System.out.println("Chave PIX utilizada: " + chavePix);
            System.out.printf("Saldo atualizado: R$ %.2f%n", this.saldo);
        }
    }

    // Sobrecarga 3: Pagamento via Cartão
    public void pagar(double valor, int parcelas) {
        if (parcelas <= 0) {
            System.out.println("Erro: A quantidade de parcelas deve ser maior que zero!");
            return;
        }
        if (validarPagamento(valor)) {
            this.saldo -= valor;
            double valorParcela = valor / parcelas;
            System.out.println("Pagamento no cartão realizado com sucesso!");
            System.out.printf("Parcelado em %dx de R$ %.2f%n", parcelas, valorParcela);
            System.out.printf("Saldo atualizado: R$ %.2f%n", this.saldo);
        }
    }

    // Funcionalidade adicional: Desafio (Transferência)
    public void transferir(double valor, String contaDestino) {
        if (valor <= 0) {
            System.out.println("Erro: O valor da transferência deve ser maior que zero!");
            return;
        }
        if (valor > getSaldo()) {
            System.out.println("Erro: Saldo insuficiente para realizar a transferência!");
            System.out.printf("Saldo disponível: R$ %.2f | Valor solicitado: R$ %.2f%n", getSaldo(), valor);
            return;
        }
        this.saldo -= valor;
        System.out.println("Transferência realizada com sucesso para a conta " + contaDestino + "!");
        System.out.printf("Saldo atualizado: R$ %.2f%n", this.saldo);
    }
}