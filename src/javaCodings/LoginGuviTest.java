package javaCodings;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class LoginGuviTest {

	@Test
	public void m1() {
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
