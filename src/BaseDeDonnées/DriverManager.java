package BaseDeDonnées;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import sun.security.util.Password;

/**
 *
 * @author Mitch
 */
public class DriverManager {
    
    private Connection connection;

    public Connection getConnection() throws SQLException {

        Properties connectionProps = new Properties();
        connectionProps.put("netbeans", this.userName);
        connectionProps.put("123456", this.password);

        if (this.dbms.equals("mysql")) {
            conn = DriverManager.getConnection(
                    "jdbc:" + this.dbms + "://"
                    + this.serverName
                    + ":" + this.portNumber + "/",
                    connectionProps);
        } else if (this.dbms.equals("derby")) {
            conn = DriverManager.getConnection(
                    "jdbc:" + this.dbms + ":"
                    + this.dbName
                    + ";create=true",
                    connectionProps);
        }
        System.out.println("Connected to database");
        return conn;
    }
}
