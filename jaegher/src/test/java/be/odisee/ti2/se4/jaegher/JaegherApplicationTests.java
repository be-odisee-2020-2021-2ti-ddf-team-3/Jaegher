package be.odisee.ti2.se4.jaegher;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(format={"pretty", "html:target/cucumber"},tags={"~@skip"})
class JaegherApplicationTests {

}
