package testCases;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.SignIn;

public class VerifySignIn {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = BrowserFactory.getBrowser("chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
	}
	@Test
	public void verifySign()
	{
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		String title = home.getApplicationTitle();
		Assert.assertTrue(title.contains("Modern - Homepage 2"));
		home.clickonSign_In();
		SignIn si=PageFactory.initElements(driver, SignIn.class);
		si.login(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 0, 1));
		
			}
@AfterMethod
	public void closing()
	{
		BrowserFactory.closing(driver);
	}
	
}
