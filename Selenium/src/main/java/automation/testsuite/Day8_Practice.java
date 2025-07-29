package automation.testsuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import automation.common.CT_PageURL;
import automation.common.CommonBase;


public class Day8_Practice extends CommonBase {
	@Test
	public void getElementById()
	{
		driver = initChromeDriver(CT_PageURL.ALADA_URL);
		WebElement emailElenment= driver.findElement(By.id("txtLoginUsername"));
		System.out.println("emailElement: "+emailElenment);
		
	}
	
	@Test
	public void getElementByName()
	{
		driver = initChromeDriver(CT_PageURL.ALADA_URL);
		WebElement passElement= driver.findElement(By.name("txtLoginPassword"));
		System.out.println("PassElement: "+passElement);
	}
	@Test
	public void getElementByText()
	{
		driver = initChromeDriver(CT_PageURL.SELECTOR_HUB_URL);
		WebElement textFindOut = driver.findElement(By.linkText("Find out how to automate these controls without XPath"));
		System.out.println("textFindOut: "+textFindOut);
	}
	@Test
	public void getElementByPartialLinkText()
	{
		driver = initChromeDriver(CT_PageURL.SELECTOR_HUB_URL);
		WebElement textCourse = driver.findElement(By.partialLinkText("A course with complex scenarios"));
		System.out.println("textFindOut: "+textCourse);
		
	}

}
