package bestbuyautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BrandAndSelectAnyBrand {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the system property to the location of your ChromeDriver executable.
        System.setProperty("webdriver.chrome.driver",
 "C:\\Users\\Kalpesh Patil\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Create a WebDriver instance (in this case, for Chrome).
        driver = new ChromeDriver();

        // Navigate to the Best Buy website.
        driver.get("https://www.bestbuy.com");
    }

    @Test
    public void testSelectAndAddBrand() {
        // Find and click the hamburger menu icon to open the menu.
        WebElement hamburgerMenuIcon = driver.findElement(By.id("header-menu-button"));
        hamburgerMenuIcon.click();

        // Find and click the "Brands" category using XPath.
        WebElement brandsCategory = driver.findElement(By.xpath("//a[contains(text(),'Brands')]"));
        brandsCategory.click();

        // Find and click the "Microsoft" brand using XPath.
        WebElement microsoftBrand = driver.findElement(By.xpath("//a[contains(text(),'Microsoft')]"));
        microsoftBrand.click();

        // You can navigate further to select a specific product or perform other interactions.
    }

    @AfterClass
    public void tearDown() {
        // Close the WebDriver.
        driver.quit();
    }
}
