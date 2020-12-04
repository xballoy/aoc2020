package com.xballoy.aoc.challenge;

import com.xballoy.aoc.InputToStrings;
import com.xballoy.aoc.challenge.day4.PassportAttribute;
import com.xballoy.aoc.challenge.day4.ToPassportData;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class Day4 {

    private final List<Map<PassportAttribute, String>> passportsData;

    public Day4(Supplier<String> inputSupplier) {
        final String input = inputSupplier.get();
        final ToPassportData toPassportData = new ToPassportData();

        this.passportsData = new InputToStrings()
            .andThen(toPassportData)
            .apply(input);
    }

    public int validPassport() {
        int validPassportCount = 0;

        for (Map<PassportAttribute, String> passport: passportsData) {
            final boolean containsRequiredAttributes = passport.keySet()
                .containsAll(PassportAttribute.getRequiredAttributes());

            if(containsRequiredAttributes) {
                validPassportCount += 1;
            }
        }

        return validPassportCount;
    }
}
