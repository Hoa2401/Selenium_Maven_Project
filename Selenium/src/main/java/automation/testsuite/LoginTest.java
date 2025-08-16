package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CT_PageURL;
import automation.common.CommonBase;
import automation.pageLocator.LoginPage;

public class LoginTest extends CommonBase {
	@BeforeMethod
	public void openChromeBrowser() {
		driver = initChromeDriver(CT_PageURL.ALADA_URL);
	}
	//Case1: Login thanh cong
	@Test
	public void loginSuccessfully() {
		LoginPage login = new LoginPage(driver);

		login.LoginFunction("hoa001@gmail.com", "123456");
		WebElement khoaHocCuaToi = driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]"));
		assertTrue(khoaHocCuaToi.isDisplayed());
		
	}
	
	@Test 
	public void loginIncorrectEmail() {
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("hoa011@gmail.com", "123456");
		WebElement emailSai =driver.findElement(By.xpath("//p[text()='Email này chưa được đăng ký.']"));
		assertTrue(emailSai.isDisplayed());
	}
	@Test 
	public void loginIncorrectPass() {
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("hoa001@gmail.com", "123564");	
		WebElement passSai = driver.findElement(By.xpath("//p[text()='Mật khẩu sai.']"));
		assertTrue(passSai.isDisplayed());
	}
	@Test
	public void loginBlankEmailPass() {
		LoginPage login = new LoginPage(driver);
		login.LoginFunction(null, "123456");
		WebElement blankEmail = driver.findElement(By.xpath("//label[text()='Vui lòng nhập email']"));
		assertTrue(blankEmail.isDisplayed());
		
		
	}


}
