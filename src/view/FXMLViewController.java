package view;

import java.io.IOException;
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
import observer.Observer;
import model.Player;
import model.PlayerIterator;
import model.Pot;
import model.Pots;
import static model.Status.END_GAME;
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
    private Stage stage;
    private Scene scene;
    @FXML
    private HBox hBoxMain;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.listWinner = new ArrayList<>();
    }

    public FXMLViewController getFXMLViewController() {
        return this.fxmlViewController;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setTable(TableComponent table) {
        this.hBoxMain.getChildren().add(table);
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
//        int cpt = game.getPlayers().size();
//        this.game.
    }

    public void displayWinner() throws IOException {
        System.out.println(listWinner.size() + " nb de victorieux ");
        String winners = "";
        for (Player player : listWinner) {
            winners = winners + " " + player.getName();
        }
        winners = winners + " Good game";

        alertBox(winners);

    }

    private void alertBox(String winners) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Winner(s)");
        alert.setHeaderText("The Winner(s) is(are) the Player ");
        ButtonType buttonComfirm = new ButtonType("Comfirm");
        alert.getButtonTypes().setAll(buttonComfirm);

        alert.setContentText(winners);
        alert.show();

    }

    @Override
    public void update() {
        
        if (game.getIsOver()) {
            try {
                defineWinner();
            } catch (GameException ex) {
                Logger.getLogger(FXMLViewController.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                displayWinner();
            } catch (IOException ex) {
                Logger.getLogger(FXMLViewController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
