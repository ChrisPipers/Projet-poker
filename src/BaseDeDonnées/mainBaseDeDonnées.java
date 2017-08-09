package BaseDeDonnées;

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
public class mainBaseDeDonnées {

    public static void connect() throws SQLException {
        Connection conn = DriverManager.getConnection();
        Statement stmt = conn.createStatement();

        DatabaseMetaData dbm = conn.getMetaData();

        ResultSet result = dbm.getTables(null, null, "PLAYER", null);
        if (result.next()) {
            System.out.println("Table exists");
        } else {
            System.out.println("Table doesn't exist");
            BaseDeDonnées.addPlayer();
        }

    }
    
    public static void addPlayersToBDD(List<Player> players) throws SQLException{
        for (Player playerP : players) {
            String namePlayer = playerP.getName();
            if (ManagementBaseDeDonnées.existPlayer(namePlayer)) {
                System.out.println("Player "+namePlayer+" already exists");
            } else {
                System.out.println("Player "+namePlayer+" doesn't exist");
                ManagementBaseDeDonnées.addPlayer(namePlayer, playerP.getMoney(), playerP.getBounty());
            }
        }
    }
}
