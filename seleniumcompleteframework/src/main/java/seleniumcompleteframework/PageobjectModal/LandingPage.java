package seleniumcompleteframework.PageobjectModal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumcompleteframework.AbstractComponents.Abstractcomponents;

public class LandingPage extends Abstractcomponents {
	WebDriver driver;

	public LandingPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement userEmail = driver.findElement(By.id("userEmail"));
	@FindBy(id = "userEmail")
	WebElement useremail;

	// WebElement password = driver.findElement(By.id("userPassword"));
	@FindBy(id = "userPassword")
	WebElement password;
//	WebElement submit=driver.findElement(By.id("login"));
	@FindBy(id = "login")
	WebElement submit;

	public ProductCatalog Applicationlogin(String email, String Password) {
		useremail.sendKeys(email);
		password.sendKeys(Password);
		submit.click();
		ProductCatalog productcat = new ProductCatalog(driver);
		return productcat;
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
}
