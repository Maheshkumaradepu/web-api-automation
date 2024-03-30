package seleniumcompleteframework.PageobjectModal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumcompleteframework.AbstractComponents.Abstractcomponents;

public class ProductCatalog extends Abstractcomponents {

	WebDriver driver;

	public ProductCatalog(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css = ".mb-3")
	List<WebElement> products;
	// wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	@FindBy(css = ".ng-animating")
	WebElement Spinner;

	By productsBy = By.cssSelector(".mb-3");
	By toastMessage = By.cssSelector("#toast-container");
	By Animation = By.cssSelector(".ng-animating");

	public List<WebElement> getProductlist() {
		waitForElementToAppear(productsBy);
		return products;
	}

	public WebElement ProductElement(String productName) {
		WebElement prod = getProductlist().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName))
				.findFirst().orElse(null);
		return prod;
	}

	public void addProductToCart(String productName) {
		WebElement prod = ProductElement(productName);

		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(Spinner);

	}
}
