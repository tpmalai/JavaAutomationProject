package javaAutomationTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownSelection {
	WebDriver driver;

	@BeforeClass
	public void initialization() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		Thread.sleep(2000);
		driver.get("https://flightnewapp.netlify.app/lavish.com/dropdownspractise/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test
	public void actions() {
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement currency = driver.findElement(By.xpath("//select[contains(@id,'_DropDownListCurrency')]"));
		Select dropdownselection = new Select(currency);
		dropdownselection.selectByVisibleText("USD");

	}

//	@AfterClass
//	public void closebrowser() {
//		System.out.println("Browser Terminated Successfully");
//		driver.close();
//	}
}
