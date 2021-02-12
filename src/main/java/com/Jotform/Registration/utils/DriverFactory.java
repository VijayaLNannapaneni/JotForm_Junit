package com.Jotform.Registration.utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class DriverFactory {
    public static WebDriver driver;
    public static PageInitialization pageInits;
    public WebDriver getDriver() {          
    	System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");
        pageInits = new PageInitialization();       
     return driver;
    }
}
