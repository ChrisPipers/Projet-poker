package BaseDeDonnées;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
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

    public static void connect() throws SQLException, BaseDeDonnéesExcetion {
        
        Connection conn;
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PokerPlayer", "netbeans", "123456");
        Statement stmt;
        stmt = conn.createStatement();

        DatabaseMetaData dbm = conn.getMetaData();

        ResultSet result;
//        result = dbm.getTables(null, null, null , null);
//        if (result.next()) {
//            System.out.println("player exists");
//        } else {
//            System.out.println("player doesn't exist");
//            BaseDeDonnées.addPlayer();
//        }

    }

    public static void addPlayersToBDD(List<Player> players) throws SQLException, BaseDeDonnéesExcetion {
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
