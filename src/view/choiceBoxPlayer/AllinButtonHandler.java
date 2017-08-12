package view.choiceBoxPlayer;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Game;
import model.GameException;

/**
 * this class allows to manage the event when the player clic on the allin check
 * of the choiceboxplayer
 *
 * @author g39864
 */
public class AllinButtonHandler implements EventHandler<ActionEvent> {

    private final Game game;

    /**
     * this is the constructor of the AllinButtonHandler
     *
     * @param game is the game where make the action all in
     */
    public AllinButtonHandler(Game game) {
        this.game = game;
    }

    /**
     * this is the class allows to make the action all in on the game when the
     * player clic on the button all in of the choiceboxplayer
     *
     * @param event is the event when the player clic on the button all in
     */
    @Override
    public void handle(ActionEvent event) {
        try {
            game.allIn();
        } catch (GameException ex) {
            Logger.getLogger(AllinButtonHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
