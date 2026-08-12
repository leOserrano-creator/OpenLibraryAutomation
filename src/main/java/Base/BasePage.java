package Base;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	
	protected WebDriver driver;
	private WebDriverWait  wait;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	//Find Locator
	protected WebElement find(By locator) {
		return wait.until(// Waits until the element is visible before returning it
	            ExpectedConditions.visibilityOfElementLocated(locator));
	}
	//Return Data 
	protected void type(String text, By locator) {
		find(locator).clear();
		find(locator).sendKeys(text);
	}
	//click element
	protected void click(By locator) {
		find(locator).click();
	}
	//See if displayed 
	 protected boolean isDisplayed(By locator) {
	        try {
	            return find(locator).isDisplayed();
	        } catch (NoSuchElementException e) {
	            return false;
	        }
	    }
	}