package javaCodings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OpenGoogle {
	@Test
	public void main() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"/Users/thirumalaivasanperumal/Downloads/chromedriver-mac-arm64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.guvi.in/code-kata/");
		WebElement element = driver.findElement(
				By.xpath("//h2[text()='Input/Output']//parent::div//following-sibling::div//a[text()='Start']"));
		Assert.assertEquals(false, false);
	}

}
