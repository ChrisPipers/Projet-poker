package BaseDeDonnées;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mitch
 */
public class ManagementBaseDeDonnées {

    public static void majPlayer(String name, int money, int bounty) throws SQLException {
        Connection conn = DriverManager.getConnection();
        PreparedStatement preparedStmt;
        try {
            String query = "maj player set money = ? set bounty = ? where name = ?";
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, money);
            preparedStmt.setInt(2, bounty);
            preparedStmt.setString(3, name);
            preparedStmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(" maj player impossible " + e.getMessage());
        }
    }

    public static void addPlayer(String name, int money, int bounty) throws SQLException {
        int nbPlayer = getNbPlayer();
        String query = "add player (IDPlayer, name, money, bounty ) values("
                + (nbPlayer + 1) + ", '"
                + name + "' "
                + money + "' "
                + bounty + ")";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection();
            PreparedStatement preparedStmt;

            preparedStmt = conn.prepareStatement(query);
            preparedStmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(" add new player impossible " + e.getMessage());
        }

    }

    // le nom est unique 
    public static boolean existPlayer(String name) throws SQLException {
        Connection conn = null;
        String query = "SELECT * FROM PokerPlayer WHERE name = ?";
        try {
            conn = DriverManager.getConnection();
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, name);
            ResultSet result = preparedStmt.executeQuery();
            if (result.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new SQLException(" impossible to find player " + name + " " + e.getMessage());
        }

    }

    public static int getNbPlayer() throws SQLException {
        Connection conn = DriverManager.getConnection();
        PreparedStatement preparedStmt;
        String query = "SELECT count(*) FROM PokerPlayer";
        try {

            preparedStmt = conn.prepareStatement(query);
            ResultSet result = preparedStmt.executeQuery();
            result.next();
            return result.getInt(1);
        } catch (SQLException e) {
            throw new SQLException(" impossible to know number of player into the DB  " + e.getMessage());
        }
    }

    public static int getIDPlayer(String name) throws SQLException {
        Connection conn = DriverManager.getConnection();
        PreparedStatement preparedStmt;
        String query = "SELECT IdPlayer FROM PokerPlayer where name = '" + name + "'";
        try {
            preparedStmt = conn.prepareStatement(query);
            ResultSet result = preparedStmt.executeQuery();
            result.next();
            return result.getInt(1);
        } catch (SQLException e) {
            throw new SQLException(" find ID player " + name + " impossible " + e.getMessage());
        }

    }
    

    public static List<PlayerBDD> getPlayer() throws SQLException {
        List<PlayerBDD> listPlayer = new ArrayList();
        Connection conn = DriverManager.getConnection();
        PreparedStatement preparedStmt;
        String query = "SELECT * FROM PokerPlayer ";
        try {
            preparedStmt = conn.prepareStatement(query);
            ResultSet result = preparedStmt.executeQuery();
            while (result.next()) {
                listPlayer.add(new PlayerBDD(result.getInt(1), result.getString(2), result.getInt(3), result.getInt(3)));
            }
            return listPlayer;
        } catch (SQLException e) {
            throw new SQLException(" listing of plaer BDD impossible " + e.getMessage());
        }
    }

    public static List<Integer> getIDAllPlayer(String name) throws SQLException {
        List<Integer> listIdAllPlayer = new ArrayList();
        Connection conn = DriverManager.getConnection();
        PreparedStatement preparedStmt;
        String query = "SELECT IDPlayer FROM PokerPlayer where name = '"+name+"'";
        try {
            preparedStmt = conn.prepareStatement(query);
            ResultSet result = preparedStmt.executeQuery();
            while (result.next()) {
                listIdAllPlayer.add(result.getInt(1));
            }
            return listIdAllPlayer;
        } catch (SQLException e) {
            throw new SQLException(" listing of plaer BDD impossible " + e.getMessage());
        }
    }
    
}
