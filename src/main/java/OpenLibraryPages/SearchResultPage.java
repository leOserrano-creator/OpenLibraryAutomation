package OpenLibraryPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import Base.BasePage;

public class SearchResultPage extends BasePage {
	
	private By resultCount = By.xpath("//div[@class='search-results-stats']");
	private By bookResults = By.xpath("//li[contains(@class,'searchResultItem')]");
	private By bookTitle = By.cssSelector("li.searchResultItem:first-of-type a.results");
	private By bookAuthor = By.cssSelector("li.searchResultItem:first-of-type span.bookauthor");
	
	
	public SearchResultPage(WebDriver driver) {
	super(driver);
	}
	
	public boolean isResultPageDisplayed() {
		return isDisplayed(resultCount);
	}
	public boolean isAtLeastOneBookDisplayed() {
		int numberOfBooks = driver.findElements(bookResults).size();
		return numberOfBooks > 0;
	}
	public String getBookTitle() {
		return find(bookTitle).getText();
	}
	public String getBookAuthor() {
		return find(bookAuthor).getText();
	}
	public BookDetailsPage clickBookTitle() {
	    WebElement title = find(bookTitle);

	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript(
	        "arguments[0].scrollIntoView({block: 'center'});",
	        title);
	    js.executeScript("arguments[0].click();", title);
	    return new BookDetailsPage(driver);
	}
	

}
