
## Session


## Withdrawal


## Deposit

### Process and Assumptions:

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

### Test Cases:

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

### Test Results:

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



## Transfer