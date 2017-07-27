package view.tableComponent;

import java.util.ArrayList;
import java.util.List;
//import static sun.audio.AudioPlayer.player;
/**
 *
 * @author Mitch
 */
public class PositionMise {
    
    private final List <Position>listMise;
//    private Player player;
    
    public PositionMise() {
        int posY[]= {8,7,3,2,1, 2, 3, 7,9, 9 };
        int posX[]= {5,4,4,5,7,11,12,12,7, 7 };
        
        listMise = new ArrayList();
        
        for (int i = 0; i < 10; i++) {
            listMise.add(new Position(posY[i], posX[i]));
        }
    }
    
    public Position getPosMise(int i){
        return this.listMise.get(i);
    }
    
    
    
    
    
    
    
    
}
