package ru.latyshev.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.latyshev.calculator.service.VacationPayCalculatorServiceImpl;

// calculation unit tests
public class VacationPayCalculatorServiceImplTest {
    @Test
    public void checkCorrectData() {
        VacationPayCalculatorServiceImpl vacationPay = new VacationPayCalculatorServiceImpl();
        String result = String.format(vacationPay.calculateVacationPay("100000", "28")
                .getVacationPay());

        Assertions.assertEquals("95563.14", result, "Wrong calculation");
    }

    @Test
    public void checkIfAvgSalaryIsWrongDataType() {
        VacationPayCalculatorServiceImpl vacationPay = new VacationPayCalculatorServiceImpl();
        String result = String.format(vacationPay.calculateVacationPay("100_000", "28")
                .getVacationPay());

        Assertions.assertEquals("Wrong average salary data type!", result,
                "Wrong avg salary data type passed!");
    }

    @Test
    public void checkIfVacationDaysIsWrongDataType() {
        VacationPayCalculatorServiceImpl vacationPay = new VacationPayCalculatorServiceImpl();
        String result = String.format(vacationPay.calculateVacationPay("100000", "28,0")
                .getVacationPay());

        Assertions.assertEquals("Wrong vacation days data type!", result,
                "Wrong vacation days data type passed!");
    }

    @Test
    public void checkIfAvgSalaryIsNegative() {
        VacationPayCalculatorServiceImpl vacationPay = new VacationPayCalculatorServiceImpl();
        String result = String.format(vacationPay.calculateVacationPay("-1", "28")
                .getVacationPay());

        Assertions.assertEquals("Data should not be negative!", result, "Negative data passed!");
    }

    @Test
    public void checkIfVacationDaysIsNegative() {
        VacationPayCalculatorServiceImpl vacationPay = new VacationPayCalculatorServiceImpl();
        String result = String.format(vacationPay.calculateVacationPay("100000", "-1")
                .getVacationPay());

        Assertions.assertEquals("Data should not be negative!", result, "Negative data passed!");
    }
}
