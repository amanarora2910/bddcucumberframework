package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class UpdatePersonalInfoPage {
	WebDriver driver;
    private final By acctView = By.cssSelector("a[title='View my customer account']");
    private final By infoLink = By.cssSelector("a[title='Information']");
    private final By name = By.id("firstname");
    private final By pwd = By.id("old_passwd");
    private final By submitBtn = By.cssSelector("button[name='submitIdentity']");
    private final By successMsg = By.className("alert-success");

	public UpdatePersonalInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateTo_PersonalInfoPage() {
		WebElement viewMyAccountBtn = driver.findElement(acctView);
		viewMyAccountBtn.click();
	}

	public void viewPersonalInfo() {
		WebElement personalInformationBtn = driver.findElement(infoLink);
		personalInformationBtn.click();
	}

	public void enterFirstName(String firstName) {
		WebElement txtFirstName = driver.findElement(name);
		txtFirstName.clear();
		txtFirstName.sendKeys(firstName);
	}

	public void enterOldPassword(String oldPassword) {
		WebElement txtOldPassword = driver.findElement(pwd);
		txtOldPassword.clear();
		txtOldPassword.sendKeys(oldPassword);
	}

	public void savePersonInfo() {
		WebElement saveBtn = driver.findElement(submitBtn);
		saveBtn.click();
	}

	public boolean IsSuccessMessageDisplayed() {
		WebElement alertSuccessMessage = driver.findElement(successMsg);
		return alertSuccessMessage.isDisplayed();
	}
}
