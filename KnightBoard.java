/**
 * @author  Vladyslav (Vlad) Maliutin
 *          Sp25 - CS 421 - Algorithms
 * 
 * @see     KnightBoard.java 
 */

import java.util.*;

/**
 * Represents the chessboard and contains the algorithm for solving the Knight's Tour problem.
 */
public class KnightBoard {
    private int[][] board;
    private int boardSize;
    private int movesTried = 0;

    private static final int[] MOVE_X = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static final int[] MOVE_Y = {1, 2, 2, 1, -1, -2, -2, -1};

    /**
     * Initializes a new chessboard of size x size.
     *
     * @param size The size of the board.
     */
    public KnightBoard(int size) {
        boardSize = size;
        board = new int[size][size];
        for (int[] row : board) {
            Arrays.fill(row, -1);
        }
    }

    /**
     * Attempts to solve the Knight's Tour problem using the specified search strategy.
     *
     * @param startX The starting row position of the knight.
     * @param startY The starting column position of the knight.
     * @param searchType The search strategy to use (0: Basic, 1: Heuristic I, 2: Heuristic II).
     * @return True if a solution is found, false otherwise.
     */
    public boolean solve(int startX, int startY, int searchType) {
        board[startX][startY] = 1;
        boolean result = backtrack(startX, startY, 2, searchType);

        System.out.println("The total number of moves is " + (movesTried + 1));

        if (result) {
            printBoard();
        } else {
            System.out.println("No solution found!");
        }

        return result;
    }

    /**
     * Recursive backtracking function to find the Knight's Tour path.
     *
     * @param x Current row position of the knight.
     * @param y Current column position of the knight.
     * @param moveCount The current move number.
     * @param searchType The search strategy (0, 1, or 2).
     * @return True if the tour is successfully completed, false otherwise.
     */
    private boolean backtrack(int x, int y, int moveCount, int searchType) {
        if (moveCount > boardSize * boardSize) {
            return true;
        }

        List<Position> nextMoves = getNextMoves(x, y, searchType);
        for (Position move : nextMoves) {
            board[move.x][move.y] = moveCount;
            movesTried++;

            if (backtrack(move.x, move.y, moveCount + 1, searchType)) {
                return true;
            }

            board[move.x][move.y] = -1; // Backtrack step
        }

        return false;
    }

    /**
     * Determines the next possible moves based on the search strategy.
     *
     * @param x Current row position of the knight.
     * @param y Current column position of the knight.
     * @param searchType The search strategy to use.
     * @return A sorted list of possible next moves.
     */
    private List<Position> getNextMoves(int x, int y, int searchType) {
        List<Position> moves = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            int nx = x + MOVE_X[i];
            int ny = y + MOVE_Y[i];

            if (isValid(nx, ny)) {
                moves.add(new Position(nx, ny));
            }
        }

        // Sorting moves based on search type
        if (searchType == 0) {
            // Basic search - Enforce strict clockwise order
            moves.sort(Comparator.comparingInt(m -> getClockwiseIndex(x, y, m.x, m.y)));
        } else if (searchType == 1) {
            // Heuristic I - Closer to border first, then clockwise
            moves.sort(Comparator.comparingInt((Position p) -> p.borderDistance(boardSize))
                                 .thenComparingInt(p -> getClockwiseIndex(x, y, p.x, p.y)));
        } else if (searchType == 2) {
            // Heuristic II - Fewest onward moves first, then clockwise
            moves.sort(Comparator.comparingInt(this::onwardMoves)
                                 .thenComparingInt(p -> getClockwiseIndex(x, y, p.x, p.y)));
        }

        return moves;
    }

    /**
     * Counts the number of valid onward moves from a given position.
     *
     * @param p The position to evaluate.
     * @return The number of available onward moves.
     */
    private int onwardMoves(Position p) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int nx = p.x + MOVE_X[i];
            int ny = p.y + MOVE_Y[i];
            if (isValid(nx, ny)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Checks if a move is valid on the board.
     *
     * @param x The row index.
     * @param y The column index.
     * @return True if the move is valid, false otherwise.
     */
    private boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < boardSize && y < boardSize && board[x][y] == -1;
    }

    /**
     * Determines the clockwise order index of a move.
     *
     * @param x The current row.
     * @param y The current column.
     * @param nx The new row.
     * @param ny The new column.
     * @return The index representing the move's position in the clockwise order.
     */
    private int getClockwiseIndex(int x, int y, int nx, int ny) {
        for (int i = 0; i < 8; i++) {
            if (x + MOVE_X[i] == nx && y + MOVE_Y[i] == ny) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Prints the board in the format specified in the sample output.
     */
    public void printBoard() {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.printf("%2d ", cell);
            }
            System.out.println();
        }
    }
}
