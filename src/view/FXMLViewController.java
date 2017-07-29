package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import model.Game;
import model.Observer;
import view.choiceBoxPlayer.ChoiceBoxPlayer;
import view.flopComponent.FlopComponent;
import view.playerComponent.PlayerComponent;
import view.tableComponent.TableComponent;

/**
 * FXML Controller class
 *
 * @author Mitch
 */
public class FXMLViewController implements Initializable, Observer {

    private Game game;
    private FXMLViewController fxmlViewController;

//    private HBox tBox;
    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private Pane pane;

    @FXML
    private HBox hBoxMain;

    @FXML
    private TableComponent table;

    @FXML
    private PlayerComponent playerC;

    @FXML
    private FlopComponent flop;

    @FXML
    private ChoiceBoxPlayer choiceBoxPlayer;


//    private ChoiceBoxPlayerController controlP;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }

//    
    public FXMLViewController getFXMLViewController() {
        return this.fxmlViewController;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setTable(TableComponent table) {

//        this.table = new TableComponent(this.game);
//        this.pane.getChildren().add(table);
        this.hBoxMain.getChildren().add(table);
//        this.tBox.getChildren().add(table);
    }

    public void setHBoxCardsPlayer() {
        for (PlayerComponent player : table.getListPlayerC()) {
            player.setHboxCards();
        }
    }

    public HBox getHbox() {
        return this.hBoxMain;
    }

    public void setHBox(TableComponent table) {
        this.hBoxMain = new HBox(table);
    }
    
    public void defineWinner(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Winner(s)");
            alert.setHeaderText("The Winner is the Player ");
            alert.setContentText(game.getCurrentPlayer().getName());
            alert.showAndWait();

    }
    
    public void restartGame(){
        game = new Game();
    }

    @Override
    public void update() {
        System.out.println("update fxml ");
//        this.table.update();
//        setTable(table);
//        this.setGame(game);
        if(game.getIsOver()){
//            game.up
            defineWinner();
            
//            restartGame();
            
        }
    }
    
}
