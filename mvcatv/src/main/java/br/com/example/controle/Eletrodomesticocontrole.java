import java.sql.SQLException;
import java.util.List;

public class EletrodomesticoControle {
    private EletrodomesticoDAO dao;

    public EletrodomesticoControle() {
        this.dao = new EletrodomesticoDAO();
    }

    public String cadastrar(Eletrodomestico e) {
        try {
            if (dao.cadastrar(e)) return "Eletrodoméstico cadastrado com sucesso!";
            return "Falha ao cadastrar eletrodoméstico.";
        } catch (SQLException ex) {
            return "Erro de banco de dados: " + ex.getMessage();
        }
    }

    public List<Eletrodomestico> listar() {
        try {
            return dao.listar();
        } catch (SQLException ex) {
            System.err.println("Erro ao listar: " + ex.getMessage());
            return null;
        }
    }

    public Eletrodomestico buscarPorId(int id) {
        try {
            return dao.buscarPorId(id);
        } catch (SQLException ex) {
            System.err.println("Erro ao buscar: " + ex.getMessage());
            return null;
        }
    }

    public String alterar(Eletrodomestico e) {
        try {
            if (dao.alterar(e)) return "Eletrodoméstico alterado com sucesso!";
            return "Falha ao alterar eletrodoméstico.";
        } catch (SQLException ex) {
            return "Erro de banco de dados: " + ex.getMessage();
        }
    }

    public String remover(int id) {
        try {
            if (dao.remover(id)) return "Eletrodoméstico removido com sucesso!";
            return "Falha ao remover eletrodoméstico.";
        } catch (SQLException ex) {
            return "Erro de banco de dados: " + ex.getMessage();
        }
    }
}