package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	
	WebDriver driver;
	
	
//	@FindBy(id="email_id") private WebElement usertextfield;
//	@FindBy(id="password") private WebElement passwordtextfield;
//	@FindBy(xpath ="//button[.='Sign In']") private WebElement sign_inButton;
	@FindBy(xpath ="//iframe[@title='DashBoard']") private WebElement Frame1;
	@FindBy(xpath="(//div[@class='DropdownWithApply'])[1]") private WebElement AllStatus;
	@FindBy(xpath="//div[@class='Custom-Checkbox']//label[.='Completed']") private WebElement CompletedcheckBox;
	@FindBy(xpath="//input[@type='submit']") private WebElement ApplyButton1;
	@FindBy(xpath="(//div[@class='DropdownWithApply'])[2]") private WebElement Recurring;
	@FindBy(xpath = "//div[@class='Custom-Checkbox']//label[.='Recurring']") private WebElement RecurringCheckBox;
	@FindBy(xpath="//input[@type='submit']") private WebElement ApplyButton2;
	@FindBy(xpath="(//div[@class='DropdownWithApply'])[3]/div/p") private WebElement Date;
	@FindBy(xpath="//input[@type='submit']") private WebElement VerifyButton;
	@FindBy(xpath="(//div[@class='Radio'])[2]") private WebElement yesterday;
	@FindBy(xpath="//input[@type='submit']") private WebElement ApplyButton3;
	@FindBy(linkText="Advertisers") private WebElement advertiserTab;
	@FindBy(linkText = "Publishers") private WebElement publisherTab;
	@FindBy(linkText ="Domains") private WebElement domainsTab;
	@FindBy(linkText = "Api's") private WebElement ApisTab;
	@FindBy(xpath = "//div[@class='nav-title']") private WebElement adminelementText;
	@FindBy(xpath="//input[@id='filter-text-box']") private WebElement SearchTextField;
	
	
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	public void EnterEmailID(String emailText) {	
//		usertextfield.sendKeys(emailText);
//	}
//	
//	public void Enterpassword(String passwordText) {		
//		passwordtextfield.sendKeys(passwordText);
//	}
//	
//	public void ClickSignInButton() {
//		sign_inButton.click();
//	}
//  *********************************************************
//	public void EnterintoTheFrame() {
//		driver.switchTo().frame(Frame1);
//	}
//	
//	public void ClickOnAllstatusDropDown() {
//		AllStatus.click();
//	}
//	
//	public void SelectCompletedCheckBox() {
//		CompletedcheckBox.click();
//	}
//	
//	public void ClickOnApplyButton() {
//		ApplyButton1.click();
//	}
//	
//	public void ClickOnRecurringDropDown() {
//		Recurring.click();
//	}
//	
//	public void ClickonRecurringCheckBox() {
//		RecurringCheckBox.click();
//	}
//	
//	public void ClickOnApplyButton2() {
//		ApplyButton2.click();
//	}
//	
//	public void ClickOnDateStatus() {
//		Date.click();
//	}
//	
//	public void VerifyApplyButton() {
//		boolean applybutton = VerifyButton.isDisplayed();
//		System.out.println(applybutton);
//	}
//	
//	public void clickOnyesterdaycheckbox() {
//		yesterday.click();
//	}
//	
//	public void ClickOnApplyButton_01() {
//		ApplyButton3.click();
//	}
//	
//	public void ClickOnadvertiserTab() {
//		advertiserTab.click();
//	}
//	
//	public void ClickOnpublisherTab() {
//		publisherTab.click();
//	}
//	
//	public void clickOndomainsTab() {
//		domainsTab.click();
//	}
//	
//	public void ClickonAPITab() {
//		ApisTab.click();
//	}
//	
//	public void CloseFrame() {
//		driver.switchTo().defaultContent();
//	}
//	
//	public void VerifyElementText() {
//		WebElement adminconsole = adminelementText;
//		System.out.println(adminconsole.getText());
//	}
	
	public void NavigateToDashboardActions() throws InterruptedException {
		driver.switchTo().frame(Frame1);
		AllStatus.click();
		CompletedcheckBox.click();
		ApplyButton1.click();
		Thread.sleep(1000);
		Recurring.click();
		RecurringCheckBox.click();
		ApplyButton2.click();
		Thread.sleep(1000);
		Date.click();
		boolean applybutton = VerifyButton.isDisplayed();
		System.out.println(applybutton);
		yesterday.click();
		ApplyButton3.click();
		advertiserTab.click();
		publisherTab.click();
		domainsTab.click();
		ApisTab.click();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		WebElement adminconsole = adminelementText;
		System.out.println(adminconsole.getText());
	}
	
}
