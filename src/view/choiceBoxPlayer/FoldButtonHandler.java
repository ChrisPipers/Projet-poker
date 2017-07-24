
package view.choiceBoxPlayer;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Game;
import model.GameException;
import model.Player;

/**
 *
 * @author Mitch
 */
public class FoldButtonHandler implements EventHandler<ActionEvent> {

    private Game game;
    private Player curentPlayer;
    
    public FoldButtonHandler( Player curentPlayer, Game game) {
        this.game = game;
        this.curentPlayer = curentPlayer;
    }

   

    @Override
    public void handle(ActionEvent event) {
        System.out.println("fold");
                curentPlayer.fold();
        try {
            game.fold();
            curentPlayer.fold();
        } catch (GameException ex) {
            Logger.getLogger(FoldButtonHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }

}
