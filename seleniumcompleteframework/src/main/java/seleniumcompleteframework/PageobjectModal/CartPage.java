package seleniumcompleteframework.PageobjectModal;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumcompleteframework.AbstractComponents.Abstractcomponents;

public class CartPage extends Abstractcomponents {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// List<WebElement> CartProducts = driver.findElements(By.cssSelector(".cart
	// h3"));
	@FindBy(css = ".cart h3")
	List<WebElement> SelectedProductName;

	// driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();
	@FindBy(xpath = "//button[contains(text(),'Checkout')]")
	WebElement checkoutBtn;

	public Boolean verifyProduct(String ProductName) {
		Boolean match = SelectedProductName.stream()
				.anyMatch(CartProduct -> CartProduct.getText().equalsIgnoreCase(ProductName));
		return match;
	}

	public ShippingPage goToShipping() {
		checkoutBtn.click();

		ShippingPage S = new ShippingPage(driver);
		return S;
	}
}
