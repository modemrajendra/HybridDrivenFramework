package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver Idriver)
	{
		this.driver=Idriver;
	}
	
	
	@FindBy(xpath="//*[contains(text(),'Sign In')]") WebElement Sign_In;
	@FindBy(xpath="//*[contains(text(),'Create an Account')]") WebElement Create_an_Account;
	
	public void clickonSign_In()
	{
		Sign_In.click();
	}
	public void clickCreateAccount()
	{
		Create_an_Account.click();
	}
	
	
	public String getApplicationTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}
	
	
	
	
	
	
	
	
	
	
	
}
