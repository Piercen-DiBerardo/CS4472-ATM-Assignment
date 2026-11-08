
package bank.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class FeesCalculatorTransferTest {

    FeesCalculator calculator = new FeesCalculator();

    private void checkFee(double amount, double fromBalance, double toBalance, boolean student, double expectedFee) {
        double actualFee = calculator.calculateTransferFee(
            amount, fromBalance, toBalance, student
        );

        String result = Math.abs(expectedFee - actualFee) <= 0.0001
        ? "PASS" : "FAIL";

        System.out.printf(
            "Amount: %.2f | From: %.2f | To: %.2f | Student: %b"
            + " | Expected: %.4f | Actual: %.4f | %s%n",
            amount, fromBalance, toBalance, student,
            expectedFee, actualFee, result
        );

        assertEquals(expectedFee, actualFee, 0.0001);
    }

    // === STUDENT: TRANSFER < $200 ===

    @Test
    void studentTest1() {
        checkFee(100, 500, 500, true, 0.10);
    }

    @Test
    void studentTest2() {
        checkFee(100, 500, 1500, true, 0.05);
    }

    @Test
    void studentTest3() {
        checkFee(100, 2500, 500, true, 0.05);
    }

    @Test
    void studentTest4() {
        checkFee(100, 2500, 2500, true, 0.025);
    }

    // === STUDENT: TRANSFER >= $200 ===

    @Test
    void studentTest5() {
        checkFee(250, 500, 500, true, 0.125);
    }

    @Test
    void studentTest6() {
        checkFee(250, 500, 1500, true, 0.0625);
    }

    @Test
    void studentTest7() {
        checkFee(250, 2500, 500, true, 0.625);
    }

    @Test
    void studentTest8() {
        checkFee(250, 2500, 2500, true, 0.3125);
    }

    // === NON-STUDENT: TRANSFER < $100 ===

    @Test
    void nonStudentTest1() {
        checkFee(50, 500, 500, false, 0.10);
    }

    @Test
    void nonStudentTest2() {
        checkFee(50, 500, 2500, false, 0.05);
    }

    @Test
    void nonStudentTest3() {
        checkFee(50, 4500, 500, false, 0.50);
    }

    @Test
    void nonStudentTest4() {
        checkFee(50, 4500, 4500, false, 0.25);
    }

    // === NON-STUDENT: TRANSFER >= $100 ===

    @Test
    void nonStudentTest5() {
        checkFee(150, 500, 500, false, 0.30);
    }

    @Test
    void nonStudentTest6() {
        checkFee(150, 500, 1500, false, 0.15);
    }

    @Test
    void nonStudentTest7() {
        checkFee(150, 4500, 500, false, 0.75);
    }

    @Test
    void nonStudentTest8() {
        checkFee(150, 4500, 4500, false, 0.375);
    }

    // === ADDITIONAL BOUNDARY TESTS ===

    @Test
    void studentExactly200() {
        checkFee(200, 500, 500, true, 0.10);
    }

    @Test
    void studentExactly2000FromBalance() {
        checkFee(100, 2000, 500, true, 0.05);
    }

    @Test
    void studentExactly1000ToBalance() {
        checkFee(100, 500, 1000, true, 0.05);
    }

    @Test
    void nonStudentExactly100() {
        checkFee(100, 500, 500, false, 0.20);
    }

    @Test
    void nonStudentExactly4000FromBalance() {
        checkFee(50, 4000, 500, false, 0.50);
    }

    @Test
    void nonStudentExactly2000ToBalance() {
        checkFee(50, 500, 2000, false, 0.05);
    }


    // === ADDITIONAL STUDENT TESTS ===

    // Transfer below $100
    @Test
    void studentBelow100Test1() {
        checkFee(50, 500, 500, true, 0.05);
    }

    @Test
    void studentBelow100Test2() {
        checkFee(50, 500, 1500, true, 0.025);
    }

    @Test
    void studentBelow100Test3() {
        checkFee(50, 2500, 500, true, 0.025);
    }

    @Test
    void studentBelow100Test4() {
        checkFee(50, 2500, 2500, true, 0.0125);
    }

    // Between $100 and $200
    @Test
    void studentBetween100And200() {
        checkFee(150, 500, 500, true, 0.15);
    }

    // Source balance between $1,000 and $2,000
    @Test
    void studentBetween1000And2000FromBalance() {
        checkFee(150, 1500, 500, true, 0.15);
    }

    // === ADDITIONAL NON-STUDENT TESTS ===

    // Source balance between $1,000 and $4,000
    @Test
    void nonStudentBelow100MiddleBalance() {
        checkFee(50, 2000, 500, false, 0.10);
    }

    // Source balance between $1,000 and $2,000
    @Test
    void nonStudentAbove100MiddleBalance() {
        checkFee(150, 1500, 500, false, 0.30);
    }

    // Source balance exactly $2,000
    @Test
    void nonStudentExactly2000FromBalance() {
        checkFee(150, 2000, 500, false, 0.75);
    }

    // Destination balance exactly $1,000
    @Test
    void nonStudentExactly1000ToBalance() {
        checkFee(150, 500, 1000, false, 0.15);
    }
}
