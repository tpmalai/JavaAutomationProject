package javaCodings;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginGuvi {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"/Users/thirumalaivasanperumal/Downloads/chromedriver-mac-arm64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.guvi.in/code-kata/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//h2[text()='Input/Output']//parent::div//following-sibling::div//a[text()='Start']")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Login'])[2]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//label[text()='Email Address']//parent::div//following-sibling::input[@type='email']")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//label[text()='Email Address']//parent::div//following-sibling::input[@type='email']")))
				.sendKeys("tmvthirumalai@gmail.com");
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//label[text()='Password']//parent::div//following-sibling::input[@type='password']")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//label[text()='Password']//parent::div//following-sibling::input[@type='password']")))
				.sendKeys("Tp#6379616155");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='login-btn']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//h2[text()='Input/Output']//parent::div//following-sibling::div//a[text()='Start']")))
				.click();
		if (!(driver.getCurrentUrl().equals("https://www.guvi.in/code-kata"))) {
			System.out.println("Passed");
		} else {
			System.out.println("failed");
		}
		System.out.println(driver.getCurrentUrl());
		driver.close();
	}

}
