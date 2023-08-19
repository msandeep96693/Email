package com.OpendTestCases;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import com.opendBase.Base1;

import Pages.LoginPage1;
import Utils.Utilities;
import Utils.Utilities1;

public class LoginTest1 extends Base1{
	
	public WebDriver driver;
	public LoginPage1 login;
	
	public LoginTest1() {
		super();
	}


	@BeforeMethod
	public void setup() {
		
//		loadproperties();	  // we can call directly by method from Base1 class  (OR)  by creating constructor
		driver = initializeBrowser(prop.getProperty("BrowserName"));
		
	}
	
	@AfterMethod
	public void TearDown() {
		
		driver.close();
	}
	
	@Test(priority = 1)
	public void verifyByValidcredentials() throws InterruptedException {
		
//		Method 3
//		***************************
		
		login = new LoginPage1(driver);
		login.NavigatetoVerifyByValidcredentials(prop.getProperty("userName"),prop.getProperty("password"));
		login.VerifyElementText();
		
		
		
//		Method 2 
//		**************
		
//		login =new LoginPage1(driver);
//		login.EnterEmailID(prop.getProperty("userName"));
//		login.Enterpassword(prop.getProperty("password"));
//		login.ClickSignInButton();
//		login.VerifyElementText();
		
//		Method 1
//		*************  
		
//		driver.findElement(By.id("email_id")).sendKeys(prop.getProperty("userName"));
//		driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
//		driver.findElement(By.xpath("//button[.='Sign In']")).click();
//		Thread.sleep(1000);
//		WebElement warningmessage = driver.findElement(By.xpath("//div[@id='alert_failed']"));
//		System.out.println(warningmessage.getText());
//		WebElement verifybyelement = driver.findElement(By.xpath("//div[@class='nav-title']"));
//		System.out.println(verifybyelement.getText());
	}
	
	
	@Test(priority = 2, dataProvider = "DataSupplier")
	public void verifyByinvalidcredentials(String Email, String Password) throws InterruptedException {
		
//		Method 3
//		************		
//		       login.NavigateToverifyByinvalidcredentials(PropData.getProperty("InvalidUserName"),PropData.getProperty("InvalidPassword"));
//		login.verifyWarningText();
		
		login = new LoginPage1(driver);
		login.NavigateToverifyByinvalidcredentials(Email, Password);
		login.verifyWarningText();		
		
//		Method = 2
//		*****************				
//		login =new LoginPage1(driver);
//		login.EnterEmailID(Email);
//		login.Enterpassword(Password);
//		login.ClickSignInButton();
//		Thread.sleep(1000);
//		login.verifyWarningText();
		
		
//		Method = 1
//		*****************
//		driver.findElement(By.id("email_id")).sendKeys(PropData.getProperty("InvalidUserName"));
//		driver.findElement(By.id("password")).sendKeys(PropData.getProperty("InvalidPassword"));		
//		driver.findElement(By.id("email_id")).sendKeys(Email);
//		driver.findElement(By.id("password")).sendKeys(Password);	
//		driver.findElement(By.xpath("//button[.='Sign In']")).click();
//		Thread.sleep(1000);
//		WebElement emailIDfail = driver.findElement(By.xpath("//div[@id='alert_failed']"));
//		if(emailIDfail.isDisplayed()) {
//			System.out.println("Warning Message is Displayed");
//		} else {
//			System.out.println("Warning Message is Not Displayed");
//		}
//		WebElement warningmessage = driver.findElement(By.xpath("//div[@id='alert_failed']"));
//		System.out.println(warningmessage.getText());
	}
	
	
	@DataProvider(name="DataSupplier")
	public Object[][] SupplyTestData() {
		 
//      Object[][] data = {{"admin@opend.com", "1234"},{"admin@opend.com","1234"}};
		Object[][] data = Utilities1.ExtractdatafromExcel("Login");
		return data;
	}
	
	
	
