package com.epam.automation.pages;

import org.openqa.selenium.*;

public class LargeAndDeepDomPage {
    private WebDriver driver;
    private By table = By.id("large-table");

    public LargeAndDeepDomPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToTable(){
        WebElement tableElement = driver.findElement(table);
        String script = "arguments[0].scrollIntoView()";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, tableElement);
    }
}
