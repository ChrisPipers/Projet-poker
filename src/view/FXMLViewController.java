package view;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Game;
import model.GameException;
import model.observer.Observer;
import model.Player;
import model.PlayerIterator;
import model.Pot;
import model.Pots;
import view.playerComponent.PlayerComponent;
import view.tableComponent.TableComponent;

/**
 * FXML Controller class is the controller of the file FXML FXMLView
 *
 * @author g39864
 */
public class FXMLViewController implements Initializable, Observer {

    private Game game;
    private FXMLViewController fxmlViewController;
    private TableComponent table;
    private List<Player> listWinner;
    private PlayerIterator iterator;
    private Stage stage;
    private Scene scene;

    @FXML
    private HBox hBoxMain;

    /**
     * Initializes the controller class.
     *
     * @param url it s the url of the FXMLView file
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.listWinner = new ArrayList<>();
    }

    /**
     * this method allows to return this, the FWMLViewController
     *
     * @return this, the FWMLViewController
     */
    public FXMLViewController getFXMLViewController() {
        return this.fxmlViewController;
    }

    /**
     * this method allows the attribut game
     *
     * @param game is the new valor of the attribut game
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * this method allows the attribut table
     *
     * @param table is the new valor of the attribut table
     */
    public void setTable(TableComponent table) {
        this.hBoxMain.getChildren().add(table);
    }

    /**
     * this method allows to update the statut of each HBox who contains the
     * card of each player
     */
    public void setHBoxCardsPlayer() {
        for (PlayerComponent player : table.getListPlayerC()) {
            player.setHboxCards();
        }
    }

    /**
     * this method allows to return the hbox of the FXMLView where to add the
     * component table
     *
     * @return the hbox of the FXMLView
     */
    public HBox getHbox() {
        return this.hBoxMain;
    }

    /**
     * this method allows to update the statut of the table
     *
     * @param table is the new valor of table
     */
    public void setHBox(TableComponent table) {
        this.hBoxMain = new HBox(table);
    }

    /**
     * this method allows to define a list of the winner(s)
     *
     * @throws GameException if the iterator is null
     */
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

    /**
     * this method allows to display the winner(s) with a alert
     */
    public void displayWinner() {
        String winners = "";
        for (Player player : listWinner) {
            winners = winners + " " + player.getName();
        }
        winners = winners + " Good game";
        alertBox(winners);
    }

    /**
     * this method allows to launch a alert to display the winner when the match
     * is end
     *
     * @param winners is the winners of the match
     */
    private void alertBox(String winners) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Winner(s)");
        alert.setHeaderText("The Winner(s) is(are) the Player ");
        ButtonType buttonComfirm = new ButtonType("Comfirm");
        alert.getButtonTypes().setAll(buttonComfirm);

        alert.setContentText(winners);
        alert.show();
    }

    /**
     * this method allows to update the statut of this when the statut of the
     * game change
     */
    @Override
    public void update() {

        if (game.getIsOver()) {
            try {
                defineWinner();
            } catch (GameException ex) {
                Logger.getLogger(FXMLViewController.class.getName()).log(Level.SEVERE, null, ex);
            }

            displayWinner();
        }
    }

}
