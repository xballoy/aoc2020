package com.xballoy.aoc.challenge.day8;

import com.xballoy.aoc.AdventOfCodeException;

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

    public Instruction flipOperation() {
        return switch (operation) {
            case JMP -> new Instruction(Operation.NOP, this.getArgument());
            case NOP -> new Instruction(Operation.JMP, this.getArgument());
            default -> throw new AdventOfCodeException(String.format("Flip is not supported on %s", operation));
        };
    }
}
