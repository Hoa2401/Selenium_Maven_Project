package automation.testsuite;

import automation.common.CT_PageURL;
import automation.common.CommonBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class BTVN_Day8 extends CommonBase  {
	
	@Test
	public void getElementById()
	{
		driver = initChromeDriver(CT_PageURL.SELECTOR_HUB_URL);
		WebElement emailElement = driver.findElement(By.xpath("(//input[@class='selectors-input jsSelector'])[1]"));
		WebElement pwdElement = driver.findElement(By.id("pass"));
		System.out.println("emailElenment: "+emailElement);
		System.out.println("Password: "+pwdElement);
	}
	
	@Test
	public void getElementByName()
	{
		driver = initChromeDriver(CT_PageURL.SELECTOR_HUB_URL);
		WebElement cpnElement = driver.findElement(By.name("company"));
		WebElement phoneElement = driver.findElement(By.name("mobile number"));
		System.out.println("Company: "+cpnElement);
		System.out.println("Mobile phone: "+phoneElement);
	}
	
}


