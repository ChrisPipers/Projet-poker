package view.choiceBoxPlayer;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Game;
import model.GameException;

/**
 * this class allows to manage the event when the player clic on the button
 * raise of the choiceboxplayer
 *
 * @author g39864
 */
public class RaiseButtonHandler implements EventHandler<ActionEvent> {

    private final Game game;
    private final ChoiceBoxPlayer choiceBoxPlayer;

    /**
     * this is the constructor of the raisebuttonhandler
     *
     * @param game is the game where make the action raise
     * @param choiceBoxPlayre is the box who contains the button raise
     */
    public RaiseButtonHandler(Game game, ChoiceBoxPlayer choiceBoxPlayre) {
        this.game = game;
        this.choiceBoxPlayer = choiceBoxPlayre;
    }

    /**
     * this is the class allows to make the action raise on the game when the
     * player clic on the button raise of the choiceboxplayer and take the valor
     * of the textfield who containt the valor of the raise
     *
     * @param event is the event when the player clic on the button raise
     */
    @Override
    public void handle(ActionEvent event) {
        int sumRaise = choiceBoxPlayer.getContainTextfield();

        try {
            game.raise(sumRaise);
        } catch (GameException ex) {
            Logger.getLogger(RaiseButtonHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
