package resources.stepsDefinition;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;

import contexts.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.OrderItemPage;

public class OrderItemStepDefinition {

	TestContext testContext;
	OrderItemPage orderItemPage;
	Date date = new Date();  
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
    String strDate = formatter.format(date);

	public OrderItemStepDefinition(TestContext context)
	{
		testContext = context;
		orderItemPage = testContext.getPageObjectManager().getOrderItemPage();
	}
	
	@And("^adds t-shirt in shopping cart$")
	public void openShirtsSection() {
		orderItemPage.openTshirtsTab();
		orderItemPage.selectItemToPurchase();
		orderItemPage.AddItemToCart();
		orderItemPage.proceedToCheckOut();
		orderItemPage.proceedToCheckOutSignIn();
		orderItemPage.proceedToCheckOutAddress();
	}
	@When("^user confirms the payment for the order$")
	public void chooseShirtToBuy() {
		orderItemPage.agreeTnC();
		orderItemPage.selectPaymentMethod();
	}

	@Then("^the order is successfully placed$")
	public void completeOrder() {
		orderItemPage.confirmOrder();
	}
	
	@And("^the order details are correct$")
	public void orderVerification() {	
		Assert.assertEquals("ORDER CONFIRMATION", orderItemPage.getPageHeadingText().toUpperCase());
		orderItemPage.verifyOrder();
        String orderReference =  OrderItemPage.orderReferenceAfterConfirm;
        Assert.assertNotNull(orderReference);       
        Assert.assertEquals(strDate, OrderItemPage.orderDate);
        Assert.assertEquals("$18.51", OrderItemPage.orderTotal);
        Assert.assertEquals("Bank wire", OrderItemPage.paymentMethod);
	}	
}


