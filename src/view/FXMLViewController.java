package view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import model.Game;
import view.flopComponent.FlopComponent;
import view.playerComponent.PlayerComponent;
import view.tableComponent.TableComponent;

/**
 * FXML Controller class
 *
 * @author Mitch
 */
public class FXMLViewController implements Initializable {

    private Game game;

    @FXML
    private HBox hBoxMain;
    
    @FXML
    private TableComponent table;
    
    @FXML
    private PlayerComponent playerC;
    
    @FXML
    private FlopComponent flop;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        game = new Game();
        game.addPlayer("Patrick", 1000, 'M');
        game.addPlayer("Patrick2", 1000, 'M');
        game.addPlayer("Patrick3", 1000, 'M');
        game.addPlayer("Patrick4", 1000, 'M');
        
        table = new TableComponent(game);
        List listPlayer = game.getPlayers();
        hBoxMain.getChildren().add(table);
    }    
    
}
