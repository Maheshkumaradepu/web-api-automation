package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//span[@class='selectable ']")
	WebElement Contactpageheader;

	@FindBy(xpath = "//td[2]/a")
	List<WebElement> ContactList;

	@FindBy(xpath = "//tbody/tr/td[2]")
	List<WebElement> ListofContacts;

	@FindBy(xpath = "//tbody/tr/td[1]")
	List<WebElement> checkbox;
	
	@FindBy(xpath="//a/button[@class='ui linkedin button']")
	WebElement NewContactbtn;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement Firstname;
	@FindBy(xpath="//input[@name='last_name']")
	WebElement Lastname;
	@FindBy(xpath="//input[@placeholder='Email address']")
	WebElement emailID;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement Savebtn;
	
	

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifycontactHeader() {
		return Contactpageheader.getText();
	}
	

	public String verifycontactsList() {
		String s = null;
		for (WebElement webElement : ContactList) {
			if (webElement.getText().equalsIgnoreCase("mayuri adepu")) {
				return webElement.getText();
			}
		}
		return s;
	}
   public void createNewContact(String fname,String Lname,String email) {
	   NewContactbtn.click();
	   Firstname.sendKeys(fname);
	   Lastname.sendKeys(Lname);
	   emailID.sendKeys(email);
	   Savebtn.click();   
   }
}
