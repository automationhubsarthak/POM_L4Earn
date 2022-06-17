package com.projectname_qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.projectname_qa.testbase.TestBase;

public class InboxPage extends TestBase{

	
	@FindBy(xpath = "//ul[@class = 'rd_tab_heads']/descendant::a[contains(text(), 'Inbox')]")
	WebElement InboxIcon;
	
	@FindBy(xpath = "//span[contains(text(), 'Hi !')]")
	WebElement HiText;
	
	@FindBy(className = "rd_logout")
	WebElement logoutLink;
	
	
	public InboxPage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	public String validateInboxPageCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public String validateInboxPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateHiTextWithExclamation() {
		return HiText.isDisplayed();
	}
	
	public boolean validateInboxIcon() {
		return InboxIcon.isDisplayed();
	}
	
	public LogoutPage clickOnLogOutLink() throws Exception {
		logoutLink.click();
		Thread.sleep(3000);
		return new LogoutPage();
	}

}
