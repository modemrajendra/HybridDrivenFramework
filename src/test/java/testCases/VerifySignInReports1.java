package testCases;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import helper.ScreenshotUtility;
import pages.HomePage;
import pages.SignIn;

public class VerifySignInReports1 {
	WebDriver driver;
	ExtentReports reporter;
	ExtentTest logger;

	@BeforeMethod
	public void setUp() {
		reporter = new ExtentReports("./Reports/repo.html", true);
		logger = reporter.startTest("TestingSample", "we are testing consumer application");
		driver = BrowserFactory.getBrowser("chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		logger.log(LogStatus.INFO, "Application is lanunched");
	}

	@Test
	public void verifySign() {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		logger.log(LogStatus.INFO, "Home Page is launched");
		String title = home.getApplicationTitle();
		Assert.assertTrue(title.contains("Modern - Homepage 2"));
		logger.log(LogStatus.PASS, "Verifed page title");
		home.clickonSign_In();
		logger.log(LogStatus.INFO, "Clicked on signin link");
		SignIn si = PageFactory.initElements(driver, SignIn.class);
		si.login(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 0, 1));
		logger.log(LogStatus.INFO, "entered email and password");
		logger.log(LogStatus.INFO, logger.addScreenCapture(ScreenshotUtility.captureScreen(driver, "validation2")));
	}

	@AfterMethod
	public void closing(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String path = ScreenshotUtility.captureScreen(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
		}
		BrowserFactory.closing(driver);
		reporter.endTest(logger);
		reporter.flush();
	}

}
