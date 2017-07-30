package view.tableComponent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import model.Game;
import observer.Observer;
import model.Player;
import model.Status;
import view.choiceBoxPlayer.ChoiceBoxPlayer;
import view.flopComponent.FlopComponent;
import view.playerComponent.PlayerComponent;

/**
 *
 * @author Mitch
 */
public final class TableComponent extends GridPane implements TableView {

    private final Game game;
    private List<Position> listPosPlayerTable;
    private List<Label> listLabel;
    private PositionMise posMise;
    private final List<Player> listPlayer;
    private VBox actionPlayer;
    private PositionPlayer posPlayer;
    private ChoiceBoxPlayer choiceB;
    private PlayerComponent playerP;
    private List<PlayerComponent> listPlayerC;
    private FlopComponent flopC;
    private Label label;
    private HBox hbtf;

    public TableComponent(Game game) throws IOException {
        this.game = game;
        this.game.addObserver(this);

        listPlayer = game.getPlayers();

        initGridPaneTable();
        initPlayerTable();
        initFlopComponent();
        addChoiceBoxPlayer(game);

        this.minHeight(400);
        this.minWidth(400);
        
        
        
        
    }

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
                + "-fx-repeat: no-repeat;"
//                + "-fx-grid-lines-visible: true"
                ;

        this.setStyle(style);

    }

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

    public void addPlayer(Player player, int k) {
        PlayerComponent playerP = new PlayerComponent(player, game);
        this.add(playerP, posPlayer.getPosPlayer(k).getJ(),
                posPlayer.getPosPlayer(k).getI());
    }

    public void initFlopComponent() {
        flopC = new FlopComponent(game);
        this.add(flopC, 6, 5);
    }

//    public void initMisePlayer() {
//        posMise = new PositionMise();
//        listLabel = new ArrayList<Label>();
//        
//        String styleMise = "-fx-background-color: white;"
//                    + "-fx-font-weight : bold;" ;
//        
//        for (int i = 0; i < listPlayer.size(); i++) {
//            for (Player player : listPlayer) {
////                label = new Label(Integer.toString(player.getSumRaise()));
//                label.setAlignment(Pos.CENTER);
//                label.setStyle(styleMise);
//                listLabel.add(label);
//                hbtf = new HBox();
//                hbtf.setMinSize(80, 60);
//                hbtf.setAlignment(Pos.CENTER);
//                hbtf.getChildren().add(label);
//
//                this.add(hbtf, posMise.getPosMise(i).getJ(),
//                        posMise.getPosMise(i).getI());
//            }
//        }
//    }


    public void addChoiceBoxPlayer(Game game) throws IOException {
        choiceB = new ChoiceBoxPlayer(game);
        this.add(choiceB, 12, 12);
    }

    public void isVissibleChoiceBox() {
        this.choiceB.setVisible(true);
    }

    public void isNotVissibleChoiceBox() {
        this.choiceB.setVisible(false);
    }

    public PlayerComponent getPlayerComponent() {
        return this.playerP;
    }

    public FlopComponent getFlopComponent() {
        return this.flopC;
    }
    
    public List<PlayerComponent> getListPlayerC() {
        return this.listPlayerC;
    }

//    public void updateMise() {
//        for (int i = 0; i < listPlayer.size(); i++) {
////            listLabel.get(i).setText(Integer.toString(listPlayer.get(i).getSumRaise()));
//        }
//    }

//    @Override
    public void updateFlop() {
        this.flopC.setBoard();

    }
//
//    @Override

    public void updatePlayers() {
        for (PlayerComponent playerP : listPlayerC) {
            playerP.update();
            playerP.setBorderLayout();
        }

//        for (int i = 0; i < listPlayerC.size(); i++) {
//            
//        
//            listPlayerC.get(i).update();
//            listPlayerC.get(i).setBorderLayout();
//        }
        
        
    }
//

    
    @Override
    public void update() {
        updatePlayers();
//        this.flopC.update();
//        if (game.getStatus()== Status.END_MATCH){
//            
//        }
//        this.updateFlop();
    }

}
