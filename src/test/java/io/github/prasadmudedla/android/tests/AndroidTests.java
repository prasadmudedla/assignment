package io.github.prasadmudedla.android.tests;

import io.github.prasadmudedla.android.pages.HomePage;
import io.github.prasadmudedla.android.pages.LoginPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AndroidTests {
    @Test
    public void testHomePageTitle() {
        HomePage homePage = new HomePage();
        assertEquals(homePage.getTitle(), "WEBDRIVER");
        assertEquals(homePage.tagLine(), "Demo app for the appium-boilerplate");
    }

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("test@email.com", "Pass@12345");
        assertEquals(loginPage.getSuccessMessageTitle(), "Success");
        assertEquals(loginPage.getSuccessMessage(), "You are logged in!");
        loginPage.closeSuccessMessage();
    }

}
