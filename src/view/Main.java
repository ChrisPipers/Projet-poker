package view;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Game;
import model.Player;
import model.cards.Card;
import view.tableComponent.TableComponent;

/**
 *
 * @author Mitch
 */
public class Main extends Application {

    private Game game;
    private TableComponent table;
    private FXMLViewController fxControl;

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLView.fxml"));
        Parent root = (Parent) loader.load();
        FXMLViewController controller = loader.<FXMLViewController>getController();

        fxControl = new FXMLViewController();
        game = new Game();
        game.addPlayer("1", 1000);
        game.addPlayer("2", 1000);
        game.addPlayer("3", 1000);
        game.addPlayer("4", 1000);
        game.addPlayer("5", 1000);
        game.addPlayer("6", 1000);
        game.addPlayer("7", 1000);
        game.addPlayer("8", 1000);
        game.addPlayer("9", 1000);
        game.addPlayer("10", 1000);
        game.start();
        System.out.println(game.getStatus() + "0");

        game.smallBlind(game.getSmallBlindValue());

        game.bigBlind(game.getSmallBlindValue() * 2);
        table = new TableComponent(game);

//        table = new TableComponent(game);
//controller.setTable(table);
        List<Player> listP = game.getPlayers();
//        table.getFlopComponent().setPot(game);
//        table.updateFlop();
        controller.setGame(game);
        
        controller.setTable(table);
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
