package flopComponent;

import cardComponent.CardComponent;
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
    
    private HBox flopView;

    
    
    
    public FlopComponent(Game game){
        List <Card> flop = game.getBoard();
        System.out.println(flop.size());
        for (Card card : flop) {
            CardComponent cardC = new CardComponent(card);
            this.flopView.getChildren().add(cardC);
        }
        
    }
    
    public void defineDeck(){
        
        
    }
    
    
}
