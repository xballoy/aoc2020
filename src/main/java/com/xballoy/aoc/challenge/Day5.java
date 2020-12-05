package com.xballoy.aoc.challenge;

import com.xballoy.aoc.AdventOfCodeException;
import com.xballoy.aoc.InputSupplier;
import com.xballoy.aoc.challenge.day5.Seat;
import com.xballoy.aoc.challenge.day5.ToSeat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day5 {

    private final List<Seat> seats;

    public Day5(final InputSupplier inputSupplier) {
        final ToSeat toSeat = new ToSeat();
        this.seats = inputSupplier.get()
            .map(toSeat)
            .collect(Collectors.toList());
    }

    public int part1() {
        return seats.stream()
            .map(Seat::getId)
            .max(Integer::compareTo)
            .orElseThrow(() -> new AdventOfCodeException("Unable to find a max"));
    }

    public int part2() {
        int minSeatId = seats.stream()
            .map(Seat::getId)
            .min(Integer::compareTo)
            .orElseThrow(() -> new AdventOfCodeException("Unable to find a min"));

        int maxSeatId = seats.stream()
            .map(Seat::getId)
            .max(Integer::compareTo)
            .orElseThrow(() -> new AdventOfCodeException("Unable to find a max"));

        final int expectedTotal = IntStream.rangeClosed(minSeatId, maxSeatId)
            .reduce(0, Integer::sum);

        final Integer currentTotal = seats.stream()
            .map(Seat::getId)
            .reduce(0, Integer::sum);

        return expectedTotal - currentTotal;
    }
}
