package view.tableComponent;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import java.io.IOException;
import java.util.List;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import model.Game;
import model.Player;
import view.FXMLViewController;
import view.choiceBoxPlayer.ChoiceBoxPlayer;
import view.choiceBoxPlayer.ChoiceBoxPlayerController;
import view.flopComponent.FlopComponent;
import view.playerComponent.PlayerComponent;
import view.tableComponent.Position;

/**
 *
 * @author Mitch
 */
public class TableComponent extends GridPane {

//    GridPane gridPaneTable;
    private Game game;
    private List<Position> listPosPlayerTable;
    private List<Player> listPlayer;
    private VBox actionPlayer;
    private PositionPlayer posPlayer;
    private ChoiceBoxPlayer choiceB;
    public TableComponent(){
        initGridPaneTable();
    }
    
    public TableComponent(Game game) throws IOException {
        this.game = game;
        
       
        listPlayer = game.getPlayers();
        initGridPaneTable();
        initPlayerTable();
//        initActionPlayerPoker();
        initFlopComponent();
        addChoiceBoxPlayer(game);
this.minHeight(400);
this.minWidth(400);
        System.out.println("table init finish");
    }

    private void initGridPaneTable() {
        for (int i = 0; i < 16; i++) {
            this.getColumnConstraints().add(new ColumnConstraints(80));
        }
        for (int i = 0; i < 14; i++) {
            this.getRowConstraints().add(new RowConstraints(60));
        }
        final String style = "-fx-background-color: dimgray;"
                //                + "-fx-background-image: url(Image/texture-background.png);"
                + "-fx-background-image: url(view/Image/tablepoker.png);"
                + "-fx-background-size: 1200 860;"
                + "-fx-background-position: center bottom; "
                + "-fx-repeat: no-repeat;"
//                + "-fx-background-size: cover, auto;"
                + "-fx-grid-lines-visible: true"
                ;

        this.setStyle(style);
        

    }

    private void initPlayerTable() {
        posPlayer = new PositionPlayer();
        for (int i = 0; i < listPlayer.size(); i++) {
            PlayerComponent playerP = new PlayerComponent(listPlayer.get(i));
//            final String style = "-fx-width: 60%;"
//     +"-fx-height: 60%;";
//            playerP.setStyle(style);

//            playerP.setSize();
            this.add(playerP,posPlayer.getPosPlayer(i).getJ(),
                    posPlayer.getPosPlayer(i).getI());
        }
    }
    
    
    public void addPlayer(Player player, int k){
        PlayerComponent playerP = new PlayerComponent(player);
        this.add(playerP,posPlayer.getPosPlayer(k).getJ(),
                    posPlayer.getPosPlayer(k).getI());
    }
    
    public void initFlopComponent(){
        FlopComponent flopC = new FlopComponent();
        this.add(flopC,6,5);
    }
    
    public void addChoiceBoxPlayer(Game game) throws IOException{
        choiceB = new ChoiceBoxPlayer();
        this.add(choiceB, 12, 12);
    }
    
    
//    
//    public void initActionPlayerPoker(){
//        Position posAction = posTable.getPositionButtonActionBox();
//        int column = posAction.getY();
//        int row = posAction.getX();
//        actionPlayer = new ActionPlayerPoker ();
//        actionPlayer.setVisible(true);
//        this.add(actionPlayer, column, row);
//        
//    }
    
//    public void initBoardPoker(){
//        BoardPoker boardPoker = new BoardPoker(this.game);
//    }
//    
    
//    public void unshowActionPlayerPoker(){
//        this.actionPlayer.setVisible(false);
//    }

}
