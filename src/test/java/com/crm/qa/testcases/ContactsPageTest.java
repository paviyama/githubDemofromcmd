package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName="contacts";
	
	public ContactsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		intialization();
		contactsPage=new ContactsPage();
		loginPage = new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage=homePage.clickOnContacts();
	}
	@DataProvider
	public Object[][] getCRMContactsTestData(){
		Object data[][]=testUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test(priority=3,dataProvider="getCRMContactsTestData")
	public void addnewContacts(String firstname, String lastname, String email, String company ){
		contactsPage.addNewContact();
		contactsPage.createNewContact(firstname, lastname, email, company);
	}
	
	@Test(priority=1)
	public void verifyContactsListTest(){
		contactsPage.selectContactsByName("SUNDEEP YAMA");
	}
	@Test(priority=2)
	public void verifyMultipleContactsListTest(){
		contactsPage.selectContactsByName("SUNDEEP YAMA");
		contactsPage.selectContactsByName("Pavithra Yama");
	}
	
	@AfterMethod
	public void TearDown() throws InterruptedException{
		Thread.sleep(2000);
		driver.quit();
	}

}
