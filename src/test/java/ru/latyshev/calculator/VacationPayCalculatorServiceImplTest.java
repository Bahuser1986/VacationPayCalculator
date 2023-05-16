package ru.latyshev.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.latyshev.calculator.service.VacationPayCalculatorServiceImpl;

// calculation unit tests
public class VacationPayCalculatorServiceImplTest {
    @ParameterizedTest
    @CsvSource({
            "100000, 28, 95563.14",
            "100000, 0, 0.00",
            "0, 28, 0.00"
    })
    public void testCorrectData(String value1, String value2, String expectedResult) {
        VacationPayCalculatorServiceImpl vacationPay = new VacationPayCalculatorServiceImpl();
        String result = String.format(vacationPay.calculateVacationPay(value1, value2)
                .getVacationPay());

        Assertions.assertEquals(expectedResult, result, "Wrong calculation");
    }

    @ParameterizedTest
    @ValueSource(strings = {"100,000", "", "!"})
    public void testIfAvgSalaryIsWrongDataType(String value) {
        VacationPayCalculatorServiceImpl vacationPay = new VacationPayCalculatorServiceImpl();
        String result = String.format(vacationPay.calculateVacationPay(value, "28")
                .getVacationPay());

        Assertions.assertEquals("Wrong average salary data type!", result,
                "Wrong avg salary data type passed!");
    }

    @ParameterizedTest
    @ValueSource(strings = {"28,0", "", "!"})
    public void testIfVacationDaysIsWrongDataType(String value) {
        VacationPayCalculatorServiceImpl vacationPay = new VacationPayCalculatorServiceImpl();
        String result = String.format(vacationPay.calculateVacationPay("100000", value)
                .getVacationPay());

        Assertions.assertEquals("Wrong vacation days data type!", result,
                "Wrong vacation days data type passed!");
    }

    @ParameterizedTest
    @CsvSource({
            "-1, 20",
            "100, -1"
    })
    public void testIfParameterIsNegative(String value1, String value2) {
        VacationPayCalculatorServiceImpl vacationPay = new VacationPayCalculatorServiceImpl();
        String result = String.format(vacationPay.calculateVacationPay(value1, value2)
                .getVacationPay());

        Assertions.assertEquals("Data should not be negative!", result, "Negative data passed!");
    }
}
