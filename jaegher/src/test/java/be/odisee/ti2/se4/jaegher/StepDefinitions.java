package be.odisee.ti2.se4.jaegher;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class StepDefinitions {
    WebDriver driver;

    @Given("^Ik ben op de log in pagina$")
    public void Ik_ben_op_de_log_in_pagina() throws Throwable {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

        driver = new FirefoxDriver();
        driver.navigate().to("http://localhost:8080/login");
    }
    @When("^I enter \"([^\"]*)\" in the ([^\"]*) field$")
    public void i_enter_in_the_username_field(String enteredText, String fieldName) throws Throwable {

        driver.findElement(By.id(fieldName)).sendKeys(enteredText);
    }
    @When("^I press on the login button$")
    public void i_press_on_the_login_button() throws Throwable {
        driver.findElement(By.name("Login")).click();
    }

    @Then("^I should go to the home screen$")
    public void I_should_go_to_the_home_screen() throws Throwable {
        driver.navigate().to("http://localhost:8080/home");
    }
}
