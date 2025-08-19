package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CT_PageURL;
import automation.common.CommonBase;
import automation.pageLocator.ALADA_LoginLogoutPage_Factory;

public class ALADA_LoginLogout_Test extends CommonBase {
	@BeforeMethod
	public void openBrowser() {
		driver = initFirefoxDriver(CT_PageURL.ALADA_URL);
	}
	@Test
	public void loginSuccessfully() {
		ALADA_LoginLogoutPage_Factory factory = new ALADA_LoginLogoutPage_Factory(driver);
		factory.loginFunction("hoa001@gmail.com", "123456");
		WebElement khoaHocCuaToi = driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]"));
		assertTrue(khoaHocCuaToi.isDisplayed());
	}
	@Test
	public void logoutSuccessfully() {
		loginSuccessfully();
		ALADA_LoginLogoutPage_Factory factory = new ALADA_LoginLogoutPage_Factory(driver);
		factory.logoutFunction();
		assertTrue(driver.findElement(By.xpath("//div[@class='login']")).isDisplayed());
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
