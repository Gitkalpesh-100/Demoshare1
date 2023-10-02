package bestbuyautomation;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BestBuyTest {
	WebDriver driver;
	WebDriverWait wait;

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
	@Test
	public void openBestBuyWebsite() throws InterruptedException {
		// Navigate to the Best Buy website
		//driver.get("https://www.bestbuy.com");
		driver.manage().window().maximize();
		//WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='us-link']//img[1][@alt='United States']")));
		//WebElement US = wait.until(ExpectedConditions.elementToBeClickable(	By.xpath("(//div[@class='country-selection']//h4[text()='United States']/..)[1]")));
		WebElement US = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@class='us-link']//img[1][@alt='United States']")));
		
		US.click();
		Thread.sleep(5000);
	}

	// Question 2 - Check Broken Links
	@Test
	public void testCheckBrokenLinks() throws IOException, InterruptedException {
		// Find all the links on the page.
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		System.out.println(allLinks);
		System.out.println(allLinks.size());

		for (int i = 0; i < allLinks.size(); i++) {

			WebElement element = allLinks.get(i);
			String url = element.getAttribute("href");

			URL link = new URL(url);
			
			HttpsURLConnection httpConn = (HttpsURLConnection) link.openConnection();
			Thread.sleep(3000);
			httpConn.connect();
			int respcode = httpConn.getResponseCode();

			if (respcode >= 400) {
				System.out.println(url + " -" + "is broken link");
			}

			else {
				System.out.println(url + "-" + "is a valid link");
			}
		}
	}

	// Question 3 - SignUp and Login functionality
	@Test(priority = 1)
	public void signUpTest() {
		// Navigate to the Best Buy website
		driver.get("https://www.bestbuy.com");
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
		WebElement emailField = driver.findElement(By.id("email"));
		WebElement passwordField = driver.findElement(By.id("fld-p1"));
		WebElement confirmpasswordField = driver.findElement(By.id("reenterPassword"));
		WebElement mobilephonenumberField = driver.findElement(By.id("phone"));
		WebElement createanAccountSubmitButton = driver.findElement(By.xpath("//button[text()='Create Account']"));

		firstNameField.sendKeys("Kalpesh");
		lastNameField.sendKeys("Patil");
		emailField.sendKeys("kalpeshpatil028@gmail.com");
		passwordField.sendKeys("Kalpesh@1");
		confirmpasswordField.sendKeys("Kalpesh@1");
		mobilephonenumberField.sendKeys("1232319889");
		createanAccountSubmitButton.click();

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

	// Question 4 - Write a code for navigation of all Menu and validation of title
	// in each page.

	@Test
	public void testTopDeals() {
		driver.navigate().to("Top Deals");
		navigateAndValidateTitle("Top Deals");
	}

	@Test
	public void testDealOfDay() {
		driver.navigate().to("Deal of the Day");
		navigateAndValidateTitle("Deal of the Day");
	}

	@Test
	public void testMyBestBuyMemberships() {
		driver.navigate().to("My Best Buy Memberships");
		navigateAndValidateTitle("My Best Buy Memberships");
	}

	@Test
	public void testCreditCards() {
		driver.navigate().to("Credit cards");
		navigateAndValidateTitle("Credit cards");
	}

	@Test
	public void testRecentlyViewed() {
		driver.navigate().to("Recently viewed");
		navigateAndValidateTitle("Recently viewed");
	}

	@Test
	public void testOrderStatus() {
		driver.navigate().to("Order status");
		navigateAndValidateTitle("Order status");
	}

	@Test
	public void testSavedItems() {
		driver.navigate().to("Saved items");
		navigateAndValidateTitle("Saved items");
	}

	@Test
	public void testHiUsername() {
		driver.navigate().to("Hi User");
		navigateAndValidateTitle("Hi User");
	}

	@Test
	public void testMore() {
		driver.navigate().to("More");
		navigateAndValidateTitle("More");
	}

	private void navigateAndValidateTitle(String menuText) {
		WebElement menuLink = driver.findElement(By.linkText(menuText));
		menuLink.click();

		// Validate the title of the page.
		String pageTitle = driver.getTitle();
		Assert.assertTrue(pageTitle.contains(menuText), "Page title contains expected text: " + menuText);
	}

	@AfterTest
	public void tearDown() {
		// Clean up and close the WebDriver instance
		driver.quit();
	}
}
