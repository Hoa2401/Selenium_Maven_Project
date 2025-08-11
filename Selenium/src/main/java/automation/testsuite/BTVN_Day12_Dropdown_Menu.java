package automation.testsuite;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;

import automation.common.CT_PageURL;
import automation.common.CommonBase;

public class BTVN_Day12_Dropdown_Menu extends CommonBase {
	@Test
	public void handleDropdownMenu() {
		driver = initChromeDriver(CT_PageURL.GLOBALSQ_URL);
		WebElement dropMenu =driver.findElement(By.xpath("//div[@class='single_tab_div resp-tab-content resp-tab-content-active']/descendant::div/following::select"));
		Select menuSelect = new Select(dropMenu);
		//0. Kiem tra so luong
		int size= menuSelect.getOptions().size();
		assertEquals(size, 249);
		
		//1. Chon option Viet Nam bang ham selectByVisibleText
		menuSelect.selectByContainsVisibleText("Viet Nam");
		String actualText1 = menuSelect.getFirstSelectedOption().getText();
		assertEquals(actualText1, "Viet Nam");
		
		//2. Chon option Maldives bang ham selectByValue
		menuSelect.selectByValue("MDV");
		String actualText2 = menuSelect.getFirstSelectedOption().getText();
		assertEquals(actualText2, "Maldives");
		
		//3. Chon option American Samoa bang ham Index
		menuSelect.selectByIndex(4);
		String actualText3 = menuSelect.getFirstSelectedOption().getText();
		assertEquals(actualText3, "American Samoa");
	}
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
