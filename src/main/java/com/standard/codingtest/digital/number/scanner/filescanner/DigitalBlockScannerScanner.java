package com.standard.codingtest.digital.number.scanner.filescanner;

import com.standard.codingtest.digital.number.scanner.DigitalNumbers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class DigitalBlockScannerScanner implements Iterable<DigitalNumbers>, DigitalBlockScanner {

    public static final int NUMBER_LENGTH = 9;

    private final String file;

    public DigitalBlockScannerScanner(String file) {
        this.file = file;
    }

    @Override
    public Iterable<DigitalNumbers> scan() {
        return DigitalBlockScannerScanner.this;
    }

    @Override
    public Iterator<DigitalNumbers> iterator() {

        Scanner scanner = getScanner();

        return new Iterator<DigitalNumbers>() {
            @Override
            public boolean hasNext() {
                return scanner.hasNext();
            }

            @Override
            public DigitalNumbers next() {
                StringBuilder sb = new StringBuilder();

                String line1 = scanner.nextLine();
                sb.append(line1);
                fixMacWhitespaceIssue(sb, line1);

                String line2 = scanner.nextLine();
                sb.append(line2);
                fixMacWhitespaceIssue(sb, line2);

                String line3 = scanner.nextLine();
                sb.append(line3);
                fixMacWhitespaceIssue(sb, line3);

                if(scanner.hasNext())
                    scanner.nextLine();

                char[] chars = sb.toString().toCharArray();
                return new DigitalNumbers(chars, NUMBER_LENGTH);
            }
        };
    }

    private static void fixMacWhitespaceIssue(StringBuilder sb, String line) {
        if(line.length() == NUMBER_LENGTH * 3 - 1) sb.append(" ");
    }

    private Scanner getScanner() {
        try {
            return new Scanner(new File(file));
        } catch (FileNotFoundException e) {
            throw new ScanError("file not found", e);
        }
    }

    public static class ScanError extends RuntimeException {

        public ScanError(String cause, Throwable e) {
            super(cause, e);
        }
    }

}
