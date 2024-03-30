package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{


	//Page Factory- OR:-
	@FindBy(xpath="//span[@class='user-display']")
	WebElement usernameLabel;
	
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contact;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealslink;
	
	@FindBy(xpath="//span[contains(text(),'Task')]")
	WebElement tasklink;
	//intialize the page objects 
	public  HomePage() {
		PageFactory.initElements(driver,this);
	}
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public String verifyUserName() {
		return usernameLabel.getText();
		
	}
	public ContactsPage clickContacts() {
		contact.click();
		return new ContactsPage();
	}
	
	public DealsPage clickDeals() {
		dealslink.click();
		return new DealsPage();
	}
	
	public TaskPage clickTasks() {
		tasklink.click();
		return new TaskPage();
	}
}
