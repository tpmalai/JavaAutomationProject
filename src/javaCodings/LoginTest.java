package javaCodings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	@Test
	public void m1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.guvi.in/code-kata/");
		WebElement element = driver.findElement(
				By.xpath("//h2[text()='Input/Output']//parent::div//following-sibling::div//a[text()='Start']"));
		Actions action = new Actions(driver);
		// action.click(element).build().perform();
		action.moveToElement(element).build().perform();
	}
}