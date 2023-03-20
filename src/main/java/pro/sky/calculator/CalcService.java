package pro.sky.calculator;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class CalcService {
    public String answerCalc() {
        return "Добро пожаловать в калькулятор";
    }

    public int plus(int a, int b) {
        return a + b;
    }

    public int minus(int a, int b) {
        return a - b;
    }

    public double divide(int a, int b) {
        return a / (double) b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

