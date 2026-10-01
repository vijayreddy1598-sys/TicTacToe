package com.tictactoe;

import java.util.ArrayList;
import java.util.List;

/**
 * Encapsulates the 3x3 grid and all rules related to it.
 * The board knows nothing about players or input/output flow.
 */
public class Board {

    public static final int SIZE = 3;

    private final Symbol[][] cells = new Symbol[SIZE][SIZE];

    public Board() {
        reset();
    }

    public void reset() {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                cells[r][c] = Symbol.EMPTY;
            }
        }
    }

    public boolean isValidPosition(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE;
    }

    public boolean isCellEmpty(int row, int col) {
        return isValidPosition(row, col) && cells[row][col] == Symbol.EMPTY;
    }

    /**
     * Places a symbol on the board.
     *
     * @return true if placed, false if the position is invalid or occupied
     */
    public boolean placeMark(int row, int col, Symbol symbol) {
        if (symbol == Symbol.EMPTY || !isCellEmpty(row, col)) {
            return false;
        }
        cells[row][col] = symbol;
        return true;
    }

    /** Clears a cell (used by the computer player to simulate moves). */
    public void clearCell(int row, int col) {
        if (isValidPosition(row, col)) {
            cells[row][col] = Symbol.EMPTY;
        }
    }

    public Symbol getCell(int row, int col) {
        return cells[row][col];
    }

    public boolean isFull() {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (cells[r][c] == Symbol.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<int[]> getEmptyCells() {
        List<int[]> empty = new ArrayList<>();
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (cells[r][c] == Symbol.EMPTY) {
                    empty.add(new int[] { r, c });
                }
            }
        }
        return empty;
    }

    /** Checks whether the given symbol has three in a row. */
    public boolean hasWon(Symbol s) {
        for (int i = 0; i < SIZE; i++) {
            if (cells[i][0] == s && cells[i][1] == s && cells[i][2] == s) {
                return true; // row
            }
            if (cells[0][i] == s && cells[1][i] == s && cells[2][i] == s) {
                return true; // column
            }
        }
        if (cells[0][0] == s && cells[1][1] == s && cells[2][2] == s) {
            return true; // main diagonal
        }
        return cells[0][2] == s && cells[1][1] == s && cells[2][0] == s; // anti-diagonal
    }

    public void display() {
        System.out.println();
        System.out.println("     1   2   3");
        for (int r = 0; r < SIZE; r++) {
            System.out.println("   +---+---+---+");
            System.out.print(" " + (r + 1) + " |");
            for (int c = 0; c < SIZE; c++) {
                System.out.print(" " + cells[r][c].getDisplay() + " |");
            }
            System.out.println();
        }
        System.out.println("   +---+---+---+");
        System.out.println();
    }
}
