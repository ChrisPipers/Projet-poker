package view.playerComponent;

import view.handPokerPlayer.handPokerPlayer;
import java.util.List;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.TextAlignment;
import model.Game;
import model.observer.Observer;
import model.Player;
import model.cards.Card;

/**
 *
 * @author Mitch
 */
public final class PlayerComponent extends HBox implements Observer {

    private ImageView picturePlayer;
    private final Game game;
    private final Player player;
    private TextField textFButton;
    private Label pot;
    private Label bounty;

    private final HBox hBoxCards;

    public PlayerComponent(Player player, Game game) {

        this.game = game;
        this.game.addObserver(this);

        this.player = player;
        this.setHeight(90);
        this.setWidth(250);
        this.hBoxCards = new HBox();
        setBorderLayout();
        this.getChildren().add(hBoxCards);
//        initHBoxCards();
        initPicturePlayer(player);
        initVBoxPlayer(player);

    }

    public void setBorderLayout() {
        final String boderStyle;
        if (this.player == game.getCurrentPlayer()) {
            boderStyle
                    = "-fx-border-color: red red red red ;"
                    + "-fx-background-color: white;";
            for (Card card : this.player.getCards()) {
                card.show();
            }
            setHboxCards();
        } else {
            for (Card card : this.player.getCards()) {
                card.hide();
            }
            setHboxCards();
            boderStyle
                    = "-fx-border-color: black black black black;";
        }
        this.setStyle(boderStyle);

    }

    public void initHBoxCards() {
        List<Card> cards = player.getCards();
        String sCard;
        handPokerPlayer handP = new handPokerPlayer(cards);
        this.hBoxCards.getChildren().add(handP);
    }

    public void initPicturePlayer(Player player) {
        String selectImage = ("view/Image/M.png");
        Image image = new Image(selectImage, 80, 80, false, false);
        picturePlayer = new ImageView();
        picturePlayer.setImage(image);
        picturePlayer.setFitWidth(80);
        getChildren().add(picturePlayer);
    }

    public void initVBoxPlayer(Player player) {
        final String style = "-fx-background-position: center, center;"
                + "-fx-background-color: #b22228;"
                + "-fx-background-size: cover, auto;";

        Label name = new Label(player.getName());
        name.setTextAlignment(TextAlignment.CENTER);
        Line line = new Line(0, 0, 40, 0);
        final String StyleLine = "-fx-background-position: center, center;"
                + "-fx-background-size: cover, auto;";
        line.setStyle(StyleLine);
        pot = new Label(Integer.toString(player.getMoney()));
        pot.setStyle("-fx-font-weight: bold;");
        pot.setTextAlignment(TextAlignment.CENTER);
        VBox vboxPlayer = new VBox(6);
        
        bounty = new Label(Double.toString(player.getBounty()));
        
        vboxPlayer.getChildren().addAll(name, line, pot, bounty);
        vboxPlayer.setStyle(style);
        getChildren().add(vboxPlayer);
    }

    public void setHboxCards() {
        this.hBoxCards.getChildren().clear();
        List<Card> cards = player.getCards();
        String sCard;
        handPokerPlayer handP = new handPokerPlayer(cards);
        this.hBoxCards.getChildren().add(handP);
    }

    public void clearHBoxCards() {
        this.player.isFold();
        this.hBoxCards.getChildren().clear();
    }

    public void setLabelPot(Player player) {
        this.pot.setText(Integer.toString(player.getMoney()));

    }

    public void isFold() {
        this.hBoxCards.setVisible(false);
    }

    public void setPot() {
        this.pot.setText(Integer.toString(player.getMoney()));
    }

    public void setBounty(){
        this.bounty.setText(Double.toString(player.getBounty()));
    }
    public Player getPlayer() {
        return this.player;
    }

    @Override
    public void update() {
        if (!this.player.isFold()) {
            setPot();
            setBorderLayout();
            if (this.game.getIsOver()) {
                for (Card card : this.player.getCards()) {
                    card.show();
                    setHboxCards();
                    setPot();
                    setBounty();
                }
            }
        } else {
            this.hBoxCards.setVisible(false);
        }
    }

}
