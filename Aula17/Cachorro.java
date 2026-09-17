package Aula17;

public class Cachorro extends Animal{
    
    private  String raca;

    public Cachorro()[

    ]

    public Cachorro(String raca) {
        this.raca = raca;
    }

    public Cachorro(String nome, int idade, String raca) {
        super(nome, idade);
        this.raca = raca;
    }

    public String getRaca() {
        return raca
    }

    public  void satRaca(String raca) {
        this.raca = raca;
    }

    @Override
    public  String exibirInfo(){
        return "Cachorro | Nome "+getNome()
        +"| Idade: "+getIdade()
        +"| Raça: "+(raca==null ? "" :raca);
    }

    
}
