package pro.sky.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.calculator.exception.DivByZeroException;
import pro.sky.calculator.service.CalcService;

import java.security.DigestException;

public class CalcServiceTests {

    private final CalcService calcService = new CalcService();

    @Test
    public void plusTest() {
        Number actual = calcService.plus(1, 2);
        Number expected = 3;
        Assertions.assertEquals(expected, actual);

        actual = calcService.plus(-1, 2);
        expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void minusTest() {
        Number actual = calcService.minus(2, 1);
        Number expected = 1;
        Assertions.assertEquals(expected, actual);

        actual = calcService.minus(-1, 2);
        expected = -3;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void multiplyTest() {
        Number actual = calcService.multiply(1, 2);
        Number expected = 2;
        Assertions.assertEquals(expected, actual);

        actual = calcService.multiply(-1, 2);
        expected = -2;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void divideTest() {
        Number actual = calcService.divide(1, 2);
        Number expected = 0.5;
        Assertions.assertEquals(expected, actual);

        actual = calcService.divide(-1, 2);
        expected = -0.5;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void divideNegativeTest() {
        Assertions.assertThrows(DivByZeroException.class, () -> calcService.divide(1, 0));
        Assertions.assertThrows(DivByZeroException.class, () -> calcService.divide(-1, 0));
    }
    @Test
    void contextLoads() {
    }

}
