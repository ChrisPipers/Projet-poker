package view.choiceBoxPlayer;

import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import model.Bet;
import model.Game;

/**
 *
 * @author Mitch
 */
public final class ChoiceBoxPlayer extends GridPane implements ChoiceBoxView {

    private final Button fold;
    private final Button check;
    private final Button call;
    private final Button raise;
    private final Button allin;
    private final TextField sumRaiseTF;

    private final Game game;

    private final List<Bet> avaibleBet;

    public ChoiceBoxPlayer(Game game) {
        this.game = game;
        fold = new Button("Fold");
        check = new Button("Check");
        call = new Button("Call");
        raise = new Button("Raise");
        allin = new Button("All-in");
        sumRaiseTF = new TextField();
        this.avaibleBet = game.getAvailable();

        textFieldFilter();
        handlerAllButton();
        definePosElements();
        defineSize();
        definePos();
        changeStyle();
        adaptVissibilityOfButton();
        this.game.addObserver(this);
    }

    private void defineSize() {
        this.fold.setMinSize(100, 40);
        this.allin.setMinSize(100, 40);
        this.check.setMinSize(100, 40);
        this.call.setMinSize(100, 40);
        this.raise.setMinSize(100, 40);
        this.sumRaiseTF.setMaxSize(100, 40);
        this.setMinSize(234 + 110, 120);
    }

    private void definePos() {
        this.setHgap(20);
        this.setVgap(20);
        this.fold.setTranslateX(10);
        this.raise.setTranslateX(10);
        this.fold.setTranslateY(10);
        this.check.setTranslateY(10);
        this.call.setTranslateY(10);
        this.check.setTranslateX(-10);
        this.allin.setTranslateX(-10);
    }

    private void definePosElements() {
        this.add(fold, 0, 0);
        this.add(check, 2, 0);
        this.add(call, 1, 0);
        this.add(raise, 0, 1);
        this.add(sumRaiseTF, 1, 1);
        this.add(allin, 2, 1);
    }

    private void changeStyle() {
        String Style = "-fx-background-color: crimson;"
                + "-fx-border-color: black black black black;";
        this.setStyle(Style);
    }

    private void textFieldFilter() {
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
    }

    private void handlerAllButton() {
        CheckButtonHandler checkButtonHandler = new CheckButtonHandler(this.game);
        check.addEventHandler(ActionEvent.ACTION, checkButtonHandler);

        CallBttonHandler callButtonHandler = new CallBttonHandler(this.game);
        call.addEventHandler(ActionEvent.ACTION, callButtonHandler);

        FoldButtonHandler foldButtonHandler = new FoldButtonHandler(this.game);
        fold.addEventHandler(ActionEvent.ACTION, foldButtonHandler);

        RaiseButtonHandler raiseButtonHandler = new RaiseButtonHandler(this.game, this);
        raise.addEventHandler(ActionEvent.ACTION, raiseButtonHandler);

        AllinButtonHandler allinButtonHandler = new AllinButtonHandler(this.game);
        allin.addEventHandler(ActionEvent.ACTION, allinButtonHandler);
    }

    public int getContainTextfield() {
        return Integer.parseInt(this.sumRaiseTF.getText());
    }

    public void hideButton(Button but) {
        but.setVisible(false);
    }

    public void hideAllButton() {
        this.call.setVisible(false);
        this.check.setVisible(false);
        this.raise.setVisible(false);
        this.sumRaiseTF.setVisible(false);
        this.fold.setVisible(false);
    }

    public void resetTextFieldRaise() {
        this.sumRaiseTF.clear();
    }

    public void adaptVissibilityOfButton() {
        hideAllButton();
        for (Bet bet : avaibleBet) {
            switch (bet) {
                case CHECK:
                    check.setVisible(true);
                    break;
                case RAISE:
                    raise.setVisible(true);
                    sumRaiseTF.setVisible(true);
                    break;
                case CALL:
                    call.setVisible(true);
                    break;
                case FOLD:
                    fold.setVisible(true);
                    break;
            }
        }
        if (this.game.getMinimium() == 0) {
            check.setVisible(true);
            call.setVisible(false);
        }
    }

    @Override
    public void update() {
        adaptVissibilityOfButton();
        resetTextFieldRaise();
    }

}
