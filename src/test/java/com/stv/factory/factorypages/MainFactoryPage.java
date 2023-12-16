package com.stv.factory.factorypages;

import com.stv.framework.core.drivers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainFactoryPage extends FactoryPage {

    @FindBy(css = "[aria-label='Sign in']")
    private WebElement accountLink;

    @FindBy(xpath = "//button[contains(text(),'Accept all')]")
    private WebElement trustButton;

    @FindBy(xpath = "//button[@aria-label='Basket']")
    private WebElement basketIcon;

    @FindBy(xpath = "//h1[contains(text(),'Your shopping basket is empty')]")
    private WebElement emptyBasketTitle;

    @FindBy(xpath = "//button[@class='Button_button__8B4nB Button_secondary__k_TzE Button_sizeButtonXxsmallXlarge__Lrcw1 EmptyBasket_signinButton__nxEK7']")
    private WebElement signInButton;



    public boolean isAccountLinkDisplayed(){
        return accountLink.isDisplayed();
    }

    public void clickOnAccountLink(){
        accountLink.click();
    }

    public void clickOnTrustButton(){
        trustButton.click();
    }

    public void clickOnBasketIcon() {
        basketIcon.click();
    }

    public boolean isEmptyBasketTitleDisplayed(){
        return emptyBasketTitle.isDisplayed();
    }

    public void clickOnSignInButton() {
        signInButton.click();
    }

}

