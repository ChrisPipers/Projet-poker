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
 * this class allows to manage the event when the player clic on the button fold
 * of the choiceboxplayer
 *
 * @author g39864
 */
public class FoldButtonHandler implements EventHandler<ActionEvent> {

    private final Game game;
    private Alert alert;

    /**
     * this is the constructor of the FoldButtonHandler
     *
     * @param game is the game where make the action fold
     */
    public FoldButtonHandler(Game game) {
        this.game = game;
    }

    /**
     * this is the class allows to make the action fold on the game when the
     * player clic on the button fold of the choiceboxplayer
     *
     * @param event is the event when the player clic on the button fold
     */
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

    /**
     * this method allows to launch an alert when the player clic on the button
     * fold when the minimum to raise is zero
     *
     * @throws GameException is the exception launch if the option check, or
     * fold is not autorized by the game
     */
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

        } else if (result.get() == buttonFold) {
            game.fold();
        }

    }

}
