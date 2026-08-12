package OpenLibraryPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Base.BasePage;

public class OpenLibraryHomePage extends BasePage{
	
	private By HomePageHeading = By.cssSelector(".logo-icon");

	public OpenLibraryHomePage (WebDriver driver){
	super(driver);
	}
	public boolean isHomePageDisplayed() {
		return isDisplayed(HomePageHeading);
	}
}