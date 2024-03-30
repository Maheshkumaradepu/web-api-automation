package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactsPage;
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage= new LoginPage();
		contactsPage=new ContactsPage();
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	

	@Test(priority=1)
	public void verifyHomeTitle() {
		String HPTitle=homepage.verifyHomePageTitle();
		Assert.assertEquals(HPTitle,"Cogmento CRM","HPTitle Not matched");
	}
	@Test(priority=2)
	public void verifyLogedUser() {
		String user=homepage.verifyUserName();
		Assert.assertEquals(user,"mahesh adepu");
	}
	@Test(priority=3)
	public void verifyContacts() {	
	contactsPage =	homepage.clickContacts();
		
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
