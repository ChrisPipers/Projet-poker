
package BaseDeDonnées;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Mitch
 */
public class BaseDeDonnées {
   

    private Connection connexion;

    public static void addPlayer() throws SQLException {

        Connection connection = null;
        connection = DriverManager.getConnection("jdbc:derby://localhost:1527/PokerPlayer", "Netbeans", "123456");
        Statement stmt = connection.createStatement();
        String query = "add player"
                + "(IDPlayer INTEGER not NULL,"
                + "name VARCHAR (40),"
                + "money INTEGER,"
                + "bounty INTEGER"
                + "PRIMARY KEY (IDPlayer))";
        stmt.executeUpdate(query);

    }

    public static void addTable() throws SQLException {
        Connection connection = null;
        connection = DriverManager.getConnection("jdbc:derby://localhost:1527/PokerPlayer", "Netbeans", "123456");
        Statement stmt = connection.createStatement();
        String query = "add table"
                + ("IDTable INTEGER not NULL"
                + "IDPlayer INTEGER not NULL"
                + "PRIMARY KEY (IDTable, IDPlayer)");
        stmt.executeUpdate(query);
    }



}
