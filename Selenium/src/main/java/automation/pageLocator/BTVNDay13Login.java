package automation.pageLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BTVNDay13Login {
	private WebDriver driver;

	public BTVNDay13Login(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public void LoginFunction(String email, String pass) {
		WebElement textEmail = driver.findElement(By.id("email"));
		if(textEmail.isDisplayed()) {
			textEmail.sendKeys(email);
		}
		WebElement textPassword = driver.findElement(By.id("password"));
		if(textPassword.isDisplayed()) {
			textPassword.sendKeys(pass);
		}
		WebElement buttonLogin = driver.findElement(By.xpath("//button[text()='Đăng nhập']"));
		if(buttonLogin.isEnabled()) {
			buttonLogin.click();
	}
	
	}	

	}

