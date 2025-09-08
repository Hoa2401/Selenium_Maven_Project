package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.CT_PageURL;
import automation.common.CommonBase;

public class BTVN_Day18_BepAnToan_Zalo extends CommonBase {
	@BeforeMethod
	@Parameters("browser")
	public void openBrowser(@Optional("chrome") String browser) {
		driver = setupDriver(browser);
		driver.get(CT_PageURL.BEPANTOAN_URL);
	}
	
	@Test
	public void handleBtnChatVoiChungToi() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		clickByJS(By.xpath("//a[@href='https://zalo.me/0912331335']/span[text()='Chat với chúng tôi']"));
		String mainWindow = driver.getWindowHandle();
		Set<String> listwindows = driver.getWindowHandles();
		for( String window : listwindows) {
			if(!mainWindow.equals(window)) {
				driver.switchTo().window(window);
				assertTrue(isElementDisplay(By.xpath("//p[text()='Đăng nhập qua mã QR']")));
				driver.close();
			}
		}
	}

}
