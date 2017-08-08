package view.tableComponent;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mitch
 */
public class PositionPlayer {

    private final List<Position> listPosPlayer;

    public PositionPlayer() {
        int posX[] = {3, 1, 1, 3, 7, 11, 13, 13, 11, 7};
        int posY[] = {9, 7, 3, 1, 0, 1, 3, 7, 9, 10};

        listPosPlayer = new ArrayList();

        for (int i = 0; i < 10; i++) {
            listPosPlayer.add(new Position(posY[i], posX[i]));
        }
    }

    public Position getPosPlayer(int j) {
        return this.listPosPlayer.get(j);
    }

}
