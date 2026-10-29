import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
    private static final String URL = "jdbc:mysql://localhost:3306/loja";
    private static final String USER = "root"; // Seu usuário do MySQL
    private static final String PASSWORD = ""; // Sua senha do MySQL

    public static Connection getConexao() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}