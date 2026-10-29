import java.util.ArrayList;
import java.util.List;

public class EletrodomesticoDAO {
    
    public boolean cadastrar(Eletrodomestico e) throws SQLException {
        String sql = "INSERT INTO eletrodomestico (nome, marca, voltagem, preco) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoMySQL.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, e.getNome());
            stmt.setString(2, e.getMarca());
            stmt.setString(3, e.getVoltagem());
            stmt.setDouble(4, e.getPreco());
            return stmt.executeUpdate() > 0;
        }
    }

    public List<Eletrodomestico> listar() throws SQLException {
        List<Eletrodomestico> lista = new ArrayList<>();
        String sql = "SELECT * FROM eletrodomestico";
        try (Connection conn = ConexaoMySQL.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                lista.add(new Eletrodomestico(
                    rs.getInt("id"), rs.getString("nome"),
                    rs.getString("marca"), rs.getString("voltagem"),
                    rs.getDouble("preco")
                ));
            }
        }
        return lista;
    }

    public Eletrodomestico buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM eletrodomestico WHERE id = ?";
        try (Connection conn = ConexaoMySQL.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Eletrodomestico(
                        rs.getInt("id"), rs.getString("nome"),
                        rs.getString("marca"), rs.getString("voltagem"),
                        rs.getDouble("preco")
                    );
                }
            }
        }
        return null;
    }

    public boolean alterar(Eletrodomestico e) throws SQLException {
        String sql = "UPDATE eletrodomestico SET nome=?, marca=?, voltagem=?, preco=? WHERE id=?";
        try (Connection conn = ConexaoMySQL.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, e.getNome());
            stmt.setString(2, e.getMarca());
            stmt.setString(3, e.getVoltagem());
            stmt.setDouble(4, e.getPreco());
            stmt.setInt(5, e.getId());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean remover(int id) throws SQLException {
        String sql = "DELETE FROM eletrodomestico WHERE id=?";
        try (Connection conn = ConexaoMySQL.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }
}