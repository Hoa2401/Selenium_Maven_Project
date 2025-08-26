package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CT_PageURL;
import automation.common.CommonBase;
import automation.pageLocator.BTVN_Day15_Factory;

public class BTVN_Day15_TEDU_Search extends CommonBase {
	BTVN_Day15_Factory  tedu1;

	
	@BeforeMethod
	public void openBrowser() {
		driver = initFirefoxDriver(CT_PageURL.TEDU_URL);
		tedu1 = new BTVN_Day15_Factory(driver);
	}
	@Test
	public void loginSuccessfully() throws InterruptedException {
		tedu1.loginFunction("hoant240198@gmail.com", "1234567");
		Thread.sleep(3000);
		assertTrue(driver.findElement(By.id("my_account")).isDisplayed());
		
	}
	
	@Test
	public void searchKeyWord() throws InterruptedException {
		loginSuccessfully();
		tedu1.searchFunction("ASP Net");
		Thread.sleep(3000);
		assertTrue(driver.findElement(By.xpath("//li[text()='Kết quả tìm kiếm: ASP Net']")).isDisplayed());
	}

}
