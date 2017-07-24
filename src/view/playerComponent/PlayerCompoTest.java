package view.playerComponent;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Game;
import model.GameException;
import model.Player;
import model.cards.Card;
import model.cards.Color;
import model.cards.Deck;
import model.cards.Value;


/**
 *
 * @author Mitch
 */
public class PlayerCompoTest extends Application {

    @Override
    public void start(Stage primaryStage) throws GameException {
        Deck deck = new Deck();
        Game game = new Game();
        game.addPlayer("Patrick", 1000, 'M');
        game.addPlayer("Patrick2", 1000, 'M');
        game.addPlayer("Patrick3", 1000, 'M');
        game.addPlayer("Patridck4", 1000, 'M');
        game.start();
//        String name = "Mitch123456789";
//        int pot = 1000;
//        char sexe = 'M';
        Player player = game.getCurrentPlayer();
        Card card1 = new Card(Color.CLUB, Value.ACE);
        Card card2 = new Card(Color.CLUB, Value.ACE);
        player.add(card1);
        player.add(card2);

        PlayerComponent playerC = new PlayerComponent(player, game);

        Scene scene1 = new Scene(playerC, 280, 150);
        primaryStage.centerOnScreen();

        primaryStage.sizeToScene();
        primaryStage.setResizable(true);
        primaryStage.setTitle("Player");
        primaryStage.setScene(scene1);
        primaryStage.show();

    }

    /**
     * this method allows to launch the application
     *
     * @param args is the param of argument necessary
     */
    public static void main(String[] args) {
        launch(args);
    }

}
