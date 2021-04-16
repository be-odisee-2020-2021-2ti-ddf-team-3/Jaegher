package be.odisee.ti2.se4.jaegher;

import be.odisee.ti2.se4.jaegher.controllers.KlantController;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(KlantController.class)
public class KlantControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void klanten() throws Exception {

        mockMvc.perform(get("/klanten"))
                .andExpect(status().isOk())
                .andExpect(view().name("klanten"))
        ;
    }

}
