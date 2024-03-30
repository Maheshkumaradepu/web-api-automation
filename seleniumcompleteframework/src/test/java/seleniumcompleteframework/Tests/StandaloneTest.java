package seleniumcompleteframework.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandaloneTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		// login in to the WebSite
		// *****************************************************************************
		driver.findElement(By.id("userEmail")).sendKeys("seleniumtesting01@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Amahesh@12");
		driver.findElement(By.id("login")).click();
		// ***********************************************
		
		//Getting Product list and Click on add to cart button
		//*****************************************
		String ProductName = "adidas original";
		String Place = "india";
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod = null;
		for (int i = 0; i < products.size(); i++) {
			WebElement product = products.get(i);
			WebElement titleElement = product.findElement(By.cssSelector("b"));
			String title = titleElement.getText();
			if (title.equalsIgnoreCase(ProductName)) {
				prod = product;
				break; // Exit the loop once the desired product is found
			}
		}
		if (prod != null) {
			prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.xpath("//li/button[contains(text(),'Cart')]")).click();
		//***************************************************************8
		
		

		List<WebElement> CartProducts = driver.findElements(By.cssSelector(".cart h3"));
		Boolean match = CartProducts.stream()
				.anyMatch(CartProduct -> CartProduct.getText().equalsIgnoreCase(ProductName));
		Assert.assertTrue(match);

		driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys(Place);
		Thread.sleep(2000);
		List<WebElement> Countrys = driver
				.findElements(By.xpath("//section[@class='ta-results list-group ng-star-inserted']/button/span"));
		for (WebElement webElement : Countrys) {
			String CountryName = webElement.getText();
			if (CountryName.equalsIgnoreCase(Place)) {
				webElement.click();
				break;
			}
		}
		driver.findElement(By.xpath("//div[@class='actions']/a")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		String ConfirmMessage = driver.findElement(By.xpath("//h1")).getText();
		Assert.assertTrue(ConfirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		String OrderID = driver.findElement(By.xpath("//label[@class='ng-star-inserted']")).getText();
		System.out.println("OrderID:" + OrderID);
		driver.close();
	}

}
