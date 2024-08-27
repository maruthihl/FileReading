package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DeleteGitHubRepos {

	public static void main(String[] args) {

		// Set up WebDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Your GitHub credentials
		String username = "maruthihl2000@gmail.com";
		String password = "Maruthi@4159";

		// List of repositories to delete
		String[] repositoriesToDelete = { "\r\n" + "maruthihl/python1", "maruthihl/kobe6", "maruthihl/kobe6",
				"maruthihl/kobe87" }; // Replace with your repository names

		try {
			// Log in to GitHub
			githubLogin(driver, username, password);

			// Delete each repository
			for (String repoName : repositoriesToDelete) {
				deleteRepository(driver, username, repoName);
			}
		} finally {
			// Close the WebDriver
			driver.quit();
		}
	}

	public static void githubLogin(WebDriver driver, String username, String password) {
		driver.get("https://github.com/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("login_field")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.name("commit")).click();
	}

	public static void deleteRepository(WebDriver driver, String username, String repoName) {
		driver.get("https://github.com/" + username + "/" + repoName + "/settings");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Scroll to the bottom of the page and click the "Delete this repository"
		// button
		WebElement deleteButton = driver.findElement(By.xpath("//summary[contains(text(),'Delete this repository')]"));
		deleteButton.click();

		// Confirm deletion
		WebElement confirmInput = driver.findElement(By.xpath(
				"//input[@aria-label='maruthihl/python1']"));
		confirmInput.sendKeys(repoName);

		WebElement confirmButton = driver.findElement(
				By.xpath("//button[contains(text(),'I understand the consequences, delete this repository')]"));
		confirmButton.click();

		// Wait a moment for the operation to complete
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
