package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CT_PageURL;
import automation.common.CommonBase;
import automation.pageLocator.TEDU_Factory;

public class TEDU_UpdatePass_Test extends CommonBase {
	TEDU_Factory tedu;
	
	@BeforeMethod
	public void openBrowser() {
		driver = initFirefoxDriver(CT_PageURL.TEDU_URL);
		tedu = new TEDU_Factory(driver);
	}
	@Test
	public void loginSuccessfully() throws InterruptedException {
		tedu.loginFunction("hoant240198@gmail.com", "123456");
		Thread.sleep(3000);
		assertTrue(driver.findElement(By.id("my_account")).isDisplayed());
		
	}
	
	@Test
	public void updatePassSuccessfully() throws InterruptedException {
		loginSuccessfully();
		tedu.updatePassword("123456","1234567");
		Thread.sleep(3000);
		assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed());
	}
	public void serchKhoaHoc() {
		
	}

}
