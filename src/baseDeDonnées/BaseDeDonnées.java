package baseDeDonnées;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Mitch
 */
public class BaseDeDonnées {

    private Connection connexion;

    public static void addPlayer() throws SQLException, BaseDeDonnéesExcetion, ClassNotFoundException {

        String query = " CREATE TABLE POKERPLAYER "
                + "(IDPlayer INTEGER not NULL, "
                + " name VARCHAR (50), "
                + " money INTEGER, "
                + " bounty INTEGER, "
                + " PRIMARY KEY ( IDPlayer ))";

        
        Connection connection = null;
        
        try {
            connection = DriverManagerP.getConnection();
            
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            throw new SQLException (" add player impossible " + e.getMessage());
        }

    }

}
