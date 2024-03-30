package seleniumcompleteframework.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumcompleteframework.PageobjectModal.CartPage;

public class Abstractcomponents {
	WebDriver driver;

	WebDriverWait wait;

	public Abstractcomponents(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	// driver.findElement(By.xpath("//li/button[contains(text(),'Cart')]")).click();

	@FindBy(xpath = "//li/button[contains(text(),'Cart')]")
	WebElement cartHeader;

	public void waitForElementToAppear(By findby) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}

	public void waitForElementToDisappear(WebElement Ele) {
		wait.until(ExpectedConditions.invisibilityOf(Ele));

	}

	public CartPage goToCartPage() {
		cartHeader.click();
		CartPage C = new CartPage(driver);
		return C;
	}
}
