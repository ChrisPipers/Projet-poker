package view;

import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Game;
import model.Player;
import view.tableComponent.TableComponent;
import view.thread.WaitForAnimation;

/**
 *
 * @author Mitch
 */
public class Main extends Application {

    private Game game;
    private TableComponent table;
    private FXMLViewController fxControl;
    private WaitForAnimation wait ;

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLView.fxml"));
        Parent root = (Parent) loader.load();
        FXMLViewController controller = loader.<FXMLViewController>getController();
        fxControl = new FXMLViewController();

        wait = new WaitForAnimation(1);
        
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
        table = new TableComponent(game);
//        wait.run();
        game.smallBlind(game.getSmallBlindValue());
//        wait.run();
                table = new TableComponent(game);

        game.bigBlind(game.getSmallBlindValue() * 2);
//wait.run();
        table = new TableComponent(game);

        List<Player> listP = game.getPlayers();

        controller.setGame(game);

        game.addObserver(controller);

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
