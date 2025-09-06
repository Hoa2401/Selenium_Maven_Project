package automation.testsuite;

import java.time.Duration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import automation.common.CT_PageURL;
import automation.common.CommonBase;

public class Day17_Practice_iFrame extends CommonBase {
	@BeforeMethod
	public void openBrowser() {
		driver = initChromeDriver(CT_PageURL.CODESTAR_URL_HOMEPAGE);
	}
	
	@Test
	public void handleIframe() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		By locator = By.xpath(("//h2[text()='Đăng kí nhận tư vấn lộ trình phát triển nghề nghiệp về AWS/Kiểm thử/Lập trình web']"));
		scrollToElement(locator);
		System.out.println("iframe total: " + driver.findElement(By.tagName("iframe")).getSize());
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("(//input[@name='name'])[1]")).sendKeys("Nguyen An");
		driver.findElement(By.id("phone_number")).sendKeys("0987654321");
		driver.findElement(By.id("email")).sendKeys("h001@gmail.com");
		clickByJS(By.xpath("//button[normalize-space()='Gửi ngay']"));

	}

}
