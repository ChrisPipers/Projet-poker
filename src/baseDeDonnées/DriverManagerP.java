package baseDeDonnées;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
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
            conn = DriverManager.getConnection(connectionURL, user, pssword);
        } catch (SQLException e) {
            throw new BaseDeDonnéesExcetion(" impossible to connected database " + e.getMessage());
        }
        return conn;
    }
    /**
     * start a transaction and determine the level of isolation
     * 
     * @param lvl, is the level of the isolation of 
     * @throws baseDeDonnées.BaseDeDonnéesExcetion
     * @throws java.lang.ClassNotFoundException
     */
    public static void startTransaction(int lvl) throws BaseDeDonnéesExcetion, ClassNotFoundException{
        try {
            getConnection().setAutoCommit(false);

            int isol = 0;
            switch (lvl) {
                case 0:
                    isol = java.sql.Connection.TRANSACTION_READ_UNCOMMITTED;
                    break;
                case 1:
                    isol = java.sql.Connection.TRANSACTION_READ_COMMITTED;
                    break;
                case 2:
                    isol = java.sql.Connection.TRANSACTION_REPEATABLE_READ;
                    break;
                case 3:
                    isol = java.sql.Connection.TRANSACTION_SERIALIZABLE;
                    break;
                default:
                    throw new BaseDeDonnéesExcetion("transation not possible ");
            }
            getConnection().setTransactionIsolation(isol);
        } catch (SQLException ex) {
            throw new BaseDeDonnéesExcetion("impossible to start the transaction : "+ex.getMessage());
        }
    }

    /**
     * valid the transaction 
     * @throws baseDeDonnées.BaseDeDonnéesExcetion
     * @throws java.lang.ClassNotFoundException
     */
    public static void validateTransaction() throws BaseDeDonnéesExcetion, ClassNotFoundException {
        try {
            getConnection().commit();
            getConnection().setAutoCommit(true);
        } catch (SQLException ex) {
            throw new BaseDeDonnéesExcetion("impossible to validat the transaction : "+ex.getMessage());
        }
    }

    /**
     * cancel the transaction
     * @throws baseDeDonnées.BaseDeDonnéesExcetion
     * @throws java.lang.ClassNotFoundException
     */
    public static void cancelTransaction() throws BaseDeDonnéesExcetion, ClassNotFoundException  {
        try {
            getConnection().rollback();
            getConnection().setAutoCommit(true);
        } catch (SQLException ex) {
            throw new BaseDeDonnéesExcetion("not possible to cancel the transaction : "+ex.getMessage());
        }
    }
}
    
    

