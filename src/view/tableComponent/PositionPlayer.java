package view.tableComponent;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mitch
 */
public class PositionPlayer {

    private final List <Position>listPosPlayer ;
    
    public PositionPlayer(){
        int posX[]= {2,2,4,4,7,7,11,11,13,13};
        int posY[]=  {3,7,1,9,0,10,1,9,3,7};

        listPosPlayer = new ArrayList();
        
        for (int i = 0; i < 10; i++) {
            listPosPlayer.add(new Position(posY[i], posX[i]));
        }


        
    }
    
    public Position getPosPlayer(int j){
        return this.listPosPlayer.get(j);
    }
    
   
    
}
