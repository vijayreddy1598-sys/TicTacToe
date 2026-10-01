package com.tictactoe;

/**
 * Represents the content of a board cell.
 */
public enum Symbol {
    X('X'),
    O('O'),
    EMPTY(' ');

    private final char display;

    Symbol(char display) {
        this.display = display;
    }

    public char getDisplay() {
        return display;
    }

    public Symbol opposite() {
        if (this == X) {
            return O;
        }
        if (this == O) {
            return X;
        }
        return EMPTY;
    }
}
