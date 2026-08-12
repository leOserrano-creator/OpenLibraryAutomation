package OpenLibrary;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {

	protected WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://openlibrary.org/search");
	}
	@AfterMethod
	public void cleanUp(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			File screenshot = ((ChromeDriver) driver).getScreenshotAs(OutputType.FILE);
	        try {
	            FileHandler.copy(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}
	        driver.quit();
	    }
	}