package com.tictactoe;

import java.util.Scanner;

/**
 * A player that reads moves from the console.
 */
public class HumanPlayer extends Player {

    private final Scanner scanner;

    public HumanPlayer(String name, Symbol symbol, Scanner scanner) {
        super(name, symbol);
        this.scanner = scanner;
    }

    @Override
    public int[] chooseMove(Board board) {
        while (true) {
            System.out.print(this + ", enter row and column (1-3), e.g. '2 3': ");
            try {
                int row = Integer.parseInt(scanner.next()) - 1;
                int col = Integer.parseInt(scanner.next()) - 1;

                if (!board.isValidPosition(row, col)) {
                    System.out.println("Position out of range. Use numbers 1 to 3.");
                } else if (!board.isCellEmpty(row, col)) {
                    System.out.println("That cell is already taken. Try again.");
                } else {
                    return new int[] { row, col };
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter two numbers.");
            }
        }
    }
}
