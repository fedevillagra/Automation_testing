package login;

import base.BaseTests;
import com.epam.automation.pages.LoginPage;
import com.epam.automation.pages.SecureAreaPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginTests extends BaseTests {

    @Test
    public void testSucessfullLogin() {
        LoginPage loginPage = homePage.clickAuthenticationLink();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        assertTrue(secureAreaPage.getAlertText()
                        .contains("You logged into a secure area!"),
                "Alert text is incorrect");
    }

}
