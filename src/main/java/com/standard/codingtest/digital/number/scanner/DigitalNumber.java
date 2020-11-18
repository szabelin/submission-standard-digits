package com.standard.codingtest.digital.number.scanner;


import java.util.Arrays;

public class DigitalNumber {
    public final char[] number;

    public DigitalNumber(char[] number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return new String(Arrays.copyOfRange(number, 0,3)) + System.lineSeparator()
                + new String(Arrays.copyOfRange(number, 3, 6)) + System.lineSeparator()
                + new String(Arrays.copyOfRange(number, 6, 9));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DigitalNumber that = (DigitalNumber) o;

        return Arrays.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(number);
    }
}
