package automation.testsuite;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import automation.common.CT_PageURL;
import automation.common.CommonBase;

public class AlertPractice2_Day16 extends CommonBase {
	@BeforeMethod
	public void openBrowser() {
		driver = initChromeDriver(CT_PageURL.ALERT_URL2);	
	}
	
	@Test
	public void deleteCustumer() throws InterruptedException {
		type(By.name("cusid"), "hn123");
		click(By.name("submit"));
		String actual1 = driver.switchTo().alert().getText();
		assertEquals(actual1, "Do you really want to delete this Customer?");
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
		String actual2 = driver.switchTo().alert().getText();
		assertEquals(actual2, "Customer Successfully Delete!");
		driver.switchTo().alert().accept();
	}

}
