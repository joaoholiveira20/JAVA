package Agendacontatos;
public class ContatoProfissional extends Contato {
    private String empresa;
    private String cargo;

    // Construtor chamando super(nome, numero)
    public ContatoProfissional(String nome, String numero, String empresa, String cargo) {
        super(nome, numero);
        this.empresa = empresa;
        this.cargo = cargo;
    }

    // Getters e Setters
    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    // Sobrescrita do método usando super.exibirDados()
    @Override
    public String exibirDados() {
        return super.exibirDados() + " | Tipo: Profissional | Empresa: " + empresa + " | Cargo: " + cargo;
    }
}