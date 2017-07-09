package flopComponent;

import cardComponent.CardComponent;
import deckComponent.DeckComponent;
import java.util.List;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import model.Game;
import model.cards.Card;

/**
 *
 * @author Mitch
 */
public class FlopComponent extends HBox {
    
    private HBox board = new HBox();
    private DeckComponent deck = new DeckComponent();
    
    
    
    public FlopComponent(Game game){
        
        List <Card> flop = game.getBoard();
        System.out.println(flop.size());
        for (Card card : flop) {
            CardComponent cardC = new CardComponent(card);
            this.board.getChildren().add(cardC);
        }
        
        this.getChildren().add(deck);
        
    }
    
    
    
    
}
