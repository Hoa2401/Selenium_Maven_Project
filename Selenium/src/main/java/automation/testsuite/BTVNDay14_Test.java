package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CT_PageURL;
import automation.common.CommonBase;
import automation.pageLocator.BTVNDay14_Factory;

public class BTVNDay14_Test extends CommonBase {
	@BeforeMethod
	public void openBrowser() {
		driver = initChromeDriver(CT_PageURL.ALADA_URL);
	}
	@Test
	public void Signup() {
		WebElement DK = driver.findElement(By.xpath("//a[text()='Đăng Ký']"));
		DK.click();
		BTVNDay14_Factory factory = new BTVNDay14_Factory(driver);
		factory.SignupFunction("Nguyen Van An", "hoa002@gmail.com", "123456", "0987654321");
		WebElement khoaHocCuaToi = driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]"));
		assertTrue(khoaHocCuaToi.isDisplayed());
	}
	
	@Test
	public void LoginSuccessfully() {
		BTVNDay14_Factory factory = new BTVNDay14_Factory(driver);
		factory.loginFunction("hoa002@gmail.com", "123456789");
		WebElement khoaHocCuaToi = driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]"));
		assertTrue(khoaHocCuaToi.isDisplayed());
	}
	
	@Test
	public void editInfo() {
		LoginSuccessfully();
		BTVNDay14_Factory factory = new BTVNDay14_Factory(driver);
		factory.EditInfoFunction("123456789","123456");
		WebElement khoaHocCuaToi = driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]"));
		assertTrue(khoaHocCuaToi.isDisplayed());
		WebElement imgAva = driver.findElement(By.xpath("//div[@class='avatar2']"));
		imgAva.click();
		WebElement btnThoat = driver.findElement(By.xpath("//a[text()='Thoát']"));
		btnThoat.click();
	}
	@Test
	public void newLoginSuccessfully() {
		BTVNDay14_Factory factory = new BTVNDay14_Factory(driver);
		factory.NewLogin("hoa002@gmail.com", "123456");
		WebElement khoaHocCuaToi = driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]"));
		assertTrue(khoaHocCuaToi.isDisplayed());
	}
	}


