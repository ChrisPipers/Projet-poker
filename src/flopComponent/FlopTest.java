package flopComponent;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Game;

/**
 *
 * @author Mitch
 */
public class FlopTest extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Game game = new Game();
        FlopComponent flop = new FlopComponent(game);
        Match match = new Match();
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
