package view.handPokerPlayer;

import view.cardComponent.CardComponent;
import java.util.List;
import javafx.scene.layout.HBox;
import model.cards.Card;

/**
 *
 * @author Mitch
 */
public class handPokerPlayer extends HBox {

    private String sCard;
    private CardComponent cardCL;
    private CardComponent cardCR;

    public handPokerPlayer(List<Card> listCard) {
//        System.out.println(listCard.size());
        if (!listCard.isEmpty()) {
            cardCL = new CardComponent(listCard.get(0));
            cardCR = new CardComponent(listCard.get(1));

            cardCL.setRotate(-10);

            cardCR.setRotate(10);

            getChildren().addAll(cardCL, cardCR);
        }
        this.setSpacing(-20);
    }

    public void setHandPokerPlayer(List<Card> listCard) {
        cardCL = new CardComponent(listCard.get(0));
        cardCR = new CardComponent(listCard.get(1));
    }
    
    
    public void SetVissibleHand(){
        this.cardCL.setVissibleHand();
        this.cardCR.setVissibleHand();
        
    }

}
