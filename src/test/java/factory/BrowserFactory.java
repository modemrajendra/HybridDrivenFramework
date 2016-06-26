package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import dataProvider.ConfigDataProvider;

public class BrowserFactory {
	static WebDriver driver;

	public static WebDriver getBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", DataProviderFactory.getConfig().getChromePath());
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("ie")) {

			System.setProperty("webdriver.ie.driver", DataProviderFactory.getConfig().getIePath());
			driver = new InternetExplorerDriver();
return driver;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		return driver;
	}
	public static void closing(WebDriver Idriver)
	{
		driver.close();
	}

}
