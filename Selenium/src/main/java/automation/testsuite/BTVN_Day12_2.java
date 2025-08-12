package automation.testsuite;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;

import automation.common.CT_PageURL;
import automation.common.CommonBase;

public class BTVN_Day12_2 extends CommonBase {
	@Test
	public void chooseAgeUnder18() {
		driver = initChromeDriver(CT_PageURL.SELENIUM_WEBDRIVER_URL);
		scrollToElement(By.id("number"));
		WebElement radioUnder18 = driver.findElement(By.id("under_18"));
		boolean rdoUnder18 = radioUnder18.isSelected();
		assertEquals(rdoUnder18,false);
			if(radioUnder18.isEnabled()== true)
			{
				radioUnder18.click();
				System.out.println("RadioUnder 18 was clicked");
			}
		}
	@Test
	public void chooseAge18Older() {
		driver=initChromeDriver(CT_PageURL.SELENIUM_WEBDRIVER_URL);
		scrollToElement(By.id("number"));
		WebElement radioOlder18 = driver.findElement(By.id("over_18"));
		boolean rdoOlder18 = radioOlder18.isSelected();
		assertEquals(rdoOlder18,false);
		if(radioOlder18.isEnabled()== true) {
			radioOlder18.click();
			System.out.println("Radio 18 or older was click");
		}
	}
	@Test
	public void radioDisabled() {
		driver = initChromeDriver(CT_PageURL.SELENIUM_WEBDRIVER_URL);
		scrollToElement(By.id("number"));
		WebElement radioDisabled = driver.findElement(By.id("radio-disabled"));
		boolean rdoDisabled = radioDisabled.isEnabled();
		assertEquals(rdoDisabled,false);
		if(!radioDisabled.isEnabled()) {
			System.out.println("Radio button is disabled");
		}
		
	}
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	
		
	}


