package javaAutomationTests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingAlerts {

	// Alert Obj = driver.switchTo().alert()
	// accept
	// dismiss
	// getText
	// sendkeys

	WebDriver driver;

	@BeforeClass
	public void initialization() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		Thread.sleep(2000);
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test
	public void clickforJsAlert() {
		WebElement element = driver.findElement(By.xpath("(//ul//li//button)[1]"));
		element.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	@Test
	public void clickforJsConform() {

	}

	@Test
	public void clickforJsPrompt() {

	}

	@AfterClass
	public void driverClose() {
		System.out.println("Browser Terminated successfully");
		driver.close();
	}
}
