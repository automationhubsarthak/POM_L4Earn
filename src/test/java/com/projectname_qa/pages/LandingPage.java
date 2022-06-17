package com.projectname_qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.projectname_qa.testbase.TestBase;

public class LandingPage extends TestBase {

	public LandingPage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class = 'mailicon']")
	WebElement RediffMailIcon;
	
	@FindBy(css = "a.moneyicon.relative")
	WebElement MoneyLink;
	
	@FindBy(css = "a.bmailicon.relative")
	WebElement BusinessEmailLink;
	
	@FindBy(css = "a.vdicon")
	WebElement VideosLink;
	
	@FindBy(css = "a.shopicon.relative")
	WebElement ShoppingLink;
	
	@FindBy(className = "signin")
	WebElement SignInLink;
	
	
	public String validateLandingPageTitle() {
		return driver.getTitle();
	}
	
	public String validateLandingPageCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public boolean validateRediffMailIconLink() {
		return RediffMailIcon.isDisplayed();
	}
	
	public boolean validateMoneyIconLink() {
		return MoneyLink.isDisplayed();
	}
	
	public boolean validateBusinessEmailIconLink() {
		return BusinessEmailLink.isDisplayed();
	}
	
	public boolean validateVideosIconLink() {
		return VideosLink.isDisplayed();
	}
	
	public boolean validateShoppingIconLink() {
		return ShoppingLink.isDisplayed();
	}
	

	public LoginPage clickOnSignInLink() throws Exception {
		SignInLink.click();
		return new LoginPage();
	}
}
