import java.util.Scanner;


public class array7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] nomes = new String[3];


        //cadstrar
        System.out.println("===Cadastro de Nomes===");
        for (int i=0;i<nomes.length;i++){
            System.out.println("Digite o nome: ");
            nomes[i]=sc.nextLine();
        }

        //Listar
        System.out.println("\n Lista atual");
        listar(nomes);

        //alterar
        System.out.println("\nDigite a posição para alterar: ");
        int posAlterar=sc.nextInt();
        sc.nextLine();

        if (posAlterar>=0 && posAlterar<nomes.length) {
            System.out.println("Digite o novo nome: ");
            nomes[posAlterar]=sc.nextLine();
        }else{
            System.out.println("posição inválida");
        }

        //remover

        System.out.println("\nDigite a posição para remover: ");
        int posRemover=sc.nextInt();

        if(posRemover>=0 && posRemover<nomes.length) {
            for (int i=posRemover; i<nomes.length-1;i++){
                nomes[i]=nomes[i+1];
            }
            nomes[nomes.length -1]=null;
        }else{
            System.out.println("Posição inválida");
        }
        System.out.println("\n lista após remoção");
        listar(nomes);


        sc.close();
        }

        public static void listar(String[] array) {
            for (int i=0;i<array.length;i++){
                System.out.println("\n Lista atual");
                listar(array);
            }
        }
}


