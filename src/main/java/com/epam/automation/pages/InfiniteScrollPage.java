package com.epam.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {
    private WebDriver driver;
    By textBlocks = By.className("jscroll-added");

    public InfiniteScrollPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Scrolls until paragraph with index specified is in view
     * @param index l-based
     */
    public  void scrollToParagraph(int index){
        String script = "window.scrollTo(0, document.body.scrollHeight);";
        JavascriptExecutor js = (JavascriptExecutor) driver;

        while (getNumberOfParagraphPresent() < index){
            js.executeScript(script);
        }
    }

    private int getNumberOfParagraphPresent(){
        return driver.findElements(textBlocks).size();
    }
}
