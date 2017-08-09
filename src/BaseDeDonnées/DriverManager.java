package BaseDeDonnées;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Mitch
 */
public class DriverManager {

    private static Connection conn;

    public static Connection getConnection() throws SQLException {

        if (conn == null) {
            try {
                conn = java.sql.DriverManager.getConnection("jdbc:derby://localhost:1527/PokerPlayer", "Netbeans", "123456");
                System.out.println("Connected to database");
            } catch (SQLException e) {
                throw new SQLException(" impossible to connected database " + e.getMessage());
            }
        }
        return conn;
    }
}
