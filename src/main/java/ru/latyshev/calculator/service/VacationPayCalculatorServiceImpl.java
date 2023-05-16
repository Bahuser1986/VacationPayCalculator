package ru.latyshev.calculator.service;

import ru.latyshev.calculator.VacationPay;

public class VacationPayCalculatorServiceImpl implements VacationPayCalculatorService{
    private static final double AVERAGE_SALARY_A_MONTH = 29.3;

    @Override
    public VacationPay calculateVacationPay(double avgSalary, int vacationDays) {
        return new VacationPay(avgSalary / AVERAGE_SALARY_A_MONTH * vacationDays);
    }
}
