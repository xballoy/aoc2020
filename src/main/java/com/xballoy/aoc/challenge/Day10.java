package com.xballoy.aoc.challenge;

import com.xballoy.aoc.InputSupplier;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day10 {

    private final List<Integer> adapters;

    public Day10(final InputSupplier inputSupplier) {
        this.adapters = inputSupplier.get()
            .map(Integer::parseInt)
            .sorted()
            .collect(Collectors.toList());

        // Add the build-in adapter
        this.adapters.add(this.adapters.get(this.adapters.size() - 1) + 3);
    }

    public double part1() {
        final String diffs = getStringDiffs();
        System.out.println(diffs);

        final long difference1Jolt = diffs.codePoints()
            .filter(it -> it == '1')
            .count();
        final long difference3Jolts = diffs.codePoints()
            .filter(it -> it == '3')
            .count();

        return difference1Jolt * difference3Jolts;
    }

    private String getStringDiffs() {
        int currentJolt = 0;

        StringBuilder diffsBuilder = new StringBuilder();
        for (Integer adapter : adapters) {
            diffsBuilder.append(adapter - currentJolt);
            currentJolt = adapter;
        }

        return diffsBuilder.toString();
    }

    public BigInteger part2() {
        final String stringDiffs = getStringDiffs();
        final String[] split = stringDiffs.split("3");

        final long possibility2 = Arrays.stream(split).filter("11"::equals).count();
        final long possibility4 = Arrays.stream(split).filter("111"::equals).count();
        final long possibility7 = Arrays.stream(split).filter("1111"::equals).count();

        return BigInteger.valueOf(2).pow((int) possibility2)
            .multiply(BigInteger.valueOf(4).pow((int) possibility4))
            .multiply(BigInteger.valueOf(7).pow((int) possibility7));
    }
}
