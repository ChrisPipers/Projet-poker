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
import model.Game;
import model.Player;

/**
 *
 * @author Mitch
 */
public class ChoiceBoxPlayer extends GridPane implements ChoiceBoxView {

    private Button fold;

    private Button check;

    private Button raise;

    private TextField sumRaiseTF;

////    private ChoiceBoxPlayerController choiceBoxPlayerController;
    private Game game;

    private Match match;

    private CheckButtonHandler checkButtonHandler;
    private FoldButtonHandler foldButtonHandler;
    private RaiseButtonHandler raiseButtonHandler;
    private Player curentPlayer;
//    private final List<Observer> listObserver;

    public ChoiceBoxPlayer(Game game) {
//        this.listObserver = new ArrayList<>();
        fold = new Button("Fold");
        check = new Button("Check");
        raise = new Button("Raise");
        sumRaiseTF = new TextField();
//        curentPlayer = game.getCurrentPlayer();
        
        
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

        checkButtonHandler = new CheckButtonHandler(game);
        check.addEventHandler(ActionEvent.ACTION, checkButtonHandler);

        foldButtonHandler = new FoldButtonHandler(game);
        fold.addEventHandler(ActionEvent.ACTION, foldButtonHandler);

        raiseButtonHandler = new RaiseButtonHandler(game, this);
        raise.addEventHandler(ActionEvent.ACTION, raiseButtonHandler);

        this.game = game;
        this.match = new Match();

        this.add(fold, 0, 0);
        this.add(check, 1, 0);
        this.add(raise, 0, 1);
        this.add(sumRaiseTF, 1, 1);
        defineSize();
        changeStyle();
        this.game.addObserver(this);

//        this.setBackground();
    }

    private void defineSize() {
        this.fold.setMinSize(100, 40);

        this.check.setMinSize(100, 40);
        this.raise.setMinSize(100, 40);
        this.sumRaiseTF.setMaxSize(100, 40);
        this.setMinSize(234, 120);
        this.setHgap(20);
        this.setVgap(20);
        this.fold.setTranslateX(10);
        this.raise.setTranslateX(10);
        this.fold.setTranslateY(10);
        this.check.setTranslateY(10);
    }

    private void changeStyle() {
        String Style = "-fx-background-color: crimson;"
                + "-fx-border-color: black black black black;";
        this.setStyle(Style);
    }

    public int getContainTextfield() {
        return Integer.parseInt(this.sumRaiseTF.getText());
    }

    public void hideCheck() {
        this.check.setVisible(false);
    }

    public void resetTextFieldRaise() {
        this.sumRaiseTF.clear();
    }

    @Override
    public void update() {
        if (this.game.getMinimium() != 0) {
            hideCheck();
        }
        
        resetTextFieldRaise();

    }

//    @Override
//    public void notifyObserver() {
////        setChanged();
////        listObserver.stream().forEach((observer) -> {
////            observer.update();
////        });
//
//        for (Observer observer : listObserver) {
//            observer.update();
//        }
//    }
////
////    @Override
//    public void addObserver(Observer observer) {
//        listObserver.add(observer);
//    }
//
//    @Override
//    public void removeObserver(Observer observer) {
//        listObserver.remove(observer);
//    }
//    
}
