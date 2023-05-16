package ru.latyshev.calculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.latyshev.calculator.service.VacationPayCalculatorServiceImpl;

import java.util.Locale;

@Controller
public class VacationPayCalculatorController {
    @GetMapping("/calculacte")
    public String calculatorPage(@RequestParam(value = "avgSalary", required = false) Double avgSalary,
                            @RequestParam(value = "vacationDays", required = false) Integer vacationDays,
                            Model model) {
        if (avgSalary != null && vacationDays != null) {
            model.addAttribute("result",
                    String.format(Locale.ENGLISH, "%.2f", new VacationPayCalculatorServiceImpl()
                            .calculateVacationPay(avgSalary, vacationDays).getVacationPay()));
        }
        return "calculacte";
    }
}
