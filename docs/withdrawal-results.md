# Withdrawal boundary cases and executed results

See [assignment1.md, section 2](assignment1.md#2-withdrawal) for the domains, full Cartesian-product derivation, specification rules, and explicit invalid-input assumption. Executed on Java 11, November 7, 2026. Actual amounts below are captured from the production method during JUnit execution. WF-04 means an assumption-based rejection check, not a confirmed fee-rule violation.

| ID | Amount | Balance | Student | Day | Expected | Actual | Result | Fault group |
|---|---:|---:|:---:|---:|---|---|:---:|---|
| W001 | -0.01 | -0.01 | Yes | 0 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W002 | -0.01 | -0.01 | Yes | 1 | IllegalArgumentException (assumed) | -0.000000000 | FAIL | WF-04 |
| W003 | -0.01 | -0.01 | Yes | 2 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W004 | -0.01 | -0.01 | Yes | 3 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W005 | -0.01 | -0.01 | Yes | 4 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W006 | -0.01 | -0.01 | Yes | 5 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W007 | -0.01 | -0.01 | Yes | 6 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W008 | -0.01 | -0.01 | Yes | 7 | IllegalArgumentException (assumed) | -0.000000000 | FAIL | WF-04 |
| W009 | -0.01 | -0.01 | Yes | 8 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W010 | -0.01 | -0.01 | No | 0 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W011 | -0.01 | -0.01 | No | 1 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W012 | -0.01 | -0.01 | No | 2 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W013 | -0.01 | -0.01 | No | 3 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W014 | -0.01 | -0.01 | No | 4 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W015 | -0.01 | -0.01 | No | 5 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W016 | -0.01 | -0.01 | No | 6 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W017 | -0.01 | -0.01 | No | 7 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W018 | -0.01 | -0.01 | No | 8 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W019 | -0.01 | 0.00 | Yes | 0 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W020 | -0.01 | 0.00 | Yes | 1 | IllegalArgumentException (assumed) | -0.000000000 | FAIL | WF-04 |
| W021 | -0.01 | 0.00 | Yes | 2 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W022 | -0.01 | 0.00 | Yes | 3 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W023 | -0.01 | 0.00 | Yes | 4 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W024 | -0.01 | 0.00 | Yes | 5 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W025 | -0.01 | 0.00 | Yes | 6 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W026 | -0.01 | 0.00 | Yes | 7 | IllegalArgumentException (assumed) | -0.000000000 | FAIL | WF-04 |
| W027 | -0.01 | 0.00 | Yes | 8 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W028 | -0.01 | 0.00 | No | 0 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W029 | -0.01 | 0.00 | No | 1 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W030 | -0.01 | 0.00 | No | 2 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W031 | -0.01 | 0.00 | No | 3 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W032 | -0.01 | 0.00 | No | 4 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W033 | -0.01 | 0.00 | No | 5 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W034 | -0.01 | 0.00 | No | 6 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W035 | -0.01 | 0.00 | No | 7 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W036 | -0.01 | 0.00 | No | 8 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W037 | -0.01 | 0.01 | Yes | 0 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W038 | -0.01 | 0.01 | Yes | 1 | IllegalArgumentException (assumed) | -0.000000000 | FAIL | WF-04 |
| W039 | -0.01 | 0.01 | Yes | 2 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W040 | -0.01 | 0.01 | Yes | 3 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W041 | -0.01 | 0.01 | Yes | 4 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W042 | -0.01 | 0.01 | Yes | 5 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W043 | -0.01 | 0.01 | Yes | 6 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W044 | -0.01 | 0.01 | Yes | 7 | IllegalArgumentException (assumed) | -0.000000000 | FAIL | WF-04 |
| W045 | -0.01 | 0.01 | Yes | 8 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W046 | -0.01 | 0.01 | No | 0 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W047 | -0.01 | 0.01 | No | 1 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W048 | -0.01 | 0.01 | No | 2 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W049 | -0.01 | 0.01 | No | 3 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W050 | -0.01 | 0.01 | No | 4 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W051 | -0.01 | 0.01 | No | 5 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W052 | -0.01 | 0.01 | No | 6 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W053 | -0.01 | 0.01 | No | 7 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W054 | -0.01 | 0.01 | No | 8 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W055 | -0.01 | 999.99 | Yes | 0 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W056 | -0.01 | 999.99 | Yes | 1 | IllegalArgumentException (assumed) | -0.000000000 | FAIL | WF-04 |
| W057 | -0.01 | 999.99 | Yes | 2 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W058 | -0.01 | 999.99 | Yes | 3 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W059 | -0.01 | 999.99 | Yes | 4 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W060 | -0.01 | 999.99 | Yes | 5 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W061 | -0.01 | 999.99 | Yes | 6 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W062 | -0.01 | 999.99 | Yes | 7 | IllegalArgumentException (assumed) | -0.000000000 | FAIL | WF-04 |
| W063 | -0.01 | 999.99 | Yes | 8 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W064 | -0.01 | 999.99 | No | 0 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W065 | -0.01 | 999.99 | No | 1 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W066 | -0.01 | 999.99 | No | 2 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W067 | -0.01 | 999.99 | No | 3 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W068 | -0.01 | 999.99 | No | 4 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W069 | -0.01 | 999.99 | No | 5 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W070 | -0.01 | 999.99 | No | 6 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W071 | -0.01 | 999.99 | No | 7 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W072 | -0.01 | 999.99 | No | 8 | IllegalArgumentException (assumed) | -0.000020000 | FAIL | WF-04 |
| W073 | -0.01 | 1000.00 | Yes | 0 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W074 | -0.01 | 1000.00 | Yes | 1 | IllegalArgumentException (assumed) | -0.000000000 | FAIL | WF-04 |
| W075 | -0.01 | 1000.00 | Yes | 2 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W076 | -0.01 | 1000.00 | Yes | 3 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W077 | -0.01 | 1000.00 | Yes | 4 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W078 | -0.01 | 1000.00 | Yes | 5 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W079 | -0.01 | 1000.00 | Yes | 6 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W080 | -0.01 | 1000.00 | Yes | 7 | IllegalArgumentException (assumed) | -0.000000000 | FAIL | WF-04 |
| W081 | -0.01 | 1000.00 | Yes | 8 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W082 | -0.01 | 1000.00 | No | 0 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W083 | -0.01 | 1000.00 | No | 1 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W084 | -0.01 | 1000.00 | No | 2 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W085 | -0.01 | 1000.00 | No | 3 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W086 | -0.01 | 1000.00 | No | 4 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W087 | -0.01 | 1000.00 | No | 5 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W088 | -0.01 | 1000.00 | No | 6 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W089 | -0.01 | 1000.00 | No | 7 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W090 | -0.01 | 1000.00 | No | 8 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W091 | -0.01 | 1000.01 | Yes | 0 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W092 | -0.01 | 1000.01 | Yes | 1 | IllegalArgumentException (assumed) | -0.000000000 | FAIL | WF-04 |
| W093 | -0.01 | 1000.01 | Yes | 2 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W094 | -0.01 | 1000.01 | Yes | 3 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W095 | -0.01 | 1000.01 | Yes | 4 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W096 | -0.01 | 1000.01 | Yes | 5 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W097 | -0.01 | 1000.01 | Yes | 6 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W098 | -0.01 | 1000.01 | Yes | 7 | IllegalArgumentException (assumed) | -0.000000000 | FAIL | WF-04 |
| W099 | -0.01 | 1000.01 | Yes | 8 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W100 | -0.01 | 1000.01 | No | 0 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W101 | -0.01 | 1000.01 | No | 1 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W102 | -0.01 | 1000.01 | No | 2 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W103 | -0.01 | 1000.01 | No | 3 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W104 | -0.01 | 1000.01 | No | 4 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W105 | -0.01 | 1000.01 | No | 5 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W106 | -0.01 | 1000.01 | No | 6 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W107 | -0.01 | 1000.01 | No | 7 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W108 | -0.01 | 1000.01 | No | 8 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W109 | -0.01 | 3000.00 | Yes | 0 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W110 | -0.01 | 3000.00 | Yes | 1 | IllegalArgumentException (assumed) | -0.000000000 | FAIL | WF-04 |
| W111 | -0.01 | 3000.00 | Yes | 2 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W112 | -0.01 | 3000.00 | Yes | 3 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W113 | -0.01 | 3000.00 | Yes | 4 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W114 | -0.01 | 3000.00 | Yes | 5 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W115 | -0.01 | 3000.00 | Yes | 6 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W116 | -0.01 | 3000.00 | Yes | 7 | IllegalArgumentException (assumed) | -0.000000000 | FAIL | WF-04 |
| W117 | -0.01 | 3000.00 | Yes | 8 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W118 | -0.01 | 3000.00 | No | 0 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W119 | -0.01 | 3000.00 | No | 1 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W120 | -0.01 | 3000.00 | No | 2 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W121 | -0.01 | 3000.00 | No | 3 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W122 | -0.01 | 3000.00 | No | 4 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W123 | -0.01 | 3000.00 | No | 5 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W124 | -0.01 | 3000.00 | No | 6 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W125 | -0.01 | 3000.00 | No | 7 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W126 | -0.01 | 3000.00 | No | 8 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W127 | -0.01 | 4999.99 | Yes | 0 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W128 | -0.01 | 4999.99 | Yes | 1 | IllegalArgumentException (assumed) | -0.000000000 | FAIL | WF-04 |
| W129 | -0.01 | 4999.99 | Yes | 2 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W130 | -0.01 | 4999.99 | Yes | 3 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W131 | -0.01 | 4999.99 | Yes | 4 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W132 | -0.01 | 4999.99 | Yes | 5 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W133 | -0.01 | 4999.99 | Yes | 6 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W134 | -0.01 | 4999.99 | Yes | 7 | IllegalArgumentException (assumed) | -0.000000000 | FAIL | WF-04 |
| W135 | -0.01 | 4999.99 | Yes | 8 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W136 | -0.01 | 4999.99 | No | 0 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W137 | -0.01 | 4999.99 | No | 1 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W138 | -0.01 | 4999.99 | No | 2 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W139 | -0.01 | 4999.99 | No | 3 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W140 | -0.01 | 4999.99 | No | 4 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W141 | -0.01 | 4999.99 | No | 5 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W142 | -0.01 | 4999.99 | No | 6 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W143 | -0.01 | 4999.99 | No | 7 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W144 | -0.01 | 4999.99 | No | 8 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W145 | -0.01 | 5000.00 | Yes | 0 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W146 | -0.01 | 5000.00 | Yes | 1 | IllegalArgumentException (assumed) | -0.000000000 | FAIL | WF-04 |
| W147 | -0.01 | 5000.00 | Yes | 2 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W148 | -0.01 | 5000.00 | Yes | 3 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W149 | -0.01 | 5000.00 | Yes | 4 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W150 | -0.01 | 5000.00 | Yes | 5 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W151 | -0.01 | 5000.00 | Yes | 6 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W152 | -0.01 | 5000.00 | Yes | 7 | IllegalArgumentException (assumed) | -0.000000000 | FAIL | WF-04 |
| W153 | -0.01 | 5000.00 | Yes | 8 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W154 | -0.01 | 5000.00 | No | 0 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W155 | -0.01 | 5000.00 | No | 1 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W156 | -0.01 | 5000.00 | No | 2 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W157 | -0.01 | 5000.00 | No | 3 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W158 | -0.01 | 5000.00 | No | 4 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W159 | -0.01 | 5000.00 | No | 5 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W160 | -0.01 | 5000.00 | No | 6 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W161 | -0.01 | 5000.00 | No | 7 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W162 | -0.01 | 5000.00 | No | 8 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W163 | -0.01 | 5000.01 | Yes | 0 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W164 | -0.01 | 5000.01 | Yes | 1 | IllegalArgumentException (assumed) | -0.000000000 | FAIL | WF-04 |
| W165 | -0.01 | 5000.01 | Yes | 2 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W166 | -0.01 | 5000.01 | Yes | 3 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W167 | -0.01 | 5000.01 | Yes | 4 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W168 | -0.01 | 5000.01 | Yes | 5 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W169 | -0.01 | 5000.01 | Yes | 6 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W170 | -0.01 | 5000.01 | Yes | 7 | IllegalArgumentException (assumed) | -0.000000000 | FAIL | WF-04 |
| W171 | -0.01 | 5000.01 | Yes | 8 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W172 | -0.01 | 5000.01 | No | 0 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W173 | -0.01 | 5000.01 | No | 1 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W174 | -0.01 | 5000.01 | No | 2 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W175 | -0.01 | 5000.01 | No | 3 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W176 | -0.01 | 5000.01 | No | 4 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W177 | -0.01 | 5000.01 | No | 5 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W178 | -0.01 | 5000.01 | No | 6 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W179 | -0.01 | 5000.01 | No | 7 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W180 | -0.01 | 5000.01 | No | 8 | IllegalArgumentException (assumed) | -0.000010000 | FAIL | WF-04 |
| W181 | 0.00 | -0.01 | Yes | 0 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W182 | 0.00 | -0.01 | Yes | 1 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W183 | 0.00 | -0.01 | Yes | 2 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W184 | 0.00 | -0.01 | Yes | 3 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W185 | 0.00 | -0.01 | Yes | 4 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W186 | 0.00 | -0.01 | Yes | 5 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W187 | 0.00 | -0.01 | Yes | 6 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W188 | 0.00 | -0.01 | Yes | 7 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W189 | 0.00 | -0.01 | Yes | 8 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W190 | 0.00 | -0.01 | No | 0 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W191 | 0.00 | -0.01 | No | 1 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W192 | 0.00 | -0.01 | No | 2 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W193 | 0.00 | -0.01 | No | 3 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W194 | 0.00 | -0.01 | No | 4 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W195 | 0.00 | -0.01 | No | 5 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W196 | 0.00 | -0.01 | No | 6 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W197 | 0.00 | -0.01 | No | 7 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W198 | 0.00 | -0.01 | No | 8 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W199 | 0.00 | 0.00 | Yes | 0 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W200 | 0.00 | 0.00 | Yes | 1 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W201 | 0.00 | 0.00 | Yes | 2 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W202 | 0.00 | 0.00 | Yes | 3 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W203 | 0.00 | 0.00 | Yes | 4 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W204 | 0.00 | 0.00 | Yes | 5 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W205 | 0.00 | 0.00 | Yes | 6 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W206 | 0.00 | 0.00 | Yes | 7 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W207 | 0.00 | 0.00 | Yes | 8 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W208 | 0.00 | 0.00 | No | 0 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W209 | 0.00 | 0.00 | No | 1 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W210 | 0.00 | 0.00 | No | 2 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W211 | 0.00 | 0.00 | No | 3 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W212 | 0.00 | 0.00 | No | 4 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W213 | 0.00 | 0.00 | No | 5 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W214 | 0.00 | 0.00 | No | 6 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W215 | 0.00 | 0.00 | No | 7 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W216 | 0.00 | 0.00 | No | 8 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W217 | 0.00 | 0.01 | Yes | 0 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W218 | 0.00 | 0.01 | Yes | 1 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W219 | 0.00 | 0.01 | Yes | 2 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W220 | 0.00 | 0.01 | Yes | 3 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W221 | 0.00 | 0.01 | Yes | 4 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W222 | 0.00 | 0.01 | Yes | 5 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W223 | 0.00 | 0.01 | Yes | 6 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W224 | 0.00 | 0.01 | Yes | 7 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W225 | 0.00 | 0.01 | Yes | 8 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W226 | 0.00 | 0.01 | No | 0 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W227 | 0.00 | 0.01 | No | 1 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W228 | 0.00 | 0.01 | No | 2 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W229 | 0.00 | 0.01 | No | 3 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W230 | 0.00 | 0.01 | No | 4 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W231 | 0.00 | 0.01 | No | 5 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W232 | 0.00 | 0.01 | No | 6 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W233 | 0.00 | 0.01 | No | 7 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W234 | 0.00 | 0.01 | No | 8 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W235 | 0.00 | 999.99 | Yes | 0 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W236 | 0.00 | 999.99 | Yes | 1 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W237 | 0.00 | 999.99 | Yes | 2 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W238 | 0.00 | 999.99 | Yes | 3 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W239 | 0.00 | 999.99 | Yes | 4 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W240 | 0.00 | 999.99 | Yes | 5 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W241 | 0.00 | 999.99 | Yes | 6 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W242 | 0.00 | 999.99 | Yes | 7 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W243 | 0.00 | 999.99 | Yes | 8 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W244 | 0.00 | 999.99 | No | 0 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W245 | 0.00 | 999.99 | No | 1 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W246 | 0.00 | 999.99 | No | 2 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W247 | 0.00 | 999.99 | No | 3 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W248 | 0.00 | 999.99 | No | 4 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W249 | 0.00 | 999.99 | No | 5 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W250 | 0.00 | 999.99 | No | 6 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W251 | 0.00 | 999.99 | No | 7 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W252 | 0.00 | 999.99 | No | 8 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W253 | 0.00 | 1000.00 | Yes | 0 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W254 | 0.00 | 1000.00 | Yes | 1 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W255 | 0.00 | 1000.00 | Yes | 2 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W256 | 0.00 | 1000.00 | Yes | 3 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W257 | 0.00 | 1000.00 | Yes | 4 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W258 | 0.00 | 1000.00 | Yes | 5 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W259 | 0.00 | 1000.00 | Yes | 6 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W260 | 0.00 | 1000.00 | Yes | 7 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W261 | 0.00 | 1000.00 | Yes | 8 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W262 | 0.00 | 1000.00 | No | 0 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W263 | 0.00 | 1000.00 | No | 1 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W264 | 0.00 | 1000.00 | No | 2 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W265 | 0.00 | 1000.00 | No | 3 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W266 | 0.00 | 1000.00 | No | 4 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W267 | 0.00 | 1000.00 | No | 5 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W268 | 0.00 | 1000.00 | No | 6 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W269 | 0.00 | 1000.00 | No | 7 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W270 | 0.00 | 1000.00 | No | 8 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W271 | 0.00 | 1000.01 | Yes | 0 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W272 | 0.00 | 1000.01 | Yes | 1 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W273 | 0.00 | 1000.01 | Yes | 2 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W274 | 0.00 | 1000.01 | Yes | 3 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W275 | 0.00 | 1000.01 | Yes | 4 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W276 | 0.00 | 1000.01 | Yes | 5 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W277 | 0.00 | 1000.01 | Yes | 6 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W278 | 0.00 | 1000.01 | Yes | 7 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W279 | 0.00 | 1000.01 | Yes | 8 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W280 | 0.00 | 1000.01 | No | 0 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W281 | 0.00 | 1000.01 | No | 1 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W282 | 0.00 | 1000.01 | No | 2 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W283 | 0.00 | 1000.01 | No | 3 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W284 | 0.00 | 1000.01 | No | 4 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W285 | 0.00 | 1000.01 | No | 5 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W286 | 0.00 | 1000.01 | No | 6 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W287 | 0.00 | 1000.01 | No | 7 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W288 | 0.00 | 1000.01 | No | 8 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W289 | 0.00 | 3000.00 | Yes | 0 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W290 | 0.00 | 3000.00 | Yes | 1 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W291 | 0.00 | 3000.00 | Yes | 2 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W292 | 0.00 | 3000.00 | Yes | 3 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W293 | 0.00 | 3000.00 | Yes | 4 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W294 | 0.00 | 3000.00 | Yes | 5 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W295 | 0.00 | 3000.00 | Yes | 6 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W296 | 0.00 | 3000.00 | Yes | 7 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W297 | 0.00 | 3000.00 | Yes | 8 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W298 | 0.00 | 3000.00 | No | 0 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W299 | 0.00 | 3000.00 | No | 1 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W300 | 0.00 | 3000.00 | No | 2 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W301 | 0.00 | 3000.00 | No | 3 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W302 | 0.00 | 3000.00 | No | 4 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W303 | 0.00 | 3000.00 | No | 5 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W304 | 0.00 | 3000.00 | No | 6 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W305 | 0.00 | 3000.00 | No | 7 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W306 | 0.00 | 3000.00 | No | 8 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W307 | 0.00 | 4999.99 | Yes | 0 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W308 | 0.00 | 4999.99 | Yes | 1 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W309 | 0.00 | 4999.99 | Yes | 2 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W310 | 0.00 | 4999.99 | Yes | 3 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W311 | 0.00 | 4999.99 | Yes | 4 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W312 | 0.00 | 4999.99 | Yes | 5 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W313 | 0.00 | 4999.99 | Yes | 6 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W314 | 0.00 | 4999.99 | Yes | 7 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W315 | 0.00 | 4999.99 | Yes | 8 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W316 | 0.00 | 4999.99 | No | 0 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W317 | 0.00 | 4999.99 | No | 1 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W318 | 0.00 | 4999.99 | No | 2 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W319 | 0.00 | 4999.99 | No | 3 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W320 | 0.00 | 4999.99 | No | 4 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W321 | 0.00 | 4999.99 | No | 5 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W322 | 0.00 | 4999.99 | No | 6 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W323 | 0.00 | 4999.99 | No | 7 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W324 | 0.00 | 4999.99 | No | 8 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W325 | 0.00 | 5000.00 | Yes | 0 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W326 | 0.00 | 5000.00 | Yes | 1 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W327 | 0.00 | 5000.00 | Yes | 2 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W328 | 0.00 | 5000.00 | Yes | 3 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W329 | 0.00 | 5000.00 | Yes | 4 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W330 | 0.00 | 5000.00 | Yes | 5 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W331 | 0.00 | 5000.00 | Yes | 6 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W332 | 0.00 | 5000.00 | Yes | 7 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W333 | 0.00 | 5000.00 | Yes | 8 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W334 | 0.00 | 5000.00 | No | 0 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W335 | 0.00 | 5000.00 | No | 1 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W336 | 0.00 | 5000.00 | No | 2 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W337 | 0.00 | 5000.00 | No | 3 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W338 | 0.00 | 5000.00 | No | 4 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W339 | 0.00 | 5000.00 | No | 5 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W340 | 0.00 | 5000.00 | No | 6 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W341 | 0.00 | 5000.00 | No | 7 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W342 | 0.00 | 5000.00 | No | 8 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W343 | 0.00 | 5000.01 | Yes | 0 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W344 | 0.00 | 5000.01 | Yes | 1 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W345 | 0.00 | 5000.01 | Yes | 2 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W346 | 0.00 | 5000.01 | Yes | 3 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W347 | 0.00 | 5000.01 | Yes | 4 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W348 | 0.00 | 5000.01 | Yes | 5 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W349 | 0.00 | 5000.01 | Yes | 6 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W350 | 0.00 | 5000.01 | Yes | 7 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W351 | 0.00 | 5000.01 | Yes | 8 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W352 | 0.00 | 5000.01 | No | 0 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W353 | 0.00 | 5000.01 | No | 1 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W354 | 0.00 | 5000.01 | No | 2 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W355 | 0.00 | 5000.01 | No | 3 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W356 | 0.00 | 5000.01 | No | 4 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W357 | 0.00 | 5000.01 | No | 5 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W358 | 0.00 | 5000.01 | No | 6 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W359 | 0.00 | 5000.01 | No | 7 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W360 | 0.00 | 5000.01 | No | 8 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W361 | 0.01 | -0.01 | Yes | 0 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W362 | 0.01 | -0.01 | Yes | 1 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W363 | 0.01 | -0.01 | Yes | 2 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W364 | 0.01 | -0.01 | Yes | 3 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W365 | 0.01 | -0.01 | Yes | 4 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W366 | 0.01 | -0.01 | Yes | 5 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W367 | 0.01 | -0.01 | Yes | 6 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W368 | 0.01 | -0.01 | Yes | 7 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W369 | 0.01 | -0.01 | Yes | 8 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W370 | 0.01 | -0.01 | No | 0 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W371 | 0.01 | -0.01 | No | 1 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W372 | 0.01 | -0.01 | No | 2 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W373 | 0.01 | -0.01 | No | 3 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W374 | 0.01 | -0.01 | No | 4 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W375 | 0.01 | -0.01 | No | 5 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W376 | 0.01 | -0.01 | No | 6 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W377 | 0.01 | -0.01 | No | 7 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W378 | 0.01 | -0.01 | No | 8 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W379 | 0.01 | 0.00 | Yes | 0 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W380 | 0.01 | 0.00 | Yes | 1 | 0.000010000 | 0.000000000 | FAIL | WF-01 |
| W381 | 0.01 | 0.00 | Yes | 2 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W382 | 0.01 | 0.00 | Yes | 3 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W383 | 0.01 | 0.00 | Yes | 4 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W384 | 0.01 | 0.00 | Yes | 5 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W385 | 0.01 | 0.00 | Yes | 6 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W386 | 0.01 | 0.00 | Yes | 7 | 0.000010000 | 0.000000000 | FAIL | WF-01 |
| W387 | 0.01 | 0.00 | Yes | 8 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W388 | 0.01 | 0.00 | No | 0 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W389 | 0.01 | 0.00 | No | 1 | 0.000030000 | 0.000020000 | FAIL | WF-02 |
| W390 | 0.01 | 0.00 | No | 2 | 0.000030000 | 0.000020000 | FAIL | WF-02 |
| W391 | 0.01 | 0.00 | No | 3 | 0.000030000 | 0.000020000 | FAIL | WF-02 |
| W392 | 0.01 | 0.00 | No | 4 | 0.000030000 | 0.000020000 | FAIL | WF-02 |
| W393 | 0.01 | 0.00 | No | 5 | 0.000030000 | 0.000020000 | FAIL | WF-02 |
| W394 | 0.01 | 0.00 | No | 6 | 0.000030000 | 0.000020000 | FAIL | WF-02 |
| W395 | 0.01 | 0.00 | No | 7 | 0.000030000 | 0.000020000 | FAIL | WF-02 |
| W396 | 0.01 | 0.00 | No | 8 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W397 | 0.01 | 0.01 | Yes | 0 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W398 | 0.01 | 0.01 | Yes | 1 | 0.000010000 | 0.000000000 | FAIL | WF-01 |
| W399 | 0.01 | 0.01 | Yes | 2 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W400 | 0.01 | 0.01 | Yes | 3 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W401 | 0.01 | 0.01 | Yes | 4 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W402 | 0.01 | 0.01 | Yes | 5 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W403 | 0.01 | 0.01 | Yes | 6 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W404 | 0.01 | 0.01 | Yes | 7 | 0.000010000 | 0.000000000 | FAIL | WF-01 |
| W405 | 0.01 | 0.01 | Yes | 8 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W406 | 0.01 | 0.01 | No | 0 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W407 | 0.01 | 0.01 | No | 1 | 0.000030000 | 0.000020000 | FAIL | WF-02 |
| W408 | 0.01 | 0.01 | No | 2 | 0.000030000 | 0.000020000 | FAIL | WF-02 |
| W409 | 0.01 | 0.01 | No | 3 | 0.000030000 | 0.000020000 | FAIL | WF-02 |
| W410 | 0.01 | 0.01 | No | 4 | 0.000030000 | 0.000020000 | FAIL | WF-02 |
| W411 | 0.01 | 0.01 | No | 5 | 0.000030000 | 0.000020000 | FAIL | WF-02 |
| W412 | 0.01 | 0.01 | No | 6 | 0.000030000 | 0.000020000 | FAIL | WF-02 |
| W413 | 0.01 | 0.01 | No | 7 | 0.000030000 | 0.000020000 | FAIL | WF-02 |
| W414 | 0.01 | 0.01 | No | 8 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W415 | 0.01 | 999.99 | Yes | 0 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W416 | 0.01 | 999.99 | Yes | 1 | 0.000010000 | 0.000000000 | FAIL | WF-01 |
| W417 | 0.01 | 999.99 | Yes | 2 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W418 | 0.01 | 999.99 | Yes | 3 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W419 | 0.01 | 999.99 | Yes | 4 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W420 | 0.01 | 999.99 | Yes | 5 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W421 | 0.01 | 999.99 | Yes | 6 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W422 | 0.01 | 999.99 | Yes | 7 | 0.000010000 | 0.000000000 | FAIL | WF-01 |
| W423 | 0.01 | 999.99 | Yes | 8 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W424 | 0.01 | 999.99 | No | 0 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W425 | 0.01 | 999.99 | No | 1 | 0.000030000 | 0.000020000 | FAIL | WF-02 |
| W426 | 0.01 | 999.99 | No | 2 | 0.000030000 | 0.000020000 | FAIL | WF-02 |
| W427 | 0.01 | 999.99 | No | 3 | 0.000030000 | 0.000020000 | FAIL | WF-02 |
| W428 | 0.01 | 999.99 | No | 4 | 0.000030000 | 0.000020000 | FAIL | WF-02 |
| W429 | 0.01 | 999.99 | No | 5 | 0.000030000 | 0.000020000 | FAIL | WF-02 |
| W430 | 0.01 | 999.99 | No | 6 | 0.000030000 | 0.000020000 | FAIL | WF-02 |
| W431 | 0.01 | 999.99 | No | 7 | 0.000030000 | 0.000020000 | FAIL | WF-02 |
| W432 | 0.01 | 999.99 | No | 8 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W433 | 0.01 | 1000.00 | Yes | 0 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W434 | 0.01 | 1000.00 | Yes | 1 | 0.000010000 | 0.000000000 | FAIL | WF-01 |
| W435 | 0.01 | 1000.00 | Yes | 2 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W436 | 0.01 | 1000.00 | Yes | 3 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W437 | 0.01 | 1000.00 | Yes | 4 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W438 | 0.01 | 1000.00 | Yes | 5 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W439 | 0.01 | 1000.00 | Yes | 6 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W440 | 0.01 | 1000.00 | Yes | 7 | 0.000010000 | 0.000000000 | FAIL | WF-01 |
| W441 | 0.01 | 1000.00 | Yes | 8 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W442 | 0.01 | 1000.00 | No | 0 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W443 | 0.01 | 1000.00 | No | 1 | 0.000010000 | 0.000010000 | PASS | — |
| W444 | 0.01 | 1000.00 | No | 2 | 0.000010000 | 0.000010000 | PASS | — |
| W445 | 0.01 | 1000.00 | No | 3 | 0.000010000 | 0.000010000 | PASS | — |
| W446 | 0.01 | 1000.00 | No | 4 | 0.000010000 | 0.000010000 | PASS | — |
| W447 | 0.01 | 1000.00 | No | 5 | 0.000010000 | 0.000010000 | PASS | — |
| W448 | 0.01 | 1000.00 | No | 6 | 0.000010000 | 0.000010000 | PASS | — |
| W449 | 0.01 | 1000.00 | No | 7 | 0.000010000 | 0.000010000 | PASS | — |
| W450 | 0.01 | 1000.00 | No | 8 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W451 | 0.01 | 1000.01 | Yes | 0 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W452 | 0.01 | 1000.01 | Yes | 1 | 0.000010000 | 0.000000000 | FAIL | WF-01 |
| W453 | 0.01 | 1000.01 | Yes | 2 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W454 | 0.01 | 1000.01 | Yes | 3 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W455 | 0.01 | 1000.01 | Yes | 4 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W456 | 0.01 | 1000.01 | Yes | 5 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W457 | 0.01 | 1000.01 | Yes | 6 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W458 | 0.01 | 1000.01 | Yes | 7 | 0.000010000 | 0.000000000 | FAIL | WF-01 |
| W459 | 0.01 | 1000.01 | Yes | 8 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W460 | 0.01 | 1000.01 | No | 0 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W461 | 0.01 | 1000.01 | No | 1 | 0.000010000 | 0.000010000 | PASS | — |
| W462 | 0.01 | 1000.01 | No | 2 | 0.000010000 | 0.000010000 | PASS | — |
| W463 | 0.01 | 1000.01 | No | 3 | 0.000010000 | 0.000010000 | PASS | — |
| W464 | 0.01 | 1000.01 | No | 4 | 0.000010000 | 0.000010000 | PASS | — |
| W465 | 0.01 | 1000.01 | No | 5 | 0.000010000 | 0.000010000 | PASS | — |
| W466 | 0.01 | 1000.01 | No | 6 | 0.000010000 | 0.000010000 | PASS | — |
| W467 | 0.01 | 1000.01 | No | 7 | 0.000010000 | 0.000010000 | PASS | — |
| W468 | 0.01 | 1000.01 | No | 8 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W469 | 0.01 | 3000.00 | Yes | 0 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W470 | 0.01 | 3000.00 | Yes | 1 | 0.000010000 | 0.000000000 | FAIL | WF-01 |
| W471 | 0.01 | 3000.00 | Yes | 2 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W472 | 0.01 | 3000.00 | Yes | 3 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W473 | 0.01 | 3000.00 | Yes | 4 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W474 | 0.01 | 3000.00 | Yes | 5 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W475 | 0.01 | 3000.00 | Yes | 6 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W476 | 0.01 | 3000.00 | Yes | 7 | 0.000010000 | 0.000000000 | FAIL | WF-01 |
| W477 | 0.01 | 3000.00 | Yes | 8 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W478 | 0.01 | 3000.00 | No | 0 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W479 | 0.01 | 3000.00 | No | 1 | 0.000010000 | 0.000010000 | PASS | — |
| W480 | 0.01 | 3000.00 | No | 2 | 0.000010000 | 0.000010000 | PASS | — |
| W481 | 0.01 | 3000.00 | No | 3 | 0.000010000 | 0.000010000 | PASS | — |
| W482 | 0.01 | 3000.00 | No | 4 | 0.000010000 | 0.000010000 | PASS | — |
| W483 | 0.01 | 3000.00 | No | 5 | 0.000010000 | 0.000010000 | PASS | — |
| W484 | 0.01 | 3000.00 | No | 6 | 0.000010000 | 0.000010000 | PASS | — |
| W485 | 0.01 | 3000.00 | No | 7 | 0.000010000 | 0.000010000 | PASS | — |
| W486 | 0.01 | 3000.00 | No | 8 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W487 | 0.01 | 4999.99 | Yes | 0 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W488 | 0.01 | 4999.99 | Yes | 1 | 0.000010000 | 0.000000000 | FAIL | WF-01 |
| W489 | 0.01 | 4999.99 | Yes | 2 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W490 | 0.01 | 4999.99 | Yes | 3 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W491 | 0.01 | 4999.99 | Yes | 4 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W492 | 0.01 | 4999.99 | Yes | 5 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W493 | 0.01 | 4999.99 | Yes | 6 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W494 | 0.01 | 4999.99 | Yes | 7 | 0.000010000 | 0.000000000 | FAIL | WF-01 |
| W495 | 0.01 | 4999.99 | Yes | 8 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W496 | 0.01 | 4999.99 | No | 0 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W497 | 0.01 | 4999.99 | No | 1 | 0.000010000 | 0.000010000 | PASS | — |
| W498 | 0.01 | 4999.99 | No | 2 | 0.000010000 | 0.000010000 | PASS | — |
| W499 | 0.01 | 4999.99 | No | 3 | 0.000010000 | 0.000010000 | PASS | — |
| W500 | 0.01 | 4999.99 | No | 4 | 0.000010000 | 0.000010000 | PASS | — |
| W501 | 0.01 | 4999.99 | No | 5 | 0.000010000 | 0.000010000 | PASS | — |
| W502 | 0.01 | 4999.99 | No | 6 | 0.000010000 | 0.000010000 | PASS | — |
| W503 | 0.01 | 4999.99 | No | 7 | 0.000010000 | 0.000010000 | PASS | — |
| W504 | 0.01 | 4999.99 | No | 8 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W505 | 0.01 | 5000.00 | Yes | 0 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W506 | 0.01 | 5000.00 | Yes | 1 | 0.000010000 | 0.000000000 | FAIL | WF-01 |
| W507 | 0.01 | 5000.00 | Yes | 2 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W508 | 0.01 | 5000.00 | Yes | 3 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W509 | 0.01 | 5000.00 | Yes | 4 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W510 | 0.01 | 5000.00 | Yes | 5 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W511 | 0.01 | 5000.00 | Yes | 6 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W512 | 0.01 | 5000.00 | Yes | 7 | 0.000010000 | 0.000000000 | FAIL | WF-01 |
| W513 | 0.01 | 5000.00 | Yes | 8 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W514 | 0.01 | 5000.00 | No | 0 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W515 | 0.01 | 5000.00 | No | 1 | 0.000000000 | 0.000010000 | FAIL | WF-03 |
| W516 | 0.01 | 5000.00 | No | 2 | 0.000000000 | 0.000010000 | FAIL | WF-03 |
| W517 | 0.01 | 5000.00 | No | 3 | 0.000000000 | 0.000010000 | FAIL | WF-03 |
| W518 | 0.01 | 5000.00 | No | 4 | 0.000000000 | 0.000010000 | FAIL | WF-03 |
| W519 | 0.01 | 5000.00 | No | 5 | 0.000000000 | 0.000010000 | FAIL | WF-03 |
| W520 | 0.01 | 5000.00 | No | 6 | 0.000000000 | 0.000010000 | FAIL | WF-03 |
| W521 | 0.01 | 5000.00 | No | 7 | 0.000000000 | 0.000010000 | FAIL | WF-03 |
| W522 | 0.01 | 5000.00 | No | 8 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W523 | 0.01 | 5000.01 | Yes | 0 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W524 | 0.01 | 5000.01 | Yes | 1 | 0.000010000 | 0.000000000 | FAIL | WF-01 |
| W525 | 0.01 | 5000.01 | Yes | 2 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W526 | 0.01 | 5000.01 | Yes | 3 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W527 | 0.01 | 5000.01 | Yes | 4 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W528 | 0.01 | 5000.01 | Yes | 5 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W529 | 0.01 | 5000.01 | Yes | 6 | 0.000000000 | 0.000010000 | FAIL | WF-01 |
| W530 | 0.01 | 5000.01 | Yes | 7 | 0.000010000 | 0.000000000 | FAIL | WF-01 |
| W531 | 0.01 | 5000.01 | Yes | 8 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W532 | 0.01 | 5000.01 | No | 0 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W533 | 0.01 | 5000.01 | No | 1 | 0.000000000 | 0.000010000 | FAIL | WF-03 |
| W534 | 0.01 | 5000.01 | No | 2 | 0.000000000 | 0.000010000 | FAIL | WF-03 |
| W535 | 0.01 | 5000.01 | No | 3 | 0.000000000 | 0.000010000 | FAIL | WF-03 |
| W536 | 0.01 | 5000.01 | No | 4 | 0.000000000 | 0.000010000 | FAIL | WF-03 |
| W537 | 0.01 | 5000.01 | No | 5 | 0.000000000 | 0.000010000 | FAIL | WF-03 |
| W538 | 0.01 | 5000.01 | No | 6 | 0.000000000 | 0.000010000 | FAIL | WF-03 |
| W539 | 0.01 | 5000.01 | No | 7 | 0.000000000 | 0.000010000 | FAIL | WF-03 |
| W540 | 0.01 | 5000.01 | No | 8 | IllegalArgumentException (assumed) | 0.000010000 | FAIL | WF-04 |
| W541 | 0.02 | -0.01 | Yes | 0 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W542 | 0.02 | -0.01 | Yes | 1 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W543 | 0.02 | -0.01 | Yes | 2 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W544 | 0.02 | -0.01 | Yes | 3 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W545 | 0.02 | -0.01 | Yes | 4 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W546 | 0.02 | -0.01 | Yes | 5 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W547 | 0.02 | -0.01 | Yes | 6 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W548 | 0.02 | -0.01 | Yes | 7 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W549 | 0.02 | -0.01 | Yes | 8 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W550 | 0.02 | -0.01 | No | 0 | IllegalArgumentException (assumed) | 0.000040000 | FAIL | WF-04 |
| W551 | 0.02 | -0.01 | No | 1 | IllegalArgumentException (assumed) | 0.000040000 | FAIL | WF-04 |
| W552 | 0.02 | -0.01 | No | 2 | IllegalArgumentException (assumed) | 0.000040000 | FAIL | WF-04 |
| W553 | 0.02 | -0.01 | No | 3 | IllegalArgumentException (assumed) | 0.000040000 | FAIL | WF-04 |
| W554 | 0.02 | -0.01 | No | 4 | IllegalArgumentException (assumed) | 0.000040000 | FAIL | WF-04 |
| W555 | 0.02 | -0.01 | No | 5 | IllegalArgumentException (assumed) | 0.000040000 | FAIL | WF-04 |
| W556 | 0.02 | -0.01 | No | 6 | IllegalArgumentException (assumed) | 0.000040000 | FAIL | WF-04 |
| W557 | 0.02 | -0.01 | No | 7 | IllegalArgumentException (assumed) | 0.000040000 | FAIL | WF-04 |
| W558 | 0.02 | -0.01 | No | 8 | IllegalArgumentException (assumed) | 0.000040000 | FAIL | WF-04 |
| W559 | 0.02 | 0.00 | Yes | 0 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W560 | 0.02 | 0.00 | Yes | 1 | 0.000020000 | 0.000000000 | FAIL | WF-01 |
| W561 | 0.02 | 0.00 | Yes | 2 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W562 | 0.02 | 0.00 | Yes | 3 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W563 | 0.02 | 0.00 | Yes | 4 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W564 | 0.02 | 0.00 | Yes | 5 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W565 | 0.02 | 0.00 | Yes | 6 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W566 | 0.02 | 0.00 | Yes | 7 | 0.000020000 | 0.000000000 | FAIL | WF-01 |
| W567 | 0.02 | 0.00 | Yes | 8 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W568 | 0.02 | 0.00 | No | 0 | IllegalArgumentException (assumed) | 0.000040000 | FAIL | WF-04 |
| W569 | 0.02 | 0.00 | No | 1 | 0.000060000 | 0.000040000 | FAIL | WF-02 |
| W570 | 0.02 | 0.00 | No | 2 | 0.000060000 | 0.000040000 | FAIL | WF-02 |
| W571 | 0.02 | 0.00 | No | 3 | 0.000060000 | 0.000040000 | FAIL | WF-02 |
| W572 | 0.02 | 0.00 | No | 4 | 0.000060000 | 0.000040000 | FAIL | WF-02 |
| W573 | 0.02 | 0.00 | No | 5 | 0.000060000 | 0.000040000 | FAIL | WF-02 |
| W574 | 0.02 | 0.00 | No | 6 | 0.000060000 | 0.000040000 | FAIL | WF-02 |
| W575 | 0.02 | 0.00 | No | 7 | 0.000060000 | 0.000040000 | FAIL | WF-02 |
| W576 | 0.02 | 0.00 | No | 8 | IllegalArgumentException (assumed) | 0.000040000 | FAIL | WF-04 |
| W577 | 0.02 | 0.01 | Yes | 0 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W578 | 0.02 | 0.01 | Yes | 1 | 0.000020000 | 0.000000000 | FAIL | WF-01 |
| W579 | 0.02 | 0.01 | Yes | 2 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W580 | 0.02 | 0.01 | Yes | 3 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W581 | 0.02 | 0.01 | Yes | 4 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W582 | 0.02 | 0.01 | Yes | 5 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W583 | 0.02 | 0.01 | Yes | 6 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W584 | 0.02 | 0.01 | Yes | 7 | 0.000020000 | 0.000000000 | FAIL | WF-01 |
| W585 | 0.02 | 0.01 | Yes | 8 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W586 | 0.02 | 0.01 | No | 0 | IllegalArgumentException (assumed) | 0.000040000 | FAIL | WF-04 |
| W587 | 0.02 | 0.01 | No | 1 | 0.000060000 | 0.000040000 | FAIL | WF-02 |
| W588 | 0.02 | 0.01 | No | 2 | 0.000060000 | 0.000040000 | FAIL | WF-02 |
| W589 | 0.02 | 0.01 | No | 3 | 0.000060000 | 0.000040000 | FAIL | WF-02 |
| W590 | 0.02 | 0.01 | No | 4 | 0.000060000 | 0.000040000 | FAIL | WF-02 |
| W591 | 0.02 | 0.01 | No | 5 | 0.000060000 | 0.000040000 | FAIL | WF-02 |
| W592 | 0.02 | 0.01 | No | 6 | 0.000060000 | 0.000040000 | FAIL | WF-02 |
| W593 | 0.02 | 0.01 | No | 7 | 0.000060000 | 0.000040000 | FAIL | WF-02 |
| W594 | 0.02 | 0.01 | No | 8 | IllegalArgumentException (assumed) | 0.000040000 | FAIL | WF-04 |
| W595 | 0.02 | 999.99 | Yes | 0 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W596 | 0.02 | 999.99 | Yes | 1 | 0.000020000 | 0.000000000 | FAIL | WF-01 |
| W597 | 0.02 | 999.99 | Yes | 2 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W598 | 0.02 | 999.99 | Yes | 3 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W599 | 0.02 | 999.99 | Yes | 4 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W600 | 0.02 | 999.99 | Yes | 5 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W601 | 0.02 | 999.99 | Yes | 6 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W602 | 0.02 | 999.99 | Yes | 7 | 0.000020000 | 0.000000000 | FAIL | WF-01 |
| W603 | 0.02 | 999.99 | Yes | 8 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W604 | 0.02 | 999.99 | No | 0 | IllegalArgumentException (assumed) | 0.000040000 | FAIL | WF-04 |
| W605 | 0.02 | 999.99 | No | 1 | 0.000060000 | 0.000040000 | FAIL | WF-02 |
| W606 | 0.02 | 999.99 | No | 2 | 0.000060000 | 0.000040000 | FAIL | WF-02 |
| W607 | 0.02 | 999.99 | No | 3 | 0.000060000 | 0.000040000 | FAIL | WF-02 |
| W608 | 0.02 | 999.99 | No | 4 | 0.000060000 | 0.000040000 | FAIL | WF-02 |
| W609 | 0.02 | 999.99 | No | 5 | 0.000060000 | 0.000040000 | FAIL | WF-02 |
| W610 | 0.02 | 999.99 | No | 6 | 0.000060000 | 0.000040000 | FAIL | WF-02 |
| W611 | 0.02 | 999.99 | No | 7 | 0.000060000 | 0.000040000 | FAIL | WF-02 |
| W612 | 0.02 | 999.99 | No | 8 | IllegalArgumentException (assumed) | 0.000040000 | FAIL | WF-04 |
| W613 | 0.02 | 1000.00 | Yes | 0 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W614 | 0.02 | 1000.00 | Yes | 1 | 0.000020000 | 0.000000000 | FAIL | WF-01 |
| W615 | 0.02 | 1000.00 | Yes | 2 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W616 | 0.02 | 1000.00 | Yes | 3 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W617 | 0.02 | 1000.00 | Yes | 4 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W618 | 0.02 | 1000.00 | Yes | 5 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W619 | 0.02 | 1000.00 | Yes | 6 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W620 | 0.02 | 1000.00 | Yes | 7 | 0.000020000 | 0.000000000 | FAIL | WF-01 |
| W621 | 0.02 | 1000.00 | Yes | 8 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W622 | 0.02 | 1000.00 | No | 0 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W623 | 0.02 | 1000.00 | No | 1 | 0.000020000 | 0.000020000 | PASS | — |
| W624 | 0.02 | 1000.00 | No | 2 | 0.000020000 | 0.000020000 | PASS | — |
| W625 | 0.02 | 1000.00 | No | 3 | 0.000020000 | 0.000020000 | PASS | — |
| W626 | 0.02 | 1000.00 | No | 4 | 0.000020000 | 0.000020000 | PASS | — |
| W627 | 0.02 | 1000.00 | No | 5 | 0.000020000 | 0.000020000 | PASS | — |
| W628 | 0.02 | 1000.00 | No | 6 | 0.000020000 | 0.000020000 | PASS | — |
| W629 | 0.02 | 1000.00 | No | 7 | 0.000020000 | 0.000020000 | PASS | — |
| W630 | 0.02 | 1000.00 | No | 8 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W631 | 0.02 | 1000.01 | Yes | 0 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W632 | 0.02 | 1000.01 | Yes | 1 | 0.000020000 | 0.000000000 | FAIL | WF-01 |
| W633 | 0.02 | 1000.01 | Yes | 2 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W634 | 0.02 | 1000.01 | Yes | 3 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W635 | 0.02 | 1000.01 | Yes | 4 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W636 | 0.02 | 1000.01 | Yes | 5 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W637 | 0.02 | 1000.01 | Yes | 6 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W638 | 0.02 | 1000.01 | Yes | 7 | 0.000020000 | 0.000000000 | FAIL | WF-01 |
| W639 | 0.02 | 1000.01 | Yes | 8 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W640 | 0.02 | 1000.01 | No | 0 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W641 | 0.02 | 1000.01 | No | 1 | 0.000020000 | 0.000020000 | PASS | — |
| W642 | 0.02 | 1000.01 | No | 2 | 0.000020000 | 0.000020000 | PASS | — |
| W643 | 0.02 | 1000.01 | No | 3 | 0.000020000 | 0.000020000 | PASS | — |
| W644 | 0.02 | 1000.01 | No | 4 | 0.000020000 | 0.000020000 | PASS | — |
| W645 | 0.02 | 1000.01 | No | 5 | 0.000020000 | 0.000020000 | PASS | — |
| W646 | 0.02 | 1000.01 | No | 6 | 0.000020000 | 0.000020000 | PASS | — |
| W647 | 0.02 | 1000.01 | No | 7 | 0.000020000 | 0.000020000 | PASS | — |
| W648 | 0.02 | 1000.01 | No | 8 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W649 | 0.02 | 3000.00 | Yes | 0 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W650 | 0.02 | 3000.00 | Yes | 1 | 0.000020000 | 0.000000000 | FAIL | WF-01 |
| W651 | 0.02 | 3000.00 | Yes | 2 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W652 | 0.02 | 3000.00 | Yes | 3 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W653 | 0.02 | 3000.00 | Yes | 4 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W654 | 0.02 | 3000.00 | Yes | 5 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W655 | 0.02 | 3000.00 | Yes | 6 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W656 | 0.02 | 3000.00 | Yes | 7 | 0.000020000 | 0.000000000 | FAIL | WF-01 |
| W657 | 0.02 | 3000.00 | Yes | 8 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W658 | 0.02 | 3000.00 | No | 0 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W659 | 0.02 | 3000.00 | No | 1 | 0.000020000 | 0.000020000 | PASS | — |
| W660 | 0.02 | 3000.00 | No | 2 | 0.000020000 | 0.000020000 | PASS | — |
| W661 | 0.02 | 3000.00 | No | 3 | 0.000020000 | 0.000020000 | PASS | — |
| W662 | 0.02 | 3000.00 | No | 4 | 0.000020000 | 0.000020000 | PASS | — |
| W663 | 0.02 | 3000.00 | No | 5 | 0.000020000 | 0.000020000 | PASS | — |
| W664 | 0.02 | 3000.00 | No | 6 | 0.000020000 | 0.000020000 | PASS | — |
| W665 | 0.02 | 3000.00 | No | 7 | 0.000020000 | 0.000020000 | PASS | — |
| W666 | 0.02 | 3000.00 | No | 8 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W667 | 0.02 | 4999.99 | Yes | 0 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W668 | 0.02 | 4999.99 | Yes | 1 | 0.000020000 | 0.000000000 | FAIL | WF-01 |
| W669 | 0.02 | 4999.99 | Yes | 2 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W670 | 0.02 | 4999.99 | Yes | 3 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W671 | 0.02 | 4999.99 | Yes | 4 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W672 | 0.02 | 4999.99 | Yes | 5 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W673 | 0.02 | 4999.99 | Yes | 6 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W674 | 0.02 | 4999.99 | Yes | 7 | 0.000020000 | 0.000000000 | FAIL | WF-01 |
| W675 | 0.02 | 4999.99 | Yes | 8 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W676 | 0.02 | 4999.99 | No | 0 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W677 | 0.02 | 4999.99 | No | 1 | 0.000020000 | 0.000020000 | PASS | — |
| W678 | 0.02 | 4999.99 | No | 2 | 0.000020000 | 0.000020000 | PASS | — |
| W679 | 0.02 | 4999.99 | No | 3 | 0.000020000 | 0.000020000 | PASS | — |
| W680 | 0.02 | 4999.99 | No | 4 | 0.000020000 | 0.000020000 | PASS | — |
| W681 | 0.02 | 4999.99 | No | 5 | 0.000020000 | 0.000020000 | PASS | — |
| W682 | 0.02 | 4999.99 | No | 6 | 0.000020000 | 0.000020000 | PASS | — |
| W683 | 0.02 | 4999.99 | No | 7 | 0.000020000 | 0.000020000 | PASS | — |
| W684 | 0.02 | 4999.99 | No | 8 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W685 | 0.02 | 5000.00 | Yes | 0 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W686 | 0.02 | 5000.00 | Yes | 1 | 0.000020000 | 0.000000000 | FAIL | WF-01 |
| W687 | 0.02 | 5000.00 | Yes | 2 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W688 | 0.02 | 5000.00 | Yes | 3 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W689 | 0.02 | 5000.00 | Yes | 4 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W690 | 0.02 | 5000.00 | Yes | 5 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W691 | 0.02 | 5000.00 | Yes | 6 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W692 | 0.02 | 5000.00 | Yes | 7 | 0.000020000 | 0.000000000 | FAIL | WF-01 |
| W693 | 0.02 | 5000.00 | Yes | 8 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W694 | 0.02 | 5000.00 | No | 0 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W695 | 0.02 | 5000.00 | No | 1 | 0.000000000 | 0.000020000 | FAIL | WF-03 |
| W696 | 0.02 | 5000.00 | No | 2 | 0.000000000 | 0.000020000 | FAIL | WF-03 |
| W697 | 0.02 | 5000.00 | No | 3 | 0.000000000 | 0.000020000 | FAIL | WF-03 |
| W698 | 0.02 | 5000.00 | No | 4 | 0.000000000 | 0.000020000 | FAIL | WF-03 |
| W699 | 0.02 | 5000.00 | No | 5 | 0.000000000 | 0.000020000 | FAIL | WF-03 |
| W700 | 0.02 | 5000.00 | No | 6 | 0.000000000 | 0.000020000 | FAIL | WF-03 |
| W701 | 0.02 | 5000.00 | No | 7 | 0.000000000 | 0.000020000 | FAIL | WF-03 |
| W702 | 0.02 | 5000.00 | No | 8 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W703 | 0.02 | 5000.01 | Yes | 0 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W704 | 0.02 | 5000.01 | Yes | 1 | 0.000020000 | 0.000000000 | FAIL | WF-01 |
| W705 | 0.02 | 5000.01 | Yes | 2 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W706 | 0.02 | 5000.01 | Yes | 3 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W707 | 0.02 | 5000.01 | Yes | 4 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W708 | 0.02 | 5000.01 | Yes | 5 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W709 | 0.02 | 5000.01 | Yes | 6 | 0.000000000 | 0.000020000 | FAIL | WF-01 |
| W710 | 0.02 | 5000.01 | Yes | 7 | 0.000020000 | 0.000000000 | FAIL | WF-01 |
| W711 | 0.02 | 5000.01 | Yes | 8 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W712 | 0.02 | 5000.01 | No | 0 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W713 | 0.02 | 5000.01 | No | 1 | 0.000000000 | 0.000020000 | FAIL | WF-03 |
| W714 | 0.02 | 5000.01 | No | 2 | 0.000000000 | 0.000020000 | FAIL | WF-03 |
| W715 | 0.02 | 5000.01 | No | 3 | 0.000000000 | 0.000020000 | FAIL | WF-03 |
| W716 | 0.02 | 5000.01 | No | 4 | 0.000000000 | 0.000020000 | FAIL | WF-03 |
| W717 | 0.02 | 5000.01 | No | 5 | 0.000000000 | 0.000020000 | FAIL | WF-03 |
| W718 | 0.02 | 5000.01 | No | 6 | 0.000000000 | 0.000020000 | FAIL | WF-03 |
| W719 | 0.02 | 5000.01 | No | 7 | 0.000000000 | 0.000020000 | FAIL | WF-03 |
| W720 | 0.02 | 5000.01 | No | 8 | IllegalArgumentException (assumed) | 0.000020000 | FAIL | WF-04 |
| W721 | 500.00 | -0.01 | Yes | 0 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W722 | 500.00 | -0.01 | Yes | 1 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W723 | 500.00 | -0.01 | Yes | 2 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W724 | 500.00 | -0.01 | Yes | 3 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W725 | 500.00 | -0.01 | Yes | 4 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W726 | 500.00 | -0.01 | Yes | 5 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W727 | 500.00 | -0.01 | Yes | 6 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W728 | 500.00 | -0.01 | Yes | 7 | IllegalArgumentException (assumed) | 0.000000000 | FAIL | WF-04 |
| W729 | 500.00 | -0.01 | Yes | 8 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W730 | 500.00 | -0.01 | No | 0 | IllegalArgumentException (assumed) | 1.000000000 | FAIL | WF-04 |
| W731 | 500.00 | -0.01 | No | 1 | IllegalArgumentException (assumed) | 1.000000000 | FAIL | WF-04 |
| W732 | 500.00 | -0.01 | No | 2 | IllegalArgumentException (assumed) | 1.000000000 | FAIL | WF-04 |
| W733 | 500.00 | -0.01 | No | 3 | IllegalArgumentException (assumed) | 1.000000000 | FAIL | WF-04 |
| W734 | 500.00 | -0.01 | No | 4 | IllegalArgumentException (assumed) | 1.000000000 | FAIL | WF-04 |
| W735 | 500.00 | -0.01 | No | 5 | IllegalArgumentException (assumed) | 1.000000000 | FAIL | WF-04 |
| W736 | 500.00 | -0.01 | No | 6 | IllegalArgumentException (assumed) | 1.000000000 | FAIL | WF-04 |
| W737 | 500.00 | -0.01 | No | 7 | IllegalArgumentException (assumed) | 1.000000000 | FAIL | WF-04 |
| W738 | 500.00 | -0.01 | No | 8 | IllegalArgumentException (assumed) | 1.000000000 | FAIL | WF-04 |
| W739 | 500.00 | 0.00 | Yes | 0 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W740 | 500.00 | 0.00 | Yes | 1 | 0.500000000 | 0.000000000 | FAIL | WF-01 |
| W741 | 500.00 | 0.00 | Yes | 2 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W742 | 500.00 | 0.00 | Yes | 3 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W743 | 500.00 | 0.00 | Yes | 4 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W744 | 500.00 | 0.00 | Yes | 5 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W745 | 500.00 | 0.00 | Yes | 6 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W746 | 500.00 | 0.00 | Yes | 7 | 0.500000000 | 0.000000000 | FAIL | WF-01 |
| W747 | 500.00 | 0.00 | Yes | 8 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W748 | 500.00 | 0.00 | No | 0 | IllegalArgumentException (assumed) | 1.000000000 | FAIL | WF-04 |
| W749 | 500.00 | 0.00 | No | 1 | 1.500000000 | 1.000000000 | FAIL | WF-02 |
| W750 | 500.00 | 0.00 | No | 2 | 1.500000000 | 1.000000000 | FAIL | WF-02 |
| W751 | 500.00 | 0.00 | No | 3 | 1.500000000 | 1.000000000 | FAIL | WF-02 |
| W752 | 500.00 | 0.00 | No | 4 | 1.500000000 | 1.000000000 | FAIL | WF-02 |
| W753 | 500.00 | 0.00 | No | 5 | 1.500000000 | 1.000000000 | FAIL | WF-02 |
| W754 | 500.00 | 0.00 | No | 6 | 1.500000000 | 1.000000000 | FAIL | WF-02 |
| W755 | 500.00 | 0.00 | No | 7 | 1.500000000 | 1.000000000 | FAIL | WF-02 |
| W756 | 500.00 | 0.00 | No | 8 | IllegalArgumentException (assumed) | 1.000000000 | FAIL | WF-04 |
| W757 | 500.00 | 0.01 | Yes | 0 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W758 | 500.00 | 0.01 | Yes | 1 | 0.500000000 | 0.000000000 | FAIL | WF-01 |
| W759 | 500.00 | 0.01 | Yes | 2 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W760 | 500.00 | 0.01 | Yes | 3 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W761 | 500.00 | 0.01 | Yes | 4 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W762 | 500.00 | 0.01 | Yes | 5 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W763 | 500.00 | 0.01 | Yes | 6 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W764 | 500.00 | 0.01 | Yes | 7 | 0.500000000 | 0.000000000 | FAIL | WF-01 |
| W765 | 500.00 | 0.01 | Yes | 8 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W766 | 500.00 | 0.01 | No | 0 | IllegalArgumentException (assumed) | 1.000000000 | FAIL | WF-04 |
| W767 | 500.00 | 0.01 | No | 1 | 1.500000000 | 1.000000000 | FAIL | WF-02 |
| W768 | 500.00 | 0.01 | No | 2 | 1.500000000 | 1.000000000 | FAIL | WF-02 |
| W769 | 500.00 | 0.01 | No | 3 | 1.500000000 | 1.000000000 | FAIL | WF-02 |
| W770 | 500.00 | 0.01 | No | 4 | 1.500000000 | 1.000000000 | FAIL | WF-02 |
| W771 | 500.00 | 0.01 | No | 5 | 1.500000000 | 1.000000000 | FAIL | WF-02 |
| W772 | 500.00 | 0.01 | No | 6 | 1.500000000 | 1.000000000 | FAIL | WF-02 |
| W773 | 500.00 | 0.01 | No | 7 | 1.500000000 | 1.000000000 | FAIL | WF-02 |
| W774 | 500.00 | 0.01 | No | 8 | IllegalArgumentException (assumed) | 1.000000000 | FAIL | WF-04 |
| W775 | 500.00 | 999.99 | Yes | 0 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W776 | 500.00 | 999.99 | Yes | 1 | 0.500000000 | 0.000000000 | FAIL | WF-01 |
| W777 | 500.00 | 999.99 | Yes | 2 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W778 | 500.00 | 999.99 | Yes | 3 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W779 | 500.00 | 999.99 | Yes | 4 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W780 | 500.00 | 999.99 | Yes | 5 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W781 | 500.00 | 999.99 | Yes | 6 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W782 | 500.00 | 999.99 | Yes | 7 | 0.500000000 | 0.000000000 | FAIL | WF-01 |
| W783 | 500.00 | 999.99 | Yes | 8 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W784 | 500.00 | 999.99 | No | 0 | IllegalArgumentException (assumed) | 1.000000000 | FAIL | WF-04 |
| W785 | 500.00 | 999.99 | No | 1 | 1.500000000 | 1.000000000 | FAIL | WF-02 |
| W786 | 500.00 | 999.99 | No | 2 | 1.500000000 | 1.000000000 | FAIL | WF-02 |
| W787 | 500.00 | 999.99 | No | 3 | 1.500000000 | 1.000000000 | FAIL | WF-02 |
| W788 | 500.00 | 999.99 | No | 4 | 1.500000000 | 1.000000000 | FAIL | WF-02 |
| W789 | 500.00 | 999.99 | No | 5 | 1.500000000 | 1.000000000 | FAIL | WF-02 |
| W790 | 500.00 | 999.99 | No | 6 | 1.500000000 | 1.000000000 | FAIL | WF-02 |
| W791 | 500.00 | 999.99 | No | 7 | 1.500000000 | 1.000000000 | FAIL | WF-02 |
| W792 | 500.00 | 999.99 | No | 8 | IllegalArgumentException (assumed) | 1.000000000 | FAIL | WF-04 |
| W793 | 500.00 | 1000.00 | Yes | 0 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W794 | 500.00 | 1000.00 | Yes | 1 | 0.500000000 | 0.000000000 | FAIL | WF-01 |
| W795 | 500.00 | 1000.00 | Yes | 2 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W796 | 500.00 | 1000.00 | Yes | 3 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W797 | 500.00 | 1000.00 | Yes | 4 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W798 | 500.00 | 1000.00 | Yes | 5 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W799 | 500.00 | 1000.00 | Yes | 6 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W800 | 500.00 | 1000.00 | Yes | 7 | 0.500000000 | 0.000000000 | FAIL | WF-01 |
| W801 | 500.00 | 1000.00 | Yes | 8 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W802 | 500.00 | 1000.00 | No | 0 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W803 | 500.00 | 1000.00 | No | 1 | 0.500000000 | 0.500000000 | PASS | — |
| W804 | 500.00 | 1000.00 | No | 2 | 0.500000000 | 0.500000000 | PASS | — |
| W805 | 500.00 | 1000.00 | No | 3 | 0.500000000 | 0.500000000 | PASS | — |
| W806 | 500.00 | 1000.00 | No | 4 | 0.500000000 | 0.500000000 | PASS | — |
| W807 | 500.00 | 1000.00 | No | 5 | 0.500000000 | 0.500000000 | PASS | — |
| W808 | 500.00 | 1000.00 | No | 6 | 0.500000000 | 0.500000000 | PASS | — |
| W809 | 500.00 | 1000.00 | No | 7 | 0.500000000 | 0.500000000 | PASS | — |
| W810 | 500.00 | 1000.00 | No | 8 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W811 | 500.00 | 1000.01 | Yes | 0 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W812 | 500.00 | 1000.01 | Yes | 1 | 0.500000000 | 0.000000000 | FAIL | WF-01 |
| W813 | 500.00 | 1000.01 | Yes | 2 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W814 | 500.00 | 1000.01 | Yes | 3 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W815 | 500.00 | 1000.01 | Yes | 4 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W816 | 500.00 | 1000.01 | Yes | 5 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W817 | 500.00 | 1000.01 | Yes | 6 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W818 | 500.00 | 1000.01 | Yes | 7 | 0.500000000 | 0.000000000 | FAIL | WF-01 |
| W819 | 500.00 | 1000.01 | Yes | 8 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W820 | 500.00 | 1000.01 | No | 0 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W821 | 500.00 | 1000.01 | No | 1 | 0.500000000 | 0.500000000 | PASS | — |
| W822 | 500.00 | 1000.01 | No | 2 | 0.500000000 | 0.500000000 | PASS | — |
| W823 | 500.00 | 1000.01 | No | 3 | 0.500000000 | 0.500000000 | PASS | — |
| W824 | 500.00 | 1000.01 | No | 4 | 0.500000000 | 0.500000000 | PASS | — |
| W825 | 500.00 | 1000.01 | No | 5 | 0.500000000 | 0.500000000 | PASS | — |
| W826 | 500.00 | 1000.01 | No | 6 | 0.500000000 | 0.500000000 | PASS | — |
| W827 | 500.00 | 1000.01 | No | 7 | 0.500000000 | 0.500000000 | PASS | — |
| W828 | 500.00 | 1000.01 | No | 8 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W829 | 500.00 | 3000.00 | Yes | 0 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W830 | 500.00 | 3000.00 | Yes | 1 | 0.500000000 | 0.000000000 | FAIL | WF-01 |
| W831 | 500.00 | 3000.00 | Yes | 2 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W832 | 500.00 | 3000.00 | Yes | 3 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W833 | 500.00 | 3000.00 | Yes | 4 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W834 | 500.00 | 3000.00 | Yes | 5 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W835 | 500.00 | 3000.00 | Yes | 6 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W836 | 500.00 | 3000.00 | Yes | 7 | 0.500000000 | 0.000000000 | FAIL | WF-01 |
| W837 | 500.00 | 3000.00 | Yes | 8 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W838 | 500.00 | 3000.00 | No | 0 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W839 | 500.00 | 3000.00 | No | 1 | 0.500000000 | 0.500000000 | PASS | — |
| W840 | 500.00 | 3000.00 | No | 2 | 0.500000000 | 0.500000000 | PASS | — |
| W841 | 500.00 | 3000.00 | No | 3 | 0.500000000 | 0.500000000 | PASS | — |
| W842 | 500.00 | 3000.00 | No | 4 | 0.500000000 | 0.500000000 | PASS | — |
| W843 | 500.00 | 3000.00 | No | 5 | 0.500000000 | 0.500000000 | PASS | — |
| W844 | 500.00 | 3000.00 | No | 6 | 0.500000000 | 0.500000000 | PASS | — |
| W845 | 500.00 | 3000.00 | No | 7 | 0.500000000 | 0.500000000 | PASS | — |
| W846 | 500.00 | 3000.00 | No | 8 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W847 | 500.00 | 4999.99 | Yes | 0 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W848 | 500.00 | 4999.99 | Yes | 1 | 0.500000000 | 0.000000000 | FAIL | WF-01 |
| W849 | 500.00 | 4999.99 | Yes | 2 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W850 | 500.00 | 4999.99 | Yes | 3 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W851 | 500.00 | 4999.99 | Yes | 4 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W852 | 500.00 | 4999.99 | Yes | 5 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W853 | 500.00 | 4999.99 | Yes | 6 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W854 | 500.00 | 4999.99 | Yes | 7 | 0.500000000 | 0.000000000 | FAIL | WF-01 |
| W855 | 500.00 | 4999.99 | Yes | 8 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W856 | 500.00 | 4999.99 | No | 0 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W857 | 500.00 | 4999.99 | No | 1 | 0.500000000 | 0.500000000 | PASS | — |
| W858 | 500.00 | 4999.99 | No | 2 | 0.500000000 | 0.500000000 | PASS | — |
| W859 | 500.00 | 4999.99 | No | 3 | 0.500000000 | 0.500000000 | PASS | — |
| W860 | 500.00 | 4999.99 | No | 4 | 0.500000000 | 0.500000000 | PASS | — |
| W861 | 500.00 | 4999.99 | No | 5 | 0.500000000 | 0.500000000 | PASS | — |
| W862 | 500.00 | 4999.99 | No | 6 | 0.500000000 | 0.500000000 | PASS | — |
| W863 | 500.00 | 4999.99 | No | 7 | 0.500000000 | 0.500000000 | PASS | — |
| W864 | 500.00 | 4999.99 | No | 8 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W865 | 500.00 | 5000.00 | Yes | 0 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W866 | 500.00 | 5000.00 | Yes | 1 | 0.500000000 | 0.000000000 | FAIL | WF-01 |
| W867 | 500.00 | 5000.00 | Yes | 2 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W868 | 500.00 | 5000.00 | Yes | 3 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W869 | 500.00 | 5000.00 | Yes | 4 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W870 | 500.00 | 5000.00 | Yes | 5 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W871 | 500.00 | 5000.00 | Yes | 6 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W872 | 500.00 | 5000.00 | Yes | 7 | 0.500000000 | 0.000000000 | FAIL | WF-01 |
| W873 | 500.00 | 5000.00 | Yes | 8 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W874 | 500.00 | 5000.00 | No | 0 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W875 | 500.00 | 5000.00 | No | 1 | 0.000000000 | 0.500000000 | FAIL | WF-03 |
| W876 | 500.00 | 5000.00 | No | 2 | 0.000000000 | 0.500000000 | FAIL | WF-03 |
| W877 | 500.00 | 5000.00 | No | 3 | 0.000000000 | 0.500000000 | FAIL | WF-03 |
| W878 | 500.00 | 5000.00 | No | 4 | 0.000000000 | 0.500000000 | FAIL | WF-03 |
| W879 | 500.00 | 5000.00 | No | 5 | 0.000000000 | 0.500000000 | FAIL | WF-03 |
| W880 | 500.00 | 5000.00 | No | 6 | 0.000000000 | 0.500000000 | FAIL | WF-03 |
| W881 | 500.00 | 5000.00 | No | 7 | 0.000000000 | 0.500000000 | FAIL | WF-03 |
| W882 | 500.00 | 5000.00 | No | 8 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W883 | 500.00 | 5000.01 | Yes | 0 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W884 | 500.00 | 5000.01 | Yes | 1 | 0.500000000 | 0.000000000 | FAIL | WF-01 |
| W885 | 500.00 | 5000.01 | Yes | 2 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W886 | 500.00 | 5000.01 | Yes | 3 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W887 | 500.00 | 5000.01 | Yes | 4 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W888 | 500.00 | 5000.01 | Yes | 5 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W889 | 500.00 | 5000.01 | Yes | 6 | 0.000000000 | 0.500000000 | FAIL | WF-01 |
| W890 | 500.00 | 5000.01 | Yes | 7 | 0.500000000 | 0.000000000 | FAIL | WF-01 |
| W891 | 500.00 | 5000.01 | Yes | 8 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W892 | 500.00 | 5000.01 | No | 0 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
| W893 | 500.00 | 5000.01 | No | 1 | 0.000000000 | 0.500000000 | FAIL | WF-03 |
| W894 | 500.00 | 5000.01 | No | 2 | 0.000000000 | 0.500000000 | FAIL | WF-03 |
| W895 | 500.00 | 5000.01 | No | 3 | 0.000000000 | 0.500000000 | FAIL | WF-03 |
| W896 | 500.00 | 5000.01 | No | 4 | 0.000000000 | 0.500000000 | FAIL | WF-03 |
| W897 | 500.00 | 5000.01 | No | 5 | 0.000000000 | 0.500000000 | FAIL | WF-03 |
| W898 | 500.00 | 5000.01 | No | 6 | 0.000000000 | 0.500000000 | FAIL | WF-03 |
| W899 | 500.00 | 5000.01 | No | 7 | 0.000000000 | 0.500000000 | FAIL | WF-03 |
| W900 | 500.00 | 5000.01 | No | 8 | IllegalArgumentException (assumed) | 0.500000000 | FAIL | WF-04 |
