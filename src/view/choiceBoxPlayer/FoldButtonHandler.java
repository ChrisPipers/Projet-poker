package view.choiceBoxPlayer;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import model.Game;
import model.GameException;

/**
 *
 * @author Mitch
 */
public class FoldButtonHandler implements EventHandler<ActionEvent> {

    private final Game game;
    private Alert alert;

    public FoldButtonHandler(Game game) {
        this.game = game;
    }

    @Override
    public void handle(ActionEvent event) {
        if (game.getMinimium() == 0) {

            try {
                makeAlert();
            } catch (GameException ex) {
                Logger.getLogger(FoldButtonHandler.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private void makeAlert() throws GameException {
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Warning  ");
        alert.setHeaderText("You can use check ");
        alert.setContentText("Comfirm your choice ");

        ButtonType buttonCheck = new ButtonType("Check");
        ButtonType buttonFold = new ButtonType("Fold");
        ButtonType buttonCancel = new ButtonType("Cancel");
        

        alert.getButtonTypes().setAll(buttonCheck, buttonFold, buttonCancel);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonCheck) {
            game.check();

        }else if(result.get() == buttonFold) {
            game.fold();
        }

    }

}
