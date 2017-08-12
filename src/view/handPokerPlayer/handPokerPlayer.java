package view.handPokerPlayer;

import view.cardComponent.CardComponent;
import java.util.List;
import javafx.scene.layout.HBox;
import model.cards.Card;

/**
 * this class allows to build a hand of poker , the hand is composed of two card
 * component
 *
 * @author g39864
 */
public class handPokerPlayer extends HBox {

    private String sCard;
    private CardComponent cardCL;
    private CardComponent cardCR;

    /**
     * this is the constructor of the class handpokerplayer
     *
     * @param listCard is the list of the card of a player poker this parameter
     * containt the cards for build the hand
     */
    public handPokerPlayer(List<Card> listCard) {
        if (!listCard.isEmpty()) {
            cardCL = new CardComponent(listCard.get(0));
            cardCR = new CardComponent(listCard.get(1));

            cardCL.setRotate(-10);

            cardCR.setRotate(10);

            getChildren().addAll(cardCL, cardCR);
        }
        this.setSpacing(-20);
    }

    /**
     * this method allows to modify the cards contains in the hand
     *
     * @param listCard is the new list of the cards for modify the cards of the
     * hand
     */
    public void setHandPokerPlayer(List<Card> listCard) {
        cardCL = new CardComponent(listCard.get(0));
        cardCR = new CardComponent(listCard.get(1));
    }

    /**
     * this method allows to make the cards of the hand vissible
     */
    public void SetVissibleHand() {
        this.cardCL.setVissibleHand();
        this.cardCR.setVissibleHand();

    }

}
