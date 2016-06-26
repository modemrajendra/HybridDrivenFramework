package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignIn {

	WebDriver driver;
	
	@FindBy(xpath="//*[@id='email']") WebElement Email;
	@FindBy(xpath="//*[@id='pass']") WebElement Password;
	@FindBy(xpath="//*[@id='send2']") WebElement Login;
	
	
	public void login(String email, String pass)
	{
		Email.sendKeys(email);
		Password.sendKeys(pass);
		Login.click();
	}

	
	
	
	
	
	
}
