package bestbuyautomation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckoutPageAndDummyPayment {
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
    public void testNavigateToCheckoutAndFillForm() {
        // Navigate to the checkout page (hypothetical URL).
        driver.get("https://www.bestbuy.com/checkout");

        // Find and fill out form fields (hypothetical form fields).
        WebElement firstNameInput = driver.findElement(By.id("first_name"));
        WebElement lastNameInput = driver.findElement(By.id("last_name"));
        WebElement creditCardInput = driver.findElement(By.id("credit_card"));
        WebElement expirationInput = driver.findElement(By.id("expiration"));
        WebElement cvvInput = driver.findElement(By.id("cvv"));

        // Fill out the form with dummy information.
        firstNameInput.sendKeys("John");
        lastNameInput.sendKeys("Doe");
        creditCardInput.sendKeys("1234 5678 9012 3456");
        expirationInput.sendKeys("12/25");
        cvvInput.sendKeys("123");

        // Submit the form (hypothetical submit button).
        WebElement submitButton = driver.findElement(By.id("submit_button"));
        submitButton.click();

        // You can add assertions or verifications as needed.
    }

    @AfterClass
    public void tearDown() {
        // Close the WebDriver.
        driver.quit();
    }
}

