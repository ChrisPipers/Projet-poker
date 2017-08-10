package BaseDeDonnées;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Mitch
 */
public class DriverManagerP {

    private static Connection conn;

    public static Connection getConnection() throws BaseDeDonnéesExcetion {

            try {
                conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PokerPlayer2", "Mitch", "Mitch");
                System.out.println("Connected to database");
            } catch (SQLException e) {
                throw new BaseDeDonnéesExcetion(" impossible to connected database " + e.getMessage());
            }
        
        return conn;
    }
    
}

