package view.choiceBoxPlayer;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Game;
import model.GameException;

/**
 * this class allows to manage the event when the player clic on the call check
 * of the choiceboxplayer
 *
 * @author g39864
 */
public class CallBttonHandler implements EventHandler<ActionEvent> {

    private final Game game;

    /**
     * this is the constructor of the CallButtonHandler
     *
     * @param game is the game where make the action call
     */
    public CallBttonHandler(Game game) {
        this.game = game;
    }

    /**
     * this is the class allows to make the action call on the game when the
     * player clic on the button call of the choiceboxplayer
     *
     * @param event is the event when the player clic on the button call
     */
    @Override
    public void handle(ActionEvent event) {
        try {
            game.call();
        } catch (GameException ex) {
            Logger.getLogger(CallBttonHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
