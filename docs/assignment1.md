# CS 4472 — Assignment 1: Black-Box Testing

## 1. ATM Session

### 1.1 Test Design and Assumptions

**Class tested:** `atm.session.Session` (withdrawal, transaction choice 1). Test class: `src/test/java/atm/session/SessionTest.java`.

**Testing technique:** Robust Boundary Value Analysis under the single fault assumption. Each test case changes one input away from its nominal value and keeps the other input valid. This is why the full Cartesian product of "worst case" BVA is not used. The two techniques conflict, and the single fault assumption was applied, as the assignment requires.

**Specification rules under test:**

| Input | Valid | Failure outcome |
|---|---|---|
| PIN | Exactly 5 digits (`'0'`–`'9'`) | `InvalidPinFormatException` |
| Withdrawal amount | Can be dispensed in $20 and $50 bills, and does not exceed the $1,000 daily limit | `InvalidAmountException` |

**Account setup:** each test creates a fresh test-bank `WithdrawalAccount` with a $5,000 opening balance, a $1,000 daily limit, and $0 withdrawn today. The mocked `MessageDispatcher` delegates withdrawals to that account. Successful withdrawals reduce its balance and daily allowance; over-limit requests return an unsuccessful result without changing either. This is an in-memory test fixture, not a new production-bank feature: the starter has no daily-limit configuration API. The $1,000 daily limit is the upper boundary for the amount. The tests still exercise the real `Session.setAmount` and require `InvalidAmountException` for invalid amounts; a declined bank result alone does not satisfy that exception expectation.

**PIN input.** The PIN has two dimensions.
- *Length:* the valid length is exactly 5, so min = max = 5. The robust values are 4 (min−), 5 (min, nominal, max) and 6 (max+). I also added the extremes 0 (empty) and 1.
- *Digit value:* each character is valid from `'0'` (min) to `'9'` (max). The boundary characters are `'/'` (min−, one below `'0'`), `'0'`, `'1'`, `'8'`, `'9'` and `':'` (max+, one above `'9'`). Under the single fault assumption the invalid character is placed in one position at a time (all 5 positions) and the other four digits stay at the nominal `'5'`. I added one non-digit letter.
- Valid cases: `55555` (nominal), `00000`, `11111`, `88888`, `99999`.

**Withdrawal amount input.** The valid amounts are the sums of $20 and $50 bills: every multiple of $10 from $20 up to $1,000, except $30.
- *Min = $20* (the smallest dispensable amount). Min− values are $19, $0, −$1 and −$50. Min+ is $21 (not dispensable, so invalid). I also tested $40 and $60, the next dispensable amounts, because the denomination rule is not monotonic.
- *Nominal = $500.*
- *Max = $1,000* (the daily limit). Max− is $990 (the next dispensable amount below the limit) and $999. Max+ is $1,001, and I also tried $1,020 and $1,050, which are dispensable but over the limit.
- $10 and $30 are undispensable amounts between the bounds.

**Assumptions:**
- A withdrawal of $0 or less is invalid. The specification only says the amount must be dispensable in $20 and $50 bills, and I assumed that includes at least one bill.
- An amount over the $1,000 daily limit is rejected with `InvalidAmountException` by the session. The assignment names the limit as the upper boundary, so I assumed the exception is raised at the session level and not later by the bank.
- `Session.addPin` does not check the PIN format. The check is in `FormatChecker.checkPinFormat`, called from `ATM.checkPin`, which feeds `Session`. The PIN tests therefore go through `ATM.checkPin`, which then calls `Session.addPin`.
- The amount tests call `Session` directly (`addCard`, `addPin`, `setTransaction`, `setFromAccount`, `setAmount`). This stops the PIN fault from making every amount test fail, which would break the single fault assumption.

### 1.2 Test Cases and Results

**PIN format** (`pinFormat`)

| Test ID | PIN | Boundary | Expected | Actual | Result |
|---|---|---|---|---|:---:|
| P01 | `55555` | nominal | Accepted | `InvalidPinFormatException` | FAIL |
| P02 | `00000` | min digit | Accepted | `InvalidPinFormatException` | FAIL |
| P03 | `11111` | min+ digit | Accepted | `InvalidPinFormatException` | FAIL |
| P04 | `88888` | max− digit | Accepted | `InvalidPinFormatException` | FAIL |
| P05 | `99999` | max digit | Accepted | `InvalidPinFormatException` | FAIL |
| P06 | (empty) | length 0 | `InvalidPinFormatException` | `InvalidPinFormatException` | PASS |
| P07 | `5` | length 1 | `InvalidPinFormatException` | `InvalidPinFormatException` | PASS |
| P08 | `5555` | length min− (4) | `InvalidPinFormatException` | Accepted | FAIL |
| P09 | `555555` | length max+ (6) | `InvalidPinFormatException` | `InvalidPinFormatException` | PASS |
| P10–P14 | `/5555`, `5/555`, `55/55`, `555/5`, `5555/` | digit min− in positions 1–5 | `InvalidPinFormatException` | `InvalidPinFormatException` | PASS |
| P15–P19 | `:5555`, `5:555`, `55:55`, `555:5`, `5555:` | digit max+ in positions 1–5 | `InvalidPinFormatException` | `InvalidPinFormatException` | PASS |
| P20 | `5555a` | non-digit letter | `InvalidPinFormatException` | `InvalidPinFormatException` | PASS |

