package com.stv.factory.factorytests;

import com.stv.design.designpages.MainPage;
import com.stv.factory.factorypages.LoginPage;
import com.stv.factory.factorypages.MainFactoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainFactoryTest extends BasicFactoryTest {

    MainFactoryPage mainFactoryPage = new MainFactoryPage();
    LoginPage loginPage = new LoginPage();
    @Test (description = "Assert the main page is loaded and account icon is visible")
    public void assertAccountIconIsDisplayed() {
        boolean actualResult = mainFactoryPage.isAccountLinkDisplayed();
        Assert.assertEquals(actualResult, true, "Account link isn't visible");
    }

    @Test (description = "Assert the login page is loaded", dependsOnMethods = "assertAccountIconIsDisplayed")
    public void assertLoginPageOpened() {
        mainFactoryPage.clickOnTrustButton();
        mainFactoryPage.clickOnAccountLink();
        Assert.assertEquals(new LoginPage().isLoginContainerDisplayed(), true, "Login page isn't loaded properly");
    }

    @Test (description = "Assert the user can sign up", dependsOnMethods = "assertLoginPageOpened")
    public void assertUserToSignUp() {
        loginPage.isSignUpDisplayed();
        loginPage.clickSignUpButton();
        Assert.assertEquals(new LoginPage().isCreateAccountContainerDisplayed(), true,
                "Sign up page isn't loaded properly");

    }

    @Test (description = "Assert the user can recover password", dependsOnMethods = "assertUserToSignUp")
    public void assertRecoverPassword() {
        loginPage.isSignInDisplayed();
        loginPage.clickSignInButton();
        loginPage.isForgotPasswordDisplayed();
        loginPage.clickForgotPassword();
        Assert.assertEquals(new LoginPage().isForgottenPasswordContainerDisplayed(), true,
                "Forgotten password recovery page isn't loaded properly");
    }

    @Test (description = "Assert login with empty credentials", dependsOnMethods = "assertRecoverPassword")
    public void assertEmptyCredentials() {
        loginPage.isBackToLoginDisplayed();
        loginPage.clickBackToLoginButton();
        loginPage.isLoginContainerDisplayed();
        loginPage.isContinueButtonDisplayed();
        loginPage.clickContinueButton();
        Assert.assertEquals(loginPage.isLoginContainerDisplayed(), true,
                "Check on login with empty credentials doesn't work properly");
    }
}

