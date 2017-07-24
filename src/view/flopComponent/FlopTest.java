package flopComponent;

import view.flopComponent.FlopComponent;
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
        
                System.out.println(game.getStatus()+"1");
                System.out.println(game.getBoard().size());

        game.smallBlind(1);
        game.bigBlind(2);
                System.out.println(game.getStatus()+"2");
                System.out.println(game.getBoard().size()+"taille board");

        game.call();
        game.call();
                        System.out.println(game.getStatus()+"3");
                System.out.println(game.getBoard().size()+"taille board");

        game.call();
        game.call();
         System.out.println(game.getStatus()+"4");
                System.out.println(game.getBoard().size()+"taille board");

        game.call();
        game.call();
             System.out.println(game.getStatus()+"5");
                System.out.println(game.getBoard().size()+"taille board");

        game.call();
        game.call();
         System.out.println(game.getStatus()+"6");
                System.out.println(game.getBoard().size()+"taille board");

        game.call();
        game.call();
 System.out.println(game.getStatus()+"7");
                System.out.println(game.getBoard().size()+"taille board");

        
             game.call();
        game.call();
        game.call();
        game.call();
         System.out.println(game.getStatus()+"6");
//
        System.out.println(game.getBoard().size());
//        System.out.println(game.getCards().size());

        FlopComponent flop = new FlopComponent(game);
        flop.setBoard(game);
        flop.setPot(game);
        Scene scene = new Scene(flop, 800, 200);

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
