package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.CT_PageURL;
import automation.common.CommonBase;

public class BTVN_Day18_HandleWgtZalo extends CommonBase{
	@BeforeMethod
	@Parameters("browser")
	public void openBrowser(@Optional("chrome") String browser) {
		driver = setupDriver(browser);
		driver.get(CT_PageURL.DIENMAYNHAPKHAU_URL);
	}
	
	@Test
	public void handleWidgtZalo() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		clickByJS(By.xpath("//body[@class='home page-template page-template-templates page-template-fullwidth page-template-templatesfullwidth-php page page-id-347 wpb-js-composer js-comp-ver-5.1.1 vc_responsive']/div[@class='site']/following::div[@id='button-contact-vr']/div[@id='gom-all-in-one']/div[@id='zalo-vr']"));
		String mainWindow = driver.getWindowHandle();
		Set<String> listWindows = driver.getWindowHandles();
		for (String window : listWindows) {
			if(!mainWindow.equals(window)) {
				driver.switchTo().window(window);
				assertTrue(isElementDisplay(By.xpath("//h1[text()='Hiền- Hùng Anh']")));
				driver.close();
			}
		}
	}
	
}
