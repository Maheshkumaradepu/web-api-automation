package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//Page Factory- OR:-
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')])']")
	WebElement signUpBtn;
	
	@FindBy(xpath="//a[@class='brand-name']")
	WebElement crmlogo;
	
	@FindBy(xpath="//div[@class='rd-navbar-nav-wrap toggle-original-elements']/ul/a")
WebElement loginpgBtn;	
	public LoginPage(){
		PageFactory.initElements(driver,this);	
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return crmlogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		loginpgBtn.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}


}
