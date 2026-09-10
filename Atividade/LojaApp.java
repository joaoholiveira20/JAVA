import java.util.Scanner;

public class LojaApp {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        Loja l=new  Loja(null, 0, 0);

        System.out.println("Informe o produto: ");
        l.setNome(sc.nextLine());

        System.out.println("Informe o preço: ");
        l.setPreço(sc.nextFloat());


        System.out.println("Informe a quantidade: ");
        l.setQuantidade(sc.nextInt());

        System.out.println("O Produto: "+l.getNome());
        System.out.println("O Preço: "+l.getPreço());
        System.out.println("A Quantidade: "+l.getQuantidade());


        sc.close();
    }
}