**Withdrawal amount** (`withdrawalAmount`)

| Test ID | Amount | Boundary | Expected | Actual | Result |
|---|---:|---|---|---|:---:|
| A01 | −50 | below min | `InvalidAmountException` | No exception; test bank declines | FAIL |
| A02 | −1 | below min | `InvalidAmountException` | `InvalidAmountException` | PASS |
| A03 | 0 | min− | `InvalidAmountException` | No exception; test bank declines | FAIL |
| A04 | 19 | min− | `InvalidAmountException` | `InvalidAmountException` | PASS |
| A05 | 20 | min | Accepted | Accepted | PASS |
| A06 | 21 | min+ | `InvalidAmountException` | `InvalidAmountException` | PASS |
| A07 | 40 | next dispensable | Accepted | Accepted | PASS |
| A08 | 60 | next dispensable | Accepted | `InvalidAmountException` | FAIL |
| A09 | 500 | nominal | Accepted | Accepted | PASS |
| A10 | 990 | max− | Accepted | Accepted | PASS |
| A11 | 999 | max− | `InvalidAmountException` | `InvalidAmountException` | PASS |
| A12 | 1000 | max (daily limit) | Accepted | Accepted | PASS |
| A13 | 1001 | max+ | `InvalidAmountException` | `InvalidAmountException` | PASS |
| A14 | 1020 | over limit, dispensable | `InvalidAmountException` | No exception; test bank declines | FAIL |
| A15 | 1050 | over limit, dispensable | `InvalidAmountException` | No exception; test bank declines | FAIL |
| A16 | 10 | undispensable | `InvalidAmountException` | `InvalidAmountException` | PASS |
| A17 | 30 | undispensable | `InvalidAmountException` | `InvalidAmountException` | PASS |

### 1.3 Test Results Summary

| Group | Tests | Passed | Failed |
|---|---:|---:|---:|
| PIN format | 20 | 14 | 6 |
| Withdrawal amount | 17 | 12 | 5 |
| **Total** | **37** | **26** | **11** |

### 1.4 Fault Localization

| Fault ID | Failing tests | Suspected fault | Justification |
|---|---|---|---|
| SF-01 | P01–P05, P08 | `atm.utils.FormatChecker.checkPinFormat`: `pin.length == 4` and the `for` loop bound `i < 4` | The check requires a 4-character PIN, so every valid 5-digit PIN is rejected (P01–P05) and a 4-digit PIN is accepted (P08). The specification says 5 digits. |
| SF-02 | A08 | `atm.utils.CashValidator.validateWithdrawal`: the nested `% 50` then `% 20` test | It only accepts an amount if the remainder after `% 50` is divisible by 20. $60 (3 × $20) leaves a remainder of 10 and is rejected, even though it can be dispensed. |
| SF-03 | A01, A03 | `atm.utils.CashValidator.validateWithdrawal` (no lower bound) | `amount % 50 == 0` is true for 0 and −50, so they are accepted. No `amount > 0` check exists in `CashValidator` or in `Session.setAmount`. |
| SF-04 | A14, A15 | `atm.session.Session.setAmount` (no daily-limit check) | The Session does not compare the amount with the configured fixture limit or raise `InvalidAmountException`. The test bank declines $1,020 and $1,050, but `Session.setAmount` still returns normally, violating the stated session-level exception assumption. |

**Note:** SF-01 hides a possible second fault in the same condition, `pin[i] >= '9'` (it should be `> '9'`). The digit `'9'` would be rejected even after the length is fixed. P05 (`99999`) fails for the length fault today, so the tests can't isolate this second fault yet. It will show up in the fix phase.

## 2. Withdrawal

### 2.1 Test Design and Assumptions

**Method tested:** `bank.utils.FeesCalculator.calculateWithdrawalFee()`

**Testing technique:** Robust Worst Case Boundary Value Analysis (RWC-BVA). Every selected amount, balance, student status, and day is combined with every other selected value. Multiple invalid inputs may occur together: the single-fault restriction applies to the Session section, not this fee suite.

The specified fee rules are unchanged: students pay 0% on weekdays and 0.1% on weekends; non-students pay 0.3% below $1,000, 0.1% from $1,000 to below $5,000, and 0% at or above $5,000.

**Input domains and assumptions:**

- The amount is a positive dollar amount, account balance is nonnegative, student status is Boolean, and the calendar day is 1 (Sunday) through 7 (Saturday). Amounts and balances are probed with a $0.01 step. Fee precision is retained without cent rounding because the specification provides no rounding rule; the assertion tolerance is $0.000000001.
- There is no specified maximum amount or balance for this method. No artificial upper bound is imposed. The Session's denomination restrictions and $1,000 daily limit do not define this fee calculator's domain. Boundary probes cover the lower monetary boundaries and each fee-tier boundary, plus nominal representatives.
- **Invalid-input oracle assumption:** amount <= 0, balance < 0, or a day outside 1..7 should cause `IllegalArgumentException`. The handout does not specify rejection behavior for this method. These robustness failures are reported separately as assumption-based observations, not confirmed violations of a stated exception requirement. `boolean` has no representable invalid value in this Java signature.

