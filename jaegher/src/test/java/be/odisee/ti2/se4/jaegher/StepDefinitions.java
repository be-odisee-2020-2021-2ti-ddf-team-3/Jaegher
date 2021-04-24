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

    //Login
    WebDriver driver;


    /*
    //voegKlantToe
    @Given("^Ik ben op de pagina waar ik de lijst van klanten kan raadplegen$")
    public void Ik_ben_op_de_klanten_pagina() throws Throwable {
       // System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

        //driver = new FirefoxDriver();
        //niet zeker of die moet wordne gecomment
        driver.navigate().to("http://localhost:8080/klanten");
    }


   class LabelData {

        String label;
        String data;
    }


    //input data
    @When("^I enter \"([^\"]*)\" in the ([^\"]*) field$")
    public void i_enter_in_the_naam_field(String enteredText, String fieldName) throws Throwable {

        driver.findElement(By.id(fieldName)).sendKeys(enteredText);
    }
    @When("^I enter \"([^\"]*)\" in the ([^\"]*) field$")
    public void i_enter_in_the_achternaam_field(String enteredText, String fieldName) throws Throwable {

        driver.findElement(By.id(fieldName)).sendKeys(enteredText);
    }
    @When("^I enter \"([^\"]*)\" in the ([^\"]*) field$")
    public void i_enter_in_the_email_field(String enteredText, String fieldName) throws Throwable {

        driver.findElement(By.id(fieldName)).sendKeys(enteredText);
    }
    @When("^I enter \"([^\"]*)\" in the ([^\"]*) field$")
    public void i_enter_in_the_addres_field(String enteredText, String fieldName) throws Throwable {

        driver.findElement(By.id(fieldName)).sendKeys(enteredText);
    }
    @When("^I enter \"([^\"]*)\" in the ([^\"]*) field$")
    public void i_enter_in_the_geboortedatum_field(String enteredText, String fieldName) throws Throwable {

        driver.findElement(By.id(fieldName)).sendKeys(enteredText);
    }
    @When("^I press on the Submit button$")
    public void i_press_on_the_Submit_button() throws Throwable {
        driver.findElement(By.id("maakKlant")).click();
    }
    //output
    @Then("^I should see the following on the screen$")
    public void i_should_see_the_following_on_the_screen_klanten(List<LabelData> checklist) throws Throwable {
        // wacht tot de juiste pagina geladen is
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .textToBePresentInElementLocated(By.tagName("body"), "Details van persoon"));

        String bodyText = driver.findElement(By.tagName("body")).getText();
        for (LabelData ld: checklist){
            String text2bFound = ld.label + " " + ld.data;
            Assert.assertTrue("Did not find this text: "+text2bFound+"\n",bodyText.contains(text2bFound));
        }

    }

    //voegLichaamsmaatToe
    @Given("^Ik ben op de pagina waar ik de gegevens van een klant kan wijzigen$")
    public void Ik_ben_op_de_lichaamsmaat_pagina() throws Throwable {
       // System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

        //driver = new FirefoxDriver();
        //niet zeker of die moet wordne gecomment
        driver.navigate().to("http://localhost:8080/klanten");
    }

    @When("^I press on the Submit button$")
    public void i_press_on_the_Submit_button() throws Throwable {
        driver.findElement(By.id("maakKlant")).click();
    }

    class LabelData {
        String label;
        String data;
    }


    //input data
    @When("^I enter \"([^\"]*)\" in the ([^\"]*) field$")
    public void i_enter_in_the_lengteLinkerbeen_field(String enteredText, String fieldName) throws Throwable {

        driver.findElement(By.id(fieldName)).sendKeys(enteredText);
    }
    @When("^I enter \"([^\"]*)\" in the ([^\"]*) field$")
    public void i_enter_in_the_lengteRechterbeen_field(String enteredText, String fieldName) throws Throwable {

        driver.findElement(By.id(fieldName)).sendKeys(enteredText);
    }
    @When("^I enter \"([^\"]*)\" in the ([^\"]*) field$")
    public void i_enter_in_the_bekkenKanteling_field(String enteredText, String fieldName) throws Throwable {

        driver.findElement(By.id(fieldName)).sendKeys(enteredText);
    }
    @When("^I enter \"([^\"]*)\" in the ([^\"]*) field$")
    public void i_enter_in_the_lengteLinkerarm_field(String enteredText, String fieldName) throws Throwable {

        driver.findElement(By.id(fieldName)).sendKeys(enteredText);
    }
    @When("^I enter \"([^\"]*)\" in the ([^\"]*) field$")
    public void i_enter_in_the_lengteRechtearm_field(String enteredText, String fieldName) throws Throwable {

        driver.findElement(By.id(fieldName)).sendKeys(enteredText);
    }
    @When("^I enter \"([^\"]*)\" in the ([^\"]*) field$")
    public void i_enter_in_the_gewicht_field(String enteredText, String fieldName) throws Throwable {

        driver.findElement(By.id(fieldName)).sendKeys(enteredText);
    }
    @When("^I enter \"([^\"]*)\" in the ([^\"]*) field$")
    public void i_enter_in_the_grootte_field(String enteredText, String fieldName) throws Throwable {

        driver.findElement(By.id(fieldName)).sendKeys(enteredText);
    }
    @When("^I press on the Submit button$")
    public void i_press_on_the_Submit_button() throws Throwable {
        driver.findElement(By.id("maakKlant")).click();
    }

    @When("^I click the klant dat ik heb gewijzigd$")
    public void iClickTheKlantDatIkHebGewijzigd() {
        driver.findElement(By.class("gemaakteKlant")).click();
    }


    //output
    @Then("^I should see the following on the screen$")
    public void i_should_see_the_following_on_the_screen_klanten(List<LabelData> checklist) throws Throwable {
        // wacht tot de juiste pagina geladen is
        new WebDriverWait(driver, 10).until(ExpectedConditions
                                                .textToBePresentInElementLocated(By.tagName("body"), "Details van persoon")); 

        String bodyText = driver.findElement(By.tagName("body")).getText();
        for (LabelData ld: checklist){
            String text2bFound = ld.label + " " + ld.data;
            Assert.assertTrue("Did not find this text: "+text2bFound+"\n",bodyText.contains(text2bFound));
        }

    }

     */



}
