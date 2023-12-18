package javaCodings;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyFaceBook {
	@Test
	public void m2() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/thirumalaivasanperumal/Downloads/chromedriver-mac-arm64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com/");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Create new account']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='First name']")))
				.sendKeys("Test");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='lastname']"))).sendKeys("User");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='reg_email__']")))
				.sendKeys("testu4896@gmail.com");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='reg_email_confirmation__']")))
				.sendKeys("testu4896@gmail.com");
	}

}
