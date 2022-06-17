package com.projectname_qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.projectname_qa.testbase.TestBase;

public class LoginPage extends TestBase{
	//whenever you are designing your page classes there are 4 things that you have to keep in mind
	//0. extend the Base Class
	//1. Design your WebElement or page Objects
	//2. You have to initialize your Page Objects (PageFactory)
	//3. You have to define the Actions

	//logoImage, title, currentUrl, username, password, signinButton

	@FindBy(className = "logtext")
	WebElement logoImage;
	
	@FindBy(id = "login1")
	@CacheLookup
	WebElement userName;
	
	@FindBy(id = "password")
	@CacheLookup
	WebElement passWord;
	
	@FindBy(xpath = "//input[@class = 'signinbtn']")
	WebElement signInButton;
	
	
	public LoginPage() throws Exception {
		PageFactory.initElements(driver, this);
    }
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public String validateLoginPageCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public boolean validateLoginPageLogoImage() {
		return logoImage.isDisplayed();
		
	}
	
	public InboxPage loginDetails(String uname, String pword) throws Exception {
		userName.sendKeys(uname);
		passWord.sendKeys(pword);
		signInButton.click();
		Thread.sleep(3000);
		return new InboxPage();
	}
	

}


















