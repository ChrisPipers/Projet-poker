package view.flopComponent;

import view.cardComponent.CardComponent;
import view.deckComponent.DeckComponent;
import java.util.List;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import model.Game;
import model.Status;
import static model.Status.END_GAME;
import static model.Status.FLOP;
import static model.Status.RIVER;
import static model.Status.TURN;
import model.cards.Card;

/**
 * this calss allows to build the flop component who is composed to the card of
 * the flop, the valor of the pot and the valor of the bounty
 *
 * @author g39864
 */
public final class FlopComponent extends HBox implements FlopView {

    private HBox board;
    private DeckComponent deck;
    private TextField text;
    private TextField bounty;
    private final Game game;
    private Status status;

    /**
     * this is the constructor of the flopcomponent
     *
     * @param game is the game used for initialised the flop and to evolve it
     * while the evolve of the match
     */
    public FlopComponent(Game game) {
        this.game = game;
        this.game.addObserver(this);
        this.status = game.getStatus();

        this.setMinHeight(70 + 30);
        this.setMinWidth(62 * 5 + 90 + 200 + 100);
        this.setPrefWidth(62 * 5 + 90 + 200 + 100);

        makeBoard();
        makeDeck();
        makePot();
        makeBounty();

        this.getChildren().addAll(board, deck, text, bounty);
    }

    /**
     * this method allows to dimentionned the hbox who contains the cards of the
     * flop
     */
    private void makeBoard() {
        this.board = new HBox();
        this.board.setMinHeight(70);
        this.board.setMinWidth(64 * 5);
        this.board.setTranslateY(20);
    }

    /**
     * this method allows to make a deck component
     */
    private void makeDeck() {
        this.deck = new DeckComponent();
        this.deck.setTranslateY(20);
    }

    /**
     * this method allows to initialize the label who contains the valor of the
     * potvof the match
     */
    private void makePot() {
        String style = "-fx-background-color: red;"
                + "-fx-font-family: monospace;"
                + "-fx-font-size: 16;"
                + "-fx-alignment: center;"
                + "-fx-font-weight: bold;";

        String sSumPot = String.valueOf(0);

        this.text = new TextField("" + sSumPot);
        this.text.setStyle(style);
        this.text.setMinHeight(50);
        this.text.setMinWidth(120);
        this.text.setTranslateY(20);
        this.text.setTranslateX(-520);
    }

    /**
     * this method allows to initialize the label who contains the valor of the
     * bounty of the match
     */
    private void makeBounty() {
        String style = "-fx-background-color: red;"
                + "-fx-font-family: monospace;"
                + "-fx-font-size: 16;"
                + "-fx-alignment: center;"
                + "-fx-font-weight: bold;";

        String bount = String.valueOf(0);

        this.bounty = new TextField("" + bount);
        this.bounty.setStyle(style);
        this.bounty.setMinHeight(50);
        this.bounty.setMinWidth(120);
        this.bounty.setTranslateY(20);
        this.bounty.setTranslateX(-520);
    }

    /**
     * this method allows to reset the valor of pot when a new match is launch
     */
    private void resetPot() {
        this.text.setText(Integer.toString(0));
    }

    /**
     * this method allows to reset the valor of bounty when a new match is
     * launch
     */
    private void resetBounty() {
        this.bounty.setText(Integer.toString(0));
    }

    /**
     * this method allows to set the hbox board who contain the cards of the
     * flop while the game and modify it allows the statut of the match
     */
    private void setBoard() {
        List<Card> cardsBoard = game.getBoard();
        if (null != game.getStatus() && (this.status != game.getStatus())) {
            switch (game.getStatus()) {
                case FLOP:
                    this.status = FLOP;
                    for (Card card : cardsBoard) {
                        card.show();
                        CardComponent cardC = new CardComponent(card);
                        this.board.getChildren().add(cardC);
                    }
                    break;
                case TURN: {
                    this.status = TURN;
                    Card card = cardsBoard.get(3);
                    card.show();
                    CardComponent cardC = new CardComponent(card);
                    this.board.getChildren().add(cardC);
                    break;
                }
                case RIVER: {
                    this.status = RIVER;
                    Card card = cardsBoard.get(4);
                    card.show();
                    CardComponent cardC = new CardComponent(card);
                    this.board.getChildren().add(cardC);
                    break;
                }

            }
        }

    }

    /**
     * this method allows to set the label who contains the valor of the pot
     */
    private void setPot() {
        if (game.getStatus() == END_GAME) {
            resetPot();
        } else {
            this.text.setText(Integer.toString(game.getPot()));
        }
    }

    /**
     * this method allows to set the label who contains the valor of the bounty
     */
    private void setBounty() {
        if (game.getStatus() == END_GAME) {
            resetBounty();
        } else {
            this.bounty.setText(Integer.toString(game.getBounty()));
        }
    }

    /**
     * this method allows to update this flop component where the are some
     * changement
     */
    @Override
    public void update() {
        setBoard();
        setPot();
        setBounty();

    }
}
