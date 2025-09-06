package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CT_PageURL;
import automation.common.CommonBase;

public class BTVN_Day17_Mediamart extends CommonBase {
	@BeforeMethod
	public void openBrowser() {
		driver = initChromeDriver(CT_PageURL.MEDIAMART_URL);
	}
	
	@Test
	public void handleWidgetZalo() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement widgetZalo = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe[src*='widget.zalo.me']")));
		driver.switchTo().frame(widgetZalo);
		clickByJS(By.xpath("//div[contains(@class,'za-chat__head-box')]"));
		assertTrue(isElementDisplay(By.xpath("//div[@id='root']/div[@class='za-chat']")));
	}
}
