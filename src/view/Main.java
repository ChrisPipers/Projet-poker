
package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Game;

/**
 *
 * @author Mitch
 */
public class Main extends Application{

    Game game = new Game();
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLView.fxml"));
        
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
