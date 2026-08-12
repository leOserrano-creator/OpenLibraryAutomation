package OpenLibraryPages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import Base.BasePage;

public class SearchBookPage extends BasePage{
	public SearchBookPage(WebDriver driver) {
	super(driver);
	}
	
		private By searchField = By.cssSelector("input.search-input");
		private By searchButton = By.cssSelector("button.search-bar-trigger");
	    private By searchModal =
		            By.cssSelector("ol-search-modal");
	    private By seeResultsButton =
	            By.cssSelector("ol-button[variant='primary'] button");


	    public void enterBookName(String bookName) {
	        click(searchButton);

	        SearchContext shadowRoot =
	        		driver.findElement(searchModal).getShadowRoot();
	        shadowRoot.findElement(searchField).sendKeys(bookName);
	    }
	    public SearchResultPage clickButton() {
	        SearchContext shadowRoot =
	        		driver.findElement(searchModal).getShadowRoot();
	        shadowRoot.findElement(seeResultsButton).click();

	        return new SearchResultPage(driver);
	    }
}