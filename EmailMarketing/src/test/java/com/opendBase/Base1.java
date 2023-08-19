package com.opendBase;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base1 {

	WebDriver driver;
	public Properties prop;
	public Properties PropData;
	
//	public void loadproperties() {   // we can call by method to other class (Through Extends)
		public Base1() {	        // OR by call by creating a constructor (Through Super)
		
		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"/src/main/java/config/config.properties");
		try {
		FileInputStream fis = new FileInputStream(propFile);
		prop.load(fis);
	} catch(Throwable e) {
		e.printStackTrace();
	}
		
		PropData = new Properties();
		File TestDataFile = new File(System.getProperty("user.dir")+"/src/main/java/testdata/TestData.properties");
		try {
		FileInputStream fis = new FileInputStream(TestDataFile);
		PropData.load(fis);
		} catch(Throwable e) {
			e.printStackTrace();
		}
	}
	
	public WebDriver initializeBrowser(String BrowserName) {
			
		if(BrowserName.equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
			
		} else if(BrowserName.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
			
		} else if (BrowserName.equalsIgnoreCase("edge")) {
			 
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
//		driver.get("https://campaignsopend.tech-active.com/#/admin_login");
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		return driver;
	}
	
	
}