	@Test(priority = 3, enabled = true )
	public void verifyByvalid_emailID_invalidpassword() throws InterruptedException {
		
//		MEthod = 3
//		****************
		login = new LoginPage1(driver);
		login.NavigateToverifyByvalidEmailIDandInvalidPassword(prop.getProperty("userName"),PropData.getProperty("InvalidPassword"));
		login.verifyWarningText();
		
		
		
//		MEthod = 2
//		***********************
//		login =new LoginPage1(driver);
//		login.EnterEmailID(prop.getProperty("userName"));
//		login.Enterpassword(PropData.getProperty("InvalidPassword"));
//		login.ClickSignInButton();
//		Thread.sleep(1000);
//		login.verifyWarningText();
		
		
//		MEthod = 1
//		***********************
//		driver.findElement(By.id("email_id")).sendKeys(prop.getProperty("userName"));
//		driver.findElement(By.id("password")).sendKeys(PropData.getProperty("InvalidPassword"));
//		driver.findElement(By.xpath("//button[.='Sign In']")).click();
//		Thread.sleep(1000);
//		WebElement invalidcredentials = driver.findElement(By.xpath("//div[@id='alert_failed']"));
//		if(invalidcredentials.isDisplayed()) {
//			System.out.println("Warning Message is Displayed");
//		} else {
//			System.out.println("Warning Message is not Displayed");
//		}
//		WebElement warningmessage = driver.findElement(By.xpath("//div[@id='alert_failed']"));
//		System.out.println(warningmessage.getText());
		}
	

	
	@Test(priority = 4, enabled = true)
	public void verifyByinvalid_emailID_validpassword() throws InterruptedException {
		
//		MEthod = 1
//		***********************
		login = new LoginPage1(driver);
		
		login.NavigateToverifyByInvalidEmailIDandvalidPassword(PropData.getProperty("InvalidUserName"),prop.getProperty("password"));
		login.verifyWarningText();
		
		
//		MEthod = 2
//		***********************
		
//		login =new LoginPage1(driver);
//		login.EnterEmailID(PropData.getProperty("InvalidUserName"));
//		login.Enterpassword(prop.getProperty("password"));
//		login.ClickSignInButton();
//		Thread.sleep(1000);
//		login.verifyWarningText();
		
//		MEthod = 1
//		***********************
		
//		driver.findElement(By.id("email_id")).sendKeys(PropData.getProperty("InvalidUserName"));
//		driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
//		driver.findElement(By.xpath("//button[.='Sign In']")).click();
//		Thread.sleep(1000);
//		WebElement invalidcredentials = driver.findElement(By.xpath("//div[@id='alert_failed']"));
//		if(invalidcredentials.isDisplayed()) {
//			System.out.println("Warning message is displayed");
//		} else {
//			System.out.println("Warning message is not displayed");
//		}
//		WebElement warningmessage = driver.findElement(By.xpath("//div[@id='alert_failed']"));
//		System.out.println(warningmessage.getText());
		
	}
	
	@Test(priority = 5, enabled = true)
	public void verifyBywithoutprovidingcredentials() throws InterruptedException {
		
//		MEthod = 3
//		***********************
		
		login = new LoginPage1(driver);
		login.NavigateToverifyBywithoutprovidingcredentials("", "");
		login.verifyWarningText();
		
		
//		MEthod = 2
//		***********************
		
//		login =new LoginPage1(driver);
//		login.EnterEmailID("");
//		login.Enterpassword("");
//		login.ClickSignInButton();
//		Thread.sleep(1000);
//		login.verifyWarningText();
		
//		MEthod = 1
//		***********************
		
//		driver.findElement(By.id("email_id")).sendKeys("");
//		driver.findElement(By.id("password")).sendKeys("");
//		driver.findElement(By.xpath("//button[.='Sign In']")).click();
//		Thread.sleep(1000);
//		WebElement withoutcredentials = driver.findElement(By.xpath("//div[@id='alert_failed']"));
//		if(withoutcredentials.isDisplayed()) {
//			System.out.println("Warning Message is Displayed");
//		} else {
//			System.out.println("Warning Message is Not Displayed");
//		}
//		WebElement warningmessage = driver.findElement(By.xpath("//div[@id='alert_failed']"));
//		System.out.println(warningmessage.getText());
	}
}
