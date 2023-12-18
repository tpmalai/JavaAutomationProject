package javaAutomationTests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginFlipkart {
	WebDriver driver;

	@BeforeClass
	public void initialization() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		Thread.sleep(2000);
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void m1() throws InterruptedException, IOException {
		WebElement Mobile = driver.findElement(By.xpath("//span[text()='Mobiles']"));
		// WebElement Drop = driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions actions = new Actions(driver);
		// actions.dragAndDrop(Drag, Drop).build().perform();
		actions.click(Mobile).build().perform();
		if (driver.getCurrentUrl().startsWith("https://www.flipkart.com/mobile-phones")) {
			Assert.assertEquals("https://www.flipkart.com/mobile-phones",
					driver.getCurrentUrl().startsWith("https://www.flipkart.com/mobile-phones"));
		}
		System.out.println("https://www.flipkart.com/mobile-phones "
				.equals(driver.getCurrentUrl().startsWith("https://www.flipkart.com/mobile-phones")));
		TakesScreenshot tk = (TakesScreenshot) driver;
		File f = tk.getScreenshotAs(OutputType.FILE);
		File file = new File("/Users/thirumalaivasanperumal/eclipse-workspace/SeleniumSamples/DashBoard.png");
		FileUtils.copyFile(f, file);
		Thread.sleep(1000);
	}

	@AfterClass
	public void close() {
		System.out.println("Browser Terminated Successfully");
		driver.close();
	}
}
