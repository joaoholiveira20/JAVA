package Try;

public class Try2 {
    public static void main(String[] args) {
        int [] numeros={10,20,30};

        try{
            System.out.println(numeros[5]);

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Erro: índice forado limite");
        }
        finally{
            System.out.println("Fim do progama!");
        }
    }
}
