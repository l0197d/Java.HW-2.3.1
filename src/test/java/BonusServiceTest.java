import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BonusServiceTest {

    @Test
    void shouldCalculateRegisteredAndUnderLimit() {

        BonusService service = new BonusService();

        long amount = 1000_60;
        long expected = 30;

        long actual = service.calculate(amount, true);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateRegisteredAndOverLimit() {

        BonusService service = new BonusService();

        long amount = 1000_000_60;
        long expected = 30;

        long actual = service.calculate(amount, true);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateNotRegisteredAndUnderLimit() {

        BonusService service = new BonusService();

        long amount = 1000_60;
        long expected = 8;

        long actual = service.calculate(amount, false);

        assertEquals(expected, actual);


    }

    @Test
    void shouldCalculateNotRegisteredAndOverLimit() {

        BonusService service = new BonusService();

        long amount = 1000_000_60;
        long expected = 8000;

        long actual = service.calculate(amount, false);

        assertEquals(expected, actual);


    }
}
