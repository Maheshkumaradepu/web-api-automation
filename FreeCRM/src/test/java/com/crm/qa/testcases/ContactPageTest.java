package com.crm.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactsPage;

	String sheetName = "contacts";

	public ContactPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		contactsPage = new ContactsPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homepage.clickContacts();
	}

	@Test(priority = 1)
	public void contactspageHeader() {
		String header = contactsPage.verifycontactHeader();
		Assert.assertEquals(header, "Contacts");
	}

	@Test(priority = 3)
	public void contactsList() {
		String contact = contactsPage.verifycontactsList();
		Assert.assertEquals(contact, "mayuri adepu");
	}

	@DataProvider
	public Object[][] getCRMTestdata() throws InvalidFormatException {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 2, dataProvider = "getCRMTestdata")
	public void verifyCreateContact(String FNAME, String LNAME, String EMAIL) {
		contactsPage.createNewContact(FNAME, LNAME, EMAIL);
		homepage.clickContacts();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
