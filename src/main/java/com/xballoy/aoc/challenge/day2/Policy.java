package com.xballoy.aoc.challenge.day2;

public class Policy {
    private final int min;
    private final int max;
    private final char letter;
    private final String password;

    public Policy(final int min,
                  final int max,
                  final char letter,
                  final String password) {
        this.min = min;
        this.max = max;
        this.letter = letter;
        this.password = password;
    }

    public int getMin() {
        return this.min;
    }

    public int getMax() {
        return this.max;
    }

    public char getLetter() {
        return this.letter;
    }

    public String getPassword() {
        return this.password;
    }
}
