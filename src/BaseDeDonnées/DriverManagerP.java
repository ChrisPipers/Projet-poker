package BaseDeDonnées;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Mitch
 */
public class DriverManagerP {

    private static Connection conn;

    public static Connection getConnection() throws BaseDeDonnéesExcetion, SQLException, ClassNotFoundException {
        String connectionURL = "jdbc:derby://localhost:1527/PokerPlayer";
        String user = "netbeans";
        String pssword = "123456";

        try {
            System.out.println("here");
            conn = DriverManager.getConnection(connectionURL, user, pssword);
        } catch (SQLException e) {
            throw new BaseDeDonnéesExcetion(" impossible to connected database " + e.getMessage());
        }
        return conn;
    }
}
