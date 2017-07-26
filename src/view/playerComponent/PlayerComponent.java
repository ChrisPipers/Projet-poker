package view.playerComponent;

import view.handPokerPlayer.handPokerPlayer;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.TextAlignment;
import model.Game;
import model.Observer;
import model.Player;
import model.cards.Card;
import view.choiceBoxPlayer.ChoiceBoxPlayer;

/**
 *
 * @author Mitch
 */
public class PlayerComponent extends HBox implements PlayerComponentView {

    private ImageView picturePlayer;
    private ChoiceBoxPlayer choiceBoxPlayer;
    private Game game;
    private Player player;
    private TextField textFButton;
    private Label pot;
    private HBox hBoxCards;

    public PlayerComponent(Player player, Game game) {
        
        this.game = game;
        this.player = player;
        this.setHeight(90);
        this.setWidth(250);
        this.choiceBoxPlayer = new ChoiceBoxPlayer(game);
        this.hBoxCards = new HBox();
        borderLayout();
        this.getChildren().add(hBoxCards);
        getHBoxCards(player);
        getPicturePlayer(player);
        getVBoxPlayer(player);
      
    }
    
    public void borderLayout(){
         final String boderStyle;
        if (this.player == game.getCurrentPlayer()) {
             boderStyle = 
                "-fx-border-color: red red red red ;"
                     +"-fx-background-color: white;";
        }else{
        boderStyle = 
                "-fx-border-color: black black black black;";
        }
        this.setStyle(boderStyle);
    }

    public void getHBoxCards(Player player) {
        List<Card> cards = player.getCards();
        String sCard;
        handPokerPlayer handP = new handPokerPlayer(cards);
        this.hBoxCards.getChildren().add(handP);
    }

    public void getPicturePlayer(Player player) {
        String selectImage = ("view/Image/" + Character.toString(player.getSexe()) + ".png");
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
        pot = new Label(Integer.toString(player.getMoney()));
        pot.setTextAlignment(TextAlignment.CENTER);

//        pot.setStyle(style);
        VBox vboxPlayer = new VBox(6);
        vboxPlayer.getChildren().addAll(name, line, pot);
        vboxPlayer.setStyle(style);
        getChildren().add(vboxPlayer);
    }

    public void setHboxCards(){
        List<Card> cards = player.getCards();
        String sCard;
        handPokerPlayer handP = new handPokerPlayer(cards);
        this.hBoxCards.getChildren().add(handP);
    }
    
    public void clearHBoxCards(){
        this.hBoxCards.getChildren().clear();
    }
    
    public void setLabelPot(Player player){
        this.pot.setText(Integer.toString(player.getMoney()));
    }
    
    public void isFold(){
        this.hBoxCards.setVisible(false);
    }
    
//    public void initTextFieldButton(){
//        this.textFButton = new TextField("")
//    }

    @Override
    public void upDate() {
        
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
