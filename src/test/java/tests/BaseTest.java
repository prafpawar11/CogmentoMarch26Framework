package tests;

import java.time.Duration;

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

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.name("email")).sendKeys("prafulp1010@gmail.com");

		driver.findElement(By.name("password")).sendKeys("Pr@ful0812");

		driver.findElement(By.xpath("//div[text()='Login']")).click();

		Thread.sleep(3000);
	}

	@Test(priority = 1)
	public void validateLoginFunctionality() {
		Assert.assertEquals(driver.getTitle(), "Free CRM");
	}

	@Test(priority = 2)
	public void createContact() throws InterruptedException {

		driver.findElement(By.xpath("//span[text()='Contacts']")).click();

		driver.findElement(By.xpath("//button[text()='Create']")).click();

		Thread.sleep(2000);

		driver.findElement(By.name("first_name")).sendKeys("Abhijeet");

		driver.findElement(By.name("last_name")).sendKeys("Kanade");

		driver.findElement(By.name("description")).sendKeys("TC-003");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[text()='Save']")).click();

		Thread.sleep(3000);
	}

	@Test(priority = 3)
	public void createDeal() throws InterruptedException {

		driver.findElement(By.xpath("//a[@href='/deals']")).click();

		driver.findElement(By.xpath("//a[@href='/deals/new']")).click();

		Thread.sleep(2000);

		driver.findElement(By.name("title")).sendKeys("Motorola Edge 50");

		driver.findElement(By.name("description")).sendKeys("8GB RAM 128GB ROM");

		driver.findElement(By.name("identifier")).sendKeys("Edge 50");

		driver.findElement(By.xpath("//button[text()='Save']")).click();

		boolean isDisplayed = driver.findElement(By.xpath("//span[@class=\"selectable \"]")).isDisplayed();

		Thread.sleep(2000);

		Assert.assertTrue(isDisplayed);
	}

	@AfterTest
	public void teardown() throws InterruptedException {

		Thread.sleep(3000);
		driver.quit();
	}

}
