package automation.pageLocator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TEDU_Factory {
	private WebDriver driver;
	@FindBy(id="UserName") WebElement textEmail;
	@FindBy(id="Password") WebElement textPass;
	@FindBy(xpath="//button[text()='Đăng nhập']") WebElement btnDangNhap;;
	@FindBy(id="onesignal-slidedown-allow-button") WebElement btnSubcribe;;
	@FindBy(id="my_account") WebElement btnMyAccount;
	@FindBy(xpath="//a[@title='Đổi mật khẩu']") WebElement btnChangePass;
	@FindBy(id="OldPassword") WebElement textOldPassword;
	@FindBy(id="NewPassword") WebElement textNewPassword;
	@FindBy(id="ConfirmNewPassword") WebElement textConfirmNewPassword;
	@FindBy(xpath="//input[@value='Cập nhật']") WebElement btnCapNhat;


	public TEDU_Factory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void loginFunction(String email, String pass) {
		textEmail.sendKeys(email);
		textPass.sendKeys(pass);
		btnDangNhap.click();
	}
	
	public void updatePassword(String oldPass, String newPass) throws InterruptedException {
		Thread.sleep(2000);
		btnSubcribe.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('my_account').click();");
//		btnMyAccount.click();
		js.executeScript("arguments[0].click();", btnChangePass);
//		btnChangePass.click();
		Thread.sleep(2000);
		textOldPassword.sendKeys(oldPass);
		textNewPassword.sendKeys(newPass);
		textConfirmNewPassword.sendKeys(newPass);
		btnCapNhat.click();
		
	}
	

}
