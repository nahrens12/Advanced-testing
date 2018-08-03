package com.qa.PetClinicSel;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.PendingException;

import gherkin.lexer.Pa;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class PetClinicTest {
	
	
	WebDriver driver;
    ExtentTest test;
    ExtentReports reports;
    
    @Before
    public void setUp()
    {
    	System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        reports = new ExtentReports("C:\\Users\\Admin\\eclipse-workspace\\AdvanceTestingAssess\\Automated_PetClinic_Sel.html", true);
        test = reports.startTest("Automated");	
    	
    }
	
    @After
    public void tearDown()
    {
    	try {
            Thread.sleep(3000);
        }catch (Exception e){

        }
    	
    	driver.quit();
    	 reports.endTest(test);
         reports.flush();
    	
    }
    
    @Test 
    public void homePage() throws InterruptedException
    {
    	driver.get("http://10.0.10.10:4200/petclinic/welcome");
        WebElement owner = driver.findElement(By.xpath("/html/body/app-root/div[1]/nav/div/ul/li[2]/a"));
        owner.click();
        Thread.sleep(200); 
      test.log(LogStatus.INFO, "Pet Clinic Home page opened");
      test.log(LogStatus.PASS, "Successful");
        
        WebElement addOwner = driver.findElement(By.xpath("/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[2]/a"));
        addOwner.click(); 
        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        firstName.sendKeys("Bob");
        WebElement lastName = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        lastName.sendKeys("Lee");
        WebElement address = driver.findElement(By.xpath("//*[@id=\"address\"]"));
        address.sendKeys("Layton Street");
        WebElement city = driver.findElement(By.xpath("//*[@id=\"city\"]"));
        city.sendKeys("Chicago");
        WebElement phoneNo = driver.findElement(By.xpath("//*[@id=\"telephone\"]"));
        phoneNo.sendKeys("98789");
        test.log(LogStatus.INFO, "Adding new owners information");
      test.log(LogStatus.FAIL, "If numbers are not together phone number wont work ");
        WebElement submit = driver.findElement(By.xpath("/html/body/app-root/app-owner-add/div/div/form/div[7]/div/button[2]"));
        submit.click();
        test.log(LogStatus.PASS, "Owner Successfully added");
        Thread.sleep(1000);
        
        WebElement selectName = driver.findElement(By.xpath("/html/body/app-root/app-owner-list/div/div/div/table/tbody/tr[12]/td[1]/a"));
        selectName.click();
        test.log(LogStatus.INFO, "Selecting an Owner from the List");
        Thread.sleep(1000);
        WebElement addNewPet = driver.findElement(By.xpath("/html/body/app-root/app-owner-detail/div/div/button[3]"));
        addNewPet.click();
        Thread.sleep(4000);
        test.log(LogStatus.INFO, "Can add new pet, can insert pet information");
        test.log(LogStatus.INFO, "Able to add numerous pets");
       
        WebElement backButton = driver.findElement(By.xpath("/html/body/app-root/app-pet-add/div/div/form/div[6]/div/button[1]"));
        backButton.click();
        test.log(LogStatus.INFO, "Back button allows us to go back to the owners profile");
      test.log(LogStatus.INFO, "Able to see your own pets on the Profile, if any have been added");
      test.log(LogStatus.INFO, "Pets can also be deleted from the Owners Profile");
        
        WebElement editOwner = driver.findElement(By.xpath("/html/body/app-root/app-owner-detail/div/div/button[2]"));
        editOwner.click();
      test.log(LogStatus.INFO, "Owners information can be edited on this page");
        
        WebElement lookingForOwner = driver.findElement(By.xpath("/html/body/app-root/div[1]/nav/div/ul/li[2]/a"));
        lookingForOwner.click();
        
        WebElement listOfOwners = driver.findElement(By.xpath("/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[1]/a"));
        listOfOwners.click(); 
      test.log(LogStatus.INFO, "List of Owners Displayed");
      test.log(LogStatus.PASS, "Successful");
        Thread.sleep(4000);
     
     assertEquals("Owners", driver.findElement(By.xpath("/html/body/app-root/app-owner-list/div/div/h2")).getText());
    }
}
