package com.xballoy.aoc;

public class AdventOfCodeException extends RuntimeException {

    public AdventOfCodeException() {
    }

    public AdventOfCodeException(final String message) {
        super(message);
    }

    public AdventOfCodeException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public AdventOfCodeException(final Throwable cause) {
        super(cause);
    }

    public AdventOfCodeException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
