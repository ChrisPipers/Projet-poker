package handPokerPlayer;

import cardComponent.CardComponent;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import model.Player;
import model.cards.Card;

/**
 *
 * @author Mitch
 */
public class handPokerPlayer extends HBox {
    
    public handPokerPlayer(List <Card> listCard ){
         
        String sCard;
        int i = 0;
        for (Card card : listCard) {
            CardComponent cardC = new CardComponent(card);
            if ( i == 0){
                cardC.setRotate(-10);
            }else{
                cardC.setRotate(10);
            }
            i++;
            
            getChildren().add(cardC);
        }
        this.setSpacing(-20);
    }
    
    
}
