package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports generateExtentReport() {
		
		ExtentReports extentReports = new ExtentReports();
		
		File extentFile = new File(System.getProperty("user.dir")+"/test-output/ExtentReport/extentReport.html");
		
		ExtentSparkReporter extentsparkreporter = new ExtentSparkReporter(extentFile);
		
		extentsparkreporter.config().setTheme(Theme.DARK);
		extentsparkreporter.config().setReportName("OPEND Email Marketing");
		extentsparkreporter.config().setDocumentTitle("Automation Report");
		extentsparkreporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentReports.attachReporter(extentsparkreporter);
		
		Properties configprop = new Properties();
		
		File configFile = new File(System.getProperty("user.dir")+"/src/main/java/config/config.properties");
		
		try {
		FileInputStream fis = new FileInputStream(configFile);
		configprop.load(fis);
		} catch(Throwable e) {
			e.printStackTrace();
		}
		
		
		extentReports.setSystemInfo("Application URL", configprop.getProperty("url"));
		extentReports.setSystemInfo("Browser Name", configprop.getProperty("BrowserName"));
		extentReports.setSystemInfo("User Name", configprop.getProperty("userName"));
		extentReports.setSystemInfo("Password", configprop.getProperty("password"));
		extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReports.setSystemInfo("Username",System.getProperty("user.name"));
		extentReports.setSystemInfo("Java Version",System.getProperty("java.version"));
		
		return extentReports;
	}
	
	
}
