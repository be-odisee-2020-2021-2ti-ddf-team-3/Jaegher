package be.odisee.ti2.groep4.quatraplanning;

import cucumber.api.java.en.*;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepDefinitions {
    WebDriver driver;

    @Given("^I am on the login page$")
    public void i_am_on_the_page_where_I_can_login() throws Throwable {
        // voor het gemak zetten we de geckodriver in de root van het project - indien path de backspaces escapen
        // geckodriver voor Linux, geckodriver.exe voor Windows 64bit
        //System.setProperty("webdriver.gecko.driver", "geckodriver");
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

        driver = new FirefoxDriver();
        driver.navigate().to("http://localhost:8080/login");
    }

    @When("^I enter \"([^\"]*)\" in the ([^\"]*) field$")
    public void enter(String enteredText, String fieldName) throws Throwable {

        driver.findElement(By.name(fieldName)).sendKeys(enteredText);
    }


    @When("^I press on the Submit button$")
    public void i_press_on_the_Submit_button() throws Throwable {
        driver.findElement(By.name("action")).click();
    }

    class LabelData {
        String label;
        String data;
    }

    /*@Then("^I should \"([^\"]*)\" see the following url$")
    public void i_should_see_the_following_on_the_screen(String url) throws Throwable {
        // wacht tot de juiste pagina geladen is
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .textToBePresentInElementLocated(By.tagName("body"), "Welcome to Quatra Planning"));
        String bodyText = driver.findElement(By.tagName("body")).getText();
        if (url == driver.getCurrentUrl()) {
            Assert.assertTrue("Did not load this webpage: " + "planningLijst" + "\n", driver.getCurrentUrl().contains("http://localhost:8080/planningLijst"));
        }
    }*/

    @Then("^I should see \"([^\"]*)\"")
    public void i_should_see_a_list_containing(String text2bFound) throws Throwable {
        // wacht tot de juiste pagina geladen is
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .textToBePresentInElementLocated(By.tagName("body"), "Lijst van plannings"));
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue("Did not find this text: "+text2bFound+"\n",bodyText.contains(text2bFound));
    }


    /*@Then("^I close the browser$")
    public void i_close_the_browser() throws Throwable {
        driver.quit();
    }*/
}
