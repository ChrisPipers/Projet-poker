package BaseDeDonnées;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Mitch
 */
public class BaseDeDonnées {

    private Connection connexion;

    public static void addPlayer() throws SQLException {

        String query = "add player"
                + "(IDPlayer INTEGER not NULL,"
                + "name VARCHAR (50),"
                + "money INTEGER,"
                + "bounty INTEGER"
                + "PRIMARY KEY (IDPlayer))";

        Connection connection = null;
        try {
            connection = DriverManager.getConnection();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            throw new SQLException (" add player impossible " + e.getMessage());
        }

    }

    public static void addTable() throws SQLException {
        
        String query = "add table"
                + ("IDTable INTEGER not NULL"
                + "IDPlayer INTEGER not NULL"
                + "PRIMARY KEY (IDTable, IDPlayer)");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            throw new SQLException (" add table impossible " + e.getMessage());
        }
    }

}
