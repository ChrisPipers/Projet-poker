package view.choiceBoxPlayer;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import model.Bet;
import model.Game;
import model.Player;

/**
 *
 * @author Mitch
 */
public class ChoiceBoxPlayer extends GridPane implements ChoiceBoxView {

    private Button fold;

    private Button check;

    private Button call;

    private Button raise;

    private TextField sumRaiseTF;

////    private ChoiceBoxPlayerController choiceBoxPlayerController;
    private Game game;

    private Match match;

    private CallBttonHandler callButtonHandler;
    private CheckButtonHandler checkButtonHandler;
    private FoldButtonHandler foldButtonHandler;
    private RaiseButtonHandler raiseButtonHandler;
    private Player curentPlayer;
    private List<Bet> avaibleBet;

//    private final List<Observer> listObserver;

    public ChoiceBoxPlayer(Game game) {
        this.game = game;
//        this.listObserver = new ArrayList<>();
        fold = new Button("Fold");
        check = new Button("Check");
        call = new Button("Call");
        raise = new Button("Raise");
        sumRaiseTF = new TextField();
//        curentPlayer = game.getCurrentPlayer();
        this.avaibleBet = game.getAvailable();
        sumRaiseTF.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event
            ) {
                if (!"0123456789".contains(event.getCharacter())) {
                    event.consume();
                }
            }
        }
        );

        checkButtonHandler = new CheckButtonHandler(this.game);
        check.addEventHandler(ActionEvent.ACTION, checkButtonHandler);

        callButtonHandler = new CallBttonHandler(game, this);
        call.addEventHandler(ActionEvent.ACTION, callButtonHandler);

        foldButtonHandler = new FoldButtonHandler(this.game);
        fold.addEventHandler(ActionEvent.ACTION, foldButtonHandler);

        raiseButtonHandler = new RaiseButtonHandler(this.game, this);
        raise.addEventHandler(ActionEvent.ACTION, raiseButtonHandler);

        this.game = game;
        this.match = new Match();

        this.add(fold, 0, 0);
        this.add(check, 2, 0);
        this.add(call, 1, 0);
        this.add(raise, 0, 1);
        this.add(sumRaiseTF, 1, 1);
        defineSize();
        changeStyle();
        adaptVissibilityOfButton();
        this.game.addObserver(this);
        
//        this.setBackground();
    }

    private void defineSize() {
        this.fold.setMinSize(100, 40);

        this.check.setMinSize(100, 40);
        this.call.setMinSize(100, 40);
        this.raise.setMinSize(100, 40);
        this.sumRaiseTF.setMaxSize(100, 40);
        this.setMinSize(234+110, 120);
        this.setHgap(20);
        this.setVgap(20);
        this.fold.setTranslateX(10);
        this.raise.setTranslateX(10);
        this.fold.setTranslateY(10);
        this.check.setTranslateY(10);
        this.call.setTranslateY(10);
        this.check.setTranslateX(-10);
    }

    private void changeStyle() {
        String Style = "-fx-background-color: crimson;"
                + "-fx-border-color: black black black black;";
        this.setStyle(Style);
    }

    public int getContainTextfield() {
        return Integer.parseInt(this.sumRaiseTF.getText());
    }

    public void hideButton(Button but) {
        but.setVisible(false);
    }
    
    public void hideAllButton(){
        this.call.setVisible(false);
        this.check.setVisible(false);
        this.raise.setVisible(false);
        this.sumRaiseTF.setVisible(false);
        this.fold.setVisible(false);
    }

    public void resetTextFieldRaise() {
        this.sumRaiseTF.clear();
    }
    
    
    
    public void adaptVissibilityOfButton(){
        hideAllButton();
        for (Bet bet : avaibleBet) {
            switch (bet){
                case CHECK: check.setVisible(true);break;
                case RAISE: raise.setVisible(true);
                            sumRaiseTF.setVisible(true);break;
                case CALL: call.setVisible(true);break;
                case FOLD: fold.setVisible(true);break;
           
            }
        }
    }
    
    
    
    

    @Override
    public void update() {
        System.out.println("update box");
        
        adaptVissibilityOfButton();
        resetTextFieldRaise();
if (this.game.getMinimium()== 0) {
            check.setVisible(true);
            call.setVisible(false);
        } 
    }
 
}
