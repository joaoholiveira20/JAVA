
public class PedidoDeDelivery extends Pedido implements Pagamento{
    private String endereco;
    private  double taxaEntrega;


    public PedidoDeDelivery(int numero, String cliente, double valor, String endereco, double taxaEntrega) {
        super(numero, cliente, valor);
        this.endereco = endereco;
        this.taxaEntrega = taxaEntrega;
    }

    public double calcularTotal(){
        return getValor()+taxaEntrega;
    }

    @Override
public void pagar(double valor) {
    System.out.printf("Pagamento em dinheiro realizado: R$%.2f%n", valor);
}

public void pagar(double valor, String chavePix) {
    System.out.printf("Pagamento via PIX realizado: R$ %.2f%n", valor);
    System.out.println("Chave PIX: " + chavePix);
}

public void pagar(double valor, int parcelas) {
    double valorParcela = valor / parcelas;
    System.out.printf("Pagamento com cartão realizado: R$ %.2f%n", valor);
    System.out.println("Parcelas: " + parcelas);
    System.out.printf("Valor de cada parcela: R$ %.2f%n", valorParcela);
}

public void mostraDados() {
    super.mostrarDados();
    System.out.println("Endereço: "+endereco);
    System.out.printf("taxa de entrega> R$ %.2f%n",taxaEntrega);
    System.out.printf("taxa com entrega> R$ %.2f%n",calcularTotal());
}

    
}
