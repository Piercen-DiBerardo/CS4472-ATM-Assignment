# CS 4472 — Assignment 1: Black-Box Testing

## 1. ATM Session

*To be completed using Robust Worst Case Boundary Value Analysis for the PIN and withdrawal amount.*

## 2. Withdrawal

*To be completed using Robust Worst Case Boundary Value Analysis By Erina Mitha.*

## 3. Deposit

### 3.1 Process and Assumptions:

**Analysis technique:** Weak Robust Equivalence Class Analysis

For my process to calculate the test cases, I split the possible valid and invalid inputs into groups, Invalid, Students, and Non-students, and then within student and non-student I split them into amount and balance groups, creating the list below. Then I created a table for the test cases with columns TestID, Groups Covered, Student?, Amount deposited, Account balance, and Expected fee. In the groups covered column I made sure each group appeared at least once to meet the weak requirements. Each invalid group was tested in its own test case with only one invalid input while the rest are valid to meet the robust requirements. And then I filled in the rest of the table based on the groups that each row covered, choosing values around the midpoint of its range. The assumptions I made were that an invalid input should throw an exception, a $0 balance is valid, and that there is no upper limit on the amount deposited and the account balance. 

#### Weak Robust Equivalence Class Analysis Groups:

1. Invalid:
   - a. negative deposit
   - b. $0 deposit
   - c. negative balance

2. For student:
   - a. Amount:
     - i. amount deposited is more than $0, up to $50
     - ii. amount deposited is more than $50
   - b. Balance:
     - i. balance is $0 to $500
     - ii. balance is more than $500, up to $5000
     - iii. balance is more than $5000

3. For non-students:
   - a. Amount:
     - i. amount deposited is more than $0, up to $250
     - ii. amount deposited is more than $250
   - b. Balance:
     - i. balance is $0 to $2500
     - ii. balance is more than $2500, up to $10,000
     - iii. balance is more than $10,000

### 3.2 Test Cases:

| Test ID | Groups Covered | Student? | Amount deposited | Account balance | Expected Fee |
|---|---|---|---|---|---|
| 1 | 1a, 2bi | yes | -$20 | $250 | Exception |
| 2 | 1b, 2bii | yes | $0 | $2000 | Exception |
| 3 | 1c, 2ai | yes| $25 | -$5000 | Exception |
| 4 | 2ai, 2bi | yes | $25 | $250 | $0.00 |
| 5 | 2aii, 2bii | yes | $100 | $2500 | $0.50 |
| 6 | 2ai, 2biii | yes | $25 | $10,000 | $0.125 |
| 7 | 3ai, 3bi | no | $130 | $1500 | $0.13 |
| 8 | 3aii, 3bii | no | $500 | $5000 | $4.00 |
| 9 | 3ai, 3biii | no | $150 | $50,000 | $0.00 | 

### 3.3 Test Results:

| Test ID | Result |
|---|---|
| 1 | Fail |
| 2 | Fail |
| 3 | Fail |
| 4 | Fail |
| 5 | Fail |
| 6 | Pass |
| 7 | Fail |
| 8 | Fail |
| 9 | Fail |

## 4. Transfer

### 4.1 Test Design and Assumptions

**Method tested:** `bank.utils.FeesCalculator.calculateTransferFee()`

**Testing technique:** Decision Table Analysis

I used Decision Table Analysis to test the transfer fee calculation. The fee depends on four inputs: the transfer amount, the source account balance, the destination account balance, and whether the client is a student.

I separated student and non-student transfers because they use different fee rules. Each group has eight possible combinations of conditions, giving 16 rules in total.

I created one test for each rule, then added 16 more tests to check the boundary values and other cases where the wrong condition might be used. This gave a total of 32 test cases.

The following assumptions were made:

- Account balances are the balances before the transfer.
- All amounts and balances used in these tests are nonnegative.
- The method returns a fee in dollars, so percentages must be converted to decimals when calculating expected results.
- No rounding was applied because the specification does not give a rounding rule. JUnit uses a tolerance of `0.0001` when comparing results.

Expected results were calculated using the assignment specification rather than the existing code.

### 4.2 Decision Tables

#### Student Transfers

For student transfers, the conditions are:

- **A:** Transfer amount is less than $200.
- **S:** Source balance is less than $2,000.
- **D:** Destination balance is less than $1,000.

Y means the condition is true, and N means it is false.

