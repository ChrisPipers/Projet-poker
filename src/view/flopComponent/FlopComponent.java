package view.flopComponent;

import view.cardComponent.CardComponent;
import view.deckComponent.DeckComponent;
import java.util.List;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import model.Game;
import model.cards.Card;

/**
 *
 * @author Mitch
 */
public class FlopComponent extends HBox {
    
    private HBox board ;
    private DeckComponent deck;
    private TextField text;
    
    public FlopComponent(){
        this.setMinHeight(70+30);
        this.setMinWidth(62*5+90+200+100);
        
        
        
        this.setPrefWidth(62*5+90+200+100);
        board = new HBox();
        this.board.setMinHeight(70);
        this.board.setMinWidth(62*5);
        
        deck = new DeckComponent();
        this.getChildren().addAll(board, deck);
        
    }
    
    public FlopComponent(Game game){
        this.setMinHeight(70+30);
        this.setMinWidth(62*5+90+200+100);
        
        this.setPrefWidth(62*5+90+200+100);
        
        deck = new DeckComponent();
        makeBoard(game);
        makePot(game);
        this.board.setTranslateY(20);
        this.deck.setTranslateY(20);
        this.text.setTranslateY(20);
        this.text.setTranslateX(-520);
        this.getChildren().addAll(board, deck, text);
//        this.getChildren().add(deck);
//        this.getChildren().add(text);
        
    }
    
    
    public void makeBoard(Game game) {
        board = new HBox();
        this.board.setMinHeight(70);
        this.board.setMinWidth(62*5);
        List <Card> flop = game.getBoard();
        System.out.println(flop.size()+ " nb de carte");
        for (Card card : flop) {
            card.show();
            CardComponent cardC = new CardComponent(card);
            this.board.getChildren().add(cardC);
        }
        
    }
    
    public void makePot(Game game){
        String style = "-fx-background-color: red;"
//                + "-fx-size: 1 cm;"
//                + "-fx-lenght: 2cm;"
                + "-fx-font-family: monospace;"
                + "-fx-font-size: 16;"
                + "-fx-alignment: center;"
                + "-fx-font-weight: bold"
                
                ;
        
        int sumPot = game.getPot();
        System.out.println(sumPot+ " on est dans make pot");
        String sSumPot = String.valueOf(sumPot);
        System.out.println(sSumPot);
        this.text = new TextField(""+sSumPot);
        this.text.setStyle(style);
        this.text.setMinHeight(50);
        this.text.setMinWidth(120);
        
        
    }
    
    
    
    
    
}
