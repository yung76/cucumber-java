package hellocucumber;

import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.After;
import driver.Appium;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

class IsItFriday {
    static String isItFriday(String today) {
        return "Friday".equals(today) ? "TGIF" : "Nope";
    }
}

public class Stepdefs {
    private String today;
    private String actualAnswer;
    private Appium appium;

    public Appium getAppium() {
        return appium;
    }

    public void setAppium(Appium appium) {
        this.appium = appium;
    }

    public Stepdefs() {
        System.out.println("estoy en el constructor de las steps");
        this.setAppium(new Appium());
    }

    @Given("^today is \"([^\"]*)\"$")
    public void today_is_Friday(String today) {
        this.today = today;
        System.out.println("--------------->1");
    }

    @When("^I ask whether it's Friday yet$")
    public void i_ask_whether_it_s_Friday_yet() {
        // Write code here that turns the phrase above into concrete actions
        //throw new cucumber.api.PendingException();+
        System.out.println("--------------->2");
        actualAnswer = IsItFriday.isItFriday(today);
    }

    @Then("^I should be told \"([^\"]*)\"$")
    public void i_should_be_told(String expectedAnswer) {
        // Write code here that turns the phrase above into concrete actions
        //throw new cucumber.api.PendingException();
        System.out.println("--------------->3");
        assertEquals(expectedAnswer, actualAnswer);
    }
    @Given("^Establish a connection to saucelabs$")
    public void connection_to_saucelabs() throws MalformedURLException {
        // Write code here that turns the phrase above into concrete actions
        //Appium ap = new Appium();
        this.getAppium().initAppium();
        System.out.println("step -----> 1 ");
    }

    @When("^I tap on element$")
    public void i_tap_on_element() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        //throw new cucumber.api.PendingException();
        //android.widget.RadioButton
        WebDriverWait wait =new WebDriverWait(this.getAppium().getAppiumDriver(),60);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.RadioButton[contains(@text,'5GB')]")));
        System.out.println(" I'm in tap on element method ");
        //TimeUnit.SECONDS.sleep(7);
        this.getAppium().getAppiumDriver().findElementByXPath("//android.widget.RadioButton[contains(@text,'5GB')]").click();
        System.out.println(" It's worked ");
        //AndroidElement asd = (AndroidElement) new WebDriver(this.getAppium().getAppiumDriver(),30).until();
        System.out.println("step -----> 2 ");
    }

    @After
    public void doSomethingAfter(Scenario scenario){
        // Do something after after scenario
        System.out.println("Closing driver");
        this.getAppium().getAppiumDriver().quit();
        System.out.println("--------------->AFTER---->"+scenario.getStatus());
    }
}
