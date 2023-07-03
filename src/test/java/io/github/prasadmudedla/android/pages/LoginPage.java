package io.github.prasadmudedla.android.pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;

import static io.github.prasadmudedla.drivers.AndroidDriverManager.getDriver;

public class LoginPage {

    private WebElement emailField() {
        return getDriver().findElement(AppiumBy.accessibilityId("input-email"));
    }

    private WebElement passwordField() {
        return getDriver().findElement(AppiumBy.accessibilityId("input-password"));
    }

    private WebElement loginBtn() {
        return getDriver().findElement(AppiumBy.accessibilityId("button-LOGIN"));
    }

    public String getSuccessMessageTitle() {
        return getDriver().findElement(AppiumBy.id("android:id/alertTitle")).getText();
    }

    public String getSuccessMessage() {
        return getDriver().findElement(AppiumBy.id("android:id/message")).getText();
    }

    private WebElement okBtn() {
        return getDriver().findElement(AppiumBy.id("android:id/button1"));
    }

    public void login(String email, String password) {
        HomePage homePage = new HomePage();
        homePage.openMenu("Login");
        emailField().sendKeys(email);
        passwordField().sendKeys(password);
        loginBtn().click();
    }

    public void closeSuccessMessage() {
        okBtn().click();
    }


}
