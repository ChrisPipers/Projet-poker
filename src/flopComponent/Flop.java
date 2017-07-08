package flopComponent;

import cardComponent.CardComponent;
import java.util.List;
import javafx.scene.layout.HBox;
import model.Game;
import model.cards.Card;

/**
 *
 * @author Mitch
 */
public class Flop extends HBox {
    
    public Flop(Game game){
        List <Card> flop = game.getBoard();
        
        for (Card card : flop) {
            CardComponent cardC = new CardComponent(card);
            this.getChildren().add(cardC);
        }
        
    }
    
    
}
