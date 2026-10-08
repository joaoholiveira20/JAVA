package File;
import java.io.File;
import java.io.IOException;

public class Ex01 {
    public static void main(String[] args) {
        
        try{
            File arquivo = new File
            ("exemplo.txt");
            if (arquivo.createNewFile()){
                System.out.println("Arqquivo criado com sucesso "+arquivo.getName());
            }
        }catch(IOException e){
            System.out.println("ocorreu um erro");
            e.printStackTrace();
        }
    }
}
 