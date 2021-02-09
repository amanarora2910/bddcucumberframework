package pageObjects;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class OrderItemPage{
	WebDriver driver;
	private final By categoryMenu = By.className("sf-menu");
	private final By tShirtsSection = By.cssSelector("li:last-child a[title='T-shirts']");
	private final By getProductsAsList = By.className("icon-th-list");
	private final By addToCart = By.className("ajax_add_to_cart_button");
	private final By shoppingCart = By.className("layer_cart_cart");
	private final By containerBtn = By.className("button-container");
	private final By proceedLink = By.tagName("a");
	private final By proceedSignIn = By.className("standard-checkout");
	private final By proceedAddress = By.cssSelector("button[name='processAddress']");
	private final By tncChBox = By.id("cgv");
	private final By proceedShipping = By.className("standard-checkout");
	private final By payMethod = By.className("bankwire");
	private final By cartNav = By.id("cart_navigation");
	private final By submitOrder = By.cssSelector("button[type='submit']");
	private final By pgHeading = By.className("page-heading");
	private final By box = By.className("box");
	private final By orderHistoryLink = By.cssSelector("a[title='Back to orders']");
	private final By orderTable = By.tagName("tbody");
	private final By topOrder = By.className("first_item");
	private final By histLink = By.className("history_link");
	private final By histDate = By.className("history_date");
	private final By histPrice = By.className("history_price");
	private final By histMethod = By.className("history_method");
	public static String pageHeadingText;
	public static String orderReferenceAfterConfirm;
	public static String orderReference;
	public static String orderDate;
	public static String orderTotal;
	public static String paymentMethod;
	
	public OrderItemPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void openTshirtsTab() {
		WebElement topBarCategoryMenu = driver.findElement(categoryMenu);
		WebElement tShirtsTab = topBarCategoryMenu.findElement(tShirtsSection);
		tShirtsTab.click();
	}

	public void selectItemToPurchase() {
		WebElement viewProductasList = driver.findElement(getProductsAsList);
		viewProductasList.click();
	}

	public void AddItemToCart() {
		WebElement addToCartLink = driver.findElement(addToCart);
		addToCartLink.click();
	}

	public void proceedToCheckOut() {
		WebElement shoppingCartModal = driver.findElement(shoppingCart);
		WebElement btnContainer = shoppingCartModal.findElement(containerBtn);
		WebElement proceedToCheckoutBtn = btnContainer.findElement(proceedLink);
		proceedToCheckoutBtn.click();
	}

	public void proceedToCheckOutSignIn() {
		WebElement proceedToCheckoutSignInBtn = driver.findElement(proceedSignIn);
		proceedToCheckoutSignInBtn.click();
	}

	public void proceedToCheckOutAddress() {
		WebElement proceedToCheckoutAddressBtn = driver.findElement(proceedAddress);
		proceedToCheckoutAddressBtn.click();
	}

	public void agreeTnC() {
		WebElement termsOfServiceBox = driver.findElement(tncChBox);
		termsOfServiceBox.click();
		WebElement proceedToCheckoutShippingBtn = driver.findElement(proceedShipping);
		proceedToCheckoutShippingBtn.click();	
	}
	
	public void selectPaymentMethod(){
		WebElement payByBankWire = driver.findElement(payMethod);
		payByBankWire.click();
	}

	public void confirmOrder() {
		WebElement cartNavigationModal = driver.findElement(cartNav);
		WebElement confirmOrder = cartNavigationModal.findElement(submitOrder);
		confirmOrder.click();
	}

	public String getPageHeadingText() {
		WebElement pageHeading = driver.findElement(pgHeading);
		pageHeadingText = pageHeading.getText();
		return pageHeadingText;
	}

	
	public void verifyOrder() {
		WebElement infoBox = driver.findElement(box);
		String infoBoxText = infoBox.getText();
		Matcher matcher = Pattern.compile("[A-Z]{9}").matcher(infoBoxText);
		orderReferenceAfterConfirm = matcher.find() ? matcher.group(0) : null;
		WebElement orderHistoryBtn = driver.findElement(orderHistoryLink);
		orderHistoryBtn.click();
		WebElement tblBody = driver.findElement(orderTable);
		WebElement item = tblBody.findElement(topOrder);
		orderReference = item.findElement(histLink).getText();
		orderDate = item.findElement(histDate).getText();
		orderTotal = item.findElement(histPrice).getText();
		paymentMethod = item.findElement(histMethod).getText();
			    
	}
}
