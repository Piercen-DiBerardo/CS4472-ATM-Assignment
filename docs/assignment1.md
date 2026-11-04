# CS 4472 — Assignment 1: Black-Box Testing

## 1. ATM Session

*To be completed using Robust Worst Case Boundary Value Analysis for the PIN and withdrawal amount By Gurshaan Deol.*

## 2. Withdrawal

### 2.1 Test Design and Assumptions

**Method tested:** `bank.utils.FeesCalculator.calculateWithdrawalFee()`

**Testing technique:** Robust Worst-Case Boundary Value Analysis (RWC-BVA).

I tested the withdrawal fee calculation as a black-box method by deriving the expected fee, then comparing it with the fee returned by the program. The method takes four inputs: the withdrawal amount, account balance, student status, and day of the week. The test suite uses combinations of the selected values for all four inputs. The balance values focus on the two fee thresholds ($1,000 and $5,000), and the Boolean and day inputs cover student/non-student and weekday/weekend cases.

The specified fee rules are:

| Client | Condition | Expected fee |
|---|---|---|
| Student | Weekday | 0% of withdrawal amount |
| Student | Weekend | 0.1% of withdrawal amount |
| Non-student | Balance < $1,000 | 0.3% of withdrawal amount |
| Non-student | $1,000 ≤ balance < $5,000 | 0.1% of withdrawal amount |
| Non-student | Balance ≥ $5,000 | $0 |

**Input selection:**

| Input | Values tested | Reason |
|---|---|---|
| Withdrawal amount | $20, $50, $100, $200, $500, $999, $1,000 | Seven representative amounts to check that the fee scales with amount; these are **not** all formal amount boundary values, because the fee specification does not define an amount limit. |
| Account balance | −$1, $0, $500, $999, $1,000, $1,001, $3,000, $4,999, $5,000, $5,001 | Values near the specified $1,000 and $5,000 thresholds, plus representative balances and two exceptional balances. |
| Student status | `true`, `false` | Both client types. |
| Day of week | `Calendar.MONDAY` (2), `Calendar.SATURDAY` (7) | One representative weekday and one representative weekend day. |

The Cartesian product generates **7 × 10 × 2 × 2 = 280 test cases**. Each combination is a separate JUnit dynamic test. Expected values are computed independently from the written fee specification, not from the implementation being tested. JUnit compares fees with an absolute tolerance of `0.0001`. The code reports each test as PASS or FAIL.

**Assumptions and limitations:**

- Account balance is the balance supplied to the fee calculator at the time the fee is calculated.
- Amounts and fees are in dollars. For example, 0.1% is multiplied as `0.001`.
- The fee specification gives no separate amount threshold, maximum amount, rounding rule, or exception behavior for this calculator method. The seven amount values therefore provide representative combination coverage rather than mathematically complete robust boundary selection for the amount input.
- A negative balance (−$1) and zero balance are included as exploratory inputs. The fee specification itself does not establish whether a negative balance is valid or whether an exception is required. These tests apply the stated `< $1,000` fee rule; they do not demonstrate valid handling of negative balances.
- Some withdrawal amounts exceed the supplied account balance. These tests examine only the fee-calculation method, not the ATM session's ability to authorize or dispense the withdrawal.
- Only Monday and Saturday are tested. The results demonstrate weekday/weekend behavior for those representatives, but not every day of the week.
- The suite is **combination-based and boundary-focused**, but should not be described as a formally exhaustive robust worst-case suite for every input domain without additional input-domain specifications.

### 2.2 Test Cases and Results

Each row records one executed JUnit test. `Day` is shown as Monday (2) or Saturday (7). Expected and actual fees are in dollars; `PASS` means the absolute difference is at most `0.0001`.

