package com.xballoy.aoc.challenge.day8;

public class Instruction {

    private final Operation operation;
    private final int argument;

    public Instruction(final Operation operation, final int argument) {
        this.operation = operation;
        this.argument = argument;
    }

    public Operation getOperation() {
        return this.operation;
    }

    public int getArgument() {
        return this.argument;
    }
}
