package BaseDeDonnées;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Mitch
 */
public class DriverManager {
    
    private Connection conn;

    public Connection getConnection() throws SQLException {

        if (conn == null) {
            conn = java.sql.DriverManager.getConnection("jdbc:derby://localhost:1527/PokerPlayer", "Netbeans", "123456");
        }
        System.out.println("Connected to database");
        return conn;
    }
}
