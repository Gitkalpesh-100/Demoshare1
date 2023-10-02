package bestbuyautomation;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Links;

import io.cucumber.java.be.I.Is;

public class CheckBrokenLink {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		// Set up WebDriver (e.g., ChromeDriver)
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Kalpesh Patil\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void openBestBuyWebsite() throws InterruptedException {
		// Navigate to the Best Buy website
		driver.get("https://www.bestbuy.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}
	
	

    @Test
  public void testCheckBrokenLinks() throws IOException, InterruptedException {
        // Find all the links on the page.
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        
        System.out.println(allLinks.size());
        
        
        for(int i=0;i<allLinks.size();i++){
        	
        	
        	WebElement element = allLinks.get(i);
        	String url = element.getAttribute("href");
        	
        	URL link = new URL(url);
        	
        	HttpsURLConnection httpConn = (HttpsURLConnection) link.openConnection();
        	
        	Thread.sleep(3000);
        	
        	httpConn.connect();
        	
        	int respcode = httpConn.getResponseCode();
        	
        	if(respcode>=400) {
        		System.out.println(url + " -" + "is broken link");
        	}
        	
        	else {
				System.out.println(url + "-" + "is a valid link");
			}
        }
    }
 
	@AfterTest
	public void tearDown() {
		// Clean up and close the WebDriver instance
		driver.quit();
	}
}
