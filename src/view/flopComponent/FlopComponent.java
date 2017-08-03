package view.flopComponent;

import view.cardComponent.CardComponent;
import view.deckComponent.DeckComponent;
import java.util.List;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import model.Game;
import model.Status;
//import model.Observer;
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
    private final DeckComponent deck;
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

        deck = new DeckComponent();

        makeBoard(game);
        makePot(game);

        this.board.setTranslateY(20);
        this.deck.setTranslateY(20);
        this.text.setTranslateY(20);
        this.text.setTranslateX(-520);

        this.getChildren().addAll(board, deck, text);

    }

    public void makeBoard(Game game) {
        this.board = new HBox();
        this.board.setMinHeight(70);
        this.board.setMinWidth(64 * 5);
    }

    public void makePot(Game game) {
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
    }

    public void setPot() {
        if (game.getStatus() == END_GAME) {
            resetPot();
        } else {
            this.text.setText(Integer.toString(game.getPot()));
        }
    }

    public void resetPot() {
        this.text.setText(Integer.toString(0));
    }

    public void setBoard() {
        List<Card> cardsBoard = game.getBoard();
        if (null != game.getStatus()&& (this.status!= game.getStatus())) {
            switch (game.getStatus()) {
                case FLOP:
                    this.status = FLOP;
                    for (Card card : cardsBoard) {
                        card.show();
                        System.out.println("1");
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
                case END_MATCH:
                    
                    resetBoard();
                    resetPot();
                    break;
                default:
                    break;
            }
        }

    }

    public void resetBoard() {
        this.getChildren().clear();
    }

    @Override
    public void update() {
        setPot();
        
        setBoard();
    }
}
