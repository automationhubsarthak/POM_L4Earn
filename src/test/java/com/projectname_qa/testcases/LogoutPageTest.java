package com.projectname_qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.projectname_qa.pages.InboxPage;
import com.projectname_qa.pages.LandingPage;
import com.projectname_qa.pages.LoginPage;
import com.projectname_qa.pages.LogoutPage;
import com.projectname_qa.testbase.TestBase;

public class LogoutPageTest extends TestBase {
	
	public LoginPage loginPage;
	public InboxPage inboxPage;
	public LogoutPage logoutPage;
	public LandingPage landingPage;

	public LogoutPageTest() throws Exception {
		super();
	}
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		initialize();
		loginPage = new LoginPage();
		inboxPage = loginPage.loginDetails(prop.getProperty("username"), prop.getProperty("password"));
		logoutPage = new LogoutPage();
		landingPage = new LandingPage();
		
	}
	
	@Test(priority = 1)
	public void logoutPageTitleTest() {
		String title = logoutPage.validateLogoutPageTitle();
		System.out.println("Title is :" + title);
		Assert.assertEquals(title, "Welcome to Rediffmail");
	}
	
	@Test(priority = 2)
	public void logoutPageCurrentUrlTest() {
		String currentUrl = logoutPage.validateLogoutPageCurrentUrl();
		System.out.println("Current Url is :" + currentUrl);
		Assert.assertEquals(currentUrl, "login.rediff.com");
	}
	
	@Test(priority = 3)
	public void logoutPageFeedbackLinkTest() {
		boolean feedbankLink = logoutPage.validateFeedbackLink();
		Assert.assertTrue(feedbankLink);
	}
	
	
	@Test(priority = 4)
	public void clickOnRediffHomeLinkTest() throws Exception {
		landingPage = logoutPage.clickOnRediffHomeLink();
		Thread.sleep(2000);
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	
	

}
