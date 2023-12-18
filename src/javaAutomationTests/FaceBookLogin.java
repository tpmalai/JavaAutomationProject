package javaAutomationTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBookLogin {
	WebDriver driver;

	@BeforeClass
	public void initialization() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		Thread.sleep(2000);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test
	public void actions() {
		Assert.assertEquals("https://www.facebook.com/", driver.getCurrentUrl());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Create new account']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='First name']")))
				.sendKeys("Test");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='lastname']"))).sendKeys("User");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='reg_email__']")))
				.sendKeys("testu4896@gmail.com");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='reg_email_confirmation__']")))
				.sendKeys("testu4896@gmail.com");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@aria-label='New password']")))
				.sendKeys("Testuser@123");
		WebElement Birthday = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select dropdownselection = new Select(Birthday);
		dropdownselection.selectByVisibleText("11");
		WebElement BirthdayMonth = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select dropdownselectionMonth = new Select(BirthdayMonth);
		dropdownselectionMonth.selectByVisibleText("May");
		WebElement BirthdayYear = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select dropdownselectionyear = new Select(BirthdayYear);
		dropdownselectionyear.selectByVisibleText("1985");
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//label[text()='Male']//parent::span//input[@type='radio']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='websubmit']"))).click();
	}

	@AfterClass
	public void closebrowser() {
		System.out.println("Browser Terminated Successfully");
		driver.close();
	}
}
