package com.projectname_qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.projectname_qa.testbase.TestBase;

public class LogoutPage extends TestBase{

	
	@FindBy(xpath = "//p[contains(text(), 'You have successfully signed out of Rediffmail.')]")
	WebElement logoutNotificationMessage;
	
	@FindBy(xpath = "//a[contains(text(), 'Feedback')]")
	WebElement feedbackLink;
	
	@FindBy(xpath = "//b[contains(text(), 'Rediff Home')]")
	WebElement rediffHomeLink;
	
	
	public LogoutPage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLogoutPageCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public String validateLogoutPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateFeedbackLink() {
		return feedbackLink.isDisplayed();
	}
	
	
	public LandingPage clickOnRediffHomeLink() throws Exception {
		rediffHomeLink.click();
		return new LandingPage();
	}

}
