package bank.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class DepositTest {
    FeesCalculator calculator = new FeesCalculator();

    //Deposit section invalid inputs
    @ParameterizedTest(name = "{0}")
    @CsvSource({
        "1, true, -20, 250",
        "2, true, 0, 2000",
        "3, true, 25, -5000"
    })
    void depositTestInvalid(String id, boolean student, double amount, double balance) {
        assertThrows(Exception.class, () -> calculator.calculateDepositInterest(amount, balance, student));
    }

    //Deposit section valid inputs
    @ParameterizedTest(name = "{0}")
    @CsvSource({
        "4, true, 25, 250, 0.0",
        "5, true, 100, 2500, 0.50",
        "6, true, 25, 10000, 0.125",
        "7, false, 130, 1500, 0.13",
        "8, false, 500, 5000, 4",
        "9, false, 150, 50000, 0.0"
    })
    void depositTestValid(String id, boolean student, double amount, double balance, double expectedFee) {
        assertEquals(expectedFee, calculator.calculateDepositInterest(amount, balance, student), 0.0001);
    }
}


