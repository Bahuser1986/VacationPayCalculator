package ru.latyshev.calculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.latyshev.calculator.service.VacationPayCalculatorServiceImpl;

@Controller
public class VacationPayCalculatorController {
    @GetMapping("/calculacte")
    public String calculatorPage(@RequestParam(value = "avgSalary", required = false) String avgSalary,
                            @RequestParam(value = "vacationDays", required = false) String vacationDays,
                            Model model) {
        if (avgSalary != null && vacationDays != null) {
            model.addAttribute("result",
                    new VacationPayCalculatorServiceImpl()
                            .calculateVacationPay(avgSalary, vacationDays).getVacationPay());
        }
        return "calculacte";
    }
}
