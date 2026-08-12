package OpenLibraryPages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import Base.BasePage;
	
public class BookDetailsPage extends BasePage {
	public BookDetailsPage(WebDriver driver) {
	super(driver);
	}
	
	private By bookDetailTitle = By.cssSelector("div.work-title-and-author.desktop h1.work-title");
	private By bookDetailAuthor = By.cssSelector("div.work-title-and-author.desktop h2.edition-byline");
	private By bookDescription = By.cssSelector("ol-read-more.book-description > p");
	
	public boolean isBookDetailsPageDisplayed() {
		return isDisplayed(bookDetailTitle);
	}
	
	public String getBookDetailTitle() {
		return find(bookDetailTitle).getText();
	}
	public String getBookDetailAuthor() {
		return find(bookDetailAuthor).getText();
	}
	public String getBookDescription() {
	    return find(bookDescription).getText();
	}

}
