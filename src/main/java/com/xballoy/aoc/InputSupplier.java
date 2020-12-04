package com.xballoy.aoc;

import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class InputSupplier implements Supplier<Stream<String>> {

    private static final Pattern INPUT_EOL_PATTERN = Pattern.compile("\n");

    private final Supplier<String> stringSupplier;

    public InputSupplier(Supplier<String> stringSupplier) {
        this.stringSupplier = stringSupplier;
    }

    @Override
    public Stream<String> get() {
        final String input = stringSupplier.get();

        if(input == null) {
            return Stream.empty();
        }

        return INPUT_EOL_PATTERN.splitAsStream(input);
    }
}
