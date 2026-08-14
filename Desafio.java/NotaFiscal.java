import java.util.Scanner;

public class NotaFiscal {
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.print("Digite o seu nome: ");
        String nome=sc.nextLine();

        System.out.print("Digite o nome do produto: ");
        String produto=sc.nextLine();

        System.out.print("Digite a quantidade: ");
        int quantidade=sc.nextInt();

        System.out.print("Digite o valor unitário: ");
        double valorUnitario=sc.nextDouble();

        double total= quantidade * valorUnitario;

        System.out.println("---------- NOTA FISCAL ----------");
        System.out.printf(
            "Cliente: %s%nProduto: %s%nQuantidade: %d%nPreço: %.2f%n Total: %.2f%n",
            nome, 
            produto, 
            quantidade, 
            valorUnitario, 
            total
        );
        System.out.print("---------------------------------");



        sc.close();
    }
}
