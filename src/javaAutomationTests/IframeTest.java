package javaAutomationTests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IframeTest {

	WebDriver driver;

	@BeforeClass
	public void initialization() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		Thread.sleep(2000);
		driver.get("https://the-internet.herokuapp.com/iframe");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test
	public void actions() {
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
		driver.switchTo().frame(iframe);
		WebElement textArea = driver.findElement(By.xpath("//body[contains(@aria-label,'Rich Text Area.')]"));
		textArea.clear();
		textArea.sendKeys("Vanakam da mapla theni la irundhu");
		driver.switchTo().defaultContent();
		WebElement id = driver.findElement(By.tagName("h3"));
		String text = id.getText();
		System.out.println(text);
		assertEquals(text, "An iFrame containing the TinyMCE WYSIWYG Editor");
	}

	@AfterClass
	public void driverClose() {
		System.out.println("Browser Terminated successfully");
		driver.close();
	}
}
