package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CT_PageURL;
import automation.common.CommonBase;
import automation.pageLocator.BTVNDay13Login;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BTVN_Day13 extends CommonBase {
	@BeforeMethod
	public void openChromeBrowser() {
		driver = initFirefoxDriver(CT_PageURL.CODESTAR_SYSTEM_URL);
	}
	
	@Test
	//Case1: Dang nhap thanh cong
	public void loginSuccessfully() {
		BTVNDay13Login login = new BTVNDay13Login(driver);
		login.LoginFunction("admin@gmail.com", "12345678");
		WebElement Admin = driver.findElement(By.xpath("//a[@class='btn btn-primary dropdown-toggle']"));
		assertTrue(Admin.isDisplayed());	
	}
	
	@Test
	//Case2: Login thất bại do sai email
	public void loginIncorrectEmail() {
		BTVNDay13Login login = new BTVNDay13Login(driver);
		login.LoginFunction("admin123@gmail.com", "12345678");
		WebElement failEmail = driver.findElement(By.xpath("//div[@class='container-fluid']"));
		assertTrue(failEmail.isDisplayed());
	}
	
	@Test 
	//Case3: Login thất bại do sai password
	public void loginIncorrectPassword() {
		BTVNDay13Login login = new BTVNDay13Login(driver);
		login.LoginFunction("admin@gmail.com", "12345678a");
		WebElement failPass = driver.findElement(By.xpath("//div[@class='container-fluid']"));
		assertTrue(failPass.isDisplayed());
	}
	
	@Test
	//Case4: Login thất bại do sai cả mail và password.
	public void loginIncorrectEmailPass() {
		BTVNDay13Login login = new BTVNDay13Login(driver);
		login.LoginFunction("admin123@gmail.com", "12345678a");
		WebElement failBoth = driver.findElement(By.xpath("//div[@class='container-fluid']"));
		assertTrue(failBoth.isDisplayed());
	}
	
	@Test 
	//Case5: Logout
	public void logout() {
		BTVNDay13Login login = new BTVNDay13Login(driver);
		login.LoginFunction("admin@gmail.com", "12345678");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//toast msg hien thi
		WebElement toastMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast-title']")));
		assertTrue(toastMsg.isDisplayed());
		wait.until(ExpectedConditions.invisibilityOfElementLocated((By.xpath("//div[@class='toast-title']"))));//toast- msg tu dong an di
		System.out.println("Toast message đã tự động ẩn");
		WebElement Admin = driver.findElement(By.xpath("//a[@class='btn btn-primary dropdown-toggle']"));
		Admin.click();
		WebElement logout = driver.findElement(By.xpath("(//button[text()='Đăng xuất'])[1]"));
		assertTrue(logout.isDisplayed());
		logout.click();
		WebElement logout2 = driver.findElement(By.xpath("(//button[text()='Đăng xuất'])[2]"));
		assertTrue(logout2.isDisplayed());
		logout2.click();
	}

	}
	


