public class PedidoLocal extends Pedido implements Pagamento {

    public PedidoLocal(int numero, String cliente, double valor) {
        super(numero, cliente, valor);
    }
    @Override 
    public void pagar(double valor){
        System.out.printf("pagamento em dinheiro realizado: R$ %.2f%n",valor);
    }

    public void pagar(double valor, String chavePix){
        System.out.printf("Pagamento via Pix realizado: R$ %.2f%n",valor);
        System.out.println("Chave pix: "+chavePix);
    }

    public void pagar(double valor, int parcelas){
        double valorParcela = valor/parcelas;
        System.out.printf("Pagamento via cartão realizado: R$ %.2f%n",valor);
        System.out.println("Parcelas: "+parcelas);
        System.out.println("Chave pix: "+valorParcela);
        System.out.printf("Valor de cada parcela: R$ %.2f%n",valorParcela);
    }
}
