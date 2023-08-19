package com.OpendTestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.opendBase.Base1;

import Pages.DashboardPage;
import Pages.LoginPage1;

public class DashboardTest extends Base1 {
	
	public WebDriver driver;
	DashboardPage dashboardPage;
	
	public DashboardTest() {
		super();
	}

	@BeforeMethod
	public void Setup()  {
		
		driver = initializeBrowser(prop.getProperty("BrowserName"));
		LoginPage1 loginpage = new LoginPage1(driver);
//		loginpage.NavigatetoLoginpage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void DashboardFrame() throws InterruptedException {
		

		
		LoginPage1 loginPage1 = new LoginPage1(driver);
		loginPage1.NavigatetoLoginpage(prop.getProperty("userName"),prop.getProperty("password"));
		Thread.sleep(1500);
		dashboardPage = new DashboardPage(driver);
		dashboardPage.NavigateToDashboardActions();
		
//		Method = 1         
//		***************** 
		
//		dashboardPage = new DashboardPage(driver);
//		Thread.sleep(2000);
//		dashboardPage.EnterintoTheFrame();
//		dashboardPage.ClickOnAllstatusDropDown();
//		dashboardPage.SelectCompletedCheckBox();
//		dashboardPage.ClickOnApplyButton();
//		Thread.sleep(1000);
//		dashboardPage.ClickOnRecurringDropDown();
//		dashboardPage.ClickonRecurringCheckBox();
//		dashboardPage.ClickOnApplyButton2();
//		Thread.sleep(1000);
//		dashboardPage.ClickOnDateStatus();
//		Thread.sleep(1000);
//		dashboardPage.VerifyApplyButton();
//		dashboardPage.clickOnyesterdaycheckbox();
//		Thread.sleep(1000);
//		dashboardPage.VerifyApplyButton();
//		dashboardPage.ClickOnApplyButton_01();
	}
}
