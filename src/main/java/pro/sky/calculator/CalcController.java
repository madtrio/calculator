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
        return calcService.answerCalc();
    }
}
