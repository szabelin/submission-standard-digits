package com.standard.codingtest.digital.number.scanner;


import com.google.common.collect.ImmutableList;

public class DigitalNumbers {
    public final ImmutableList<DigitalNumber> numbers;

    public DigitalNumbers(char[] block, int numberOfDigits) {

        ImmutableList.Builder<DigitalNumber> builder = ImmutableList.builder();
        for (int i = 0; i < numberOfDigits; i++) {
            builder.add(getIndexedNumber(block, i, numberOfDigits * 3));
        }

        numbers = builder.build();

    }

    private static DigitalNumber getIndexedNumber(char[] block, int index, int offset) {

        index *= 3;

        return new DigitalNumber(new char[]{

                block[index],
                block[index + 1],
                block[index + 2],

                block[offset + index],
                block[offset + index + 1],
                block[offset +index + 2],

                block[offset + offset + index],
                block[offset + offset + index + 1],
                block[offset + offset + index + 2]});

    }

    @Override
    public String toString() {
        return "DigitalNumbers{" +
                "numbers=" + numbers +
                '}';
    }
}
