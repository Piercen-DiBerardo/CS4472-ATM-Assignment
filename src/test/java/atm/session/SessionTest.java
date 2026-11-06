package atm.session;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import atm.ATM;
import atm.dispatcher.MessageDispatcher;
import atm.exceptions.InvalidAmountException;
import atm.exceptions.InvalidPinFormatException;
import atm.session.transactions.ATMWithdrawal;
import atm.ui.panels.MainPanel;
import atm.utils.CredentialsCheck;
import atm.utils.FormatChecker;
import bank.transactions.utils.AccountType;
import bank.transactions.utils.TransactionResult;

/**
 * Black-box tests of atm.session.Session driven through the ATM facade.
 * Technique: Robust Boundary Value Analysis under the single fault assumption.
 * Account under test: daily limit $1,000, available balance $5,000.
 */
class SessionTest {

    private static final String CARD = "4000000000000000";

    private ATM atm;
    private MessageDispatcher dispatcher;

    @BeforeEach
    void setUp() throws Exception {
        dispatcher = Mockito.mock(MessageDispatcher.class);
        Mockito.when(dispatcher.checkCredentials(
                ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(true);
        Mockito.when(dispatcher.performTransaction(
                ArgumentMatchers.any(), ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenReturn(new TransactionResult(true, "", 0.0, new double[] {5000.0}));

        atm = new ATM(new FormatChecker(), new CredentialsCheck(dispatcher), dispatcher);
        atm.setMainPanel(Mockito.mock(MainPanel.class));
        atm.createSession();
        atm.checkCardNumber(CARD);
    }

    // ---------------------------------------------------------------- PIN

    static Stream<Arguments> pinCases() {
        return Stream.of(
            // Valid: nominal and digit boundaries ('0' = min, '9' = max)
            Arguments.of("P01", "55555", true),
            Arguments.of("P02", "00000", true),
            Arguments.of("P03", "11111", true),
            Arguments.of("P04", "88888", true),
            Arguments.of("P05", "99999", true),
            // Invalid length: min-/max- (4), max+ (6), and extremes
            Arguments.of("P06", "", false),
            Arguments.of("P07", "5", false),
            Arguments.of("P08", "5555", false),
            Arguments.of("P09", "555555", false),
            // Invalid character just below '0' ('/') in each position
            Arguments.of("P10", "/5555", false),
            Arguments.of("P11", "5/555", false),
            Arguments.of("P12", "55/55", false),
            Arguments.of("P13", "555/5", false),
            Arguments.of("P14", "5555/", false),
            // Invalid character just above '9' (':') in each position
            Arguments.of("P15", ":5555", false),
            Arguments.of("P16", "5:555", false),
            Arguments.of("P17", "55:55", false),
            Arguments.of("P18", "555:5", false),
            Arguments.of("P19", "5555:", false),
            // Non-digit letter
            Arguments.of("P20", "5555a", false));
    }

    @ParameterizedTest(name = "{0}: PIN \"{1}\" valid={2}")
    @MethodSource("pinCases")
    void pinFormat(String id, String pin, boolean valid) {
        if (valid) {
            assertDoesNotThrow(() -> atm.checkPin(pin.toCharArray()));
        } else {
            assertThrows(InvalidPinFormatException.class,
                () -> atm.checkPin(pin.toCharArray()));
        }
    }

    // ------------------------------------------------------------- Amount

    static Stream<Arguments> amountCases() {
        return Stream.of(
            // Below the minimum ($20, smallest dispensable amount)
            Arguments.of("A01", -50, false),
            Arguments.of("A02", -1, false),
            Arguments.of("A03", 0, false),
            Arguments.of("A04", 19, false),
            // Minimum and just above it
            Arguments.of("A05", 20, true),
            Arguments.of("A06", 21, false),
            Arguments.of("A07", 40, true),
            Arguments.of("A08", 60, true),
            // Nominal
            Arguments.of("A09", 500, true),
            // Just below the daily limit
            Arguments.of("A10", 990, true),
            Arguments.of("A11", 999, false),
            // Maximum (daily limit)
            Arguments.of("A12", 1000, true),
            // Just above the daily limit
            Arguments.of("A13", 1001, false),
            Arguments.of("A14", 1020, false),
            Arguments.of("A15", 1050, false),
            // Undispensable amounts between the bounds
            Arguments.of("A16", 10, false),
            Arguments.of("A17", 30, false));
    }

    @ParameterizedTest(name = "{0}: withdraw ${1} valid={2}")
    @MethodSource("amountCases")
    void withdrawalAmount(String id, int amount, boolean valid) {
        // Session is driven directly so the PIN format check cannot affect these tests.
        Session session = new Session(Mockito.mock(MainPanel.class), dispatcher);
        session.insertCard();
        session.addCard(CARD);
        session.addPin("55555".toCharArray());
        session.setTransaction(new ATMWithdrawal());
        session.setFromAccount(AccountType.Chequing);

        if (valid) {
            assertDoesNotThrow(() -> session.setAmount(amount));
        } else {
            assertThrows(InvalidAmountException.class, () -> session.setAmount(amount));
        }
    }
}
