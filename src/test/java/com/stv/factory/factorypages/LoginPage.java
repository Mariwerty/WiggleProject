package com.stv.factory.factorypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends FactoryPage {
    @FindBy(xpath = "//*[contains(text(),'Please log in')]")
    private WebElement loginContainer;

    @FindBy(xpath = "//a[contains(text(),'Sign up')]")
    private WebElement signUp;
    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    private WebElement signIn;

    @FindBy(xpath = "//a[contains(text(),'Back to login')]")
    private WebElement backToLogin;

    @FindBy(xpath = "//a[contains(text(),'Forgot password')]")
    private WebElement forgotPassword;

    @FindBy(xpath = "//h1[contains(text(),'Forgotten Password')]")
    private WebElement forgottenPasswordContainer;

    @FindBy(xpath = "//p[contains(text(),'Create your account to continue')]")
    private WebElement createAccountContainer;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//button[contains(text(),'Continue')][@data-action-button-primary='true']")
    public WebElement continueButton;

    public boolean isLoginContainerDisplayed(){
        return loginContainer.isDisplayed();
    }

    public boolean isSignUpDisplayed(){
        return signUp.isDisplayed();
    }

    public boolean isSignInDisplayed(){
        return signIn.isDisplayed();
    }

    public boolean isBackToLoginDisplayed(){
        return backToLogin.isDisplayed();
    }

    public boolean isCreateAccountContainerDisplayed(){
        return createAccountContainer.isDisplayed();
    }
    public void clickSignUpButton(){
        signUp.click();
    }

    public void clickSignInButton(){
        signIn.click();
    }

    public void clickBackToLoginButton(){
        backToLogin.click();
    }
    public boolean isForgotPasswordDisplayed(){
        return forgotPassword.isDisplayed();
    }

    public void clickForgotPassword(){
        forgotPassword.click();
    }

    public boolean isForgottenPasswordContainerDisplayed(){
        return forgottenPasswordContainer.isDisplayed();
    }
    public boolean isContinueButtonDisplayed(){
        return continueButton.isDisplayed();
    }

    public void clickContinueButton(){
        continueButton.click();
    }

}


