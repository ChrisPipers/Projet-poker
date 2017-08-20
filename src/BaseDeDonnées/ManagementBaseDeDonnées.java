package BaseDeDonnées;

import java.sql.Connection;
import java.sql.DriverManager;
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

    public static void majPlayer(String name, int money, double bounty) throws SQLException, BaseDeDonnéesExcetion, ClassNotFoundException {
        Connection conn = DriverManagerP.getConnection();
        PreparedStatement preparedStmt;
        try {
            String query = "maj player set money = ? set bounty = ? where name = ?";
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, money);
            preparedStmt.setDouble(2, bounty);
            preparedStmt.setString(3, name);
            preparedStmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(" maj player impossible " + e.getMessage());
        }
    }

    public static void addPlayer(String name, int money, double bounty) throws SQLException, BaseDeDonnéesExcetion, ClassNotFoundException {
        int nbPlayer = getNbPlayer();
        String query = "Inser into PokerPlayer (IDPlayer, name, money, bounty ) values ("
                + (getNbPlayer() + 1) + ", '"
                + name + "', "
                + money + "', "
                + bounty + ")";

        Connection conn = null;
        try {
            conn = DriverManagerP.getConnection();
            PreparedStatement preparedStmt;

            preparedStmt = conn.prepareStatement(query);
            preparedStmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(" add new player impossible " + e.getMessage());
        }

    }

    // le nom est unique 
    public static boolean existPlayer(String name) throws SQLException, BaseDeDonnéesExcetion, ClassNotFoundException {
        Connection conn = null;
        String query = "SELECT * FROM PokerPlayer2 WHERE name = ?";
        try {
            conn = DriverManagerP.getConnection();
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

    public static int getNbPlayer() throws SQLException, BaseDeDonnéesExcetion, ClassNotFoundException {
        Connection conn = DriverManagerP.getConnection();
        PreparedStatement preparedStmt;
        String query = "SELECT count(*) FROM PokerPlayer";
        try {
            
            preparedStmt = conn.prepareStatement(query);
            ResultSet result = preparedStmt.executeQuery();
            result.next();
            System.out.println("nb player =" + result.getInt(1));
            return result.getInt(1);
        } catch (SQLException e) {
            throw new SQLException(" impossible to know number of player into the DB  " + e.getMessage());
        }
    }

    public static int getIDPlayer(String name) throws SQLException, BaseDeDonnéesExcetion, ClassNotFoundException, ClassNotFoundException {
        Connection conn = DriverManagerP.getConnection();
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
    

    public static List<PlayerBDD> getPlayer() throws SQLException, BaseDeDonnéesExcetion, ClassNotFoundException {
        List<PlayerBDD> listPlayer = new ArrayList();
        Connection conn = DriverManagerP.getConnection();
        PreparedStatement preparedStmt;
        String query = "select * from PokerPlayer ";
        try {
            preparedStmt = conn.prepareStatement(query);
            ResultSet result = preparedStmt.executeQuery();
            while (result.next()) {
                listPlayer.add(new PlayerBDD(result.getInt(1), result.getString(2), result.getInt(3), result.getDouble(4)));
            }
            return listPlayer;
        } catch (SQLException e) {
            throw new SQLException(" listing of plaer BDD impossible " + e.getMessage());
        }
    }

    public static List<Integer> getIDAllPlayer(String name) throws SQLException, BaseDeDonnéesExcetion, ClassNotFoundException {
        List<Integer> listIdAllPlayer = new ArrayList();
        Connection conn = DriverManagerP.getConnection();
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