| Test ID | Amount | Balance | Student? | Day | Expected fee | Actual fee | Result |
|---|---:|---:|:---:|---|---:|---:|:---:|
| W001 | 20.00 | -1.00 | Yes | Mon | 0.0000 | 0.0200 | FAIL |
| W002 | 20.00 | -1.00 | Yes | Sat | 0.0200 | 0.0000 | FAIL |
| W003 | 20.00 | -1.00 | No | Mon | 0.0600 | 0.0400 | FAIL |
| W004 | 20.00 | -1.00 | No | Sat | 0.0600 | 0.0400 | FAIL |
| W005 | 20.00 | 0.00 | Yes | Mon | 0.0000 | 0.0200 | FAIL |
| W006 | 20.00 | 0.00 | Yes | Sat | 0.0200 | 0.0000 | FAIL |
| W007 | 20.00 | 0.00 | No | Mon | 0.0600 | 0.0400 | FAIL |
| W008 | 20.00 | 0.00 | No | Sat | 0.0600 | 0.0400 | FAIL |
| W009 | 20.00 | 500.00 | Yes | Mon | 0.0000 | 0.0200 | FAIL |
| W010 | 20.00 | 500.00 | Yes | Sat | 0.0200 | 0.0000 | FAIL |
| W011 | 20.00 | 500.00 | No | Mon | 0.0600 | 0.0400 | FAIL |
| W012 | 20.00 | 500.00 | No | Sat | 0.0600 | 0.0400 | FAIL |
| W013 | 20.00 | 999.00 | Yes | Mon | 0.0000 | 0.0200 | FAIL |
| W014 | 20.00 | 999.00 | Yes | Sat | 0.0200 | 0.0000 | FAIL |
| W015 | 20.00 | 999.00 | No | Mon | 0.0600 | 0.0400 | FAIL |
| W016 | 20.00 | 999.00 | No | Sat | 0.0600 | 0.0400 | FAIL |
| W017 | 20.00 | 1000.00 | Yes | Mon | 0.0000 | 0.0200 | FAIL |
| W018 | 20.00 | 1000.00 | Yes | Sat | 0.0200 | 0.0000 | FAIL |
| W019 | 20.00 | 1000.00 | No | Mon | 0.0200 | 0.0200 | PASS |
| W020 | 20.00 | 1000.00 | No | Sat | 0.0200 | 0.0200 | PASS |
| W021 | 20.00 | 1001.00 | Yes | Mon | 0.0000 | 0.0200 | FAIL |
| W022 | 20.00 | 1001.00 | Yes | Sat | 0.0200 | 0.0000 | FAIL |
| W023 | 20.00 | 1001.00 | No | Mon | 0.0200 | 0.0200 | PASS |
| W024 | 20.00 | 1001.00 | No | Sat | 0.0200 | 0.0200 | PASS |
| W025 | 20.00 | 3000.00 | Yes | Mon | 0.0000 | 0.0200 | FAIL |
| W026 | 20.00 | 3000.00 | Yes | Sat | 0.0200 | 0.0000 | FAIL |
| W027 | 20.00 | 3000.00 | No | Mon | 0.0200 | 0.0200 | PASS |
| W028 | 20.00 | 3000.00 | No | Sat | 0.0200 | 0.0200 | PASS |
| W029 | 20.00 | 4999.00 | Yes | Mon | 0.0000 | 0.0200 | FAIL |
| W030 | 20.00 | 4999.00 | Yes | Sat | 0.0200 | 0.0000 | FAIL |
| W031 | 20.00 | 4999.00 | No | Mon | 0.0200 | 0.0200 | PASS |
| W032 | 20.00 | 4999.00 | No | Sat | 0.0200 | 0.0200 | PASS |
| W033 | 20.00 | 5000.00 | Yes | Mon | 0.0000 | 0.0200 | FAIL |
| W034 | 20.00 | 5000.00 | Yes | Sat | 0.0200 | 0.0000 | FAIL |
| W035 | 20.00 | 5000.00 | No | Mon | 0.0000 | 0.0200 | FAIL |
| W036 | 20.00 | 5000.00 | No | Sat | 0.0000 | 0.0200 | FAIL |
| W037 | 20.00 | 5001.00 | Yes | Mon | 0.0000 | 0.0200 | FAIL |
| W038 | 20.00 | 5001.00 | Yes | Sat | 0.0200 | 0.0000 | FAIL |
| W039 | 20.00 | 5001.00 | No | Mon | 0.0000 | 0.0200 | FAIL |
| W040 | 20.00 | 5001.00 | No | Sat | 0.0000 | 0.0200 | FAIL |
| W041 | 50.00 | -1.00 | Yes | Mon | 0.0000 | 0.0500 | FAIL |
| W042 | 50.00 | -1.00 | Yes | Sat | 0.0500 | 0.0000 | FAIL |
| W043 | 50.00 | -1.00 | No | Mon | 0.1500 | 0.1000 | FAIL |
| W044 | 50.00 | -1.00 | No | Sat | 0.1500 | 0.1000 | FAIL |
| W045 | 50.00 | 0.00 | Yes | Mon | 0.0000 | 0.0500 | FAIL |
| W046 | 50.00 | 0.00 | Yes | Sat | 0.0500 | 0.0000 | FAIL |
| W047 | 50.00 | 0.00 | No | Mon | 0.1500 | 0.1000 | FAIL |
| W048 | 50.00 | 0.00 | No | Sat | 0.1500 | 0.1000 | FAIL |
| W049 | 50.00 | 500.00 | Yes | Mon | 0.0000 | 0.0500 | FAIL |
| W050 | 50.00 | 500.00 | Yes | Sat | 0.0500 | 0.0000 | FAIL |
| W051 | 50.00 | 500.00 | No | Mon | 0.1500 | 0.1000 | FAIL |
| W052 | 50.00 | 500.00 | No | Sat | 0.1500 | 0.1000 | FAIL |
| W053 | 50.00 | 999.00 | Yes | Mon | 0.0000 | 0.0500 | FAIL |
| W054 | 50.00 | 999.00 | Yes | Sat | 0.0500 | 0.0000 | FAIL |
| W055 | 50.00 | 999.00 | No | Mon | 0.1500 | 0.1000 | FAIL |
| W056 | 50.00 | 999.00 | No | Sat | 0.1500 | 0.1000 | FAIL |
| W057 | 50.00 | 1000.00 | Yes | Mon | 0.0000 | 0.0500 | FAIL |
| W058 | 50.00 | 1000.00 | Yes | Sat | 0.0500 | 0.0000 | FAIL |
| W059 | 50.00 | 1000.00 | No | Mon | 0.0500 | 0.0500 | PASS |
| W060 | 50.00 | 1000.00 | No | Sat | 0.0500 | 0.0500 | PASS |
| W061 | 50.00 | 1001.00 | Yes | Mon | 0.0000 | 0.0500 | FAIL |
| W062 | 50.00 | 1001.00 | Yes | Sat | 0.0500 | 0.0000 | FAIL |
| W063 | 50.00 | 1001.00 | No | Mon | 0.0500 | 0.0500 | PASS |
| W064 | 50.00 | 1001.00 | No | Sat | 0.0500 | 0.0500 | PASS |
| W065 | 50.00 | 3000.00 | Yes | Mon | 0.0000 | 0.0500 | FAIL |
| W066 | 50.00 | 3000.00 | Yes | Sat | 0.0500 | 0.0000 | FAIL |
| W067 | 50.00 | 3000.00 | No | Mon | 0.0500 | 0.0500 | PASS |
| W068 | 50.00 | 3000.00 | No | Sat | 0.0500 | 0.0500 | PASS |
| W069 | 50.00 | 4999.00 | Yes | Mon | 0.0000 | 0.0500 | FAIL |
| W070 | 50.00 | 4999.00 | Yes | Sat | 0.0500 | 0.0000 | FAIL |
| W071 | 50.00 | 4999.00 | No | Mon | 0.0500 | 0.0500 | PASS |
| W072 | 50.00 | 4999.00 | No | Sat | 0.0500 | 0.0500 | PASS |
| W073 | 50.00 | 5000.00 | Yes | Mon | 0.0000 | 0.0500 | FAIL |
| W074 | 50.00 | 5000.00 | Yes | Sat | 0.0500 | 0.0000 | FAIL |
| W075 | 50.00 | 5000.00 | No | Mon | 0.0000 | 0.0500 | FAIL |
| W076 | 50.00 | 5000.00 | No | Sat | 0.0000 | 0.0500 | FAIL |
| W077 | 50.00 | 5001.00 | Yes | Mon | 0.0000 | 0.0500 | FAIL |
| W078 | 50.00 | 5001.00 | Yes | Sat | 0.0500 | 0.0000 | FAIL |
| W079 | 50.00 | 5001.00 | No | Mon | 0.0000 | 0.0500 | FAIL |
| W080 | 50.00 | 5001.00 | No | Sat | 0.0000 | 0.0500 | FAIL |
| W081 | 100.00 | -1.00 | Yes | Mon | 0.0000 | 0.1000 | FAIL |
| W082 | 100.00 | -1.00 | Yes | Sat | 0.1000 | 0.0000 | FAIL |
| W083 | 100.00 | -1.00 | No | Mon | 0.3000 | 0.2000 | FAIL |
| W084 | 100.00 | -1.00 | No | Sat | 0.3000 | 0.2000 | FAIL |
| W085 | 100.00 | 0.00 | Yes | Mon | 0.0000 | 0.1000 | FAIL |
| W086 | 100.00 | 0.00 | Yes | Sat | 0.1000 | 0.0000 | FAIL |
| W087 | 100.00 | 0.00 | No | Mon | 0.3000 | 0.2000 | FAIL |
| W088 | 100.00 | 0.00 | No | Sat | 0.3000 | 0.2000 | FAIL |
| W089 | 100.00 | 500.00 | Yes | Mon | 0.0000 | 0.1000 | FAIL |
| W090 | 100.00 | 500.00 | Yes | Sat | 0.1000 | 0.0000 | FAIL |
| W091 | 100.00 | 500.00 | No | Mon | 0.3000 | 0.2000 | FAIL |
| W092 | 100.00 | 500.00 | No | Sat | 0.3000 | 0.2000 | FAIL |
| W093 | 100.00 | 999.00 | Yes | Mon | 0.0000 | 0.1000 | FAIL |
| W094 | 100.00 | 999.00 | Yes | Sat | 0.1000 | 0.0000 | FAIL |
| W095 | 100.00 | 999.00 | No | Mon | 0.3000 | 0.2000 | FAIL |
| W096 | 100.00 | 999.00 | No | Sat | 0.3000 | 0.2000 | FAIL |
| W097 | 100.00 | 1000.00 | Yes | Mon | 0.0000 | 0.1000 | FAIL |
| W098 | 100.00 | 1000.00 | Yes | Sat | 0.1000 | 0.0000 | FAIL |
| W099 | 100.00 | 1000.00 | No | Mon | 0.1000 | 0.1000 | PASS |
| W100 | 100.00 | 1000.00 | No | Sat | 0.1000 | 0.1000 | PASS |
| W101 | 100.00 | 1001.00 | Yes | Mon | 0.0000 | 0.1000 | FAIL |
| W102 | 100.00 | 1001.00 | Yes | Sat | 0.1000 | 0.0000 | FAIL |
| W103 | 100.00 | 1001.00 | No | Mon | 0.1000 | 0.1000 | PASS |
| W104 | 100.00 | 1001.00 | No | Sat | 0.1000 | 0.1000 | PASS |
| W105 | 100.00 | 3000.00 | Yes | Mon | 0.0000 | 0.1000 | FAIL |
| W106 | 100.00 | 3000.00 | Yes | Sat | 0.1000 | 0.0000 | FAIL |
| W107 | 100.00 | 3000.00 | No | Mon | 0.1000 | 0.1000 | PASS |
| W108 | 100.00 | 3000.00 | No | Sat | 0.1000 | 0.1000 | PASS |
| W109 | 100.00 | 4999.00 | Yes | Mon | 0.0000 | 0.1000 | FAIL |
| W110 | 100.00 | 4999.00 | Yes | Sat | 0.1000 | 0.0000 | FAIL |
| W111 | 100.00 | 4999.00 | No | Mon | 0.1000 | 0.1000 | PASS |
| W112 | 100.00 | 4999.00 | No | Sat | 0.1000 | 0.1000 | PASS |
| W113 | 100.00 | 5000.00 | Yes | Mon | 0.0000 | 0.1000 | FAIL |
| W114 | 100.00 | 5000.00 | Yes | Sat | 0.1000 | 0.0000 | FAIL |
| W115 | 100.00 | 5000.00 | No | Mon | 0.0000 | 0.1000 | FAIL |
| W116 | 100.00 | 5000.00 | No | Sat | 0.0000 | 0.1000 | FAIL |
| W117 | 100.00 | 5001.00 | Yes | Mon | 0.0000 | 0.1000 | FAIL |
| W118 | 100.00 | 5001.00 | Yes | Sat | 0.1000 | 0.0000 | FAIL |
| W119 | 100.00 | 5001.00 | No | Mon | 0.0000 | 0.1000 | FAIL |
| W120 | 100.00 | 5001.00 | No | Sat | 0.0000 | 0.1000 | FAIL |
| W121 | 200.00 | -1.00 | Yes | Mon | 0.0000 | 0.2000 | FAIL |
| W122 | 200.00 | -1.00 | Yes | Sat | 0.2000 | 0.0000 | FAIL |
| W123 | 200.00 | -1.00 | No | Mon | 0.6000 | 0.4000 | FAIL |
| W124 | 200.00 | -1.00 | No | Sat | 0.6000 | 0.4000 | FAIL |
| W125 | 200.00 | 0.00 | Yes | Mon | 0.0000 | 0.2000 | FAIL |
| W126 | 200.00 | 0.00 | Yes | Sat | 0.2000 | 0.0000 | FAIL |
| W127 | 200.00 | 0.00 | No | Mon | 0.6000 | 0.4000 | FAIL |
| W128 | 200.00 | 0.00 | No | Sat | 0.6000 | 0.4000 | FAIL |
| W129 | 200.00 | 500.00 | Yes | Mon | 0.0000 | 0.2000 | FAIL |
| W130 | 200.00 | 500.00 | Yes | Sat | 0.2000 | 0.0000 | FAIL |
| W131 | 200.00 | 500.00 | No | Mon | 0.6000 | 0.4000 | FAIL |
| W132 | 200.00 | 500.00 | No | Sat | 0.6000 | 0.4000 | FAIL |
| W133 | 200.00 | 999.00 | Yes | Mon | 0.0000 | 0.2000 | FAIL |
| W134 | 200.00 | 999.00 | Yes | Sat | 0.2000 | 0.0000 | FAIL |
| W135 | 200.00 | 999.00 | No | Mon | 0.6000 | 0.4000 | FAIL |
| W136 | 200.00 | 999.00 | No | Sat | 0.6000 | 0.4000 | FAIL |
| W137 | 200.00 | 1000.00 | Yes | Mon | 0.0000 | 0.2000 | FAIL |
| W138 | 200.00 | 1000.00 | Yes | Sat | 0.2000 | 0.0000 | FAIL |
| W139 | 200.00 | 1000.00 | No | Mon | 0.2000 | 0.2000 | PASS |
| W140 | 200.00 | 1000.00 | No | Sat | 0.2000 | 0.2000 | PASS |
| W141 | 200.00 | 1001.00 | Yes | Mon | 0.0000 | 0.2000 | FAIL |
| W142 | 200.00 | 1001.00 | Yes | Sat | 0.2000 | 0.0000 | FAIL |
| W143 | 200.00 | 1001.00 | No | Mon | 0.2000 | 0.2000 | PASS |
| W144 | 200.00 | 1001.00 | No | Sat | 0.2000 | 0.2000 | PASS |
| W145 | 200.00 | 3000.00 | Yes | Mon | 0.0000 | 0.2000 | FAIL |
| W146 | 200.00 | 3000.00 | Yes | Sat | 0.2000 | 0.0000 | FAIL |
| W147 | 200.00 | 3000.00 | No | Mon | 0.2000 | 0.2000 | PASS |
| W148 | 200.00 | 3000.00 | No | Sat | 0.2000 | 0.2000 | PASS |
| W149 | 200.00 | 4999.00 | Yes | Mon | 0.0000 | 0.2000 | FAIL |
| W150 | 200.00 | 4999.00 | Yes | Sat | 0.2000 | 0.0000 | FAIL |
| W151 | 200.00 | 4999.00 | No | Mon | 0.2000 | 0.2000 | PASS |
| W152 | 200.00 | 4999.00 | No | Sat | 0.2000 | 0.2000 | PASS |
| W153 | 200.00 | 5000.00 | Yes | Mon | 0.0000 | 0.2000 | FAIL |
| W154 | 200.00 | 5000.00 | Yes | Sat | 0.2000 | 0.0000 | FAIL |
| W155 | 200.00 | 5000.00 | No | Mon | 0.0000 | 0.2000 | FAIL |
| W156 | 200.00 | 5000.00 | No | Sat | 0.0000 | 0.2000 | FAIL |
| W157 | 200.00 | 5001.00 | Yes | Mon | 0.0000 | 0.2000 | FAIL |
| W158 | 200.00 | 5001.00 | Yes | Sat | 0.2000 | 0.0000 | FAIL |
| W159 | 200.00 | 5001.00 | No | Mon | 0.0000 | 0.2000 | FAIL |
| W160 | 200.00 | 5001.00 | No | Sat | 0.0000 | 0.2000 | FAIL |
| W161 | 500.00 | -1.00 | Yes | Mon | 0.0000 | 0.5000 | FAIL |
| W162 | 500.00 | -1.00 | Yes | Sat | 0.5000 | 0.0000 | FAIL |
| W163 | 500.00 | -1.00 | No | Mon | 1.5000 | 1.0000 | FAIL |
| W164 | 500.00 | -1.00 | No | Sat | 1.5000 | 1.0000 | FAIL |
| W165 | 500.00 | 0.00 | Yes | Mon | 0.0000 | 0.5000 | FAIL |
| W166 | 500.00 | 0.00 | Yes | Sat | 0.5000 | 0.0000 | FAIL |
| W167 | 500.00 | 0.00 | No | Mon | 1.5000 | 1.0000 | FAIL |
| W168 | 500.00 | 0.00 | No | Sat | 1.5000 | 1.0000 | FAIL |
| W169 | 500.00 | 500.00 | Yes | Mon | 0.0000 | 0.5000 | FAIL |
| W170 | 500.00 | 500.00 | Yes | Sat | 0.5000 | 0.0000 | FAIL |
| W171 | 500.00 | 500.00 | No | Mon | 1.5000 | 1.0000 | FAIL |
| W172 | 500.00 | 500.00 | No | Sat | 1.5000 | 1.0000 | FAIL |
| W173 | 500.00 | 999.00 | Yes | Mon | 0.0000 | 0.5000 | FAIL |
| W174 | 500.00 | 999.00 | Yes | Sat | 0.5000 | 0.0000 | FAIL |
| W175 | 500.00 | 999.00 | No | Mon | 1.5000 | 1.0000 | FAIL |
| W176 | 500.00 | 999.00 | No | Sat | 1.5000 | 1.0000 | FAIL |
| W177 | 500.00 | 1000.00 | Yes | Mon | 0.0000 | 0.5000 | FAIL |
| W178 | 500.00 | 1000.00 | Yes | Sat | 0.5000 | 0.0000 | FAIL |
| W179 | 500.00 | 1000.00 | No | Mon | 0.5000 | 0.5000 | PASS |
| W180 | 500.00 | 1000.00 | No | Sat | 0.5000 | 0.5000 | PASS |
| W181 | 500.00 | 1001.00 | Yes | Mon | 0.0000 | 0.5000 | FAIL |
| W182 | 500.00 | 1001.00 | Yes | Sat | 0.5000 | 0.0000 | FAIL |
| W183 | 500.00 | 1001.00 | No | Mon | 0.5000 | 0.5000 | PASS |
| W184 | 500.00 | 1001.00 | No | Sat | 0.5000 | 0.5000 | PASS |
| W185 | 500.00 | 3000.00 | Yes | Mon | 0.0000 | 0.5000 | FAIL |
| W186 | 500.00 | 3000.00 | Yes | Sat | 0.5000 | 0.0000 | FAIL |
| W187 | 500.00 | 3000.00 | No | Mon | 0.5000 | 0.5000 | PASS |
| W188 | 500.00 | 3000.00 | No | Sat | 0.5000 | 0.5000 | PASS |
| W189 | 500.00 | 4999.00 | Yes | Mon | 0.0000 | 0.5000 | FAIL |
| W190 | 500.00 | 4999.00 | Yes | Sat | 0.5000 | 0.0000 | FAIL |
| W191 | 500.00 | 4999.00 | No | Mon | 0.5000 | 0.5000 | PASS |
| W192 | 500.00 | 4999.00 | No | Sat | 0.5000 | 0.5000 | PASS |
| W193 | 500.00 | 5000.00 | Yes | Mon | 0.0000 | 0.5000 | FAIL |
| W194 | 500.00 | 5000.00 | Yes | Sat | 0.5000 | 0.0000 | FAIL |
| W195 | 500.00 | 5000.00 | No | Mon | 0.0000 | 0.5000 | FAIL |
| W196 | 500.00 | 5000.00 | No | Sat | 0.0000 | 0.5000 | FAIL |
| W197 | 500.00 | 5001.00 | Yes | Mon | 0.0000 | 0.5000 | FAIL |
| W198 | 500.00 | 5001.00 | Yes | Sat | 0.5000 | 0.0000 | FAIL |
| W199 | 500.00 | 5001.00 | No | Mon | 0.0000 | 0.5000 | FAIL |
| W200 | 500.00 | 5001.00 | No | Sat | 0.0000 | 0.5000 | FAIL |
| W201 | 999.00 | -1.00 | Yes | Mon | 0.0000 | 0.9990 | FAIL |
| W202 | 999.00 | -1.00 | Yes | Sat | 0.9990 | 0.0000 | FAIL |
| W203 | 999.00 | -1.00 | No | Mon | 2.9970 | 1.9980 | FAIL |
| W204 | 999.00 | -1.00 | No | Sat | 2.9970 | 1.9980 | FAIL |
| W205 | 999.00 | 0.00 | Yes | Mon | 0.0000 | 0.9990 | FAIL |
| W206 | 999.00 | 0.00 | Yes | Sat | 0.9990 | 0.0000 | FAIL |
| W207 | 999.00 | 0.00 | No | Mon | 2.9970 | 1.9980 | FAIL |
| W208 | 999.00 | 0.00 | No | Sat | 2.9970 | 1.9980 | FAIL |
| W209 | 999.00 | 500.00 | Yes | Mon | 0.0000 | 0.9990 | FAIL |
| W210 | 999.00 | 500.00 | Yes | Sat | 0.9990 | 0.0000 | FAIL |
| W211 | 999.00 | 500.00 | No | Mon | 2.9970 | 1.9980 | FAIL |
| W212 | 999.00 | 500.00 | No | Sat | 2.9970 | 1.9980 | FAIL |
| W213 | 999.00 | 999.00 | Yes | Mon | 0.0000 | 0.9990 | FAIL |
| W214 | 999.00 | 999.00 | Yes | Sat | 0.9990 | 0.0000 | FAIL |
| W215 | 999.00 | 999.00 | No | Mon | 2.9970 | 1.9980 | FAIL |
| W216 | 999.00 | 999.00 | No | Sat | 2.9970 | 1.9980 | FAIL |
| W217 | 999.00 | 1000.00 | Yes | Mon | 0.0000 | 0.9990 | FAIL |
| W218 | 999.00 | 1000.00 | Yes | Sat | 0.9990 | 0.0000 | FAIL |
| W219 | 999.00 | 1000.00 | No | Mon | 0.9990 | 0.9990 | PASS |
| W220 | 999.00 | 1000.00 | No | Sat | 0.9990 | 0.9990 | PASS |
| W221 | 999.00 | 1001.00 | Yes | Mon | 0.0000 | 0.9990 | FAIL |
| W222 | 999.00 | 1001.00 | Yes | Sat | 0.9990 | 0.0000 | FAIL |
| W223 | 999.00 | 1001.00 | No | Mon | 0.9990 | 0.9990 | PASS |
| W224 | 999.00 | 1001.00 | No | Sat | 0.9990 | 0.9990 | PASS |
| W225 | 999.00 | 3000.00 | Yes | Mon | 0.0000 | 0.9990 | FAIL |
| W226 | 999.00 | 3000.00 | Yes | Sat | 0.9990 | 0.0000 | FAIL |
| W227 | 999.00 | 3000.00 | No | Mon | 0.9990 | 0.9990 | PASS |
| W228 | 999.00 | 3000.00 | No | Sat | 0.9990 | 0.9990 | PASS |
| W229 | 999.00 | 4999.00 | Yes | Mon | 0.0000 | 0.9990 | FAIL |
| W230 | 999.00 | 4999.00 | Yes | Sat | 0.9990 | 0.0000 | FAIL |
| W231 | 999.00 | 4999.00 | No | Mon | 0.9990 | 0.9990 | PASS |
| W232 | 999.00 | 4999.00 | No | Sat | 0.9990 | 0.9990 | PASS |
| W233 | 999.00 | 5000.00 | Yes | Mon | 0.0000 | 0.9990 | FAIL |
| W234 | 999.00 | 5000.00 | Yes | Sat | 0.9990 | 0.0000 | FAIL |
| W235 | 999.00 | 5000.00 | No | Mon | 0.0000 | 0.9990 | FAIL |
| W236 | 999.00 | 5000.00 | No | Sat | 0.0000 | 0.9990 | FAIL |
| W237 | 999.00 | 5001.00 | Yes | Mon | 0.0000 | 0.9990 | FAIL |
| W238 | 999.00 | 5001.00 | Yes | Sat | 0.9990 | 0.0000 | FAIL |
| W239 | 999.00 | 5001.00 | No | Mon | 0.0000 | 0.9990 | FAIL |
| W240 | 999.00 | 5001.00 | No | Sat | 0.0000 | 0.9990 | FAIL |
| W241 | 1000.00 | -1.00 | Yes | Mon | 0.0000 | 1.0000 | FAIL |
| W242 | 1000.00 | -1.00 | Yes | Sat | 1.0000 | 0.0000 | FAIL |
| W243 | 1000.00 | -1.00 | No | Mon | 3.0000 | 2.0000 | FAIL |
| W244 | 1000.00 | -1.00 | No | Sat | 3.0000 | 2.0000 | FAIL |
| W245 | 1000.00 | 0.00 | Yes | Mon | 0.0000 | 1.0000 | FAIL |
| W246 | 1000.00 | 0.00 | Yes | Sat | 1.0000 | 0.0000 | FAIL |
| W247 | 1000.00 | 0.00 | No | Mon | 3.0000 | 2.0000 | FAIL |
| W248 | 1000.00 | 0.00 | No | Sat | 3.0000 | 2.0000 | FAIL |
| W249 | 1000.00 | 500.00 | Yes | Mon | 0.0000 | 1.0000 | FAIL |
| W250 | 1000.00 | 500.00 | Yes | Sat | 1.0000 | 0.0000 | FAIL |
| W251 | 1000.00 | 500.00 | No | Mon | 3.0000 | 2.0000 | FAIL |
| W252 | 1000.00 | 500.00 | No | Sat | 3.0000 | 2.0000 | FAIL |
| W253 | 1000.00 | 999.00 | Yes | Mon | 0.0000 | 1.0000 | FAIL |
| W254 | 1000.00 | 999.00 | Yes | Sat | 1.0000 | 0.0000 | FAIL |
| W255 | 1000.00 | 999.00 | No | Mon | 3.0000 | 2.0000 | FAIL |
| W256 | 1000.00 | 999.00 | No | Sat | 3.0000 | 2.0000 | FAIL |
| W257 | 1000.00 | 1000.00 | Yes | Mon | 0.0000 | 1.0000 | FAIL |
| W258 | 1000.00 | 1000.00 | Yes | Sat | 1.0000 | 0.0000 | FAIL |
| W259 | 1000.00 | 1000.00 | No | Mon | 1.0000 | 1.0000 | PASS |
| W260 | 1000.00 | 1000.00 | No | Sat | 1.0000 | 1.0000 | PASS |
| W261 | 1000.00 | 1001.00 | Yes | Mon | 0.0000 | 1.0000 | FAIL |
| W262 | 1000.00 | 1001.00 | Yes | Sat | 1.0000 | 0.0000 | FAIL |
| W263 | 1000.00 | 1001.00 | No | Mon | 1.0000 | 1.0000 | PASS |
| W264 | 1000.00 | 1001.00 | No | Sat | 1.0000 | 1.0000 | PASS |
| W265 | 1000.00 | 3000.00 | Yes | Mon | 0.0000 | 1.0000 | FAIL |
| W266 | 1000.00 | 3000.00 | Yes | Sat | 1.0000 | 0.0000 | FAIL |
| W267 | 1000.00 | 3000.00 | No | Mon | 1.0000 | 1.0000 | PASS |
| W268 | 1000.00 | 3000.00 | No | Sat | 1.0000 | 1.0000 | PASS |
| W269 | 1000.00 | 4999.00 | Yes | Mon | 0.0000 | 1.0000 | FAIL |
| W270 | 1000.00 | 4999.00 | Yes | Sat | 1.0000 | 0.0000 | FAIL |
| W271 | 1000.00 | 4999.00 | No | Mon | 1.0000 | 1.0000 | PASS |
| W272 | 1000.00 | 4999.00 | No | Sat | 1.0000 | 1.0000 | PASS |
| W273 | 1000.00 | 5000.00 | Yes | Mon | 0.0000 | 1.0000 | FAIL |
| W274 | 1000.00 | 5000.00 | Yes | Sat | 1.0000 | 0.0000 | FAIL |
| W275 | 1000.00 | 5000.00 | No | Mon | 0.0000 | 1.0000 | FAIL |
| W276 | 1000.00 | 5000.00 | No | Sat | 0.0000 | 1.0000 | FAIL |
| W277 | 1000.00 | 5001.00 | Yes | Mon | 0.0000 | 1.0000 | FAIL |
| W278 | 1000.00 | 5001.00 | Yes | Sat | 1.0000 | 0.0000 | FAIL |
| W279 | 1000.00 | 5001.00 | No | Mon | 0.0000 | 1.0000 | FAIL |
| W280 | 1000.00 | 5001.00 | No | Sat | 0.0000 | 1.0000 | FAIL |

