package com.tictactoe;

/**
 * Abstract base class for all players (abstraction + polymorphism).
 * Subclasses decide HOW a move is chosen.
 */
public abstract class Player {

    private final String name;
    private final Symbol symbol;

    protected Player(String name, Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    /**
     * Chooses a move for the given board.
     *
     * @return int[] {row, col}, zero-based
     */
    public abstract int[] chooseMove(Board board);

    @Override
    public String toString() {
        return name + " (" + symbol.getDisplay() + ")";
    }
}
