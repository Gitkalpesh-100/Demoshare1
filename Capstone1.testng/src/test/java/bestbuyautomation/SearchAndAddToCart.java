package bestbuyautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchAndAddToCart {
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
	public void testSelectAndAddToyDrones() {
		// Find and click the hamburger menu icon to open the menu.
		WebElement hamburgerMenuIcon = driver.findElement(By.id("header-menu-button"));
		hamburgerMenuIcon.click();

		// Find the "Cameras, Camcorders, and Drones" category.
		WebElement dronesCategory = driver.findElement(By.linkText("Cameras, Camcorders & Drones"));

		// Scroll to the "Cameras, Camcorders, and Drones" category.
		scrollToElement(dronesCategory);

		// Click the "Cameras, Camcorders, and Drones" category to expand it.
		dronesCategory.click();

		// Find and click the "Drones" sub-category.
		WebElement dronesSubCategory = driver.findElement(By.linkText("Drones"));
		dronesSubCategory.click();

		// Find and click the "Toy Drones" sub-category.
		WebElement toyDronesSubCategory = driver.findElement(By.linkText("Toy Drones"));
		toyDronesSubCategory.click();

		// Locate and click on a specific "Toy Drones" product (you may need to modify
		// this selector).
		WebElement toyDroneProduct = driver.findElement(By.linkText("Your Toy Drone Product"));
		toyDroneProduct.click();

		// Add the product to the cart (you may need to modify this selector).
		WebElement addToCartButton = driver.findElement(By.cssSelector(".btn-primary.add-to-cart-button"));
		addToCartButton.click();

		// You can add additional validations or interactions as needed.
	}

	@AfterClass
	public void tearDown() {
		// Close the WebDriver.
		driver.quit();
	}

	// Helper method to scroll to an element using JavaScript.
	private void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
}
