package automation.pageLocator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BTVN_Day15_Factory {
	private WebDriver driver;
	@FindBy(id="UserName") WebElement txtEmail;
	@FindBy(id="Password") WebElement txtPassword;
	@FindBy(xpath="//button[text()='Đăng nhập']") WebElement btnLogin;
	@FindBy(id="my_account") WebElement btnMyAccount;
	@FindBy(xpath="//button[@id='onesignal-slidedown-cancel-button']") WebElement btnLater;
	@FindBy(xpath="//input[@class='autosearch-input form-control']") WebElement txtSearch;
	
	
	public BTVN_Day15_Factory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginFunction( String email, String pass) {
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(pass);
		btnLogin.click();
	}
	public void searchFunction(String textSearch) throws InterruptedException {
		Thread.sleep(2000);
		btnLater.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",txtSearch);
		txtSearch.sendKeys(textSearch);
		txtSearch.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}
	
	
	
	

}
