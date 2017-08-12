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
 * this class, allows to build a player component with a game and a player of
 * parameter
 *
 * @author g39864
 */
public final class PlayerComponent extends HBox implements Observer {

    private ImageView picturePlayer;
    private final Game game;
    private final Player player;
    private TextField textFButton;
    private Label pot;
    private Label bounty;

    private final HBox hBoxCards;

    /**
     * this is the constructor of player component
     *
     * @param player is the player used for initialized the player component
     * @param game is the game for know the state of the game
     */
    public PlayerComponent(Player player, Game game) {

        this.game = game;
        this.game.addObserver(this);

        this.player = player;
        this.setHeight(90);
        this.setWidth(250);
        this.hBoxCards = new HBox();
        setBorderLayout();
        this.getChildren().add(hBoxCards);
        initPicturePlayer();
        initVBoxPlayer();

    }

    /**
     * this methid allows to adapt the HBox who contains the cards of the player
     * if this player is the current player of the game
     */
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

    /**
     * this method allows to creat and add the picture player at the player
     * component
     */
    public void initPicturePlayer() {
        String selectImage = ("view/Image/M.png");
        Image image = new Image(selectImage, 80, 80, false, false);
        picturePlayer = new ImageView();
        picturePlayer.setImage(image);
        picturePlayer.setFitWidth(80);
        getChildren().add(picturePlayer);
    }

    /**
     * this methode allows to initilize the attributes of the player her pot,
     * bounty, and her name.
     */
    public void initVBoxPlayer() {
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

    /**
     * this method allows to change the card of the hbox HBoxCards who contains
     * the card og the hand of the player
     */
    public void setHboxCards() {
        this.hBoxCards.getChildren().clear();
        List<Card> cards = player.getCards();
        String sCard;
        handPokerPlayer handP = new handPokerPlayer(cards);
        this.hBoxCards.getChildren().add(handP);
    }

    /**
     * this method allows to clear the HBox who contains the cards of hand's
     * player
     */
    public void clearHBoxCards() {
        this.player.isFold();
        this.hBoxCards.getChildren().clear();
    }

    /**
     * thid method allows to hide the hbox who contains the cards if the player
     * is fold
     */
    public void isFold() {
        this.hBoxCards.setVisible(false);
    }

    /**
     * this method allows to update the statut of the Label who contains the sum
     * of the player
     */
    public void setPot() {
        this.pot.setText(Integer.toString(player.getMoney()));
    }

    /**
     * this method allows to update the statut of the Label who contains the
     * bounty of the player
     */
    public void setBounty() {
        this.bounty.setText(Double.toString(player.getBounty()));
    }

    /**
     * this method allows to return the playerComponent correspondent
     *
     * @return the playerComponent
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * this method allows to update the statut of the player component whe there
     * is a changement, is the methode used by the mvc
     */
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
