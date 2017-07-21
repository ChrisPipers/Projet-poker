
package view.choiceBoxPlayer;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Game;

/**
 *
 * @author Mitch
 */
public class ChoiceBoxPlayer extends GridPane{
    
    private Button fold;
    
    private Button check;
    
    private Button raise;
    
    private TextField sumRaise;
    
    private ChoiceBoxPlayerController choiceBoxPlayerController;
    
    private Game game;
    
    
    
    public ChoiceBoxPlayer(Game game){
        fold = new Button("Fold");
        check = new Button("Check");
        raise  = new Button("Raise");
        sumRaise = new TextField();
        
        choiceBoxPlayerController = new ChoiceBoxPlayerController();
        
        this.game = game;
        
        
        
        this.add(fold, 0, 0);
        this.add(check, 1, 0);
        this.add(raise, 0, 1);
        this.add(sumRaise, 1,1);
        defineSize();
        changeStyle();
//        this.setBackground();

        
    }
    
    private void defineSize(){
        this.fold.setMinSize(100, 40);
        
        this.check.setMinSize(100, 40);
        this.raise.setMinSize(100, 40);
        this.sumRaise.setMaxSize(100, 40);
        this.setMinSize(234, 120);
        this.setHgap(20);
        this.setVgap(20);
        this.fold.setTranslateX(10);
        this.raise.setTranslateX(10);
        this.fold.setTranslateY(10);
        this.check.setTranslateY(10);
    }
    
    private void changeStyle(){
        String Style = "-fx-background-color: crimson;"
                +"-fx-border-color: black black black black;";
        this.setStyle(Style);
    }
    
    
    public int getContainTextfield(){
        return Integer.parseInt(this.sumRaise.getText());
    }
    
    public void hideCheck(){
        this.check.setVisible(false);
    }
}
