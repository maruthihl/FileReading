package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.testng.annotations.Test;

import base.BaseTest;

public class LocatorsExteralize extends BaseTest
{
	@Test
	public void LoginTest() throws InterruptedException 
	{
		driver.findElement(By.linkText("Sign in")).click(); // Assuming this opens the login page
		WebElement emailField = driver.findElement(By.cssSelector("#login_id"));
		Thread.sleep(1000);
		emailField.sendKeys("marhlsunrs@gmail.com");
		driver.findElement(By.id("nextbtn")).click();
		WebElement pwd = driver.findElement(By.cssSelector("#password"));
		pwd.sendKeys("Maruthi@5312");
		driver.findElement(By.id("nextbtn")).click();
		Thread.sleep(1000);
		
		//vishant is don
	}
}
