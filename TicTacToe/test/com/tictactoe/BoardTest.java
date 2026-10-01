package com.tictactoe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void placeMarkOnEmptyCellSucceeds() {
        assertTrue(board.placeMark(0, 0, Symbol.X));
        assertEquals(Symbol.X, board.getCell(0, 0));
    }

    @Test
    void placeMarkOnOccupiedCellFails() {
        board.placeMark(1, 1, Symbol.X);
        assertFalse(board.placeMark(1, 1, Symbol.O));
    }

    @Test
    void placeMarkOutOfRangeFails() {
        assertFalse(board.placeMark(3, 0, Symbol.X));
        assertFalse(board.placeMark(-1, 0, Symbol.X));
    }

    @Test
    void detectsRowWin() {
        board.placeMark(0, 0, Symbol.X);
        board.placeMark(0, 1, Symbol.X);
        board.placeMark(0, 2, Symbol.X);
        assertTrue(board.hasWon(Symbol.X));
        assertFalse(board.hasWon(Symbol.O));
    }

    @Test
    void detectsColumnWin() {
        board.placeMark(0, 2, Symbol.O);
        board.placeMark(1, 2, Symbol.O);
        board.placeMark(2, 2, Symbol.O);
        assertTrue(board.hasWon(Symbol.O));
    }

    @Test
    void detectsDiagonalWin() {
        board.placeMark(0, 2, Symbol.X);
        board.placeMark(1, 1, Symbol.X);
        board.placeMark(2, 0, Symbol.X);
        assertTrue(board.hasWon(Symbol.X));
    }

    @Test
    void fullBoardDetected() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board.placeMark(r, c, (r + c) % 2 == 0 ? Symbol.X : Symbol.O);
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    void resetClearsBoard() {
        board.placeMark(0, 0, Symbol.X);
        board.reset();
        assertTrue(board.isCellEmpty(0, 0));
        assertEquals(9, board.getEmptyCells().size());
    }
}
