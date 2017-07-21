package view.choiceBoxPlayer;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import model.Game;
import model.GameException;

/**
 *
 * @author Mitch
 */
public class CheckButtonHandler implements EventHandler<ActionEvent> {

    private Game game;

    public CheckButtonHandler(Game game) {
        this.game = game;
    }

   

    @Override
    public void handle(ActionEvent event) {
        if(game.getMinimium() == 0)
        {

            try {
                game.call();
            } catch (GameException ex) {
                Logger.getLogger(CheckButtonHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
