package view.choiceBoxPlayer;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import model.Game;
import model.GameException;
import model.Player;

/**
 *
 * @author Mitch
 */
public class CheckButtonHandler implements EventHandler<ActionEvent> {

    private Game game;
    private Player curentPlayer;

    public CheckButtonHandler( Player curentPlayer) {
        this.game = game;
        this.curentPlayer = curentPlayer;
    }

   

    @Override
    public void handle(ActionEvent event) {
        System.out.println("check");
        if(game.getMinimium() == 0)
        {

            try {
                game.call();
//                game.
            } catch (GameException ex) {
                Logger.getLogger(CheckButtonHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
