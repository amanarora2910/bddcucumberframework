package resources.stepsDefinition;

import org.junit.Assert;

import contexts.TestContext;
import cucumber.api.java.en.Given;
import managers.FileReaderManager;
import pageObjects.HomePage;

public class LoginStepDefinition {

	TestContext testContext;
	HomePage homePage;
	public final String loginSuccessfulMessage = "Welcome to your account. Here you can manage all of your personal information and orders.";

	public LoginStepDefinition(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
	}

	@Given("^user is logged in$")
	public void user_is_on_homepage() {
		homePage.navigateTo_HomePage();
		homePage.navigateTo_LoginPage();
		homePage.enterUserCredentials(FileReaderManager.getInstance().getConfigReader().getUsername(), 
				FileReaderManager.getInstance().getConfigReader().getPassword());
		Assert.assertEquals(loginSuccessfulMessage, homePage.getLoginMessage());		
	}
}
