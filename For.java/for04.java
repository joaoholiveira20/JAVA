import java.util.Scanner;

public class for04 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i=1;i<=100;i++){
            System.out.println("Informe o "+ i +" º número");
            int numero=sc.nextInt();
            System.out.println("O valor infomado é: "+numero);
        }

        sc.close();
    }
}
