package automation.testsuite;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import org.openqa.selenium.WebElement;

import automation.common.CT_PageURL;
import automation.common.CommonBase;


public class Day12_RadioButton extends CommonBase{
	@Test
	public void choseMale(){
		driver = initChromeDriver(CT_PageURL.DEMOQA_URL);
		scrollToElement(By.id("userNumber"));
		WebElement radioMale = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
		boolean rdoMale=radioMale.isSelected();
		// kiem tra gia tri mac dinh
		assertEquals(rdoMale,false);
		//click vao Male
		if(radioMale.isEnabled()== true)
		{
			radioMale.click();
			System.out.println("Radio Male was clicked");
		}
		
		
	}
	@Test
	public void choseFemale() {
		driver = initChromeDriver(CT_PageURL.DEMOQA_URL);
		scrollToElement(By.id("userNumber"));
		WebElement radioFemale = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
		boolean rdoFemale=radioFemale.isSelected();
		// kiem tra gia tri mac dinh
		assertEquals(rdoFemale,false);
		//click vao Male
		if(radioFemale.isEnabled()== true)
		{
			radioFemale.click();
			System.out.println("Radio Female was clicked");
		}
		
	}
	@Test
	public void choseOther() {
		driver = initChromeDriver(CT_PageURL.DEMOQA_URL);
		scrollToElement(By.id("userNumber"));
		WebElement radioOther = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
		boolean rdoOther=radioOther.isSelected();
		// kiem tra gia tri mac dinh
		assertEquals(rdoOther,false);
		//click vao Male
		if(radioOther.isEnabled()== true)
		{
			radioOther.click();
			System.out.println("Radio Other was clicked");
		}
		
	}
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	
	
	

}
