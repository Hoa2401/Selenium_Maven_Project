package automation.pageLocator;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ALADA_LoginLogoutPage_Factory {
	private WebDriver driver;
	
	//Goi chu thich @FindBy de tao lien ket giua webElement với Locator
	//login
	@FindBy(id="txtLoginUsername") WebElement textEmail;
	@FindBy(id="txtLoginPassword") WebElement textPassword;
	@FindBy(xpath="(//button[text()='ĐĂNG NHẬP'])[3]") WebElement btnLogin;
	//logout
	@FindBy (xpath="//div[@class='avatar2']") WebElement imgAvatar;
	@FindBy (xpath="//a[text()='Thoát']") WebElement btnThoat;

	public ALADA_LoginLogoutPage_Factory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void loginFunction(String email, String pass) {
		textEmail.sendKeys(email);
		textPassword.sendKeys(pass);
		btnLogin.click();
	}
	public void logoutFunction() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.alertIsPresent());
//		driver.switchTo().alert().accept();
		imgAvatar.click();
		btnThoat.click();
	}

}
