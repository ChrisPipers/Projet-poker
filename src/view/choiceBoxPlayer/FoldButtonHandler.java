
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

    private final Game game;
    private Player curentPlayer;
    
    public FoldButtonHandler(Game game) {
        this.game = game;
    }

   

    @Override
    public void handle(ActionEvent event) {
       
//                curentPlayer.fold();
        try {          
                         System.out.println("fold");

//            curentPlayer.fold();

            game.fold();
        } catch (GameException ex) {
            Logger.getLogger(FoldButtonHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
//            
        
    }

}
