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

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLView.fxml"));
        Parent root = (Parent) loader.load();
        FXMLViewController controller = loader.<FXMLViewController>getController();
//      GameView gameV = new GameView(game);

        game = new Game();
        game.addPlayer("1", 1000, 'M');
        game.addPlayer("2", 1000, 'M');
        game.addPlayer("3", 1000, 'M');
        game.addPlayer("4", 1000, 'M');
         game.addPlayer("5", 1000, 'M');
        game.addPlayer("6", 1000, 'M');
        game.addPlayer("7", 1000, 'M');
        game.addPlayer("8", 1000, 'M');
         game.addPlayer("9", 1000, 'M');
        game.addPlayer("10", 1000, 'M');
        game.start();
//        game.startMatch();
        System.out.println(game.getStatus() + "0");
        table = new TableComponent(game);
//        System.out.println(game.getSmallBlindValue()+"");
        game.smallBlind(1);
        
        game.bigBlind(2);
        System.out.println(game.getStatus() + "2");
System.out.println(game.getStatus() + "0");
        table = new TableComponent(game);
        List<Player> listP = game.getPlayers();
//        for (Player player : listP) {
//            System.out.println(player.getMoney());
//        }
        game.call();
        game.call();
        
        game.call();
        table.getFlopComponent().setPot(game);
        System.out.println(game.getStatus() + "3");
        System.out.println(game.getSmallBlindValue());
//        game.getCurrentPlayer().makeBet(game.getSmallBlindValue());
//        game.getCurrentPlayer().makeBet(game.getSmallBlindValue()*2);
        System.out.println(game.getPot() + "pot ");
        System.out.println(game.getCurrentPlayer().getCards());

//        List<Player> listP = game.getPlayers();
//        for (Player player : listP) {
//            
//            
//        }
//        List<Player> listePlay = game.getPlayers();
//        for (Player player : listePlay) {
//            table.getPlayerComponent().setHboxCards();
//        }
        controller.setGame(game);

        controller.setTable(table);

//        controller.setHBox(table);
//        Parent root =  (Parent) loader.load();
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
