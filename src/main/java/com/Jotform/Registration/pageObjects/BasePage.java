package com.Jotform.Registration.pageObjects;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Jotform.Registration.utils.DriverFactory;

public class BasePage extends DriverFactory {
    protected WebDriverWait wait;
    protected JavascriptExecutor jsExecutor;   
    public BasePage() throws IOException {
        this.wait = new WebDriverWait(driver, 15);
        jsExecutor = ((JavascriptExecutor) driver);
    }
    
    public BasePage loadPageAndAssertContent(String url, String title) throws Exception {
    	System.setProperty("webdriver.chrome.driver","\\Drivers\\chromedriver.exe");    	       
        String actualTitle = "";    
        driver.get(url);
        // get the actual value of the title
        actualTitle = driver.getTitle();
        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(title)){
            System.out.println("Success!");
        } else {
            System.out.println("Wrong Page");
        }	
    	
        driver.navigate().to(url);
        return new BasePage();
    }
    //wait methods
    public boolean WaitUntilWebElementIsVisible(WebElement element) {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(element));
            System.out.println("WebElement is visible using locator: " + "<" + element.toString() + ">");
            return true;
        } catch (Exception e) {
            System.err.println("WebElement is NOT visible, using locator: " + "<" + element.toString() + ">");
            Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
            return false;
        }
    }
   // wait method
    //Throws IOException
    public void waitAndClickElement(WebElement element) throws InterruptedException, IOException {
        boolean clicked = false;
        int attempts = 0;
        while (!clicked && attempts < 10) {
            try {
                this.wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                System.out.println("Successfully clicked on the WebElement: " + "<" + element.toString() + ">");
                clicked = true;
            } catch (Exception e) {
                System.err.println("Unable to wait and click on WebElement, Exception: " + e.getMessage());
                Assert.fail(
                        "Unable to wait and click on the WebElement, using locator: " + "<" + element.toString() + ">");
            }
            attempts++;
        }
    }
    //Wait and Check if webelement is present
    public boolean isElementPresent(WebElement element,int timeOutInSeconds) {
        try {
        	WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);           
            wait.ignoring(NoSuchElementException.class);
            wait.ignoring(ElementNotVisibleException.class);
            wait.ignoring(StaleElementReferenceException.class);
            wait.ignoring(NoSuchFrameException.class);
            wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
        return true;
        }
        catch(Exception e) {
            return false;
        }

    }
}
