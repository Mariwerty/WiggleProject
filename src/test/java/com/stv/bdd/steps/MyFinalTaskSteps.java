package com.stv.bdd.steps;

import com.stv.factory.factorypages.LoginPage;
import com.stv.factory.factorypages.MainFactoryPage;
import com.stv.factory.factorytests.BasicFactoryTest;
import com.stv.framework.core.drivers.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.tools.ant.taskdefs.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static com.stv.framework.core.lib.WigglePageURLs.START_URL;

public class MyFinalTaskSteps extends BasicFactoryTest {
    LoginPage loginPage = new LoginPage();
    MainFactoryPage mainFactoryPage = new MainFactoryPage();

    Sleep sleep = new Sleep();
    WebDriver driver = getDriver();


    @Given("Home page is opened")
    public void homePageIsOpened() {
        driver.get(START_URL);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @And("All cookies are accepted on the Home page")
    public void allCookiesAreAcceptedOnTheHomePage() {
        if (!Driver.getDriver().findElements(By.xpath("//button[contains(text(),'Accept all')]")).isEmpty()){
            mainFactoryPage.clickOnTrustButton();
        } else {
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        }
    }

    @When("The basket icon is clicked")
    public void theBasketIconIsClicked() {
        mainFactoryPage.clickOnBasketIcon();
    }

    @Then("The empty basket page is displayed")
    public void theEmptyBasketPageIsDisplayed() {
        mainFactoryPage.isEmptyBasketTitleDisplayed();
    }

    @When("The Sign In button is pressed")
    public void theSignInButtonIsPressed() {
        mainFactoryPage.clickOnSignInButton();
    }

    @Then("The login page is opened")
    public void theLoginPageIsOpened() {
        loginPage.isLoginContainerDisplayed();
    }

    @When("The continue button is pressed")
    public void theContinueButtonIsPressed() {
        loginPage.clickContinueButton();
    }

    @When("The user clicks the Sign In icon")
    public void theUserClicksTheSignInIcon() {
        mainFactoryPage.clickOnAccountLink();
        loginPage.isLoginContainerDisplayed();
    }

    @And("The forgot password link in clicked")
    public void theForgotPasswordLinkInClicked() {
        loginPage.clickForgotPassword();
    }

    @And("The password recovery page is opened")
    public void thePasswordRecoveryPageIsOpened() {
        loginPage.isForgottenPasswordContainerDisplayed();
    }
    @And("The user inputs {string}")
    public void theUserInputs(String email) {
        loginPage.email.sendKeys(email);
        Assert.assertEquals(loginPage.email.getAttribute("value"), email);
    }


    @And("The user clicks Continue Button")
    public void theUserClicksContinueButton() {
        loginPage.clickContinueButton();
    }

    @Then("Validation error appears")
    public void validationErrorAppears() {
        loginPage.isWrongEmailMessageDisplayed();
    }

    @And("The user clears the input")
    public void theUserClearsTheInput() {
        loginPage.email.clear();
        Assert.assertEquals(loginPage.email.getAttribute("value"), "");
    }

}
