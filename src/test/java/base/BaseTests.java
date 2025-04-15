package base;

import com.epam.automation.pages.HomePage;
import com.epam.automation.utils.WindowManager;
import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        goHome();

        //driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //System.out.println(driver.getTitle());
        //driver.manage().window().maximize();
        //driver.manage().window().fullscreen();
        //driver.manage().window().setSize(new Dimension(400,800));
        //driver.manage().deleteAllCookies();
        //List<WebElement> elements = driver.findElements(By.tagName("a"));
        //System.out.println(elements.size());
        //WebElement inputsLink = driver.findElement(By.linkText("Inputs"));
        //inputsLink.click();
    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown() {
            driver.quit();
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE){
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("src/test/resources/screenshots/" + result.getName() + ".png"));
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }
}