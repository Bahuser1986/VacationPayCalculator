package ru.latyshev.calculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.latyshev.calculator.service.VacationPayCalculatorServiceImpl;

@Controller
@RequestMapping("/calculacte")
public class VacationPayCalculatorController {
    @GetMapping
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
