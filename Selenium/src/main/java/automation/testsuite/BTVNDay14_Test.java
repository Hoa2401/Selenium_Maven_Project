package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Random;
import automation.common.CT_PageURL;
import automation.common.CommonBase;
import automation.pageLocator.BTVNDay14_Factory;

public class BTVNDay14_Test extends CommonBase {
	static String baseEmail = "testBase";
	


	public static String generateRandomString(int length) {
	        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	        Random random = new Random();
	        StringBuilder email = new StringBuilder(length);

	        for (int i = 0; i < length; i++) {
	            int index = random.nextInt(characters.length());
	            email.append(characters.charAt(index));
	        }

	        baseEmail = baseEmail+email.toString()+"@gmail.com";
	        return baseEmail;
	    }
//	@Test
//	public void creatRandomEmail() {
//		System.out.println("random email"+baseEmail+generateRandomString(4)+"@gmail.com");
//	}
		

	@BeforeMethod
	public void openBrowser() {
		driver = initChromeDriver(CT_PageURL.ALADA_URL);
	}
	@Test(priority = 1)
	public void Signup() throws InterruptedException {
		generateRandomString(4);
		WebElement DK = driver.findElement(By.xpath("//a[text()='Đăng Ký']"));
		DK.click();
		BTVNDay14_Factory factory = new BTVNDay14_Factory(driver);
		factory.SignupFunction("Nguyen Van An", baseEmail, "123456", "0987654321");
		Thread.sleep(3000);
		WebElement khoaHocCuaToi = driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]"));
		assertTrue(khoaHocCuaToi.isDisplayed());
	}
	
	@Test(priority = 2)
	public void LoginSuccessfully() {
		BTVNDay14_Factory factory = new BTVNDay14_Factory(driver);
		factory.loginFunction(baseEmail, "123456");
		WebElement khoaHocCuaToi = driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]"));
		assertTrue(khoaHocCuaToi.isDisplayed());
	}
	
	@Test(priority = 3)
	public void editInfo() {
		LoginSuccessfully();
		BTVNDay14_Factory factory = new BTVNDay14_Factory(driver);
		factory.EditInfoFunction("123456","1234567");
		WebElement khoaHocCuaToi = driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]"));
		assertTrue(khoaHocCuaToi.isDisplayed());
		WebElement imgAva = driver.findElement(By.xpath("//div[@class='avatar2']"));
		imgAva.click();
		WebElement btnThoat = driver.findElement(By.xpath("//a[text()='Thoát']"));
		btnThoat.click();
	}
	@Test(priority = 4)
	public void newLoginSuccessfully() {
		BTVNDay14_Factory factory = new BTVNDay14_Factory(driver);
		factory.NewLogin(baseEmail, "1234567");
		WebElement khoaHocCuaToi = driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]"));
		assertTrue(khoaHocCuaToi.isDisplayed());
	}
	}


