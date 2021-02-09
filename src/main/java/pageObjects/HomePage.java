package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import managers.FileReaderManager;

public class HomePage {
	WebDriver driver;
	private final By signIn = By.linkText("Sign in");
	private final By emailId = By.id("email");
	private final By pwd = By.id("passwd");
	private final By submitLogin = By.id("SubmitLogin");
	private final By loginMessage = By.cssSelector(".info-account");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateTo_HomePage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}

	public void navigateTo_LoginPage() {
		driver.findElement(signIn).click();
	}

	public void enterUserCredentials(String username, String password) {
		driver.findElement(emailId).sendKeys(username);
		driver.findElement(pwd).sendKeys(password);
		driver.findElement(submitLogin).click();
	}

	public String getLoginMessage() {
		return driver.findElement(loginMessage).getText();
	}

}