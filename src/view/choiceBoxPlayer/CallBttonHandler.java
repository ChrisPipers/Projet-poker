package view.choiceBoxPlayer;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Game;
import model.GameException;

/**
 *
 * @author Mitch
 */
public class CallBttonHandler implements EventHandler<ActionEvent> {

    private final Game game;

    public CallBttonHandler(Game game) {
        this.game = game;
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            game.call();
        } catch (GameException ex) {
            Logger.getLogger(CallBttonHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
