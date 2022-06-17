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

public class LandingPageTest extends TestBase {
	public LoginPage loginPage;
	public InboxPage inboxPage;
	public LogoutPage logoutPage;
	public LandingPage landingPage;
	
	public LandingPageTest() throws Exception {
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
	public void landingPageTitleTest() {
		String title = landingPage.validateLandingPageTitle();
		System.out.println("Title is :" + title);
		Assert.assertEquals(title, "Rediff.com: News | Rediffmail | Stock Quotes | Shopping");
	}
	
	@Test(priority = 2)
	public void landingPageCurrentUrlTest() {
		String currentUrl = landingPage.validateLandingPageCurrentUrl();
		System.out.println("Current Url is :" + currentUrl);
		Assert.assertEquals(currentUrl, "rediff.com");
	}
	
	@Test(priority = 3)
	public void landingPageRediffMailLinkTest() {
		boolean RediffMailLink = landingPage.validateRediffMailIconLink();
		Assert.assertTrue(RediffMailLink);
	}
	
	@Test(priority = 4)
	public void landingPageMoneyLinkTest() {
		boolean MoneyLink = landingPage.validateMoneyIconLink();
		Assert.assertTrue(MoneyLink);
	}
	
	@Test(priority = 5)
	public void landingPageBusinessLinkTest() {
		boolean BusinessLink = landingPage.validateBusinessEmailIconLink();
		Assert.assertTrue(BusinessLink);
	}
	
	@Test(priority = 6)
	public void landingPageVideosLinkTest() {
		boolean VideosLink = landingPage.validateVideosIconLink();
		Assert.assertTrue(VideosLink);
	}
	
	@Test(priority = 7)
	public void landingPageShoppingLinkTest() {
		boolean ShoppingLink = landingPage.validateShoppingIconLink();
		Assert.assertTrue(ShoppingLink);
	}
	
	
	@Test(priority = 8)
	public void clickOnSignInLinkTest() throws Exception {
		loginPage = landingPage.clickOnSignInLink();
		Thread.sleep(2000);
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	

}
