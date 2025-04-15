package alerts;

import base.BaseTests;
import com.epam.automation.pages.AlertsPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AlertTests extends BaseTests {
    AlertsPage alertsPage;

    @Test
    public void testAcceptAlert(){
        alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerAlert();
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(),"You successfully clicked an alert");
    }
    @Test
    public void testGetTextFromAlert(){
        alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerConfirm();
        String text = alertsPage.alert_getText();
        alertsPage.alert_clickToDismiss();
        assertEquals(text,"I am a JS Confirm","Alert text incorrect");
    }

    @Test
    public void testSetInputInAlert(){
        alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerPrompt();
        String text = "boca boca boca";
        alertsPage.alert_setInput(text);
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(),"You entered: " + text,"Results text incorrect");
    }
}
