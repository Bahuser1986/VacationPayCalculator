package ru.latyshev.calculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.latyshev.calculator.VacationPay;

@Controller
public class CalculatorController {
    @GetMapping("/calculacte")
    public String calculatorPage(@RequestParam(value = "avgSalary", required = false) Double avgSalary,
                            @RequestParam(value = "vacationDays", required = false) Integer vacationDays,
                            Model model) {
        if (avgSalary != null && vacationDays != null) {
            model.addAttribute("result", new VacationPay(avgSalary, vacationDays).calculateVacationPay());
        }
        return "calculacte";
    }
}
