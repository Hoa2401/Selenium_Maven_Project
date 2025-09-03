package automation.testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import automation.common.CT_PageURL;
import automation.common.CommonBase;

public class Homework2_Day16 extends CommonBase {
	
	@BeforeMethod
	public void openBrowser() {
		driver = initFirefoxDriver(CT_PageURL.ALERT_PRACTICE_DEMO);
	}
	
	@Test
	public void handleAlert() {
		assertTrue(isElementDisplay(By.xpath("//a[normalize-space()='Selenium Practise']")));
	}
	
	 @AfterMethod
	   public void closeBrowser() {
			driver.close();
		}
}
