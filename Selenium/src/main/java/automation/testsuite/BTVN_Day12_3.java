package automation.testsuite;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;

import automation.common.CT_PageURL;
import automation.common.CommonBase;

public class BTVN_Day12_3 extends CommonBase {
	@Test
	public void chooseDropMulti() {
		driver = initChromeDriver(CT_PageURL.SELENIUM_WEBDRIVER_URL);
		scrollToElement(By.xpath("//label[text()='Biography:']"));
		WebElement dropMulti =driver.findElement(By.xpath("//select[@name='user_job2']"));
		Select menuDrop = new Select(dropMulti);
		int size= menuDrop.getOptions().size();
		assertEquals(size, 10);
		//1.Chon option "Automation" bang ham selectByVisibleText
		menuDrop.selectByVisibleText("Automation");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String actualText1 = menuDrop.getFirstSelectedOption().getText();
		assertEquals(actualText1, "Automation");
		
		//2.Chon option "Manual" bang ham selectByValue
		driver.navigate().refresh();// f5 lại trình duyệt
		scrollToElement(By.xpath("//label[text()='Biography:']"));
		WebElement dropMulti2 =driver.findElement(By.xpath("//select[@name='user_job2']"));
		Select menuDrop2 = new Select(dropMulti2);
		menuDrop2.selectByValue("manual");
		String actualText2 = menuDrop2.getFirstSelectedOption().getText();
		assertEquals(actualText2, "Manual");
	}
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
