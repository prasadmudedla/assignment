package io.github.prasadmudedla.android.pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.github.prasadmudedla.drivers.AndroidDriverManager.getDriver;

public class HomePage {
    private final WebDriverWait wait;

    public HomePage() {
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    }

    public String getTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated
                (AppiumBy.androidUIAutomator("new UiSelector().text(\"WEBDRIVER\")"))).getText();
    }

    void openMenu(String menuName) {
        getDriver().findElement(AppiumBy.accessibilityId(menuName)).click();

    }

    public String tagLine() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.androidUIAutomator("new UiSelector().text(\"Demo app for the appium-boilerplate\")"))
        ).getText();
    }

}
