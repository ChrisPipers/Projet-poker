package view;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Game;
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
        game.addPlayer("Patrick", 1000, 'M');
        game.addPlayer("Patrick2", 1000, 'M');
        game.addPlayer("Patrick3", 1000, 'M');
        game.addPlayer("Patridck4", 1000, 'M');
        game.start();
        Match match = new Match();
        
        table = new TableComponent(game);

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
