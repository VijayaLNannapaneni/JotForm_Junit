package com.Jotform.Registration.stepFunctions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import com.github.javafaker.Faker;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.JavascriptExecutor;


public class startPage{
	static WebDriver driver;
	String baseUrl = "https://www.jotform.com/form-templates/class-registration-3";
	
	@BeforeClass	
	public static void	openBrowser(){
		System.setProperty("webdriver.chrome.driver","\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		String baseUrl = "https://www.jotform.com/form-templates/class-registration-3";
		driver.get(baseUrl);
	}

	@Test
	public void assertContent() {		
		String expectedTitle = "Course Registration Form Template | JotForm";
		String actualTitle = "";  
		
		// get the actual value of the title
		actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		/*
		 * compare the actual title of the page with the expected one and print
		 * the result as correct page or not
		 */
		if (actualTitle.contentEquals(expectedTitle)){
			System.out.println("Student Registration Page!");
		} else {
			System.out.println("Wrong Page");
		} 
	
	}
	
	@Test
	public void enterStudentData() throws Exception{	
		Faker faker = new Faker();		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		//List<WebElement> iframes = driver.findElements(By.xpath("//iframe[contains(@src,'//www.googletagmanager.com/ns.html?id=GTM-TDFT5J')]"));
		//System.out.print( " iframes " + iframes.size());		
		//WebElement modal = driver.findElement(By.xpath("//*[@id=\"formPreviewArea\"]"));		
		//driver.switchTo().frame(modal);
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		// Can't get to these form elements
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
    @AfterClass
    public static void tearDown(){
    	driver.quit();
    }
        
        
   
  
	

	

}
