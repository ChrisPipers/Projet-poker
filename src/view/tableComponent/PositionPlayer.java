package view.tableComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * this class allows make the position for each player at the table
 *
 * @author g39864
 */
public class PositionPlayer {

    private final List<Position> listPosPlayer;

    /**
     * this is the constructeur of the PositionPlayer
     */
    public PositionPlayer() {
        int posX[] = {3, 1, 1, 3, 7, 11, 13, 13, 11, 7};
        int posY[] = {9, 7, 3, 1, 0, 1, 3, 7, 9, 10};

        listPosPlayer = new ArrayList();

        for (int i = 0; i < 10; i++) {
            listPosPlayer.add(new Position(posY[i], posX[i]));
        }
    }

    /**
     * this getter allows to take the number j element of the list of the
     * position of this class
     *
     * @param j is the place in the list which take
     * @return the position j at the list of the class
     */
    public Position getPosPlayer(int j) {
        return this.listPosPlayer.get(j);
    }

}
