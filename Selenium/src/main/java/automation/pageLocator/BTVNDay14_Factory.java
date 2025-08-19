package automation.pageLocator;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BTVNDay14_Factory {
	private WebDriver driver;
	
	//Syncup
	@FindBy(id="txtFirstname") WebElement textHoTen;
	@FindBy(id="txtEmail") WebElement textEmail;
	@FindBy(id="txtCEmail") WebElement textNhapLaiEmail;
	@FindBy(id="txtPassword") WebElement textPassword;
	@FindBy(id="txtCPassword") WebElement textNhapLaiPasword;
	@FindBy(id="txtPhone") WebElement textPhone;
	@FindBy(xpath="(//button[text()='ĐĂNG KÝ'])[3]") WebElement btnSignup;
	
	//Login
	@FindBy(xpath="//input[@name='txtLoginUsername']") WebElement emailLogin;
	@FindBy(id="txtLoginPassword") WebElement passwordLogin;
	@FindBy(xpath="(//button[text()='ĐĂNG NHẬP'])[3]") WebElement btnLogin;
	
	//Edit thông tin
	@FindBy (xpath="//div[@class='avatar2']") WebElement imgAvatar;
	@FindBy(xpath="//a[text()='Chỉnh sửa thông tin']") WebElement editInformation;
	@FindBy(xpath="//input[@placeholder='Mật khẩu hiện tại']") WebElement passPresent;
	@FindBy(id="txtnewpass") WebElement txtNewPass;
	@FindBy(id="txtrenewpass") WebElement txtReNewPass;
	@FindBy(xpath="//button[@onclick='checkFormPass();']") WebElement btnSavePass;

	public BTVNDay14_Factory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void SignupFunction(String hoten, String email, String pass, String phone) {
		textHoTen.sendKeys(hoten);
		textEmail.sendKeys(email);
		textNhapLaiEmail.sendKeys(email);
		textPassword.sendKeys(pass);
		textNhapLaiPasword.sendKeys(pass);
		textPhone.sendKeys(phone);
		btnSignup.click();
	}
	public void loginFunction(String emailDn , String passDn) {
		emailLogin.sendKeys(emailDn);
		passwordLogin.sendKeys(passDn);
		btnLogin.click();
}
	public void EditInfoFunction(String passPre ,String newPass) {
		imgAvatar.click();
		editInformation.click();
		passPresent.sendKeys(passPre);
		txtNewPass.sendKeys(newPass);
		txtReNewPass.sendKeys(newPass);	
		btnSavePass.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}
	public void NewLogin(String oldEmail, String pasnew) {
		emailLogin.sendKeys(oldEmail);
		passwordLogin.sendKeys(pasnew);
		btnLogin.click();
	}

}
