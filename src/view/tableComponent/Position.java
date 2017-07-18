package view.tableComponent;

/**
 * this class allows to build a position and use it
 *
 * @author g39864
 */
public class Position {

    private final int i; // utiliser des minuscules.
    private final int j;

    /**
     * this is the constructor of an position
     *
     * @param i is the line of a position
     * @param j is the column of a position
     */
    public Position(int i, int j) {
        this.i = i;
        this.j = j;
    }

    /**
     * this method return the parameter i, line, of a Piece
     *
     * @return the parameter i of a Position
     */
    public int getI() {
        return this.i;
    }

    /**
     * this method return the parameter j, column, of a Piece
     *
     * @return the parameter j of a Position
     */
    public int getJ() {
        return this.j;
    }

    /**
     * this method allows to return a string of a position return (i, j)
     *
     * @return a string of the position
     */
    @Override
    public String toString() {
        return "(" + this.i + ", " + j + ")"; //To change body of generated methods, choose Tools | Templates.
    }

}
