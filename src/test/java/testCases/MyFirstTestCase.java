package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyFirstTestCase
{
   public static void main(String[] args) throws Throwable {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.zoho.com/");
	driver.findElement(By.linkText("Sign in")).click();
	Thread.sleep(1000);
	WebElement emailField = driver.findElement(By.cssSelector("#login_id"));
	emailField.sendKeys("marhlsunrs@gmail.com");
	driver.findElement(By.id("nextbtn")).click();
	Thread.sleep(1000);
	WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
	pwd.sendKeys("Maruthi@5312");
	driver.findElement(By.id("nextbtn")).click();
}
}