| Input | Selected boundary and nominal values |
|---|---|
| Amount | -0.01, 0 (invalid); 0.01 (minimum), 0.02 (minimum+), 500 (nominal); no finite upper bound specified |
| Account balance | -0.01 (minimum-), 0 (minimum), 0.01 (minimum+), 999.99/1000/1000.01, 3000 (nominal), 4999.99/5000/5000.01 |
| Student status | true, false |
| Calendar day | 0 (minimum-), 1 (minimum), 2 (minimum+), 3, 4 (nominal), 5, 6 (maximum-), 7 (maximum), 8 (maximum+) |

The full Cartesian product is **5 × 10 × 2 × 9 = 900 test cases**. All-valid combinations check the written fee rules; every combination containing an invalid input checks the explicit rejection assumption. Cases have stable IDs W001–W900 in the test output and result table.

### 2.2 Test Cases and Results

The complete table of inputs, expected/actual outcomes, pass/fail results, and fault groups is in [withdrawal-results.md](withdrawal-results.md). It is split into a separate Markdown file to keep this report readable. Results were captured from JUnit on Java 11 on November 7, 2026.

### 2.3 Test Results Summary

| Group | Tests | Passed | Failed |
|---|---:|---:|---:|
| All-valid inputs: student | 189 | 0 | 189 |
| All-valid inputs: non-student balance < $1,000 | 63 | 0 | 63 |
| All-valid inputs: non-student $1,000 <= balance < $5,000 | 84 | 84 | 0 |
| All-valid inputs: non-student balance >= $5,000 | 42 | 0 | 42 |
| Invalid-input combinations (assumption-based oracle) | 522 | 0 | 522 |
| **Total** | **900** | **84** | **816** |

There are **294 failed checks of specified fee rules**, plus **522 failures of the separately stated invalid-input assumption**. They should not be conflated. All 900 cases executed without test errors or skips.

### 2.4 Fault Localization

| Fault ID | Affected failing cases | Suspected fault and justification |
|---|---|---|
| WF-01 | All-valid student cases | `FeesCalculator.calculateWithdrawalFee`, weekend branch: the weekend rate is 0 and weekday rate 0.001, reversing the specified rates. |
| WF-02 | All-valid non-student cases with balance < $1,000 | `FeesCalculator.calculateWithdrawalFee`, `accountBalance < 1000.00` assignment: 0.002 is used instead of 0.003. |
| WF-03 | All-valid non-student cases with balance >= $5,000 | `FeesCalculator.calculateWithdrawalFee`, `accountBalance < 10000.00`: the no-fee tier starts at $10,000 instead of $5,000. |
| WF-04 (assumption-based) | Every combination containing an invalid input | `FeesCalculator.calculateWithdrawalFee`, method entry: no validation raises the assumed `IllegalArgumentException`; a numerical fee is returned. This is not an exception contract specified in the handout. |

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
| 10 | 2aii, 2bi | yes | $100 | $250 | $0.25 |
| 11 | 3aii, 3bi | no | $500 | $1500 | $2.00 |

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
| 10 | Fail |
| 11 | Fail |

### 3.4 Fault Localization:

| Failing Test | Suspected Fault (file, method, line) | One-line justification |
|---|---|---|
| DepositTest 1, 2, 3 | FeesCalculator.java, calculateDepositInterest, lines 33-39 | The method has no input validation, so invalid inputs return a fee instead of throwing an exception |
| DepositTest 4 | FeesCalculator.java, calculateDepositInterest, line 50 (interestPercentage = 0.002) | interestPercentage should be 0%, but line 50 charges 0.2% |
| DepositTest 5 | FeesCalculator.java, calculateDepositInterest, line 39 (amount > 100.00) | Condition should be > $50, not > $100 |
| DepositTest 7 | FeesCalculator.java, calculateDepositInterest, line 64 (interestPercentage = 0.0) | interestPercentage should be 0.1% but line 64 charges 0% |
| DepositTest 8 | FeesCalculator.java, calculateDepositInterest, line 54 (amount > 500.00) | Condition should be > $250, not > $500 |
| DepositTest 9 | FeesCalculator.java, calculateDepositInterest, line 62 (interestPercentage = 0.005) | interestPercentage should be 0%, not 0.5% |
| DepositTest 10 | `FeesCalculator.calculateDepositInterest`, student `amount > 100.00` branch | A $100 deposit with $250 balance returns $0.20 instead of the specified $0.25. |
| DepositTest 11 | `FeesCalculator.calculateDepositInterest`, non-student `amount > 500.00` branch | A $500 deposit with $1500 balance returns $0 instead of the specified $2. |


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
