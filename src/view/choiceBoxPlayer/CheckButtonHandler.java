package view.choiceBoxPlayer;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Game;
import model.GameException;

/**
 * this class allows to manage the event when the player clic on the button
 * check of the choiceboxplayer
 *
 * @author g39864
 */
public class CheckButtonHandler implements EventHandler<ActionEvent> {

    private final Game game;

    /**
     * this is the constructor of the CheckButtonHandler
     *
     * @param game is the game where make the action check
     */
    public CheckButtonHandler(Game game) {
        this.game = game;
    }

    /**
     * this is the class allows to make the action check on the game when the
     * player clic on the button check of the choiceboxplayer
     *
     * @param event is the event when the player clic on the button check
     */
    @Override
    public void handle(ActionEvent event) {
        try {
            game.check();
        } catch (GameException ex) {
            Logger.getLogger(CheckButtonHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
