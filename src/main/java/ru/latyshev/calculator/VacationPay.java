package ru.latyshev.calculator;

import lombok.Data;

@Data
public class VacationPay {
    private double avgSalary;
    private int vacationDays;

    public VacationPay(double avgSalary, int vacationDays) {
        this.avgSalary = avgSalary;
        this.vacationDays = vacationDays;
    }

    public double calculateVacationPay() {
        return getAvgSalary() / 29.3 * getVacationDays();
    }
}
