package com.tictactoe;

/**
 * Controls the flow of a game between two players.
 */
public class Game {

    private final Board board;
    private final Player playerOne;
    private final Player playerTwo;
    private Player currentPlayer;
    private Player winner;
    private GameStatus status;

    public Game(Player playerOne, Player playerTwo) {
        this.board = new Board();
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.currentPlayer = playerOne;
        this.status = GameStatus.IN_PROGRESS;
    }

    /** Runs the game loop until a win or a draw. */
    public void play() {
        System.out.println("\n" + playerOne + " vs " + playerTwo);

        while (status == GameStatus.IN_PROGRESS) {
            board.display();
            int[] move = currentPlayer.chooseMove(board);
            board.placeMark(move[0], move[1], currentPlayer.getSymbol());

            if (currentPlayer instanceof ComputerPlayer) {
                System.out.println(currentPlayer + " played at " + (move[0] + 1) + " " + (move[1] + 1));
            }

            updateStatus();
            if (status == GameStatus.IN_PROGRESS) {
                switchPlayer();
            }
        }

        board.display();
        if (status == GameStatus.WIN) {
            System.out.println("*** " + winner + " wins! ***");
        } else {
            System.out.println("*** It's a draw! ***");
        }
    }

    private void updateStatus() {
        if (board.hasWon(currentPlayer.getSymbol())) {
            status = GameStatus.WIN;
            winner = currentPlayer;
        } else if (board.isFull()) {
            status = GameStatus.DRAW;
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == playerOne) ? playerTwo : playerOne;
    }

    public GameStatus getStatus() {
        return status;
    }

    public Player getWinner() {
        return winner;
    }
}
