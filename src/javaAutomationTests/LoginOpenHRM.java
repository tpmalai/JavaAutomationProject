package javaAutomationTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginOpenHRM {
	WebDriver driver;

	@BeforeClass
	public void initialization() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		Thread.sleep(2000);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test
	public void actions() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement LoginButton = driver.findElement(By.xpath("//button[text()=' Login ']"));
		wait.until(ExpectedConditions.elementToBeClickable(username)).sendKeys("Admin");
		wait.until(ExpectedConditions.elementToBeClickable(password)).sendKeys("admin123");
		wait.until(ExpectedConditions.elementToBeClickable(LoginButton)).click();

	}

	@AfterClass
	public void closebrowser() {
		System.out.println("Browser Terminated Successfully");
		driver.close();
	}
}
