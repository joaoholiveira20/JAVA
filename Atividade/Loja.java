public class Loja {
    private String nome;
    private float preço;
    private int quantidade;

    public Loja(String nome, float preço, int quantidade){
        this.nome=nome;
        this.preço=preço;
        this.quantidade=quantidade;
    }

    public String getNome(){
        return nome;
    }
    public  void setNome(String nome){
        this.nome=nome;
    }

    public float getPreço(){
        return preço;
    }
    public  void setPreço(float preço){
        this.preço=preço;
    }

    public int getQuantidade(){
        return quantidade;
    }
    public  void setQuantidade(int quantidade){
        this.quantidade=quantidade;
    }
}
