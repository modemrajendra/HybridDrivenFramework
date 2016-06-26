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

public class VerifyLoginPage {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = BrowserFactory.getBrowser("chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
	}

	@Test
	public void verifylogin() {

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		String title = home.getApplicationTitle();
		Assert.assertTrue(title.contains("Modern - Homepage 2"));

	}

	@AfterMethod
	public void tearDown() {
		BrowserFactory.closing(driver);
	}

}
