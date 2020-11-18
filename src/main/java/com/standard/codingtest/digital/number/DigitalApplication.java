package com.standard.codingtest.digital.number;

import com.standard.codingtest.digital.number.printer.Printer;
import com.standard.codingtest.digital.number.scanner.DigitalNumbers;
import com.standard.codingtest.digital.number.scanner.classifier.DigitalToBase10Classifier;
import com.standard.codingtest.digital.number.scanner.filescanner.DigitalBlockScanner;

import static com.standard.codingtest.digital.number.scanner.classifier.DigitalToBase10Classifier.INVALID_DIGIT;
import static com.standard.codingtest.digital.number.scanner.filescanner.DigitalBlockFileScanner.NUMBER_LENGTH;

public class DigitalApplication {

    private static final String ILL = "ILL";

    public DigitalApplication(Printer printer, DigitalBlockScanner scanner) {

        DigitalToBase10Classifier classifier = new DigitalToBase10Classifier();

        for (DigitalNumbers digitalBlock : scanner.scan()) {

            boolean invalid = false;

            char[] digits = new char[NUMBER_LENGTH];
            for (int i = 0; i < NUMBER_LENGTH; i++) {
                char digit = classifier.classify(digitalBlock.numbers.get(i));
                if (digit == INVALID_DIGIT) {
                    invalid = true;
                    break;
                }
                digits[i] = digit;

            }

            printer.print(invalid ? ILL : new String(digits));

        }
    }

}
