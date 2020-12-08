package com.xballoy.aoc.challenge;

import com.xballoy.aoc.AdventOfCodeException;
import com.xballoy.aoc.InputSupplier;
import com.xballoy.aoc.challenge.day8.Instruction;
import com.xballoy.aoc.challenge.day8.InstructionMapper;
import com.xballoy.aoc.challenge.day8.Operation;
import com.xballoy.aoc.challenge.day8.Result;
import com.xballoy.aoc.challenge.day8.Status;

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
        return run(instructions).getAccumulator();
    }

    @Override
    public int part2() {
        for (int i = 0; i < instructions.size(); i++) {
            final Instruction instruction = instructions.get(i);
            if (instruction.getOperation() == Operation.ACC) {
                continue;
            }

            List<Instruction> copy = new ArrayList<>(instructions);
            copy.set(i, instruction.flipOperation());
            final Result result = run(copy);
            if(result.getStatus() == Status.ENDED) {
                return result.getAccumulator();
            }

        }

        throw new AdventOfCodeException("Unable to find a solution");
    }

    private static Result run(final List<Instruction> instructions) {
        List<Integer> executedInstructions = new ArrayList<>();

        Result result = new Result();
        do {
            executedInstructions.add(result.getPosition());
            final Instruction instruction = instructions.get(result.getPosition());
            switch (instruction.getOperation()) {
                case ACC -> result.accumulate(instruction.getArgument());
                case JMP -> result.jump(instruction.getArgument());
                case NOP -> result.noop();
                default -> throw new IllegalStateException("Unexpected value: " + instruction.getOperation());
            }

            if (executedInstructions.contains(result.getPosition())) {
                result.setStatus(Status.LOOP);
            }

            if (result.getPosition() == instructions.size()) {
                result.setStatus(Status.ENDED);
            }

        } while (result.getStatus() == Status.RUNNING);

        return result;
    }
}
