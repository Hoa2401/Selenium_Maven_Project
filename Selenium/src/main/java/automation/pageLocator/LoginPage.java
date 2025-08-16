package automation.pageLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	//1 page la 1 doi tuong can test cho he thong web
	private WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	//Tim locator cua tung element tren page, roi thu hien cac step
	public void LoginFunction(String email, String pass) {
		WebElement textEmail = driver.findElement(By.id("txtLoginUsername"));
		if(textEmail.isDisplayed()) {
			textEmail.sendKeys(email);
		}
		WebElement textPassword = driver.findElement(By.id("txtLoginPassword"));
		if(textPassword.isDisplayed()) {
			textPassword.sendKeys(pass);
		}
		WebElement buttonLogin = driver.findElement(By.xpath("(//button[text()='ĐĂNG NHẬP'])[3]"));
		if(buttonLogin.isEnabled()) {
			buttonLogin.click();
	}
	
	}	

}
