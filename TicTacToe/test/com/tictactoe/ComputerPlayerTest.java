package com.tictactoe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ComputerPlayerTest {

    @Test
    void takesWinningMove() {
        Board board = new Board();
        board.placeMark(0, 0, Symbol.O);
        board.placeMark(0, 1, Symbol.O);
        ComputerPlayer cpu = new ComputerPlayer("CPU", Symbol.O);
        assertArrayEquals(new int[] { 0, 2 }, cpu.chooseMove(board));
    }

    @Test
    void blocksOpponentWin() {
        Board board = new Board();
        board.placeMark(2, 0, Symbol.X);
        board.placeMark(2, 1, Symbol.X);
        ComputerPlayer cpu = new ComputerPlayer("CPU", Symbol.O);
        assertArrayEquals(new int[] { 2, 2 }, cpu.chooseMove(board));
    }

    @Test
    void takesCentreWhenFree() {
        Board board = new Board();
        ComputerPlayer cpu = new ComputerPlayer("CPU", Symbol.O);
        assertArrayEquals(new int[] { 1, 1 }, cpu.chooseMove(board));
    }
}
