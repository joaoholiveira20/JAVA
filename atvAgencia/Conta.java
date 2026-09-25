public class Conta {
    private String numero;
    private String titular;
    protected double saldo;
    private Agencia agencia;

    public Conta(String numero, String titular, double saldoInicial, Agencia agencia) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = Math.max(0, saldoInicial);
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: O valor do depósito deve ser maior que zero!");
            return;
        }
        this.saldo += valor;
        System.out.println("Depósito realizado com sucesso!");
        System.out.printf("Novo saldo: R$ %.2f%n", this.saldo);
    }

    public void consultarSaldo() {
        System.out.printf("Saldo atual disponível: R$ %.2f%n", this.saldo);
    }

    public void exibirDados() {
        System.out.println("====================================");
        System.out.println("        DADOS DA CONTA BANCÁRIA      ");
        System.out.println("====================================");
        if (agencia != null) {
            System.out.println("Agência: " + agencia.getNumero() + " - " + agencia.getNome());
        }
        System.out.println("Número da Conta: " + numero);
        System.out.println("Titular: " + titular);
        System.out.printf("Saldo: R$ %.2f%n", saldo);
        System.out.println("====================================");
    }
}