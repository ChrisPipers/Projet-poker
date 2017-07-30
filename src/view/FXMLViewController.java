package view;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import model.Game;
import model.GameException;
import observer.Observer;
import model.Player;
import model.PlayerIterator;
import model.Pot;
import model.Pots;
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
    private TableComponent table;
    private List<Player> listWinner;
    private PlayerIterator iterator;

    @FXML
    private HBox hBoxMain;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.listWinner = new ArrayList<>();
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

    public void defineWinner() throws GameException {
        List<Pot> listPots = new ArrayList<>();
        Pots pot = game.getMatch().getPots();
        listPots = pot.getListPots();
        for (Pot listPot : listPots) {
            PlayerIterator it = game.getMatch().getIterator();
            PlayerIterator itPlayer = new PlayerIterator(it);
            listWinner = listPot.findWinners(itPlayer);
        }

    }

    public void displayWinner() {
        System.out.println(listWinner.size() + " nb de victorieux ");
        String winners = "";
        for (Player player : listWinner) {
            winners = winners + " " + player.getName();
        }
        winners = winners + " Good game";

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Winner(s)");
        alert.setHeaderText("The Winner(s) is(are) the Player ");

        alert.setContentText(winners);
        alert.showAndWait();

    }

    @Override
    public void update() {
        System.out.println("update fxml ");
//        this.table.update();
//        setTable(table);
//        this.setGame(game);
        if (game.getIsOver()) {
            try {
                //            game.up
                defineWinner();
            } catch (GameException ex) {
                Logger.getLogger(FXMLViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
            displayWinner();

        }
    }

}
