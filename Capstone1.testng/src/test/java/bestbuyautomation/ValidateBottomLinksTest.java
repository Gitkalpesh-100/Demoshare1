package bestbuyautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ValidateBottomLinksTest {
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
    public void testAccessibilityLink() {
        // Scroll to the bottom of the page to ensure the footer links are visible.
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // Find the "Accessibility" link by its XPath.
        WebElement accessibilityLink = driver.findElement(By.xpath("//a[contains(text(),'Accessibility')]"));

        // Validate that the link is displayed.
        if (accessibilityLink.isDisplayed()) {
            System.out.println("Accessibility link is displayed.");
        } else {
            System.out.println("Accessibility link is not displayed.");
        }

        // Positive Assertion: The link should be displayed.
        Assert.assertTrue(accessibilityLink.isDisplayed(), "Accessibility link is not displayed.");

        // Click the "Accessibility" link.
        accessibilityLink.click();

        // Validate the title of the "Accessibility" page.
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Accessibility"), "Page title does not contain 'Accessibility'.");

        // You can add additional validations for the content of the "Accessibility" page if needed.
    }

    @AfterClass
    public void tearDown() {
        // Close the WebDriver.
        driver.quit();
    }
}
