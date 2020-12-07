package com.xballoy.aoc.challenge.day5;

public class Seat {

    private final int row;
    private final int column;

    public Seat(final int row, final int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public int getId() {
        return this.row * 8 + this.column;
    }
}
