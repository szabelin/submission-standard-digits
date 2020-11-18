package com.standard.codingtest.digital.number;

import com.standard.codingtest.digital.number.printer.Printer;
import com.standard.codingtest.digital.number.scanner.filescanner.DigitalBlockScannerScanner;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
    These are end-to-end (acceptance) tests
 */
class DigitalApplicationTests {

    //todo: instead of reading all values from files I could instead
    //      have provided a different scanner that supplies
    //      digital blocks (from a base 10 to digital), which would be
    //      easy to add, but I wanted to stop right there.

    @Test
    void scanGoodOneNumberFile() {

        List<String> printedValues =
                scanAndCapturePrintedValues("src/main/resources/digital.number.scanner.input.1.digit");

        assertEquals(1, printedValues.size());
        assertEquals("123456789", printedValues.get(0));

    }

    @Test
    void scanGoodThreeNumbersFile() {

        List<String> printedValues =
                scanAndCapturePrintedValues("src/main/resources/digital.number.scanner.input.3.digits");

        assertEquals(3, printedValues.size());
        assertEquals("123456789", printedValues.get(0));
        assertEquals("123456789", printedValues.get(1));
        assertEquals("123456789", printedValues.get(2));

    }

    @Test
    void scanGoodOneMixedNumbersFile() {

        List<String> printedValues =
                scanAndCapturePrintedValues("src/main/resources/digital.number.scanner.input.1.mixed.digit");

        assertEquals(1, printedValues.size());
        assertEquals("678912305", printedValues.get(0));

    }

    @Test
    void handlesInvalidDigits() {

        List<String> printedValues =
                scanAndCapturePrintedValues("src/main/resources/digital.number.scanner.input.invalid.digits");

        assertEquals("123456789", printedValues.get(0));
        assertEquals("ILL", printedValues.get(1));
        assertEquals("123456789", printedValues.get(2));

    }

    private static List<String> scanAndCapturePrintedValues(String s) {
        List<String> printedValues = newArrayList();
        Printer printer = printedValues::add;

        new DigitalApplication(printer, new DigitalBlockScannerScanner(s));

        return printedValues;
    }

}