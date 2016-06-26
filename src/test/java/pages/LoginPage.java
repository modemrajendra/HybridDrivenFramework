package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	
	@FindBy(xpath="//*[@class='input-text required-entry'][@type='text'][@title='First Name']") WebElement First_Name;
	@FindBy(xpath="//*[@id='lastname']") WebElement Last_Name;
	@FindBy(xpath="//*[@id='email_address']") WebElement Email;
	By contactUs=By.xpath("//*[contains(text(), 'CONTACT US')]");
	
	public void registration(String fname, String lname, String email)
	{
	
		First_Name.sendKeys(fname);
		Last_Name.sendKeys(lname);
		Email.sendKeys(email);
			}
	public void verifyContactUs()
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		
		WebElement ele=wait.until(ExpectedConditions.presenceOfElementLocated(contactUs));
		String text=ele.getText();
		Assert.assertEquals(text,"Contact US","Not verifed properly");
	}

	
	
	
	
	
	
	
}
