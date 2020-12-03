package com.xballoy.aoc.challenge.day3;

public enum Slope {
    R1_D1(1, 1),
    R3_D1(3, 1),
    R5_D1(5, 1),
    R7_D1(7, 1),
    R1_D2(1, 2);

    private final int right;
    private final int down;

    Slope(final int right, final int down) {
        this.right = right;
        this.down = down;
    }

    public int getRight() {
        return this.right;
    }

    public int getDown() {
        return this.down;
    }
}
