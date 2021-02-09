package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.HomePage;
import pageObjects.OrderItemPage;
import pageObjects.UpdatePersonalInfoPage;

public class PageObjectManager {
	private WebDriver driver;
	private HomePage homePage;
	private OrderItemPage orderItemPage;
	private UpdatePersonalInfoPage updatePersonalInfoPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public HomePage getHomePage(){
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}
	public OrderItemPage getOrderItemPage(){
		return (orderItemPage == null) ? orderItemPage = new OrderItemPage(driver) : orderItemPage;
	}
	public UpdatePersonalInfoPage getUpdatePersonalInfoPage(){
		return (updatePersonalInfoPage == null) ? updatePersonalInfoPage = new UpdatePersonalInfoPage(driver) : updatePersonalInfoPage;
	}
	
}