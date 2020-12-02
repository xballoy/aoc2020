package com.xballoy.aoc;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;
import java.util.function.Supplier;

public class InputFileSupplier implements Supplier<String> {

    private final String inputFile;

    public InputFileSupplier(final String inputFile) {
        this.inputFile = inputFile;
    }

    @Override
    public String get() {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        final URL resource = classloader.getResource(this.inputFile);
        if(resource == null) {
            throw new AdventOfCodeException(String.format("The file %s does not exist", this.inputFile));
        }

        File input = new File(resource.getFile());
        try (Scanner scanner = new Scanner(input)) {
            return scanner.useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            throw new AdventOfCodeException(e);
        }
    }
}
