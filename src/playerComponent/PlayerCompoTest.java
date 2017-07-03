package playerComponent;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Player;
import model.cards.Deck;


/**
 *
 * @author Mitch
 */
public class PlayerCompoTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        Deck deck = new Deck();

        String name = "Mitch";
        int pot = 1000;
        char sexe = 'M';
        Player player = new Player(name, pot, sexe);
        player.getHandCards().add(deck.pick());
        player.getHandCards().add(deck.pick());

        PlayerComponent playerC = new PlayerComponent(player);

        Scene scene1 = new Scene(playerC, 400, 400);
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
