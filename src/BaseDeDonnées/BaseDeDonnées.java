
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
    Connection connexion;

    public BaseDeDonnées() throws SQLException {
        this.connexion = DriverManager.getConnection("jdbc:derby://localhost:1527/PokerPlayer [netbeans on NETBEANS]", "Netbeans", "123456");
        Statement stmt = connexion.createStatement();
        
        
        
    }
}
