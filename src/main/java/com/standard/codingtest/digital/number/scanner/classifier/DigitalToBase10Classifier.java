package com.standard.codingtest.digital.number.scanner.classifier;

import com.google.common.collect.ImmutableMap;
import com.standard.codingtest.digital.number.scanner.DigitalNumber;
import com.standard.codingtest.digital.number.scanner.DigitalNumbers;

public class DigitalToBase10Classifier {

    public static final char INVALID_DIGIT = '?';

    private static final char[] ALPHABET =
                   (" _     _  _     _  _  _  _  _ " +
                    "| |  | _| _||_||_ |_   ||_||_|" +
                    "|_|  ||_  _|  | _||_|  ||_| _|")
                           .toCharArray();

    private static final ImmutableMap<DigitalNumber, Character> DIGITAL_TO_BASE_10;

    private static final int TEN_DIGITS = 10;

    static {

        DigitalNumbers block = new DigitalNumbers(ALPHABET, TEN_DIGITS);

        ImmutableMap.Builder<DigitalNumber, Character> builder = ImmutableMap.builder();
        for (int baseTenDigit = 0; baseTenDigit <= 9; baseTenDigit++) {
            builder.put(block.numbers.get(baseTenDigit), Integer.toString(baseTenDigit).charAt(0));
        }

        DIGITAL_TO_BASE_10 = builder.build();

    }

    public char classify(DigitalNumber digitalNumber){
        return DIGITAL_TO_BASE_10.getOrDefault(digitalNumber, INVALID_DIGIT);
    }

}
