package playerComponent;

import handPokerPlayer.handPokerPlayer;
import java.util.List;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.TextAlignment;
import model.Player;
import model.cards.Card;

/**
 *
 * @author Mitch
 */
public class PlayerComponent extends HBox {

    private ImageView picturePlayer;
    

    public PlayerComponent(Player player) {
        this.setHeight(90);
        this.setWidth(250);
        
        borderLayout();
        getHBoxCards(player);
        getPicturePlayer(player);
        getVBoxPlayer(player);
        
    }
    
    public void borderLayout(){
        final String boderStyle = 
                "-fx-border-color: black black black black;";
        this.setStyle(boderStyle);
    }

    public void getHBoxCards(Player player) {
        List<Card> cards = player.getCards();
        String sCard;
        handPokerPlayer handP = new handPokerPlayer(cards);
        this.getChildren().add(handP);
    }

    public void getPicturePlayer(Player player) {
        String selectImage = ("Image/" + Character.toString(player.getSexe()) + ".png");
        System.out.println(selectImage);
        Image image = new Image(selectImage, 80, 80, false, false);
        picturePlayer = new ImageView();
        picturePlayer.setImage(image);
        picturePlayer.setFitWidth(80);
        
        getChildren().add(picturePlayer);
    }

    public void getVBoxPlayer(Player player) {
        final String style = "-fx-background-position: center, center;"
                + "-fx-background-color: #b22228;"
                + "-fx-background-size: cover, auto;";

        Label name = new Label(player.getName());
        name.setTextAlignment(TextAlignment.CENTER);
//        name.setStyle(style);
        Line line = new Line(0, 0, 40, 0);
        final String StyleLine = "-fx-background-position: center, center;"
                + "-fx-background-size: cover, auto;";
        line.setStyle(StyleLine);
        Label pot = new Label(Integer.toString(player.getMoney()));
        pot.setTextAlignment(TextAlignment.CENTER);

//        pot.setStyle(style);
        VBox vboxPlayer = new VBox(6);
        vboxPlayer.getChildren().addAll(name, line, pot);
        vboxPlayer.setStyle(style);
        getChildren().add(vboxPlayer);
    }

}
