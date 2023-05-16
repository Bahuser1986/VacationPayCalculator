package ru.latyshev.calculator.service;

import ru.latyshev.calculator.VacationPay;

import java.util.Locale;

public class VacationPayCalculatorServiceImpl implements VacationPayCalculatorService{
    private static final double AVERAGE_SALARY_PER_MONTH = 29.3;
    @Override
    public VacationPay calculateVacationPay(String avgSalary, String vacationDays) {
        if (!checkAvgSalaryType(avgSalary)) {
            return new VacationPay("Wrong average salary data type!");
        }
        if (!checkVacationDaysType(vacationDays)) {
            return new VacationPay("Wrong vacation days data type!");
        }

        double avgSalaryDouble = Double.parseDouble(avgSalary);
        int vacationDaysInteger = Integer.parseInt(vacationDays);
        if (!isNotNegativeParameters(avgSalaryDouble, vacationDaysInteger)) {
            return new VacationPay("Data should not be negative!");
        }

        return new VacationPay(String.format(Locale.ENGLISH, "%.2f",
                    avgSalaryDouble / AVERAGE_SALARY_PER_MONTH * vacationDaysInteger));
    }
    private boolean checkAvgSalaryType(String avgSalary) {
        try {
            Double.parseDouble(avgSalary);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private boolean checkVacationDaysType(String vacationDays) {
        try {
            Integer.parseInt(vacationDays);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private boolean isNotNegativeParameters(double avgSalary, int vacationDays) {
        return avgSalary >= 0 && vacationDays >= 0;
    }

}
