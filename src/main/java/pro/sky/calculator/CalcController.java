package pro.sky.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcController {
    private final CalcService calcService;

    public CalcController(CalcService calcService) {
        this.calcService = calcService;
    }

    @GetMapping(path = "/calculator")
    public String answerCalc() {
        System.out.println("Добро пожаловать в калькулятор!");
        return calcService.answerCalc();
    }


    @GetMapping(path = "/calculator/plus")
    public String plus(@RequestParam(value = "num1", required = false) Integer a, @RequestParam(value = "num2", required = false) Integer b) {
        return buildView(a, b, calcService.plus(a, b), "+");
    }

    @GetMapping(path = "/calculator/divide")
    public String divide(@RequestParam(value = "num1", required = false) Integer a, @RequestParam(value = "num2", required = false) Integer b) {

        return buildView(a, b, calcService.divide(a, b), "/");
    }

    @GetMapping(path = "/calculator/multiply")
    public String multiply(@RequestParam(value = "num1", required = false) Integer a, @RequestParam(value = "num2", required = false) Integer b) {

        return buildView(a, b, calcService.multiply(a, b), "*");
    }

    @GetMapping(path = "/calculator/minus")
    public String minus(@RequestParam(value = "num1", required = false) Integer a, @RequestParam(value = "num2", required = false) Integer b) {

        return buildView(a, b, calcService.minus(a, b), "-");
    }

    private String buildView(Integer a, Integer b, Number result, String operation) {
        if (a == null || b == null) {
            return "Не передан один из параметров";
        }
        if ("/".equals(operation) && b == 0) {
            return "На 0 делить нельзя";
        }
        return a + " " + operation + " " + b + " = " + result;

    }

}
