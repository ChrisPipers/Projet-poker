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
public class CheckButtonHandler implements EventHandler<ActionEvent> {

    private final Game game;

    public CheckButtonHandler(Game game) {
        this.game = game;
//        this.curentPlayer = curentPlayer;
    }

   

    @Override
    public void handle(ActionEvent event) {
        System.out.println("check");
        if(game.getMinimium() == 0)
        {

            try {
//                if (game.getMinimium()> game.getSmallBlindValue()*2){
//                    throw new ChoiceBoxViewException("la valeur minimum ")
//                }
                game.check();
            } catch (GameException ex) {
                
                Logger.getLogger(CheckButtonHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
