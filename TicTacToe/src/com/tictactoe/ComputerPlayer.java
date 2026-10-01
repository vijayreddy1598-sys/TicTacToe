package com.tictactoe;

import java.util.List;
import java.util.Random;

/**
 * A simple AI: win if possible, block the opponent, take the centre,
 * otherwise pick a random free cell.
 */
public class ComputerPlayer extends Player {

    private final Random random = new Random();

    public ComputerPlayer(String name, Symbol symbol) {
        super(name, symbol);
    }

    @Override
    public int[] chooseMove(Board board) {
        int[] winning = findWinningMove(board, getSymbol());
        if (winning != null) {
            return winning;
        }

        int[] blocking = findWinningMove(board, getSymbol().opposite());
        if (blocking != null) {
            return blocking;
        }

        if (board.isCellEmpty(1, 1)) {
            return new int[] { 1, 1 };
        }

        List<int[]> empty = board.getEmptyCells();
        return empty.get(random.nextInt(empty.size()));
    }

    /** Returns a cell that would make 'symbol' win immediately, or null. */
    private int[] findWinningMove(Board board, Symbol symbol) {
        for (int[] cell : board.getEmptyCells()) {
            board.placeMark(cell[0], cell[1], symbol);
            boolean wins = board.hasWon(symbol);
            board.clearCell(cell[0], cell[1]);
            if (wins) {
                return cell;
            }
        }
        return null;
    }
}
