package ru.latyshev.calculator;

import static org.hamcrest.Matchers.containsString;
import static
        org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static
        org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static
        org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static
        org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import ru.latyshev.calculator.controllers.CalculatorController;

@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {
    @Autowired
    private MockMvc mockMvc;
    public void testCalculatorPage() throws Exception {
        mockMvc.perform(get("/calculacte"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculacte"))
                .andExpect(content().string(
                        containsString("Vacation Pay Calculator")));
    }
}
