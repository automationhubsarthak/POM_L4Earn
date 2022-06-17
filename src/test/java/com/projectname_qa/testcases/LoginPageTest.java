package com.projectname_qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.projectname_qa.pages.InboxPage;
import com.projectname_qa.pages.LoginPage;
import com.projectname_qa.testbase.TestBase;
import com.projectname_qa.utilities.TestUtil;

public class LoginPageTest extends TestBase{
	
	public LoginPage loginPage;
	public InboxPage inboxPage;
	String sheetName = "LoginCredentials";

	public LoginPageTest() throws Exception {
		super();		
	}
	
	@DataProvider
    public Object[][] getRediffLoginCredentialsTestData() throws Exception {
	  Object rediffdata[][] = TestUtil.getTestData(sheetName);
	  return rediffdata;
  }
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		initialize();
		loginPage = new LoginPage();
		inboxPage = new InboxPage();
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		System.out.println("Title is :" + title);
		Assert.assertEquals(title, "Rediffmail");
	}
	
	@Test(priority = 2)
	public void loginPageCurrentUrlTest() {
		String currentUrl = loginPage.validateLoginPageCurrentUrl();
		System.out.println("Current Url is :" + currentUrl);
		Assert.assertEquals(currentUrl, "https://mail.rediff.com/cgi-bin/login.cgi");
	}
	
	@Test(priority = 3)
	public void loginPageLogoImageTest() {
		boolean logoImage = loginPage.validateLoginPageLogoImage();
		Assert.assertTrue(logoImage);
	}
	
	@Test(priority = 4, dataProvider = "getRediffLoginCredentialsTestData")
	public void loginDetailsTest(String username, String password) throws Exception {
		inboxPage = loginPage.loginDetails(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
	driver.quit();
	}

}
