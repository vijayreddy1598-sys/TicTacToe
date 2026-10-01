package com.tictactoe;

import java.util.Scanner;

/**
 * Entry point. Run this class as a Java Application.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== TIC-TAC-TOE ===");

        boolean playAgain = true;
        while (playAgain) {
            System.out.println("\n1. Player vs Player");
            System.out.println("2. Player vs Computer");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.next();

            Player p1;
            Player p2;
            switch (choice) {
                case "1":
                    p1 = new HumanPlayer("Player 1", Symbol.X, scanner);
                    p2 = new HumanPlayer("Player 2", Symbol.O, scanner);
                    break;
                case "2":
                    p1 = new HumanPlayer("You", Symbol.X, scanner);
                    p2 = new ComputerPlayer("Computer", Symbol.O);
                    break;
                case "3":
                    playAgain = false;
                    continue;
                default:
                    System.out.println("Invalid choice.");
                    continue;
            }

            new Game(p1, p2).play();
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
