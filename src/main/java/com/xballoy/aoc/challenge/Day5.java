package com.xballoy.aoc.challenge;

import com.xballoy.aoc.AdventOfCodeException;
import com.xballoy.aoc.InputSupplier;
import com.xballoy.aoc.challenge.day5.Seat;
import com.xballoy.aoc.challenge.day5.ToSeat;

import java.util.List;
import java.util.stream.Collectors;

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
}
