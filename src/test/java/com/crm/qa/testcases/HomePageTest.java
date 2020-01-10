package com.crm.qa.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	public HomePageTest(){
		super();
		}
	//test cases should be independent with each other
	//before each test case launch the browser and login
	//@test -- execute test case
	//after each test case close the browser
	@BeforeMethod
	public void setUp(){
		intialization();
		loginPage = new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals("Cogmento CRM", homePageTitle );
	}
	
	@Test(priority=2)
	public void verifyUserNameTest(){
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest(){
		contactsPage=homePage.clickOnContacts();
		
	}
	@Test(priority=4)
	public void verifyDealsLinkTest(){
		dealsPage=homePage.clickOnDeals();
	}
	@Test(priority=5)
	public void verifyTasksLinkTest(){
		tasksPage=homePage.clickOnTasks();
	}
	
	
	
	
	
	
	
	
	@AfterMethod
	public void TearDown() throws InterruptedException{
		Thread.sleep(2000);
		driver.quit();
	}


}
