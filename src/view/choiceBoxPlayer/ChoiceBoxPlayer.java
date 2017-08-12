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
import model.Status;

/**
 * this class allows to build the choiceboxplayer for the player can enter her
 * choice during a part
 *
 * @author g39864
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

    /**
     * this is the constructor to make the choiceboxplayer
     *
     * @param game is the parameter used for adapt the box allows the statut and
     * the choice possible by the player at a moment of the game
     */
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

    /**
     * this method allows to initialize the size of the layout component the
     * choiceboxplayer
     */
    private void defineSize() {
        this.fold.setMinSize(100, 40);
        this.allin.setMinSize(100, 40);
        this.check.setMinSize(100, 40);
        this.call.setMinSize(100, 40);
        this.raise.setMinSize(100, 40);
        this.sumRaiseTF.setMaxSize(100, 40);
        this.setMinSize(234 + 110, 120);
    }

    /**
     * this method allows to define the translation in the choiceboxplayer of
     * all layout
     */
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

    /**
     * this method allows to define the position in the choiceboxplayer of all
     * layout
     */
    private void definePosElements() {
        this.add(fold, 0, 0);
        this.add(check, 2, 0);
        this.add(call, 1, 0);
        this.add(raise, 0, 1);
        this.add(sumRaiseTF, 1, 1);
        this.add(allin, 2, 1);
    }

    /**
     * this method allows to change the style of the choiceboxplayer
     */
    private void changeStyle() {
        String Style = "-fx-background-color: crimson;"
                + "-fx-border-color: black black black black;";
        this.setStyle(Style);
    }

    /**
     * this method allows to limit the textfield when the player enter the sum
     * to raise to accept only the integer
     */
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

    /**
     * this method allows to link the button with her handler corresponding
     */
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

    /**
     * this method allows to take the valor enter in the textfield sumraiseTF
     *
     * @return a integer where is contained in the textfield sumraiseTF
     */
    public int getContainTextfield() {
        return Integer.parseInt(this.sumRaiseTF.getText());
    }

    /**
     * this method allows to hide all of the button of the choiceboxplayer
     */
    private void hideAllButton() {
        this.call.setVisible(false);
        this.check.setVisible(false);
        this.raise.setVisible(false);
        this.sumRaiseTF.setVisible(false);
        this.fold.setVisible(false);
    }

    /**
     * this method allows to reset the valor of the textfield sumraiseTF
     */
    public void resetTextFieldRaise() {
        this.sumRaiseTF.clear();
    }

    /**
     * this method allows to adapt the view of the choiceboxplayer depending on
     * the situation of the match
     */
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

    /**
     * this method allows to update the this when the game change
     */
    @Override
    public void update() {
        adaptVissibilityOfButton();
        resetTextFieldRaise();
        if (game.getStatus() == Status.END_GAME) {
            this.setVisible(false);
        }
    }

}
