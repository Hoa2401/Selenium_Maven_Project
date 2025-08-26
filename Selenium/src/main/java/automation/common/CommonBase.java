package automation.common;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;


public class CommonBase {
	public static WebDriver driver;
	public WebDriver initChromeDriver(String Url)
	{
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	// Tắt Password Manager
	Map<String, Object> prefs = new HashMap<String, Object>();
    prefs.put("credentials_enable_service", false);
    prefs.put("profile.password_manager_enabled", false);
 // Tắt cảnh báo password bị lộ
    prefs.put("safebrowsing.enabled", false);
    prefs.put("safebrowsing.disable_download_protection", true);
    prefs.put("profile.password_manager_leak_detection", false);
    options.setExperimentalOption("prefs", prefs);
    options.addArguments("--disable-save-password-bubble");
    options.addArguments("disable-popup-blocking");
	driver = new ChromeDriver(options);
	driver.get(Url);
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	driver.manage().window().maximize();
	return driver;
	}
	public WebDriver initFirefoxDriver(String Url) {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(Url);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		driver.manage().window().maximize();
		return driver;
	}
	public void scrollToElement(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = getElementPresentDOM(locator);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public WebElement getElementPresentDOM(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator);
	}
	
	public void closeDriver()
	{
		if(driver!=null)
			driver.close();
	}
}
