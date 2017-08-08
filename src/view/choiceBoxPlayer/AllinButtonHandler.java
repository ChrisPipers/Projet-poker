
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
public class AllinButtonHandler implements EventHandler<ActionEvent> {
    
    private final Game game;
//    private final ChoiceBoxPlayer choiceBoxPlayer;
    
    public AllinButtonHandler(Game game, ChoiceBoxPlayer choiceBoxPlayer ){
        this.game = game;
//        this.choiceBoxPlayer = choiceBoxPlayer;
    }
    
    @Override
    public void handle(ActionEvent event) {
//        int sumRaise = choiceBoxPlayer.getContainTextfield();

        try {
            game.allIn();
        } catch (GameException ex) {
            Logger.getLogger(RaiseButtonHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