| Rule | A | S | D | Fee |
|---|:---:|:---:|:---:|---:|
| ST1 | Y | Y | Y | 0.1% |
| ST2 | Y | Y | N | 0.05% |
| ST3 | Y | N | Y | 0.05% |
| ST4 | Y | N | N | 0.025% |
| ST5 | N | Y | Y | 0.05% |
| ST6 | N | Y | N | 0.025% |
| ST7 | N | N | Y | 0.25% |
| ST8 | N | N | N | 0.125% |

#### Non-Student Transfers

For non-student transfers, the balance thresholds depend on the transfer amount.

- **B:** Transfer amount is less than $100.
- **S:** Source balance is below the applicable threshold.
- **D:** Destination balance is below the applicable threshold.

When the amount is less than $100, the source and destination thresholds are $4,000 and $2,000, respectively.

When the amount is $100 or more, the thresholds are $2,000 and $1,000.

| Rule | B | S | D | Fee |
|---|:---:|:---:|:---:|---:|
| NS1 | Y | Y | Y | 0.2% |
| NS2 | Y | Y | N | 0.1% |
| NS3 | Y | N | Y | 1% |
| NS4 | Y | N | N | 0.5% |
| NS5 | N | Y | Y | 0.2% |
| NS6 | N | Y | N | 0.1% |
| NS7 | N | N | Y | 0.5% |
| NS8 | N | N | N | 0.25% |

Every rule has at least one corresponding test case. I also tested exact threshold values, including $100 and $200 for the transfer amount and the different account balance thresholds, since these are common places for boundary errors.

### 4.3 Test Cases and Results

The expected fees were calculated from the assignment specification. The actual fees were recorded from the JUnit test results.

All amounts and fees are in dollars.

#### Student Test Cases

| Test | Amount | From | To | Expected | Actual | Result |
|---|---:|---:|---:|---:|---:|---|
| ST1 | 100 | 500 | 500 | 0.1000 | 0.5000 | FAIL |
| ST2 | 100 | 500 | 1500 | 0.0500 | 0.2500 | FAIL |
| ST3 | 100 | 2500 | 500 | 0.0500 | 2.5000 | FAIL |
| ST4 | 100 | 2500 | 2500 | 0.0250 | 1.2500 | FAIL |
| ST5 | 250 | 500 | 500 | 0.1250 | 1.2500 | FAIL |
| ST6 | 250 | 500 | 1500 | 0.0625 | 0.6250 | FAIL |
| ST7 | 250 | 2500 | 500 | 0.6250 | 6.2500 | FAIL |
| ST8 | 250 | 2500 | 2500 | 0.3125 | 3.1250 | FAIL |

#### Additional Student Test Cases

| Test | Amount | From | To | Expected | Actual | Result |
|---|---:|---:|---:|---:|---:|---|
| S9 | 200 | 500 | 500 | 0.1000 | 1.0000 | FAIL |
| S10 | 50 | 500 | 500 | 0.0500 | 0.5000 | FAIL |
| S11 | 50 | 500 | 1500 | 0.0250 | 0.2500 | FAIL |
| S12 | 50 | 2500 | 500 | 0.0250 | 2.5000 | FAIL |
| S13 | 50 | 2500 | 2500 | 0.0125 | 1.2500 | FAIL |
| S14 | 150 | 1500 | 500 | 0.1500 | 3.7500 | FAIL |
| S15 | 100 | 2000 | 500 | 0.0500 | 2.5000 | FAIL |
| S16 | 100 | 500 | 1000 | 0.0500 | 0.2500 | FAIL |
| S17 | 150 | 500 | 500 | 0.1500 | 0.7500 | FAIL |

These additional tests check the exact amount and balance thresholds, as well as amounts below $100 and between $100 and $200.

#### Non-Student Test Cases

| Test | Amount | From | To | Expected | Actual | Result |
|---|---:|---:|---:|---:|---:|---|
| NS1 | 50 | 500 | 500 | 0.1000 | 1.0000 | FAIL |
| NS2 | 50 | 500 | 2500 | 0.0500 | 0.5000 | FAIL |
| NS3 | 50 | 4500 | 500 | 0.5000 | 5.0000 | FAIL |
| NS4 | 50 | 4500 | 4500 | 0.2500 | 2.5000 | FAIL |
| NS5 | 150 | 500 | 500 | 0.3000 | 1.5000 | FAIL |
| NS6 | 150 | 500 | 1500 | 0.1500 | 0.7500 | FAIL |
| NS7 | 150 | 4500 | 500 | 0.7500 | 7.5000 | FAIL |
| NS8 | 150 | 4500 | 4500 | 0.3750 | 8.2500 | FAIL |

