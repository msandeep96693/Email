package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage1 {

	WebDriver driver;
	
	@FindBy(id="email_id") private WebElement usertextfield;
	@FindBy(id="password") private WebElement passwordtextfield;
	@FindBy(xpath ="//button[.='Sign In']") private WebElement sign_inButton;
	@FindBy(xpath = "//div[@class='nav-title']") private WebElement adminelementText;
	@FindBy(xpath ="//div[@id='alert_failed']") private WebElement WarningmessageText;
	
	public LoginPage1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void EnterEmailID(String emailText) {	
		usertextfield.sendKeys(emailText);
	}
	
	public void Enterpassword(String passwordText) {		
		passwordtextfield.sendKeys(passwordText);
	}
	
	public void ClickSignInButton() {
		sign_inButton.click();
	}
	
	public void VerifyElementText() {
		WebElement adminconsole = adminelementText;
		System.out.println(adminconsole.getText());
	}
	
	public void verifyWarningText() {
		WebElement WarningMessage = WarningmessageText;
		System.out.println(WarningMessage.getText());
	}
	public LoginPage1 NavigatetoLoginpage(String emailText, String passwordText) throws InterruptedException {
		usertextfield.sendKeys(emailText);
		passwordtextfield.sendKeys(passwordText);
		sign_inButton.click();
		Thread.sleep(1000);
		return new LoginPage1(driver);
	}
	
	public LoginPage1 NavigatetoVerifyByValidcredentials(String emailText, String passwordText) throws InterruptedException {
		usertextfield.sendKeys(emailText);
		passwordtextfield.sendKeys(passwordText);
		sign_inButton.click();
		Thread.sleep(1000);
		return new LoginPage1(driver);
	}
	
	public LoginPage1 NavigateToverifyByinvalidcredentials(String emailText, String passwordText) throws InterruptedException {
		usertextfield.sendKeys(emailText);
		passwordtextfield.sendKeys(passwordText);
		sign_inButton.click();
		Thread.sleep(1000);
		return new LoginPage1(driver);
	}
	
	public LoginPage1 NavigateToverifyByvalidEmailIDandInvalidPassword(String emailText, String passwordText) throws InterruptedException {
		usertextfield.sendKeys(emailText);
		passwordtextfield.sendKeys(passwordText);
		sign_inButton.click();
		Thread.sleep(1000);
		return new LoginPage1(driver);
	}
	
	public LoginPage1 NavigateToverifyByInvalidEmailIDandvalidPassword(String emailText, String passwordText) throws InterruptedException {
		usertextfield.sendKeys(emailText);
		passwordtextfield.sendKeys(passwordText);
		sign_inButton.click();
		Thread.sleep(1000);
		return new LoginPage1(driver);
	}
	
	public LoginPage1 NavigateToverifyBywithoutprovidingcredentials(String emailText, String passwordText) throws InterruptedException {
		usertextfield.sendKeys("");
		passwordtextfield.sendKeys("");
		sign_inButton.click();
		Thread.sleep(1000);
		return new LoginPage1(driver);
	}
	
}
