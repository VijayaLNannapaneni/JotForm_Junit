package com.Jotform.Registration.pageObjects;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class StudentRegistrationForm extends BasePage{
    Faker faker = new Faker();
    WebElement fName = driver.findElement(By.id("first_4"));
    WebElement mName = driver.findElement(By.id("middle_4"));
    WebElement lName = driver.findElement(By.id("last_4"));
    Select drpdob_month = new Select(driver.findElement(By.id("input_24_month")));
    Select drpdob_year = new Select(driver.findElement(By.id("input_24_year")));
    Select drpdob_day = new Select(driver.findElement(By.id("input_24_day")));
    Select drpGender = new Select(driver.findElement(By.name("q3_gender")));
    WebElement address1 = driver.findElement(By.id("input_23_addr_line1"));
    WebElement address2 = driver.findElement(By.id("input_23_addr_line2"));
    WebElement city = driver.findElement(By.id("input_23_city"));
    WebElement state = driver.findElement(By.id("input_23_state"));
    WebElement zipcode = driver.findElement(By.id("input_23_postal"));
    WebElement email = driver.findElement(By.id("input_6"));
    WebElement mobileNo = driver.findElement(By.id("input_27_full"));
    WebElement workNum = driver.findElement(By.id("input_26_full"));
    WebElement phoneNo = driver.findElement(By.id("input_25_full"));
    WebElement company = driver.findElement(By.id("input_14"));
    Select drpcourses = new Select(driver.findElement(By.id("input_46")));
    WebElement comments = driver.findElement(By.id("id_45"));
    WebElement header = driver.findElement(By.id("subHeader_1"));
    WebElement btnSubmit = driver.findElement(By.id("input_20"));
    String firstName = "";
    String middleName = "";
    String lastName = "";
    public StudentRegistrationForm() throws IOException {
    }
    public void loadStudentRegistrationPage() {
        String URL= "https://www.jotform.com/form-templates/class-registration-3";//Constants.url;
        String actualText = "Fill out the form carefully for registration";
        System.out.println("URL" + URL);
        driver.navigate().to(URL);
        String headerText = header.getText();
        if (WaitUntilWebElementIsVisible(header)) {
            assertEquals(headerText,actualText);
        }
        else {
            System.out.println("Wrong page to test");
        }
    }
    public void enterStudentData(){
        firstName = faker.name().firstName();
        middleName = faker.name().nameWithMiddle();
        lastName = faker.name().lastName();
        String fAddress1 = faker.address().streetName();
        String fCity = faker.address().city();
        String fZipCode = faker.address().zipCode();
        String fState = faker.address().state();
        String fEmail = faker.internet().emailAddress();
        String workPhone = faker.phoneNumber().cellPhone();
        String cellPhone = faker.phoneNumber().cellPhone();
        String Phone = faker.phoneNumber().phoneNumber();
        String gender = "N/A";
        String month = "November";
        String year = "2000";
        String day = "15";
        String sCompany = "XYZ Company";
        String sCourse = "Math 101";
        String sComments = "I am interested in this course because ........................................";
        fName.sendKeys(firstName);
        mName.sendKeys(middleName);
        lName.sendKeys(lastName);
        drpdob_month.selectByVisibleText(month);
        drpdob_year.selectByVisibleText(year);
        drpdob_day.selectByVisibleText(day);
        drpGender.selectByVisibleText(gender);
        address1.sendKeys(fAddress1);
        //address2.sendKeys();
        city.sendKeys(fCity);
        state.sendKeys(fState);
        zipcode.sendKeys(fZipCode);
        email.sendKeys(fEmail);
        mobileNo.sendKeys(cellPhone);
        workNum.sendKeys(workPhone);
        phoneNo.sendKeys(Phone);
        company.sendKeys(sCompany);
        drpcourses.selectByVisibleText(sCourse);
        comments.sendKeys(sComments);
    }
    public void submitForm() throws IOException, InterruptedException {
        if ((fName.getAttribute("value").length() > 0) & (lName.getAttribute("value").length() > 0)) {
            waitAndClickElement(btnSubmit);
            //wait 5 seconds after submitting the form
            wait(5000);
            //Assert first name, Last name and Middle Name of the student after submitting the form
            Assert.assertTrue(fName.getAttribute("value").equals(firstName));
            Assert.assertTrue(mName.getAttribute("value").equals(middleName));
            Assert.assertTrue(lName.getAttribute("value").equals(lastName));
        }
    }
}
