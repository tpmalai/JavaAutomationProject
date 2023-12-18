package javaAutomationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	WebDriver driver;

	@BeforeClass
	public void initialization() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		Thread.sleep(2000);
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test
	public void m1() throws InterruptedException {
		WebElement Drag = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement Drop = driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions actions = new Actions(driver);
		// actions.dragAndDrop(Drag, Drop).build().perform();
		actions.clickAndHold(Drag).moveToElement(Drop).perform();
		Thread.sleep(1000);
	}

	@AfterClass
	public void close() {
		System.out.println("Browser Terminated Successfully");
		driver.close();
	}

}
