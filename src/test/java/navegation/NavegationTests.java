package navegation;

import base.BaseTests;
import org.testng.annotations.Test;

public class NavegationTests extends BaseTests {

    @Test
    public void testNavigator() {
        homePage.clickDynamicLoading().clickExample1();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://www.google.com");
    }

    @Test
    public void testSwitchTab(){
        homePage.clickMultipleWindows().clickHere();
        getWindowManager().swtichToTab("New Window");
    }
}
