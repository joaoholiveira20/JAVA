public class array3 {
    public static void main(String[] args) {
        int[] numero={10,20,30,40,50,60,70,80,90,100};

        for(int i=0;i<numero.length;i++){
            System.out.println("Posição "+i+" = "+numero[i]);
        }
        for (int n : numero) {
            System.out.println(n);
        }
    }
}
