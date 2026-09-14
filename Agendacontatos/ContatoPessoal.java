package Agendacontatos;
public class ContatoPessoal extends Contato {
    private String parentesco;

    // Construtor chamando super(nome, numero)
    public ContatoPessoal(String nome, String numero, String parentesco) {
        super(nome, numero);
        this.parentesco = parentesco;
    }

    // Getter e Setter
    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    // Sobrescrita do método usando super.exibirDados() para evitar erro de acesso aos atributos privados
    @Override
    public String exibirDados() {
        return super.exibirDados() + " | Tipo: Pessoal | Parentesco: " + parentesco;
    }
}