### 2.3 Test Results Summary

| Result | Number of tests |
|---|---:|
| Total tests | 280 |
| Passed | 56 |
| Failed | 224 |

All **140 student tests failed**: on the tested weekday the method charged 0.1% rather than 0%, and on the tested weekend it charged 0% rather than 0.1%. Among the **140 non-student tests**, 56 passed (balances from $1,000 up to but excluding $5,000) and 84 failed (balances below $1,000 or at least $5,000).

| Test group | Tests | Passed | Failed |
|---|---:|---:|---:|
| Students, Monday | 70 | 0 | 70 |
| Students, Saturday | 70 | 0 | 70 |
| Non-students, balance < $1,000 | 56 | 0 | 56 |
| Non-students, $1,000 ≤ balance < $5,000 | 56 | 56 | 0 |
| Non-students, balance ≥ $5,000 | 28 | 0 | 28 |
| **Total** | **280** | **56** | **224** |

### 2.4 Fault Localization

The table groups cases that exhibit the same incorrect behavior. These are suspected faults within `bank.utils.FeesCalculator.calculateWithdrawalFee()`, inferred from the output.

| Fault ID | Affected test cases | Suspected problem | Evidence |
|---|---|---|---|
| WF-01 | All student Monday and Saturday cases (140 tests) | Weekday/weekend fee logic appears reversed for student clients. | W001: $20 on Monday expected $0.0000, actual $0.0200; W002: $20 on Saturday expected $0.0200, actual $0.0000. The same pattern occurs at every tested balance and amount. |
| WF-02 | Non-students with balance < $1,000 | Incorrect low-balance fee rate, apparently 0.2% instead of 0.3%. | W003: amount $20 and balance −$1 expected $0.0600, actual $0.0400; W011: amount $20 and balance $500 shows the same 0.2%-rather-than-0.3% pattern. |
| WF-03 | Non-students with balance ≥ $5,000 | High-balance fee exemption is not applied; the implementation apparently charges 0.1% instead of 0%. | W035: amount $20 and balance $5,000 expected $0.0000, actual $0.0200; W039: balance $5,001 has the same discrepancy. |

**Fault counts:** WF-01 accounts for 140 failed student cases (70 weekday plus 70 weekend); WF-02 for 56 failed low-balance non-student cases; and WF-03 for 28 failed high-balance non-student cases. Together these explain 224 observed failures. Cases with a non-student balance from $1,000 through $4,999 passed.

**Conclusion:** The test suite shows repeated differences between the specified and implemented withdrawal fee rules. The failures indicate an apparent student-day reversal and incorrect non-student handling below $1,000 and at or above $5,000.

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
