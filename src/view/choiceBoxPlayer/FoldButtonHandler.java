
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
public class FoldButtonHandler implements EventHandler<ActionEvent> {

    private Game game;

    public FoldButtonHandler(Game game) {
        this.game = game;
    }

   

    @Override
    public void handle(ActionEvent event) {
       
            try {
                game.fold();
            } catch (GameException ex) {
                Logger.getLogger(CheckButtonHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

}
