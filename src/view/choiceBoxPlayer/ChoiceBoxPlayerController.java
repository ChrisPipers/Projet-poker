package view.choiceBoxPlayer;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import model.Game;
import model.GameException;

/**
 *
 * @author Mitch
 */
public class ChoiceBoxPlayerController {
    
    private Game game;
    
    @FXML
    private Button check;
    
    @FXML
    private Button fold;
    
    @FXML
    private Button raise;
    
    @FXML 
    private TextField sumRaise;
    
    
    
    private void handleButtonCheck(ActionEvent event) throws GameException {
        check.addEventHandler(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event
            ) {
               
                    if (game.getMinimium()==0){
                        
                        try {
                            game.call();
                        } catch (GameException ex) {
                            Logger.getLogger(ChoiceBoxPlayerController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                 
            }

        }
        );
    }

    private void handleButtonFold(ActionEvent event) throws GameException {
        fold.addEventHandler(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event
            ) {

                try {
                    game.fold();
                } catch (GameException ex) {
                    Logger.getLogger(ChoiceBoxPlayerController.class.getName()).log(Level.SEVERE, null, ex);
                }
                

            }
        }
        );

    }

    private void handleButtonRaise(ActionEvent event) throws GameException {
        raise.addEventHandler(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event
            ) {

                 
                try {
                    game.raise(Integer.parseInt(sumRaise.getText()));
                } catch (GameException ex) {
                    Logger.getLogger(ChoiceBoxPlayerController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
        );
}
    
}
