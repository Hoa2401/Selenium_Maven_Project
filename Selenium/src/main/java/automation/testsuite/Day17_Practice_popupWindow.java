package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.CT_PageURL;
import automation.common.CommonBase;

public class Day17_Practice_popupWindow extends CommonBase {
	
	@BeforeMethod
	public void openBrowser() {
		driver = initEdgeDriver(CT_PageURL.GURU_POPUP);
	}
	
	@Test
	public void handleWindow() {
		String mainWindow = driver.getWindowHandle();
		click(By.xpath("//a[text()='Click Here']"));
		Set<String> listWindows = driver.getWindowHandles();
		for (String window : listWindows) {
			if(!mainWindow.equals(window)) {
				driver.switchTo().window(window);
				assertTrue(isElementDisplay(By.xpath("//h2[contains(text(),'Enter your email address to get ')]")));
				type(By.name("emailid"),"testEmail@gmail.com");
				click(By.name("btnLogin"));
				assertTrue(isElementDisplay(By.xpath("//h2[text()='Access details to demo site.']")));
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		String currentURL = driver.getCurrentUrl();
		assertEquals(currentURL, "https://demo.guru99.com/popup.php");
		
	}
	

}
