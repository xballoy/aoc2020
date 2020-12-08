package com.xballoy.aoc.challenge;

import com.xballoy.aoc.InputSupplier;
import com.xballoy.aoc.challenge.day8.Instruction;
import com.xballoy.aoc.challenge.day8.InstructionMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day8 implements Day {

    private final List<Instruction> instructions;

    public Day8(final InputSupplier inputSupplier) {
        final InstructionMapper instructionMapper = new InstructionMapper();
        this.instructions = inputSupplier.get()
            .map(instructionMapper)
            .collect(Collectors.toList());
    }

    @Override
    public int part1() {
        List<Integer> executedInstructions = new ArrayList<>();
        boolean loop = false;
        int position = 0;
        int accumulator = 0;

        do {
            executedInstructions.add(position);
            final Instruction instruction = instructions.get(position);
            switch (instruction.getOperation()) {
                case ACC -> {
                    accumulator += instruction.getArgument();
                    position++;
                }
                case JMP -> {
                    position += instruction.getArgument();
                }
                case NOP -> {
                    position++;
                }
                default -> throw new IllegalStateException("Unexpected value: " + instruction.getOperation());
            }

            if (executedInstructions.contains(position)) {
                loop = true;
            }

        } while (!loop);

        return accumulator;
    }

    @Override
    public int part2() {
        return 0;
    }
}
