package seleniumcompleteframework.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import Maheshacademy.TestComponents.BaseTest;
import seleniumcompleteframework.PageobjectModal.CartPage;
import seleniumcompleteframework.PageobjectModal.ConfirmationPage;
import seleniumcompleteframework.PageobjectModal.ProductCatalog;
import seleniumcompleteframework.PageobjectModal.ShippingPage;

public class PomStandaloneTest extends BaseTest {
@Test
	public void submitorder() throws InterruptedException, IOException {
		String ProductName = "adidas original";
		String Place = "india";
		String email = "seleniumtesting01@gmail.com";
		String Password = "Amahesh@12";
	ProductCatalog productcat = landingpage.Applicationlogin(email, Password);
		List<WebElement> products = productcat.getProductlist();
		productcat.addProductToCart(ProductName);
		CartPage C = productcat.goToCartPage();
		Assert.assertTrue(C.verifyProduct(ProductName));
		ShippingPage S = C.goToShipping();
		S.enterCountryName(Place);
		ConfirmationPage Conf = S.goTOConfirmOrder();
		String ID = Conf.getOrderID();
		System.out.println("OrderID:" + ID);
		String ConfirmMessage = Conf.confirmationMsg();
		Assert.assertTrue(ConfirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.quit();
	}

}