#### Additional Non-Student Test Cases

| Test | Amount | From | To | Expected | Actual | Result |
|---|---:|---:|---:|---:|---:|---|
| N9 | 50 | 4000 | 500 | 0.5000 | 5.0000 | FAIL |
| N10 | 50 | 2000 | 500 | 0.1000 | 5.0000 | FAIL |
| N11 | 100 | 500 | 500 | 0.2000 | 1.0000 | FAIL |
| N12 | 50 | 500 | 2000 | 0.0500 | 0.5000 | FAIL |
| N13 | 150 | 2000 | 500 | 0.7500 | 7.5000 | FAIL |
| N14 | 150 | 500 | 1000 | 0.1500 | 0.7500 | FAIL |
| N15 | 150 | 1500 | 500 | 0.3000 | 7.5000 | FAIL |

These tests check the exact $100 amount boundary and the $1,000, $2,000, and $4,000 balance thresholds. I also included values between thresholds to check that the correct branch is selected.

#### Test Results Summary

| Result | Number of Tests |
|---|---:|
| Total tests | 32 |
| Passed | 0 |
| Failed | 32 |

All 32 transfer tests failed. In every case, the method returned a higher fee than expected.

For example, ST5 should return $0.125 for a $250 transfer, but the method returned $1.25. This is ten times the expected fee.

Other tests show much larger differences. For ST3, the expected fee was $0.05, but the method returned $2.50. This suggests that the failures are not caused by one incorrect fee multiplier alone.

### 4.4 Fault Localization

I compared the failing test results with the fee rules in the assignment specification. The failures appear to come from incorrect thresholds and fee percentages in `bank.utils.FeesCalculator.calculateTransferFee()`.

Several tests may be affected by more than one error, so I grouped the suspected faults below.

| Fault | Suspected Problem | Evidence |
|---|---|---|
| TF-01 | Student amount threshold uses $100 instead of $200. | S17 uses a $150 transfer, which should follow the under-$200 rules. |
| TF-02 | Student source balance threshold uses $1,000 instead of $2,000. | S14 uses a $1,500 source balance, which should still be below the threshold. |
| TF-03 | Student fee percentages are incorrect. | S10–S13 and ST5–ST8 return fees that are too high, including cases away from the main amount and balance boundaries. |
| TF-04 | Non-student source threshold for transfers below $100 uses $1,000 instead of $4,000. | N10 uses a $2,000 source balance, which should be in the lower-balance branch. |
| TF-05 | Non-student destination threshold for transfers below $100 uses $1,000 instead of $2,000. | The specified threshold differs from the condition identified in the implementation. |
| TF-06 | Non-student source threshold for transfers of $100 or more uses $1,000 instead of $2,000. | N15 uses a $1,500 source balance, which should be below the $2,000 threshold. |
| TF-07 | Non-student fee percentages are incorrect. | NS1–NS8 all return incorrect fees, including cases without threshold ambiguity. |

**Student transfers**

The student amount condition appears to use `amount < 100.00` instead of `amount < 200.00`. This would cause transfers between $100 and $200 to follow the wrong set of rules.

The source balance condition also appears to use $1,000 instead of $2,000. Test S14 helps identify this problem because the source balance of $1,500 is below the specified $2,000 threshold but above the threshold used in the code.

The student fee multipliers are also incorrect. Even cases that clearly fall within the intended branches produce fees that are too high. For example, ST5 returns $1.25 instead of $0.125.

**Non-student transfers**

For transfers below $100, the specification uses a $4,000 source balance threshold and a $2,000 destination balance threshold. The conditions identified in the implementation use $1,000 instead.

For transfers of $100 or more, the source balance threshold should be $2,000. Test N15 demonstrates that the implementation selects an incorrect fee for a balance between $1,000 and $2,000.

The non-student fee multipliers are also incorrect. For example, NS1 returns $1.00 instead of $0.10, and NS8 returns $8.25 instead of $0.375.

**Conclusion**

The transfer tests identified incorrect fee calculations across both student and non-student transactions. The observed differences are consistent with a combination of incorrect balance or amount thresholds and incorrect fee multipliers.

The suspected faults were identified by comparing the specification with the implementation and the recorded test results. No changes were made to the source code, since the purpose of this assignment is to identify faults rather than fix them.
