package view.tableComponent;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import model.Game;
import model.Player;
import model.Status;
import view.choiceBoxPlayer.ChoiceBoxPlayer;
import view.flopComponent.FlopComponent;
import view.playerComponent.PlayerComponent;

/**
 * this class allows to build a table component, this class build a table of
 * poker
 *
 * @author g39864
 */
public final class TableComponent extends GridPane implements TableView {

    private final Game game;
    private List<Position> listPosPlayerTable;
    private List<Label> listLabel;
    private final List<Player> listPlayer;
    private VBox actionPlayer;
    private PositionPlayer posPlayer;
    private ChoiceBoxPlayer choiceB;
    private PlayerComponent playerP;
    private List<PlayerComponent> listPlayerC;
    private FlopComponent flopC;
    private Label label;
    private HBox hbtf;

    /**
     * this is the constructor of the class TableComponent
     *
     * @param game is used for know the same state of the game
     */
    public TableComponent(Game game) {
        this.game = game;
        this.game.addObserver(this);
        listPlayer = game.getPlayers();
        initGridPaneTable();
        initPlayerTable();
        initFlopComponent();
        addChoiceBoxPlayer();
        this.minHeight(400);
        this.minWidth(400);
    }

    /**
     * this method allows to build the GridPane of the table, he add the number
     * of column and row desired and change the color of the background, add at
     * the background a image of a table , define the size of the background
     *
     */
    private void initGridPaneTable() {
        for (int i = 0; i < 16; i++) {
            this.getColumnConstraints().add(new ColumnConstraints(80));
        }
        for (int i = 0; i < 14; i++) {
            this.getRowConstraints().add(new RowConstraints(60));
        }
        final String style = "-fx-background-color: darkslategrey    ;"
                + "-fx-background-image: url(view/Image/tablepoker.png);"
                + "-fx-background-size: 1200 860;"
                + "-fx-background-position: center bottom; "
                + "-fx-repeat: no-repeat;";

        this.setStyle(style);
    }

    /**
     * this method allows to add all player of the game on the table at the
     * different positionPlayer
     */
    private void initPlayerTable() {
        listPlayerC = new ArrayList<>();
        posPlayer = new PositionPlayer();
        for (int i = 0; i < listPlayer.size(); i++) {
            playerP = new PlayerComponent(listPlayer.get(i), game);
            this.listPlayerC.add(playerP);
            this.add(playerP, posPlayer.getPosPlayer(i).getJ(),
                    posPlayer.getPosPlayer(i).getI());
        }
    }

    /**
     * this method allows to add a player at the table at the position player k
     *
     * @param player is the player to add to the table
     * @param k is the position where add this player
     */
    public void addPlayer(Player player, int k) {
        PlayerComponent playerP = new PlayerComponent(player, game);
        this.add(playerP, posPlayer.getPosPlayer(k).getJ(),
                posPlayer.getPosPlayer(k).getI());
    }

    /**
     * this method allows to creat the flop and add this one to a position of
     * the GridPane of the table
     */
    public void initFlopComponent() {
        flopC = new FlopComponent(game);
        this.add(flopC, 6, 5);
    }

    /**
     * this method allows to creat a choice box and add this one to a position
     * of the GridPane of the table
     *
     * @param game
     */
    public void addChoiceBoxPlayer() {
        choiceB = new ChoiceBoxPlayer(game);
        this.add(choiceB, 11, 12);
    }

    /**
     * this method allows to show the choicebox of the table
     */
    public void isVissibleChoiceBox() {
        this.choiceB.setVisible(true);
    }

    /**
     * this method allows to unshow the choicebox of the table
     */
    public void isNotVissibleChoiceBox() {
        this.choiceB.setVisible(false);
    }

    /**
     * this method allows to return the player component
     *
     * @return a player component
     */
    public PlayerComponent getPlayerComponent() {
        return this.playerP;
    }

    /**
     * this method allows to return the flop component
     *
     * @return
     */
    public FlopComponent getFlopComponent() {
        return this.flopC;
    }

    /**
     * this method allows to return the list of the player component of the
     * table
     *
     * @return the list of the player component of the table
     */
    public List<PlayerComponent> getListPlayerC() {
        return this.listPlayerC;
    }

    /**
     * this method allows to update the statut of all player component of the
     * table
     */
    public void updatePlayers() {
        listPlayerC.stream().map((playerC) -> {
            playerC.update();
            return playerC;
        }).forEachOrdered((playerC) -> {
            playerC.setBorderLayout();
        });
    }

    /**
     * this method allows to update the statut of the pot of each player
     * component of the table
     */
    public void updatePotPlayer() {
        listPlayerC.forEach((playerC) -> {
            playerC.setPot();
        });
    }

    /**
     * this method allows to show the and of each player component of the table
     */
    public void showAllHand() {
        listPlayerC.forEach((playerC) -> {
            Player p = playerC.getPlayer();
            if (!p.isFold()) {
                playerC.setHboxCards();
            }
        });
    }

    /**
     * this method allows to update the statut of the player component of the
     * table and if the match is end show all hand of each player compoenent
     */
    @Override
    public void update() {
        updatePlayers();
        if (game.getStatus() == Status.END_MATCH) {
            showAllHand();

        }
    }

}
