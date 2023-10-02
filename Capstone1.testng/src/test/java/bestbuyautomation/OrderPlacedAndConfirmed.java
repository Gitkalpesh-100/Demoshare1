package bestbuyautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrderPlacedAndConfirmed {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the system property to the location of your ChromeDriver executable.
        System.setProperty("webdriver.chrome.driver",
"C:\\Users\\Kalpesh Patil\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Create a WebDriver instance (in this case, for Chrome).
        driver = new ChromeDriver();

        // Navigate to the Best Buy website or the order confirmation page.
        // You should replace this URL with the actual URL of the order confirmation page.
        driver.get("https://www.bestbuy.com/order-confirmation-page"); // Replace with the actual URL.
    }

    @Test
    public void testOrderConfirmationMessage() {
        // Find the element containing the order confirmation message.
        WebElement confirmationMessage = driver.findElement(By.xpath("//div[contains(text(),'Your order has been successfully placed.')]"));

        // Check if the confirmation message is displayed (positive case).
        if (confirmationMessage.isDisplayed()) {
            System.out.println("Order confirmation message is displayed (Positive case).");
            // Positive case: The order confirmation message is displayed.
        } else {
            System.out.println("Order confirmation message is not displayed (Negative case).");
            // Negative case: The order confirmation message is not displayed.
        }

        // Assert that the confirmation message is displayed (positive case) with a custom message.
        Assert.assertTrue(confirmationMessage.isDisplayed(), "Order confirmation message is displayed."
        		+ "                                           This indicates that the order was placed successfully.");

        // You can also add a negative assertion to check if the message is not displayed (negative case).
        // Assert that the confirmation message is NOT displayed (negative case) with a custom message.
        Assert.assertFalse(!confirmationMessage.isDisplayed(), "Order confirmation message is displayed."
        		+ "                                  This indicates an issue with the order placement. (Negative case)");
    }

    @AfterClass
    public void tearDown() {
        // Close the WebDriver.
        driver.quit();
    }
}
