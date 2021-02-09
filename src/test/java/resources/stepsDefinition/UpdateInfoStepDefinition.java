package resources.stepsDefinition;

import org.junit.Assert;

import contexts.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.FileReaderManager;
import pageObjects.UpdatePersonalInfoPage;

public class UpdateInfoStepDefinition {
	TestContext testContext;
	UpdatePersonalInfoPage updatePersonalInfoPage;

	public UpdateInfoStepDefinition(TestContext context){
		testContext = context;
		updatePersonalInfoPage = testContext.getPageObjectManager().getUpdatePersonalInfoPage();
	}
	
	@When("^user navigates to My Personal Information Page$")
	public void user_is_on_MyAccountPage(){
		updatePersonalInfoPage.navigateTo_PersonalInfoPage();
		updatePersonalInfoPage.viewPersonalInfo();
	}
	@And("^user updates First Name to \"([^\"]*)\"$")  
	public void updateFirstNameTo(String firstName){
		updatePersonalInfoPage.enterFirstName(firstName);
		updatePersonalInfoPage.enterOldPassword(FileReaderManager.getInstance().getConfigReader().getPassword());
		updatePersonalInfoPage.savePersonInfo();
	}
	@Then("^Personal Information updated successfully$")
	public void personalInfoSavedSuccessfully(){
		Assert.assertTrue(updatePersonalInfoPage.IsSuccessMessageDisplayed());
	}
}