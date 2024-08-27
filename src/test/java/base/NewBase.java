package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewBase 
{
    public static WebDriver driver;
    public static Properties p = new Properties(); // For config properties
    public static Properties L = new Properties(); // For locator properties
    public static FileReader f;
    public static FileReader f1;

    @BeforeTest
    public static void setUp() throws IOException {
        if (driver == null) {
            // Load config.properties
            f = new FileReader("C:\\Users\\Admin\\eclipse-workspace\\TestScript\\src\\test\\resources\\configFiles\\config.properties");
            p.load(f);

            // Load locators.properties
            f1 = new FileReader("C:\\Users\\Admin\\eclipse-workspace\\TestScript\\src\\test\\resources\\configFiles\\locators.properties");
            L.load(f1);
        }

        if (p.getProperty("browser").equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(p.getProperty("testurl"));
        } else if (p.getProperty("browser").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get(p.getProperty("testurl"));
        }
        driver.manage().window().maximize(); // Ensure the window is maximized for proper element visibility
    }

    @AfterTest
    public static void tearDown() throws InterruptedException {
        Thread.sleep(1000); // Optional: wait for a second before closing the browser
        driver.quit();
        System.out.println("Tear down successfully");
    }
}
