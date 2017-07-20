package view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import model.Game;
import view.flopComponent.FlopComponent;
import view.playerComponent.PlayerComponent;
import view.tableComponent.TableComponent;

/**
 * FXML Controller class
 *
 * @author Mitch
 */
public class FXMLViewController implements Initializable {

    private Game game;
//    private Stage stage;
    private FXMLViewController fxmlViewController;

    private HBox tBox;
    @FXML
    private AnchorPane AnchorPane;
    
    @FXML
    private Pane pane;
        
    @FXML
    private HBox hBoxMain;
    
    @FXML
    private TableComponent table;
    
    @FXML
    private PlayerComponent playerC;
    
    @FXML
    private FlopComponent flop;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        hBoxMain = new HBox();

//        String style = "-fx-background-color: red;";
        System.out.println("init");

       
//       this.hBoxMain = new HBox();
       
        
        
        
//        AnchorPane.getChildren().add(table);
//        fxmlLoader.setRoot(table);
    }    
    
    
    
    public FXMLViewController getFXMLViewController(){
        return this.fxmlViewController;
    }
    
    
    public void setGame (Game game){
        this.game = game;
    }
    
    public void setTable(TableComponent table){
        
//        this.table = new TableComponent(this.game);
//        this.pane.getChildren().add(table);
        this.hBoxMain.getChildren().add(table);
//        this.tBox.getChildren().add(table);
    }
    
    
    
    public HBox getHbox(){
        return this.hBoxMain;
    }
    
    
    public void setHBox(TableComponent table){
        this.hBoxMain = new HBox(table);
    }
    
    
}
