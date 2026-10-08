package veiculo;
import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        ArrayList<Carro> listaCarros = new ArrayList<>();
        boolean executando = true;

        while (executando) {
            String menu = """
                    === SISTEMA DE CADASTRO DE CARROS ===
                    1 - Cadastrar Carro
                    2 - Listar Carros
                    3 - Detalhar Carro
                    4 - Alterar Carro
                    5 - Remover Carro
                    6 - Gravar Informações em Arquivo
                    7 - Sair
                    
                    Escolha uma opção:
                    """;

            String opcaoStr = JOptionPane.showInputDialog(null, menu, "Menu Principal", JOptionPane.QUESTION_MESSAGE);


            if (opcaoStr == null) {
                break;
            }

            try {
                int opcao = Integer.parseInt(opcaoStr);

                switch (opcao) {
                    case 1:
                        cadastrarCarro(listaCarros);
                        break;
                    case 2:
                        listarCarros(listaCarros);
                        break;
                    case 3:
                        detalharCarro(listaCarros);
                        break;
                    case 4:
                        alterarCarro(listaCarros);
                        break;
                    case 5:
                        removerCarro(listaCarros);
                        break;
                    case 6:
                        gravarEmArquivo(listaCarros);
                        break;
                    case 7:
                        executando = false;
                        JOptionPane.showMessageDialog(null, "Sistema encerrado.");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida! Escolha um número de 1 a 7.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, digite um número inteiro válido.");
            }
        }
    }


    private static void cadastrarCarro(ArrayList<Carro> lista) {
        String marca = JOptionPane.showInputDialog("Informe a marca do carro:");
        if (marca == null || marca.isBlank()) return;

        String modelo = JOptionPane.showInputDialog("Informe o modelo do carro:");
        if (modelo == null || modelo.isBlank()) return;

        String anoStr = JOptionPane.showInputDialog("Informe o ano do carro:");
        if (anoStr == null) return;

        try {
            int ano = Integer.parseInt(anoStr);
            Carro carro = new Carro(marca, modelo, ano);
            lista.add(carro);
            JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ano inválido! O cadastro foi cancelado.");
        }
    }


    private static void listarCarros(ArrayList<Carro> lista) {
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum carro cadastrado.");
            return;
        }

        StringBuilder builder = new StringBuilder("=== LISTA DE CARROS ===\n\n");
        for (int i = 0; i < lista.size(); i++) {
            Carro c = lista.get(i);
            builder.append(i + 1).append(" - ")
                   .append(c.getMarca()).append(" ")
                   .append(c.getModelo()).append("\n");
        }

        JOptionPane.showMessageDialog(null, builder.toString());
    }

    private static void detalharCarro(ArrayList<Carro> lista) {
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum carro cadastrado.");
            return;
        }

        int indice = selecionarIndice(lista, "Escolha o número do carro para ver os detalhes:");
        if (indice != -1) {
            Carro carro = lista.get(indice);
            JOptionPane.showMessageDialog(null, carro.exibirDetalhes());
        }
    }


    private static void alterarCarro(ArrayList<Carro> lista) {
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum carro cadastrado.");
            return;
        }

        int indice = selecionarIndice(lista, "Escolha o número do carro que deseja alterar:");
        if (indice != -1) {
            String novaMarca = JOptionPane.showInputDialog("Informe a nova marca:");
            if (novaMarca == null || novaMarca.isBlank()) return;

            String novoModelo = JOptionPane.showInputDialog("Informe o novo modelo:");
            if (novoModelo == null || novoModelo.isBlank()) return;

            String novoAnoStr = JOptionPane.showInputDialog("Informe o novo ano:");
            if (novoAnoStr == null) return;

            try {
                int novoAno = Integer.parseInt(novoAnoStr);
                Carro carro = lista.get(indice);
                carro.setMarca(novaMarca);
                carro.setModelo(novoModelo);
                carro.setAno(novoAno);
                JOptionPane.showMessageDialog(null, "Dados do carro atualizados com sucesso!");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ano inválido! A alteração foi cancelada.");
            }
        }
    }


    private static void removerCarro(ArrayList<Carro> lista) {
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum carro cadastrado.");
            return;
        }

        int indice = selecionarIndice(lista, "Escolha o número do carro que deseja remover:");
        if (indice != -1) {
            Carro removido = lista.remove(indice);
            JOptionPane.showMessageDialog(null, "Carro " + removido.getMarca() + " " + removido.getModelo() + " removido com sucesso!");
        }
    }


    private static void gravarEmArquivo(ArrayList<Carro> lista) {
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum carro cadastrado para gravar no arquivo.");
            return;
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter("carros.txt"))) {
            for (Carro c : lista) {
                writer.println("Marca: " + c.getMarca());
                writer.println("Modelo: " + c.getModelo());
                writer.println("Ano: " + c.getAno());
                writer.println("----------------------------------------");
            }
            JOptionPane.showMessageDialog(null, "Informações gravadas com sucesso no arquivo 'carros.txt'!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar no arquivo: " + e.getMessage());
        }
    }

    private static int selecionarIndice(ArrayList<Carro> lista, String mensagem) {
        StringBuilder builder = new StringBuilder(mensagem + "\n\n");
        for (int i = 0; i < lista.size(); i++) {
            Carro c = lista.get(i);
            builder.append(i + 1).append(" - ").append(c.getMarca()).append(" ").append(c.getModelo()).append("\n");
        }

        String input = JOptionPane.showInputDialog(null, builder.toString());
        if (input == null) return -1;

        try {
            int numero = Integer.parseInt(input);
            int indice = numero - 1;

            if (indice >= 0 && indice < lista.size()) {
                return indice;
            } else {
                JOptionPane.showMessageDialog(null, "Número de carro inválido!");
                return -1;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, informe um número válido.");
            return -1;
        }
    }
}