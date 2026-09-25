public class Pedido {
    private int numero;
    private String cliente;
    private double valor;
    
    public Pedido(int numero, String cliente, double valor) {
        this.numero = numero;
        this.cliente = cliente;
        this.valor = valor;
    }


    public int getNumero() {
        return numero;
    }


    public void setNumero(int numero) {
        this.numero = numero;
    }


    public String getCliente() {
        return cliente;
    }


    public void setCliente(String cliente) {
        this.cliente = cliente;
    }


    public double getValor() {
        return valor;
    }


    public void setValor(double valor) {
        this.valor = valor;
    }

    public void mostrarDados(){
        System.out.println("=====DADOS DO PEDIDO=====");
        System.out.println("Número: "+numero);
        System.out.println("Cliente: "+cliente);
        System.out.printf("Valor do pedido R$ %.2f%n",valor);
    }

    
}
