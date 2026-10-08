import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GerenciadorArquivos {

    private static final String DIRETORIO_BASE = "LABORATORIO";

    public static void main(String[] args) {
        // Assegura a criação do diretório LABORATORIO na inicialização do sistema
        File diretorioLab = new File(DIRETORIO_BASE);
        if (!diretorioLab.exists()) {
            diretorioLab.mkdir();
        }

        boolean executando = true;

        while (executando) {
            String menu = """
                    === GERENCIADOR DE ARQUIVOS (LABORATORIO) ===
                    1 - Criar pasta
                    2 - Criar arquivo
                    3 - Escrever no arquivo
                    4 - Ler arquivo
                    5 - Renomear arquivo
                    6 - Excluir arquivo
                    7 - Mostrar informações do arquivo
                    8 - Tornar somente leitura (Desafio)
                    9 - Sair
                    
                    Escolha uma opção:
                    """;

            String opcaoStr = JOptionPane.showInputDialog(null, menu, "Menu Principal", JOptionPane.QUESTION_MESSAGE);

            // Retorna ao menu ou encerra se o usuário clicar em Cancelar ou fechar a janela
            if (opcaoStr == null) {
                break;
            }

            try {
                int opcao = Integer.parseInt(opcaoStr.trim());

                switch (opcao) {
                    case 1 -> criarPasta();
                    case 2 -> criarArquivo();
                    case 3 -> escreverArquivo();
                    case 4 -> lerArquivo();
                    case 5 -> renomearArquivo();
                    case 6 -> excluirArquivo();
                    case 7 -> mostrarInformacoes();
                    case 8 -> tornarSomenteLeitura();
                    case 9 -> {
                        executando = false;
                        JOptionPane.showMessageDialog(null, "Sistema encerrado com sucesso.");
                    }
                    default -> JOptionPane.showMessageDialog(null, "Opção inválida! Escolha um número de 1 a 9.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, digite um número inteiro válido.");
            }
        }
    }

    // Garante que todas as operações fiquem estritamente dentro da pasta LABORATORIO
    private static File obterArquivoNoLaboratorio(String nome) {
        return new File(DIRETORIO_BASE, nome);
    }

    // 1 - Criar pasta
    private static void criarPasta() {
        String nomePasta = JOptionPane.showInputDialog("Digite o nome da nova pasta:");
        if (nomePasta == null || nomePasta.isBlank()) return;

        File pasta = obterArquivoNoLaboratorio(nomePasta.trim());

        if (pasta.exists()) {
            JOptionPane.showMessageDialog(null, "A pasta '" + nomePasta + "' já existe!");
        } else {
            if (pasta.mkdir()) {
                JOptionPane.showMessageDialog(null, "Pasta '" + nomePasta + "' criada com sucesso em " + DIRETORIO_BASE + "!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao criar a pasta.");
            }
        }
    }

    // 2 - Criar arquivo
    private static void criarArquivo() {
        String nomeArquivo = JOptionPane.showInputDialog("Digite o nome do arquivo com extensão (ex: atividade.txt):");
        if (nomeArquivo == null || nomeArquivo.isBlank()) return;

        File arquivo = obterArquivoNoLaboratorio(nomeArquivo.trim());

        if (arquivo.exists()) {
            JOptionPane.showMessageDialog(null, "O arquivo '" + nomeArquivo + "' já existe!");
            return;
        }

        try {
            if (arquivo.createNewFile()) {
                JOptionPane.showMessageDialog(null, "Arquivo '" + nomeArquivo + "' criado com sucesso em " + DIRETORIO_BASE + "!");
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível criar o arquivo.");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro de E/S ao criar o arquivo: " + e.getMessage());
        }
    }

    // 3 - Escrever no arquivo
    private static void escreverArquivo() {
        String nomeArquivo = JOptionPane.showInputDialog("Digite o nome do arquivo para escrita:");
        if (nomeArquivo == null || nomeArquivo.isBlank()) return;

        File arquivo = obterArquivoNoLaboratorio(nomeArquivo.trim());

        if (!arquivo.exists() || !arquivo.isFile()) {
            JOptionPane.showMessageDialog(null, "O arquivo '" + nomeArquivo + "' não existe no diretório " + DIRETORIO_BASE + "!");
            return;
        }

        if (!arquivo.canWrite()) {
            JOptionPane.showMessageDialog(null, "Acesso Negado! O arquivo está configurado como Somente Leitura.", "Erro de Permissão", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String conteudo = JOptionPane.showInputDialog("Digite o texto a ser gravado no arquivo:");
        if (conteudo == null) return;

        try (FileWriter writer = new FileWriter(arquivo, true)) { // Adiciona texto ao final do arquivo
            writer.write(conteudo + System.lineSeparator());
            JOptionPane.showMessageDialog(null, "Conteúdo gravado com sucesso no arquivo!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    // 4 - Ler arquivo
    private static void lerArquivo() {
        String nomeArquivo = JOptionPane.showInputDialog("Digite o nome do arquivo para leitura:");
        if (nomeArquivo == null || nomeArquivo.isBlank()) return;

        File arquivo = obterArquivoNoLaboratorio(nomeArquivo.trim());

        if (!arquivo.exists() || !arquivo.isFile()) {
            JOptionPane.showMessageDialog(null, "O arquivo '" + nomeArquivo + "' não existe!");
            return;
        }

        try {
            String conteudo = Files.readString(arquivo.toPath());
            if (conteudo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "O arquivo está vazio.", "Conteúdo de " + nomeArquivo, JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, conteudo, "Conteúdo de " + nomeArquivo, JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    // 5 - Renomear arquivo
    private static void renomearArquivo() {
        String nomeAtual = JOptionPane.showInputDialog("Digite o nome atual do arquivo:");
        if (nomeAtual == null || nomeAtual.isBlank()) return;

        File arquivoAtual = obterArquivoNoLaboratorio(nomeAtual.trim());

        if (!arquivoAtual.exists()) {
            JOptionPane.showMessageDialog(null, "O arquivo '" + nomeAtual + "' não existe!");
            return;
        }

        String novoNome = JOptionPane.showInputDialog("Digite o novo nome do arquivo:");
        if (novoNome == null || novoNome.isBlank()) return;

        File novoArquivo = obterArquivoNoLaboratorio(novoNome.trim());

        if (novoArquivo.exists()) {
            JOptionPane.showMessageDialog(null, "O nome '" + novoNome + "' já está em uso por outro arquivo!");
            return;
        }

        if (arquivoAtual.renameTo(novoArquivo)) {
            JOptionPane.showMessageDialog(null, "Arquivo renomeado de '" + nomeAtual + "' para '" + novoNome + "' com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Falha ao renomear o arquivo.");
        }
    }

    // 6 - Excluir arquivo
    private static void excluirArquivo() {
        String nomeArquivo = JOptionPane.showInputDialog("Digite o nome do arquivo para excluir:");
        if (nomeArquivo == null || nomeArquivo.isBlank()) return;

        File arquivo = obterArquivoNoLaboratorio(nomeArquivo.trim());

        if (!arquivo.exists()) {
            JOptionPane.showMessageDialog(null, "O arquivo '" + nomeArquivo + "' não existe!");
            return;
        }

        int confirmacao = JOptionPane.showConfirmDialog(
                null,
                "Tem certeza de que deseja excluir o arquivo '" + nomeArquivo + "'?",
                "Confirmação de Exclusão",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (confirmacao == JOptionPane.YES_OPTION) {
            if (arquivo.delete()) {
                JOptionPane.showMessageDialog(null, "Arquivo excluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao excluir o arquivo. Ele pode estar em uso ou protegido.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Operação de exclusão cancelada.");
        }
    }

    // 7 - Mostrar informações do arquivo
    private static void mostrarInformacoes() {
        String nomeArquivo = JOptionPane.showInputDialog("Digite o nome do arquivo para ver as informações:");
        if (nomeArquivo == null || nomeArquivo.isBlank()) return;

        File arquivo = obterArquivoNoLaboratorio(nomeArquivo.trim());

        if (!arquivo.exists()) {
            JOptionPane.showMessageDialog(null, "O arquivo '" + nomeArquivo + "' não existe!");
            return;
        }

        String nome = arquivo.getName();
        String extensao = extrairExtensao(nome);
        long tamanhoEmBytes = arquivo.length();
        String caminhoCompleto = arquivo.getAbsolutePath();

        boolean leitura = arquivo.canRead();
        boolean gravacao = arquivo.canWrite();
        boolean execucao = arquivo.canExecute();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String ultimaModificacao = sdf.format(new Date(arquivo.lastModified()));

        String info = String.format("""
                === INFORMAÇÕES DO ARQUIVO ===
                Nome: %s
                Extensão: %s
                Tamanho: %d bytes
                Caminho Completo: %s
                
                --- PERMISSÕES ---
                Leitura: %s
                Gravação: %s
                Execução: %s
                
                --- METADADOS ---
                Última Modificação: %s
                """,
                nome,
                extensao,
                tamanhoEmBytes,
                caminhoCompleto,
                leitura ? "Sim" : "Não",
                gravacao ? "Sim" : "Não",
                execucao ? "Sim" : "Não",
                ultimaModificacao
        );

        JOptionPane.showMessageDialog(null, info, "Informações - " + nome, JOptionPane.INFORMATION_MESSAGE);
    }

    // 8 - Desafio Complementar: Proteção de Arquivos (Somente Leitura)
    private static void tornarSomenteLeitura() {
        String nomeArquivo = JOptionPane.showInputDialog("Digite o nome do arquivo que deseja tornar Somente Leitura:");
        if (nomeArquivo == null || nomeArquivo.isBlank()) return;

        File arquivo = obterArquivoNoLaboratorio(nomeArquivo.trim());

        if (!arquivo.exists()) {
            JOptionPane.showMessageDialog(null, "O arquivo '" + nomeArquivo + "' não existe!");
            return;
        }

        boolean alterado = arquivo.setReadOnly();

        if (alterado) {
            JOptionPane.showMessageDialog(null,
                    "Sucesso! O arquivo '" + nomeArquivo + "' foi alterado para SOMENTE LEITURA.\n" +
                    "Ao consultar as informações (Opção 7), a permissão de Gravação passará a constar como 'Não'.",
                    "Proteção de Arquivos",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Não foi possível alterar as permissões no sistema operacional.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método utilitário para extrair a extensão do arquivo
    private static String extrairExtensao(String nome) {
        int ponto = nome.lastIndexOf('.');
        if (ponto > 0 && ponto < nome.length() - 1) {
            return nome.substring(ponto + 1);
        }
        return "Sem extensão";
    }
}