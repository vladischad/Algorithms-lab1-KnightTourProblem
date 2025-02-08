/**
 * @author  Vladyslav (Vlad) Maliutin
 *          Sp25 - CS 421 - Algorithms
 * 
 * @see     KnightTour.java (driver program) implements three options to search the chess board as below:
            java KnightTour <0/1/2 (no/heuristicI/heuristicII search)> <n> <x> <y>
            where n is the size of the chess board, (x, y) is the starting position at x row and y column.
 */

public class KnightTour {
    /**
     * The main method to run the Knight's Tour program.
     *
     * @param args Command-line arguments:
     *            <ul>
     *              <li>0 - Basic Search</li>
     *              <li>1 - Heuristic I (border distance)</li>
     *              <li>2 - Heuristic II (Warnsdorff’s heuristic)</li>
     *              <li>n - Board size</li>
     *              <li>x - Starting row</li>
     *              <li>y - Starting column</li>
     *            </ul>
     */
    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Usage: java KnightTour <0/1/2 (no/heuristicI/heuristicII search)> <n> <x> <y>");
            return;
        }

        int searchType = Integer.parseInt(args[0]);
        int boardSize = Integer.parseInt(args[1]);
        int startX = Integer.parseInt(args[2]);
        int startY = Integer.parseInt(args[3]);

        KnightBoard board = new KnightBoard(boardSize);
        board.solve(startX, startY, searchType);
    }
}
