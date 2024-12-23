import org.junit.jupiter.api.Test;

import ua.edu.ucu.apps.task1.ATM;

public class ATMTest {

    @Test
    public void testExactAmount() {
        ATM atm = new ATM();
        System.out.println("Test Exact Amount:");
        atm.getMeMoney(800);
    }

    @Test
    public void testExcessAmount() {
        ATM atm = new ATM();
        System.out.println("Test Excess Amount:");
        atm.getMeMoney(1200);
    }

    @Test
    public void testNotDivisibleAmount() {
        ATM atm = new ATM();
        System.out.println("Test Not Divisible Amount:");
        atm.getMeMoney(850);
    }

    @Test
    public void testZeroAmount() {
        ATM atm = new ATM();
        System.out.println("Test Zero Amount:");
        atm.getMeMoney(0);
    }

    @Test
    public void testNegativeAmount() {
        ATM atm = new ATM();
        System.out.println("Test Negative Amount:");
        atm.getMeMoney(-100);
    }
}