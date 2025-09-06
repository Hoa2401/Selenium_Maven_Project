package automation.testsuite;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import automation.common.CT_PageURL;
import automation.common.CommonBase;
import automation.pageLocator.BTVN_Day16_Factory;

public class Homework1_Day16 extends CommonBase {
	
	@BeforeMethod
	public void openBrowser() {
		driver = initFirefoxDriver(CT_PageURL.CODESTAR_SYSTEM_URL);	
	}
	
	@Test(priority = 1)
	public void LoginSuccessfully() throws InterruptedException {
		BTVN_Day16_Factory factory = new BTVN_Day16_Factory(driver);
		factory.loginFunction("admin@gmail.com", "12345678");
		assertTrue(driver.findElement(By.xpath("//p[text()='Quản lý khu làm việc']")).isDisplayed());
	}
	
	@Test(priority = 2)
	public void addKLVSuccessfully() throws InterruptedException {
		LoginSuccessfully();
		BTVN_Day16_Factory factory = new BTVN_Day16_Factory(driver);
		factory.AddKLV("HN001", "KLV2402");
		assertTrue(isElementDisplay(By.xpath("//p[text()='Quản lý khu làm việc']")));
		driver.findElement(By.xpath("//input[@class='form-control me-3']")).sendKeys("KLV2402");
		clickByJS(By.xpath("//button[text()='Tìm kiếm']"));
		assertTrue(isElementDisplay(By.xpath("//td[@class='code-work-area']"))) ;	
	}
	
	@Test(priority = 3)
	public void deleteKLVSuccessfully() throws InterruptedException {
		LoginSuccessfully();
		BTVN_Day16_Factory factory = new BTVN_Day16_Factory(driver);
		factory.DeleteKLV("KLV2402");
		assertTrue(isElementDisplay(By.xpath("//p[text()='Quản lý khu làm việc']")));
		driver.findElement(By.xpath("//input[@class='form-control me-3']")).sendKeys("KLV2402");
		clickByJS(By.xpath("//button[text()='Tìm kiếm']"));
		assertTrue(isElementDisplay(By.xpath("//h4[text()='Không tìm thấy kết quả']"))) ;	
	}

   @AfterMethod
   public void closeBrowser() {
		driver.close();
	}
}