package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AssesmentBase {
    public static WebDriver driver; // WebDriver reference
    public static Properties prop = new Properties(); // For config properties
    public static Properties loc = new Properties(); // For locator properties
    public static FileInputStream fr;
    public static FileInputStream fr1; // To read the property files

    @BeforeMethod
    public void setUp() throws IOException, InterruptedException  {
        if (driver == null) {
            // Load config.properties
        	 System.out.println(System.getProperty("user.dir"));
            fr = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\configFiles\\gigintest.properties");
           // Load locators.properties
            fr1 = new FileInputStream(System.getProperty("user.dir") +"\\src\\test\\resources\\configFiles\\giginlocatorstest.properties");
           
            prop.load(fr);
            loc.load(fr1);
        }

        if (prop.getProperty("browser").equalsIgnoreCase("chrome")) 
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(prop.getProperty("testurl"));
        }
        else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get(prop.getProperty("testurl"));
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        System.out.println("Tear down successfully");
    }
}
