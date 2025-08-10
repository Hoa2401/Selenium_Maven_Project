package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import automation.common.CT_PageURL;
import automation.common.CommonBase;

public class D12_HandleCheckbox extends CommonBase{
	
	@Test
	public void chooseHobbies()
	{
		driver = initChromeDriver(CT_PageURL.DEMOQA_URL);
		scrollToElement(By.id("userNumber"));
		WebElement sport = driver.findElement(By.xpath("//label[text()='Sports']"));
		boolean isSportSelected = sport.isSelected();
		if(isSportSelected==false)
		{
			sport.click();
			System.out.println("Checkbox Sport has been selected");
		}
		WebElement reading = driver.findElement(By.xpath("//label[text()='Reading']"));
		if(reading.isSelected()==false)
		{
			reading.click();
			System.out.println("Checkbox Reading has been selected");
		}
		WebElement music = driver.findElement(By.xpath("//label[text()='Music']"));
		if(music.isSelected()==false) {
			music.click();
			System.out.println("Checkbox Music has been selected");
		}
	}

}
