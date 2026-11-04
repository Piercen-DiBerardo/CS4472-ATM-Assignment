
package bank.utils;

import java.util.Calendar;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class FeesCalculatorWithdrawTest {

    FeesCalculator calculator = new FeesCalculator();

    private void checkFee(double amount, double bal,
            boolean student, int dayOfWeek, double expectedFee) {

        double actualFee = calculator.calculateWithdrawalFee(
                amount, bal, student, dayOfWeek);

        String result = Math.abs(expectedFee - actualFee) <= 0.0001
                ? "PASS" : "FAIL";

        System.out.printf(
                "Amount: %.2f | Balance: %.2f | Student: %b"
                + " | Day: %d | Expected: %.4f"
                + " | Actual: %.4f | %s%n",
                amount, bal, student, dayOfWeek,
                expectedFee, actualFee, result
        );

        assertEquals(expectedFee, actualFee, 0.0001);
    }

    // Calculate the expected fee
    private double expectedFee(double amount, double balance,
            boolean student, int dayOfWeek) {

        if (student) {
            if (dayOfWeek != Calendar.SATURDAY
                    && dayOfWeek != Calendar.SUNDAY) {
                return 0.0;
            }

            return amount * 0.001;
        }

        if (balance < 1000) {
            return amount * 0.003;
        }

        if (balance < 5000) {
            return amount * 0.001;
        }

        return 0.0;
    }

    // Boundary values around $1,000 and $5,000.
    // Negative and zero balances are included as explicit
    // assumptions for testing unusual input conditions.
    private final double[] balances = {
        -1, 0, 500, 999, 1000,
        1001, 3000, 4999, 5000, 5001
    };

    // Representative withdrawal amounts.
    // The fee specification does not define an amount threshold.
    private final double[] amounts = {
        20, 50, 100, 200, 500, 999, 1000
    };

    private final boolean[] studentValues = {
        true, false
    };

    private final int[] days = {
        Calendar.MONDAY,
        Calendar.SATURDAY
    };

    @TestFactory
    Stream<DynamicTest> withdrawalBoundaryTests() {

        Stream.Builder<DynamicTest> tests = Stream.builder();

        for (double amount : amounts) {
            for (double balance : balances) {
                for (boolean student : studentValues) {
                    for (int day : days) {

                        double expected = expectedFee(
                                amount, balance, student, day);

                        String name = String.format(
                                "Amount=%.2f Balance=%.2f Student=%b Day=%d",
                                amount, balance, student, day);

                        tests.add(DynamicTest.dynamicTest(
                                name,
                                () -> checkFee(
                                        amount, balance,
                                        student, day, expected)
                        ));
                    }
                }
            }
        }

        return tests.build();
    }
}
