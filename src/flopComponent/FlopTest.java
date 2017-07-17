package flopComponent;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Game;
import model.GameException;

/**
 *
 * @author Mitch
 */
public class FlopTest extends Application {

    @Override
    public void start(Stage primaryStage) throws GameException {
        Game game = new Game();

        Match match = new Match();
        game.addPlayer("Patrick", 1000, 'M');
        game.addPlayer("Patrick2", 1000, 'M');
        game.addPlayer("Patrick3", 1000, 'M');
        game.addPlayer("Patrick4", 1000, 'M');
        game.start();
        game.smallBlind(1);
        game.bigBlind(2);
        game.call();
        game.call();

        FlopComponent flop = new FlopComponent(game);

        FlopComponent flopC = new FlopComponent(game);
        Scene scene = new Scene(flopC, 300, 250);

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
