package pro.sky.calculator.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import pro.sky.calculator.exception.DivByZeroException;

@Service
public class CalcService {
    public String answerCalc() {
        return "Добро пожаловать в калькулятор";
    }

    public static int plus(int a, int b) {
        return a + b;
    }

    public static int minus(int a, int b) {
        return a - b;
    }

    public static double divide(int a, int b) {
        if (b == 0 ) {
            throw new DivByZeroException();
        }
        return a / (double) b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }
}

