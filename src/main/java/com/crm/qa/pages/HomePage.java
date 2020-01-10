package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//span[contains(text(),'pavi yama')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
		}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	public ContactsPage clickOnContacts(){
		contactsLink.click();
		return new ContactsPage();
		
		}
	public DealsPage clickOnDeals(){
		dealsLink.click();
		return new DealsPage();
	}
	public TasksPage clickOnTasks(){
		tasksLink.click();
		return new TasksPage();
	}

}
