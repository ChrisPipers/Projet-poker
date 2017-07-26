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
public class RaiseButtonHandler implements EventHandler<ActionEvent> {

    private Game game;
    private ChoiceBoxPlayer choiceBoxPlayer;
    private Player curentPlayer;

    public RaiseButtonHandler(Game game, ChoiceBoxPlayer choiceBoxPlayre) {
        this.game = game;
        this.choiceBoxPlayer = choiceBoxPlayre;
    }

 
    

    @Override
    public void handle(ActionEvent event) {
        System.out.println("raise");
        int sumRaise = choiceBoxPlayer.getContainTextfield();
        try {
            game.raise(sumRaise);
        } catch (GameException ex) {
            Logger.getLogger(RaiseButtonHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
