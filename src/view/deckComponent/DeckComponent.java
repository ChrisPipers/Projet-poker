package view.deckComponent;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * this class allows to make a graphical deck component
 *
 * @author g39864
 */
public final class DeckComponent extends HBox {

    private String stringCard;
    private ImageView iv2;

    /**
     * this is the constructor of this class, it s used for build a graphical
     * deck of cards
     */
    public DeckComponent() {
        this.iv2 = getCardImageView();
        this.getChildren().add(iv2);

        for (int i = 1; i < 10; i++) {
            this.iv2 = getCardImageView();
            iv2.setTranslateX(-58 * i);
            iv2.setTranslateY(-i * 2);
            this.getChildren().add(iv2);
        }
    }

    /**
     * this method allows fot initialise the card component to compose the deck
     *
     * @return a image view for add it s at the deck component
     */
    private ImageView getCardImageView() {
        stringCard = "view/Image/cards/" + "dos" + ".png";
        Image image = new Image(stringCard, 150, 150, false, false);
        iv2 = new ImageView();
        iv2.setImage(image);
        iv2.setFitWidth(60);
        iv2.setFitHeight(70);
        iv2.preserveRatioProperty();
        return iv2;
    }

}
