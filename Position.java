/**
 * @author  Vladyslav (Vlad) Maliutin
 *          Sp25 - CS 421 - Algorithms
 * 
 * @see     Position.java 
 */

/**
 * Represents a position on the chessboard.
 */
public class Position {
    int x, y;

    /**
     * Constructs a Position object.
     *
     * @param x The row index.
     * @param y The column index.
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Computes the distance of this position to the nearest board edge.
     *
     * @param boardSize The size of the board.
     * @return The distance from the position to the closest border.
     */
    public int borderDistance(int boardSize) {
        return Math.min(x, boardSize - 1 - x) + Math.min(y, boardSize - 1 - y);
    }
}
