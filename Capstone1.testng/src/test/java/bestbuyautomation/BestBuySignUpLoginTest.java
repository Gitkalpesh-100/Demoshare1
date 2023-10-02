package bestbuyautomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BestBuySignUpLoginTest {
	private WebDriver driver;
	private WebDriverWait wait;

	@BeforeMethod
	public void setUp() {
		// Set up WebDriver (e.g., ChromeDriver)
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Kalpesh Patil\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// to launch the website
		driver.get("https://www.bestbuy.com");
	}

	@Test(priority = 1)
	public void signUpTest() {
		// Navigate to the Best Buy website
		//driver.get("https://www.bestbuy.com");
		WebElement US = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[@class='country-selection']//h4[text()='United States']/..)[1]")));
		US.click();
		// Click on the "Account" button to open the sign-up and login options
		WebElement accountButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Account']")));
		accountButton.click();

		// Click on "Create Account" to sign up
		WebElement createAccountButton = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//a[@class='c-button c-button-outline c-button-sm create-account-btn']")));
		createAccountButton.click();

		// Fill in the sign-up form
		WebElement firstNameField = driver.findElement(By.id("firstName"));
		WebElement lastNameField = driver.findElement(By.id("lastName"));
		WebElement emailField = driver.findElement(By.id("fld-e"));
		WebElement passwordField = driver.findElement(By.id("fld-p1"));
		WebElement createAccountSubmitButton = driver.findElement(By.xpath("//button[text()='Create Account']"));

		firstNameField.sendKeys("First");
		lastNameField.sendKeys("Last");
		emailField.sendKeys("kalpeshpatil028@gmail.com");
		passwordField.sendKeys("Kalpesh@1");
		createAccountSubmitButton.click();

		// You may need to handle CAPTCHA, email verification, etc., in a real scenario.
	}

	@Test(priority = 2)
	public void loginTest() {
		// Navigate to the Best Buy website
		driver.get("https://www.bestbuy.com");

		// Click on "Sign In" to log in
		WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign In")));
		signInButton.click();

		// Fill in the login form
		WebElement signInEmailField = wait.until(ExpectedConditions.elementToBeClickable(By.id("fld-e")));
		WebElement signInPasswordField = driver.findElement(By.id("fld-p1"));
		WebElement signInSubmitButton = driver.findElement(By.xpath("//button[text()='Sign In']"));

		signInEmailField.sendKeys("kalpespatil028@gmail.com");
		signInPasswordField.sendKeys("Kalpesh@1");
		signInSubmitButton.click();

		// You can add assertions or further navigation steps after login.
	}

	@AfterClass
	public void tearDown() {
		// Close the browser window
		driver.quit();
	}
}
