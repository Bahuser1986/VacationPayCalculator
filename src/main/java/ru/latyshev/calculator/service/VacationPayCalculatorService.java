package ru.latyshev.calculator.service;

import ru.latyshev.calculator.VacationPay;

public interface VacationPayCalculatorService {
    VacationPay calculateVacationPay(String avgSalary, String vacationDays);
}
