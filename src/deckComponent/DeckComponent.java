package deckComponent;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 *
 * @author Mitch
 */
public class DeckComponent extends HBox {

    String stringCard = "Image/cards/" + "dos" + ".png";

    public DeckComponent() {
        Image image = new Image(stringCard, 150, 150, false, false);
        ImageView iv2 = new ImageView();
        iv2.setImage(image);
        iv2.setFitWidth(60);
        iv2.setFitHeight(70);
        iv2.preserveRatioProperty();
        this.getChildren().add(iv2);
        
        for (int i = 0; i < 5; i++) {

            Image image2 = new Image(stringCard, 150, 150, false, false);
            ImageView iv22 = new ImageView();
            iv22.setImage(image2);
            iv22.setFitWidth(60);
            iv22.setFitHeight(70);
            iv22.preserveRatioProperty();

            iv22.setTranslateX(-(58+(60*i)));

            this.getChildren().add(iv22);
        }

    }
}
