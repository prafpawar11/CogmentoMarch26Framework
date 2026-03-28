package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTest {

	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void setup() throws InterruptedException {

		driver.manage().window().maximize();

		driver.get("https://ui.cogmento.com/");

		driver.findElement(By.name("email")).sendKeys("prafulp1010@gmail.com");

		driver.findElement(By.name("password")).sendKeys("Pr@ful0812");

		driver.findElement(By.xpath("//div[text()='Login']")).click();

		Thread.sleep(3000);
	}

	@Test
	public void validateLoginFunctionality() {
		Assert.assertEquals(driver.getTitle(), "Free CRM");
	}

	@AfterTest
	public void teardown() throws InterruptedException {

		Thread.sleep(3000);
		driver.quit();
	}

}
