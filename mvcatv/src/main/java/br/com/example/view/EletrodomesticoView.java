
import javax.swing.JOptionPane;
import java.util.List;

public class EletrodomesticoView {
    private EletrodomesticoControle controle;

    public EletrodomesticoView() {
        this.controle = new EletrodomesticoControle();
    }

    public void exibirMenu() {
        String[] opcoes = {"1", "2", "3", "4", "5"};
        String menu = "Menu Principal\n"
                    + "1. Cadastrar eletrodoméstico\n"
                    + "2. Listar eletrodomésticos\n"
                    + "3. Alterar eletrodoméstico\n"
                    + "4. Remover eletrodoméstico\n"
                    + "5. Sair\n\n"
                    + "Escolha uma opção:";

        while (true) {
            String escolha = (String) JOptionPane.showInputDialog(null, menu, "Sistema de Eletrodomésticos", 
                        JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

            if (escolha == null || escolha.equals("5")) {
                JOptionPane.showMessageDialog(null, "Encerrando o sistema...");
                break;
            }

            switch (escolha) {
                case "1": cadastrar(); break;
                case "2": listar(); break;
                case "3": alterar(); break;
                case "4": remover(); break;
                default: JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }

    private void cadastrar() {
        String nome = lerString("Digite o nome do produto:", null);
        if (nome == null) return; 

        String marca = lerString("Digite a marca:", null);
        if (marca == null) return;

        String voltagem = lerString("Digite a voltagem (ex: 110V, 220V, Bivolt):", null);
        if (voltagem == null) return;

        Double preco = lerPreco("Digite o preço (use ponto para decimais, ex: 1599.90):", null);
        if (preco == null) return;

        Eletrodomestico e = new Eletrodomestico(nome, marca, voltagem, preco);
        String msg = controle.cadastrar(e);
        JOptionPane.showMessageDialog(null, msg);
    }

    private void listar() {
        List<Eletrodomestico> lista = controle.listar();
        if (lista == null) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum eletrodoméstico está cadastrado.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (Eletrodomestico e : lista) {
            sb.append("ID: ").append(e.getId())
            .append(" | Nome: ").append(e.getNome())
            .append(" | Marca: ").append(e.getMarca())
            .append(" | Voltagem: ").append(e.getVoltagem())
            .append(" | Preço: R$ ").append(String.format("%.2f", e.getPreco()))
            .append("\n------------------------------------------\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Eletrodomésticos", JOptionPane.INFORMATION_MESSAGE);
    }

    private void alterar() {
        Integer id = lerId();
        if (id == null) return;

        Eletrodomestico atual = controle.buscarPorId(id);
        if (atual == null) {
            JOptionPane.showMessageDialog(null, "ID não encontrado!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String nome = lerString("Nome:", atual.getNome());
        if (nome == null) return; 

        String marca = lerString("Marca:", atual.getMarca());
        if (marca == null) return;

        String voltagem = lerString("Voltagem:", atual.getVoltagem());
        if (voltagem == null) return;

        Double preco = lerPreco("Preço (ex: 1599.90):", String.valueOf(atual.getPreco()));
        if (preco == null) return;

        atual.setNome(nome);
        atual.setMarca(marca);
        atual.setVoltagem(voltagem);
        atual.setPreco(preco);

        String msg = controle.alterar(atual);
        JOptionPane.showMessageDialog(null, msg);
    }

    private void remover() {
        Integer id = lerId();
        if (id == null) return;

        Eletrodomestico atual = controle.buscarPorId(id);
        if (atual == null) {
            JOptionPane.showMessageDialog(null, "ID não encontrado!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String dados = "Deseja realmente excluir este eletrodoméstico?\n\n"
                    + "Nome: " + atual.getNome() + "\n"
                    + "Marca: " + atual.getMarca() + "\n"
                    + "Preço: R$ " + atual.getPreco();

        int confirmacao = JOptionPane.showConfirmDialog(null, dados, "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);
        
        if (confirmacao == JOptionPane.YES_OPTION) {
            String msg = controle.remover(id);
            JOptionPane.showMessageDialog(null, msg);
        }
    }

    // --- MÉTODOS AUXILIARES DE VALIDAÇÃO --- //

    private String lerString(String mensagem, String valorInicial) {
        while (true) {
            String input = (String) JOptionPane.showInputDialog(null, mensagem, "Entrada de Dados", 
                    JOptionPane.PLAIN_MESSAGE, null, null, valorInicial);
            
            if (input == null) return null; // Usuário cancelou
            
            input = input.trim();
            if (!input.isEmpty()) return input;
            
            JOptionPane.showMessageDialog(null, "O campo não pode ficar vazio!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Double lerPreco(String mensagem, String valorInicial) {
        while (true) {
            String input = (String) JOptionPane.showInputDialog(null, mensagem, "Entrada de Preço", 
                    JOptionPane.PLAIN_MESSAGE, null, null, valorInicial);
            
            if (input == null) return null; // Usuário cancelou
            
            try {
                double preco = Double.parseDouble(input.trim());
                if (preco > 0) return preco;
                JOptionPane.showMessageDialog(null, "O preço deve ser maior que zero!", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Formato inválido! Use apenas números e ponto.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private Integer lerId() {
        while (true) {
            String input = JOptionPane.showInputDialog("Digite o ID do eletrodoméstico:");
            if (input == null) return null; // Cancelou
            
            try {
                int id = Integer.parseInt(input.trim());
                if (id > 0) return id;
                JOptionPane.showMessageDialog(null, "O ID deve ser um número inteiro positivo!", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Formato de ID inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}