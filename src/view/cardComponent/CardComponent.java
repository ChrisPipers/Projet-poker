package view.cardComponent;

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
public final class CardComponent extends Parent {

    private String stringCard;
    private final Card card;

    /**
     * this is the constructor of a card component allows a card entry in
     * parameter
     *
     * @param card is the card who contain the valor and color
     */
    public CardComponent(Card card) {
        this.card = card;

        if (card.isHidden()) {
            stringCard = "view/Image/cards/" + "dos" + ".png";
        } else {
            stringCard = "view/Image/cards/" + card.toString() + ".png";
        }
        defineStyle();

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
     * this method allows to define the style of a card component
     */
    private void defineStyle() {
        final String style = "-fx-repeat: no-repeat;"
                + "-fx-image-size: cover, auto;"
                + "-fx-background-position: center, center;"
                + "-fx-background-repeat: no-repeat;"
                + "-fx-background-size: cover, auto;";
        this.setStyle(style);
    }

    /**
     * this method allows to add a event to recovery the valors of the card when
     * make a clic on it
     *
     * @return
     */
    private String eventCard() {
        this.setOnMouseClicked((MouseEvent event) -> {
            CardComponent card1 = (CardComponent) event.getSource();
        });
        return this.stringCard;
    }

    /**
     * this method change the vissibility of this component
     */
    public void setVissibleHand() {
        this.stringCard = "view/Image/cards/" + this.card.toString() + ".png";
    }

}
