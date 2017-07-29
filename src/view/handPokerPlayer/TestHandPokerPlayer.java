package view.handPokerPlayer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Player;
import model.cards.Card;
import model.cards.Color;
import model.cards.Value;

/**
 *
 * @author Mitch
 */
public class TestHandPokerPlayer extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Player player = new Player("Mitch", 0);
        
        Card card1 = new Card(Color.CLUB, Value.ACE);
        Card card2 = new Card(Color.DIAMOND, Value.ACE);
        player.add(card1);
        player.add(card2);
        
        handPokerPlayer hand = new handPokerPlayer(player.getCards());
        
        Scene scene = new Scene(hand, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
