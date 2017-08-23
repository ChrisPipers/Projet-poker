package baseDeDonnées;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import model.Player;

/**
 *
 * @author Mitch
 */
public class mainBaseDeDonnees {

    public static void connect() throws SQLException, BaseDeDonnéesExcetion, ClassNotFoundException {
        
        Connection conn = DriverManagerP.getConnection();
        Statement stmt;
        stmt = conn.createStatement();

        DatabaseMetaData dbm = conn.getMetaData();

        ResultSet result = dbm.getTables(null, null, "PokerPlayer", null);
                
      

    }

    public static void addPlayersBDD(List<Player> players) throws SQLException, BaseDeDonnéesExcetion, ClassNotFoundException {
        for (Player playerP : players) {
            String namePlayer = playerP.getName();
            if (ManagementBaseDeDonnées.existPlayer(namePlayer)) {
                System.out.println("Player " + namePlayer + " already exists");
            } else {
                System.out.println("Player " + namePlayer + " doesn't exist");
                ManagementBaseDeDonnées.addPlayer(namePlayer, playerP.getMoney(), playerP.getBounty());
            }
        }
    }
}
