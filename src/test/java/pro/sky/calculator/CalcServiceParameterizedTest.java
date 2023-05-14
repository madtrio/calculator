package pro.sky.calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.calculator.exception.DivByZeroException;
import pro.sky.calculator.service.CalcService;

import java.util.stream.Stream;

public class CalcServiceParameterizedTest {
    private final CalcService calcService = new CalcService();

    public static Stream<Arguments> plusTestParams() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(-1, 2, 1)
        );
    }
    public static Stream<Arguments> minusTestParams() {
        return Stream.of(
                Arguments.of(2, 1, 1),
                Arguments.of(-1, 2, -3)
        );
    }

    public static Stream<Arguments> multiplyTestParams() {
        return Stream.of(
                Arguments.of(2, 1, 2),
                Arguments.of(-1, 2, -2)
        );
    }
    public static Stream<Arguments> divideTestParams() {
        return Stream.of(
                Arguments.of(2, 1, 2.0),
                Arguments.of(-1, 2, -0.5)
        );
    }

    public static Stream<Arguments> divideNegTestParams() {
        return Stream.of(
                Arguments.of(1, 0),
                Arguments.of(-1, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("plusTestParams")
    public void plusTest(int a, int b, int expected) {
        Assertions.assertThat(CalcService.plus(a,b))
        .isEqualTo(expected);
    }
    @ParameterizedTest
    @MethodSource("minusTestParams")
    public void minusTest(int a, int b, int expected) {
        Assertions.assertThat(CalcService.minus(a,b))
                .isEqualTo(expected);
    }
    @ParameterizedTest
    @MethodSource("multiplyTestParams")
    public void multiplyTest(int a, int b, int expected) {
        Assertions.assertThat(CalcService.multiply(a,b))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("divideTestParams")
    public void divideTest(int a, int b, Number expected) {
        Assertions.assertThat(CalcService.divide(a,b))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("divideNegTestParams")
    public void divideNegTest(int a, int b) {
        Assertions.assertThatExceptionOfType(DivByZeroException.class)
                .isThrownBy(() -> calcService.divide(a,b));
    }
}
