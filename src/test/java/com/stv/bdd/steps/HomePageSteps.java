package com.stv.bdd.steps;

import com.stv.design.designpages.MainPage;
import com.stv.design.designtests.BasicTest;
import com.stv.factory.factorypages.MainFactoryPage;
import com.stv.factory.factorytests.BasicFactoryTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static com.stv.framework.core.lib.WigglePageURLs.START_URL;

public class HomePageSteps extends BasicFactoryTest {
        MainPage mainPage = new MainPage();
        MainFactoryPage mainFactoryPage = new MainFactoryPage();

    @Given("Home page URL is entered")
    public void homePageURLIsEntered() {
        WebDriver driver = getDriver();
        driver.get(START_URL);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @When("The user accepts all cookies")
    public void theUserAcceptsAllCookies() {
        WebElement trustButton = getDriver().findElement(By.xpath("//button[contains(text(),'Accept all')]"));
        trustButton.click();
    }

    @Then("Wiggle Logo is displayed")
    public void wiggleLogoIsDisplayed() {
        getDriver().manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        mainPage.isMainLogoDisplayed();
    }

}

