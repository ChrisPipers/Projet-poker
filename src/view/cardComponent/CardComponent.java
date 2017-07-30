package view.cardComponent;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.cards.Card;

/**
 * this class allows to build a card to select a card in a deck in parameter
 * entry
 *
 * @author Chris
 */
public class CardComponent extends Parent {

    private String stringCard;
    private Card card;
    /**
     * this is the constructor allows a deck entry in parameter
     *
     * @param card
     */
    public CardComponent(Card card) {
        this.card = card;
        
        
        
        if (card.isHidden()) {
            stringCard = "view/Image/cards/" + "dos" + ".png";
        } else {
            stringCard = "view/Image/cards/" + card.toString() + ".png";
        }
        
        final String style = "-fx-repeat: no-repeat;"
                + "-fx-image-size: cover, auto;"
                + "-fx-background-position: center, center;"
                + "-fx-background-repeat: no-repeat;"
                + "-fx-background-size: cover, auto;";
        this.setStyle(style);
        Image image = new Image(stringCard, 150, 150, false, false);
        ImageView iv2 = new ImageView();
        iv2.setImage(image);
        iv2.setFitWidth(60);
        iv2.setFitHeight(70);
        iv2.preserveRatioProperty();
        eventCard();
        getChildren().add(iv2);
    }

    /**
     * this class allows to add a event to recovery the valors of the card
     *
     */
    public String eventCard() {
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                CardComponent card = (CardComponent) event.getSource();

                System.out.println(stringCard);

            }
        });
        return this.stringCard;
    }

    public void setVissibleHand(){
        this.stringCard = "view/Image/cards/" + this.card.toString() + ".png";
    }

}
