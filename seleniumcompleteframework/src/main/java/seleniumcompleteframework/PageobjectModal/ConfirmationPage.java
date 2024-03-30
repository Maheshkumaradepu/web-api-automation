package seleniumcompleteframework.PageobjectModal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumcompleteframework.AbstractComponents.Abstractcomponents;

public class ConfirmationPage extends Abstractcomponents {
	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// String OrderID =
	// driver.findElement(By.xpath("//label[@class='ng-star-inserted']")).getText();

	@FindBy(xpath = "//label[@class='ng-star-inserted']")
	WebElement orderIdEle;
	By Ele = By.cssSelector("#toast-container");
	@FindBy(xpath = "//h1")
	WebElement Message;

	public String getOrderID() {

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

		waitForElementToAppear(Ele);
		return orderIdEle.getText();

	}

	public String confirmationMsg() {

		// driver.findElement(By.xpath("//h1")).getText();

		return Message.getText();

	}

}
