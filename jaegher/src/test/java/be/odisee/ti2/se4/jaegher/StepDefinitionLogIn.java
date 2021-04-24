package be.odisee.ti2.se4.jaegher;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StepDefinitionLogIn {

    //Login
    WebDriver driver;


    @Given("^I am on the login page$")
    public void iAmOnTheLoginPage() {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

        driver = new FirefoxDriver();
        driver.navigate().to("http://localhost:8080/login");
    }

    @When("^I enter \"([^\"]*)\" in the ([^\"]*) field$")
    public void enter(String enteredText, String fieldName) throws Throwable {
        driver.findElement(By.name(fieldName)).sendKeys(enteredText);
    }

    @And("^I press on the Submit button$")
    public void iPressOnTheSubmitButton() {
        driver.findElement(By.name("submit")).click();
    }

    @Then("^I should go to the home screen$")
    public void iShouldGoToTheHomeScreen() {
        driver.navigate().to("http://localhost:8080/home");
    }

    @Then("^I press on the Klanten button$")
    public void iPressOnTheKlantenButton()  {
        driver.findElement(By.name("klanten")).click();
    }

    @Then("^I press on the submit button klant$")
    public void iPressOnTheSubmitButtonKlant() {
        driver.findElement(By.name("submit")).click();
    }
}
