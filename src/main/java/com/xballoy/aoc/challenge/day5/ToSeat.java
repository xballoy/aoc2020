package com.xballoy.aoc.challenge.day5;

import com.xballoy.aoc.AdventOfCodeException;

import java.util.Arrays;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToSeat implements Function<String, Seat> {

    private static final Pattern SEAT_PATTERN = Pattern.compile("^(?<row>[BF]{7})(?<col>[RL]{3}$)");

    private static final int MIN_ROW = 0;
    private static final int MAX_ROW = 127;
    private static final int MIN_COL = 0;
    private static final int MAX_COL = 7;

    @Override
    public Seat apply(final String code) {
        final Matcher matcher = SEAT_PATTERN.matcher(code);
        if (!matcher.matches()) {
            throw new AdventOfCodeException(String.format("Invalid format: %s", code));
        }

        final int row = findRow(matcher.group("row").toCharArray(), MIN_ROW, MAX_ROW);
        final int col = findCol(matcher.group("col").toCharArray(), MIN_COL, MAX_COL);

        return new Seat(row, col);
    }

    private int findRow(final char[] rows, final int minRow, final int maxRow) {
        char currentRow = rows[0];
        if (rows.length == 1) {
            return currentRow == 'F' ? minRow : maxRow;
        }

        if (currentRow == 'F') {
            return findRow(Arrays.copyOfRange(rows, 1, rows.length), minRow, getLowerHalf(minRow, maxRow));
        }

        return findRow(Arrays.copyOfRange(rows, 1, rows.length), getUpperHalp(minRow, maxRow), maxRow);
    }

    private int findCol(final char[] rows, final int minRow, final int maxRow) {
        char currentRow = rows[0];
        if (rows.length == 1) {
            return currentRow == 'L' ? minRow : maxRow;
        }

        if (currentRow == 'L') {
            return findCol(Arrays.copyOfRange(rows, 1, rows.length), minRow, getLowerHalf(minRow, maxRow));
        }

        return findCol(Arrays.copyOfRange(rows, 1, rows.length), getUpperHalp(minRow, maxRow), maxRow);
    }

    protected int getLowerHalf(int min, int max) {
        return max - (max - min) / 2 - 1;
    }

    protected int getUpperHalp(int min, int max) {
        return min + (max - min) / 2 + 1;
    }
}
