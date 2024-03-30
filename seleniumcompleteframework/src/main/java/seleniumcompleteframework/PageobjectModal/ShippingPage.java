package seleniumcompleteframework.PageobjectModal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumcompleteframework.AbstractComponents.Abstractcomponents;

public class ShippingPage extends Abstractcomponents {
	WebDriver driver;

	public ShippingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys(Place);

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement countryNameBox;

	/*
	 * List<WebElement> Countrys = driver.findElements(By.
	 * xpath("//section[@class='ta-results list-group ng-star-inserted']/button/span"
	 * ));
	 */

	@FindBy(xpath = "//section[@class='ta-results list-group ng-star-inserted']/button/span")
	List<WebElement> ListofCountrys;

//	driver.findElement(By.xpath("//div[@class='actions']/a")).click();
	@FindBy(xpath = "//div[@class='actions']/a")
	WebElement PlaceorderButton;

	// driver.findElement(By.cssSelector(".ta-results"));

	By ContrysBox = By.cssSelector(".ta-results");

	public void enterCountryName(String Place) throws InterruptedException {
		countryNameBox.sendKeys(Place);
		/* we need to wait here for box */
		waitForElementToAppear(ContrysBox);

		for (WebElement Country : ListofCountrys) {
			String CountryName = Country.getText();
			if (CountryName.equalsIgnoreCase(Place)) {
				Country.click();
				break;
			}
		}
	}

	public ConfirmationPage goTOConfirmOrder() {
		PlaceorderButton.click();

		return new ConfirmationPage(driver);

	}

}
