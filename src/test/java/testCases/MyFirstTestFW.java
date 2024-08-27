package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseTest;
import utilities.ReadXLSdata;

public class MyFirstTestFW extends BaseTest {
	
    @Test(dataProviderClass=ReadXLSdata.class,dataProvider = "maruthiTest")
    public void LoginTest(String username , String password) throws InterruptedException {
    	Thread.sleep(1000);
        // Ensure the properties object `loc` is loaded
        driver.findElement(By.linkText(loc.getProperty("signin_link"))).click(); // Assuming this opens the login page
        
        WebElement emailField = driver.findElement(By.cssSelector(loc.getProperty("email_field")));
        Thread.sleep(1000);
        emailField.sendKeys(username);
        
        driver.findElement(By.id(loc.getProperty("next_button"))).click();
        
        WebElement pwd = driver.findElement(By.xpath(loc.getProperty("pwd_field")));
        pwd.sendKeys(password);
        
        driver.findElement(By.id(loc.getProperty("login_next_button"))).click();
        Thread.sleep(1000);
    }
    
}
