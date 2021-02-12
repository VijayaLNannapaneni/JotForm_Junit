package com.Jotform.Registration.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.Jotform.Registration.pageObjects.StudentRegistrationForm;
public class PageInitialization {
    public WebDriver driver;
    public StudentRegistrationForm studentRegForm;
    public PageInitialization() {
        driver = DriverFactory.driver;
        studentRegForm = PageFactory.initElements(driver, StudentRegistrationForm.class);
    }
}
