package bestbuyautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NavigateMenuAndValidateTitle {
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
    public void testTopDeals() {
        navigateAndValidateTitle("Top Deals");
    }

    @Test
    public void testDealOfDay() {
        navigateAndValidateTitle("Deal of the Day");
    }

    @Test
    public void testMyBestBuyMemberships() {
        navigateAndValidateTitle("My Best Buy Memberships");
    }

    @Test
    public void testCreditCards() {
        navigateAndValidateTitle("Credit cards");
    }

    @Test
    public void testRecentlyViewed() {
        navigateAndValidateTitle("Recently viewed");
    }

    @Test
    public void testOrderStatus() {
        navigateAndValidateTitle("Order status");
    }

    @Test
    public void testSavedItems() {
        navigateAndValidateTitle("Saved items");
    }

    @Test
    public void testHiUsername() {
        navigateAndValidateTitle("Hi Username");
    }

    @Test
    public void testMore() {
        navigateAndValidateTitle("More");
    }

    private void navigateAndValidateTitle(String menuText) {
        WebElement menuLink = driver.findElement(By.linkText(menuText));
        menuLink.click();

        // Validate the title of the page.
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains(menuText), "Page title does not contain expected text: " + menuText);
    }

    @AfterClass
    public void tearDown() {
        // Close the WebDriver.
        driver.quit();
    }
}
