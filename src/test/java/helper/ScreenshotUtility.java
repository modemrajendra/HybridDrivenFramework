package helper;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

	public static String captureScreen(WebDriver driver, String ScreenshotName) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destination = "C:\\SeleniumFramework\\com.SeleniumFramework.hybrid\\Screenshots\\" + ScreenshotName + System.currentTimeMillis() + ".png";
		try {
			FileUtils.copyFile(src, new File(destination));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("the exception is:" + e.getMessage());
		}
		return destination;

	}

}
