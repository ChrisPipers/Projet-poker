package main;

import baseDeDonnées.ManagementBaseDeDonnées;
import baseDeDonnées.PlayerBDD;
import baseDeDonnées.mainBaseDeDonnees;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Game;
import model.Player;
import view.FXMLViewController;
import view.tableComponent.TableComponent;

/**
 * this class allows to launch the game , this contain the main of the game
 *
 * @author g39864
 */
public class Main extends Application {

    private Game game;
    private TableComponent table;
    private FXMLViewController fxControl;

    @Override
    public void start(Stage stage) throws Exception {
        game = new Game();

        mainBaseDeDonnees.connect();
        int nbPlayer = ManagementBaseDeDonnées.getNbPlayer();
        if (nbPlayer == 0) {
            game.addPlayer("1", 1000, 1);
            game.addPlayer("2", 1000, 1);
            game.addPlayer("3", 1000, 1);
            game.addPlayer("4", 1000, 1);
            game.addPlayer("5", 1000,1);
            game.addPlayer("6", 1000,1);
            game.addPlayer("7", 1000,1);
            game.addPlayer("8", 1000,1);
            game.addPlayer("9", 1000,1);
            game.addPlayer("10", 1000,1);
            mainBaseDeDonnees.addPlayersBDD(game.getPlayers());
        } else {
            List<PlayerBDD> players = ManagementBaseDeDonnées.getPlayer();
            for (PlayerBDD p : players) {
                game.addPlayer(p.getName(), p.getMoney(), p.getBounty());
            }
        }

        stage.getIcons().add(new Image("./view/Image/logo.png"));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLView.fxml"));
        Parent root = (Parent) loader.load();
        FXMLViewController controller = loader.<FXMLViewController>getController();
        fxControl = new FXMLViewController();

        game.start();
        table = new TableComponent(game);
        game.smallBlind(game.getSmallBlindValue());
        table = new TableComponent(game);

        game.bigBlind(game.getSmallBlindValue() * 2);
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
     * this method launch the game
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
