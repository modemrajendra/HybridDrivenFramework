package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {
	Properties prop;

	public ConfigDataProvider() {
		File fi = new File("./Configuration/Config.properties");
		try {
			FileInputStream fis = new FileInputStream(fi);
			prop = new Properties();
			prop.load(fis);
		}

		catch (Exception e) {

			System.out.println("The Exception is: " + e.getMessage());
		}

	}

	public String getChromePath() {
		String url = prop.getProperty("chromepath");
		return url;
	}

	public String getIePath() {
		String url = prop.getProperty("iepath");
		return url;
	}

	public String getApplicationUrl() {
		String url = prop.getProperty("url");

		return url;
	}
}
