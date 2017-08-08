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
 *
 * @author Mitch
 */
public final class FlopComponent extends HBox implements FlopView {

    private HBox board;
    private DeckComponent deck;
    private TextField text;
    private final Game game;
    private Status status;

    public FlopComponent(Game game) {
        this.game = game;
        this.game.addObserver(this);
        this.status = game.getStatus();

        this.setMinHeight(70 + 30);
        this.setMinWidth(62 * 5 + 90 + 200 + 100);
        this.setPrefWidth(62 * 5 + 90 + 200 + 100);

        makeBoard(game);
        makeDeck();
        makePot(game);

        this.getChildren().addAll(board, deck, text);
    }

    private void makeBoard(Game game) {
        this.board = new HBox();
        this.board.setMinHeight(70);
        this.board.setMinWidth(64 * 5);
        this.board.setTranslateY(20);
    }

    private void makeDeck() {
        this.deck = new DeckComponent();
        this.deck.setTranslateY(20);
    }

    private void makePot(Game game) {
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

    private void resetPot() {
        this.text.setText(Integer.toString(0));
    }

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

    private void setPot() {
        if (game.getStatus() == END_GAME) {
            resetPot();
        } else {
            this.text.setText(Integer.toString(game.getPot()));
        }
    }

    @Override
    public void update() {
        setBoard();
        setPot();

    }
}
