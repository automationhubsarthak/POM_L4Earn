package com.projectname_qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.projectname_qa.pages.InboxPage;
import com.projectname_qa.pages.LoginPage;
import com.projectname_qa.pages.LogoutPage;
import com.projectname_qa.testbase.TestBase;


public class InboxPageTest extends TestBase{
	
	public LoginPage loginPage;
	public InboxPage inboxPage;
	public LogoutPage logoutPage;
    
	
public InboxPageTest() throws Exception {
		super();
	
	}

    
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		initialize();
		loginPage = new LoginPage();
		inboxPage = loginPage.loginDetails(prop.getProperty("username"), prop.getProperty("password"));
		logoutPage = new LogoutPage();
		
	}
	
	@Test(priority = 1)
	public void inboxPageTitleTest() {
		String title = inboxPage.validateInboxPageTitle();
		System.out.println("Title is :" + title);
		Assert.assertEquals(title, "Rediffmail");
	}
	
	@Test(priority = 2, alwaysRun = false)
	public void inboxPageCurrentUrlTest() {
		String currentUrl = inboxPage.validateInboxPageCurrentUrl();
		System.out.println("Current Url is :" + currentUrl);
		Assert.assertEquals(currentUrl, "f5mail.rediff.com");
	}
	
	@Test(priority = 3)
	public void inboxPageInboxTextImageTest() {
		boolean logoImage = inboxPage.validateInboxIcon();
		Assert.assertTrue(logoImage);
	}
	
	@Test(priority = 4)
	public void inboxPageHiTextImageTest() {
		boolean hiImage = inboxPage.validateHiTextWithExclamation();
		Assert.assertTrue(hiImage);
	}
	
	@Test(priority = 5)
	public void logoutLinkTest() throws Exception {
		logoutPage = inboxPage.clickOnLogOutLink();
		
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
