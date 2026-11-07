package bank.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Calendar;
import java.util.Locale;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

/**
 * Assignment 1, Withdrawal: Robust Worst Case Boundary Value Analysis.
 * Full Cartesian product, including simultaneous invalid inputs.
 * Domains and invalid-input assumptions: docs/assignment1.md, section 2.1.
 */
class FeesCalculatorWithdrawTest {

    private final FeesCalculator calculator = new FeesCalculator();

    // Money uses a $0.01 step. Amount > 0 has no specified upper bound.
    private final double[] amounts = {-0.01, 0, 0.01, 0.02, 500};

    // Lower boundary and both fee thresholds, each with below/at/above probes.
    // There is no specified upper balance boundary.
    private final double[] balances = {
        -0.01, 0, 0.01, 999.99, 1000, 1000.01,
        3000, 4999.99, 5000, 5000.01
    };

    private final boolean[] studentValues = {true, false};

    // Calendar domain 1..7, including min- and max+.
    private final int[] days = {0, 1, 2, 3, 4, 5, 6, 7, 8};

    private double expectedFee(double amount, double balance, boolean student, int day) {
        if (student) {
            return day == Calendar.SATURDAY || day == Calendar.SUNDAY
                    ? amount * 0.001 : 0.0;
        }
        if (balance < 1000) {
            return amount * 0.003;
        }
        return balance < 5000 ? amount * 0.001 : 0.0;
    }

    private void checkFee(String id, double amount, double balance, boolean student, int day) {
        boolean invalid = amount <= 0 || balance < 0 || day < 1 || day > 7;
        if (invalid) {
            // Explicit robustness assumption; rejection is not specified in the handout.
            // Do not misreport these as confirmed violations of a stated exception rule.
            assertThrows(IllegalArgumentException.class,
                    () -> {
                        double actual = calculator.calculateWithdrawalFee(amount, balance, student, day);
                        System.out.printf(Locale.ROOT, "%s actual=%.9f%n", id, actual);
                    }, id);
        } else {
            double expected = expectedFee(amount, balance, student, day);
            double actual = calculator.calculateWithdrawalFee(amount, balance, student, day);
            System.out.printf(Locale.ROOT, "%s actual=%.9f%n", id, actual);
            // No currency-rounding policy is specified; retain sub-cent fee precision.
            assertEquals(expected, actual, 0.000000001, id);
        }
    }

    @TestFactory
    Stream<DynamicTest> withdrawalBoundaryTests() {
        Stream.Builder<DynamicTest> tests = Stream.builder();
        int number = 0;
        for (double amount : amounts) {
            for (double balance : balances) {
                for (boolean student : studentValues) {
                    for (int day : days) {
                        String id = String.format(Locale.ROOT, "W%03d", ++number);
                        String name = String.format(Locale.ROOT,
                                "%s amount=%.2f balance=%.2f student=%b day=%d",
                                id, amount, balance, student, day);
                        tests.add(DynamicTest.dynamicTest(name,
                                () -> checkFee(id, amount, balance, student, day)));
                    }
                }
            }
        }
        return tests.build();
    }
}
