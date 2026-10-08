package File;

import java.io.FileWriter;
import java.io.IOException;

public class Ex02 {
    public static void main(String[] args) {
        
        try{
            FileWriter escritor = new FileWriter("exemplo.txt", true);
            escritor.write("eu amo mnh ex\n");
            escritor.write("IREI VOLTAR COM ELA?\n");

            escritor.close();
            System.out.println("Escrita concluida");
        }catch(IOException e){
            System.out.println("Erro ao escrever no arquivo");
            e.printStackTrace();
        }
    }
}
