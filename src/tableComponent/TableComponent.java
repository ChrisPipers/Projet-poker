package tableComponent;

import java.util.List;
import javafx.event.EventHandler;
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
import tableComponent.Position;

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

    public TableComponent(Game game) {
        this.game = game;
        listPlayer = game.getPlayers();
        initGridPaneTable();
//        initPlayerTable();
//        initActionPlayerPoker();

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
                + "-fx-background-image: url(Image/tablepoker.png);"
                + "-fx-background-size: 1200 860;"
                + "-fx-background-position: center bottom; "
                + "-fx-repeat: no-repeat;"
//                + "-fx-background-size: cover, auto;"
                + "-fx-grid-lines-visible: true"
                ;

        this.setStyle(style);

    }

//    private void initPlayerTable() {
//        for (int i = 0; i < listPlayer.size(); i++) {
//            int column = listPosPlayerTable.get(i).getY();
//            int row = listPosPlayerTable.get(i).getX();
//            PlayerPoker playerP = new PlayerPoker(listPlayer.get(i));
////            final String style = "-fx-width: 60%;"
////     +"-fx-height: 60%;";
////            playerP.setStyle(style);
//
//            playerP.setSize();
//            this.add(playerP,column, row);
//        }
//    }
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
    
    public void unshowActionPlayerPoker(){
        this.actionPlayer.setVisible(false);
    }

}
