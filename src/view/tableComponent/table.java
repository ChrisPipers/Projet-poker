package view.tableComponent;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Game;
import model.cards.Card;
import model.cards.Color;
import model.cards.Value;

/**
 *
 * @author Mitch
 */
public class table extends Application {

    @Override
    public void start(Stage primaryStage) {
        Game game = new Game();
        Match match = new Match();
        game.addPlayer("Patrick", 1000, 'M');
        game.addPlayer("Patrick2", 1000, 'M');
        game.addPlayer("Patrick3", 1000, 'M');
        game.addPlayer("Patrick4", 1000, 'M');
        Card card = new Card(Color.CLUB, Value.ACE);
        
        for (int i = 0; i < game.getPlayers().size(); i++) {
            game.getPlayers().get(i).add(card);
                        game.getPlayers().get(i).add(card);

        }

        TableComponent table = new TableComponent(game);

        Scene scene1 = new Scene(table, 1280, 840);
        primaryStage.centerOnScreen();

        primaryStage.sizeToScene();
        primaryStage.setResizable(false);
        primaryStage.setTitle("Table");
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
