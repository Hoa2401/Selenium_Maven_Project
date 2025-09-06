package automation.pageLocator;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BTVN_Day16_Factory {
	private WebDriver driver;
	//homework 1
	@FindBy(id="email") WebElement txtEmail;
	@FindBy(id="password") WebElement txtPassword;
	@FindBy(xpath="//button[text()='Đăng nhập']") WebElement btnLogin;
	@FindBy(xpath="//a[normalize-space()='Quản lý khu làm việc']") WebElement menuKLV;
	@FindBy(xpath="//button[text()='Thêm mới']") WebElement btnAddKLV;
	@FindBy(xpath="//input[@name='work_areas_code']") WebElement txtMaKLV;
	@FindBy(xpath="//input[@name='name']") WebElement txtTenKLV;
	@FindBy(xpath="//button[text()='Lưu']") WebElement btnSave;
	@FindBy(xpath="//button[@form='add_workarea']") WebElement btnThem;
	@FindBy(xpath="//input[@class='form-control me-3']") WebElement txtSearch;
	@FindBy(xpath="//button[text()='Tìm kiếm']") WebElement btnTimKiem;
	@FindBy(xpath="//a[normalize-space()='Xóa']") WebElement btnXoa;
	//homework 2
	@FindBy(xpath="//button[text()='Try it']") WebElement btnTryIt;
	
	
	//homework 1
	public BTVN_Day16_Factory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void loginFunction(String email, String pass) throws InterruptedException {
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(pass);
		btnLogin.click();
		Thread.sleep(3000);
		menuKLV.click();
	}
	public void AddKLV(String code, String name) throws InterruptedException {
		btnAddKLV.click();
		Thread.sleep(2000);
		txtMaKLV.sendKeys(code);
		txtTenKLV.sendKeys(name);
		btnSave.click();
		btnThem.click();
		
	}
	public void DeleteKLV(String nameKLV) throws InterruptedException {
		txtSearch.sendKeys(nameKLV);
		btnTimKiem.click();
		Thread.sleep(10000);
		btnXoa.click();
		String actual = driver.switchTo().alert().getText();
		assertEquals(actual, "Bạn có thực sự muốn xóa khu vực này");
		driver.switchTo().alert().accept();
		
	}
	
	//homework 2
	public void clickBtnTryIt() throws InterruptedException {
		btnTryIt.click();
		Thread.sleep(10000);
		String actual = driver.switchTo().alert().getText();
		assertEquals(actual,"Welcome to Selenium WebDriver Tutorials");
		driver.switchTo().alert().accept();
	}

}
