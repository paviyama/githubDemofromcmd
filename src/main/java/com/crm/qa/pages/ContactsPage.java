package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement AddNewContact;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement contactsfirstname;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement contactslastname;
	
	@FindBy(xpath="//div[@name='company']//input[@class='search']")
	WebElement contactscompany;
	
	@FindBy(xpath="//input[@placeholder='Email address']")
	WebElement contactsemail;
	
	@FindBy(xpath="//i[@class='save icon']")
	WebElement contactsSaveButton;
	
	
	
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void selectContactsByName(String name)
	{
		driver.findElement(By.xpath("//td[contains(text(),'"+name+"')]//preceding::div[@class='ui fitted read-only checkbox']")).click();
	}
	
	public void addNewContact(){
		AddNewContact.click();
	}
	
	public void createNewContact(String ftName, String ltName, String email, String company){
		contactsfirstname.sendKeys(ftName);
		contactslastname.sendKeys(ltName);
		contactscompany.sendKeys(company);
		contactsemail.sendKeys(email);
		contactsSaveButton.click();
		
	}


}
