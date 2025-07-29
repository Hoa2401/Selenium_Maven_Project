package automation.testsuite;

import automation.common.CT_PageURL;
import automation.common.CommonBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class BTVN2_Day8 extends CommonBase {
	@Test
	public void getElementByName()
	{
		driver = initChromeDriver(CT_PageURL.SELENIUM_WEBDRIVER_URL);
		WebElement nameElement = driver.findElement(By.name("name"));
		WebElement addElement = driver.findElement(By.name("address"));
		System.out.println("Name: "+nameElement);
		System.out.println("Address: "+addElement);
		
	}
	
	@Test
	public void getElementById() 
	{
		driver = initChromeDriver(CT_PageURL.SELENIUM_WEBDRIVER_URL);
		WebElement emailElement = driver.findElement(By.id("email"));
		WebElement pwdlElement = driver.findElement(By.id("password"));
		System.out.println("Email: "+emailElement);
		System.out.println("Password: "+pwdlElement);
	}
	

}
