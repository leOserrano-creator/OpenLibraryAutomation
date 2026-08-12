package OpenLibrary;

import org.testng.Assert;
import org.testng.annotations.Test;

import OpenLibraryPages.BookDetailsPage;
import OpenLibraryPages.OpenLibraryHomePage;
import OpenLibraryPages.SearchBookPage;
import OpenLibraryPages.SearchResultPage;

public class OpenLibraryTest extends BaseTest{
	
	@Test
	public void verifyHarryPotterBookTest() {
		//step 1-2
		OpenLibraryHomePage homePage = new OpenLibraryHomePage(driver);
		Assert.assertTrue(homePage.isHomePageDisplayed(), "Open Library did not load");
		//step 3
		SearchBookPage searchBookPage = new SearchBookPage(driver);
			//		  /
		searchBookPage.enterBookName("Harry Potter and the Sorcerer's Stone");
		//step 4
		SearchResultPage resultPage = searchBookPage.clickButton();
		// step 5
		Assert.assertTrue(resultPage.isResultPageDisplayed(), "Result count did not load");
		Assert.assertTrue(resultPage.isAtLeastOneBookDisplayed(), "No result books appeared");
		String resultsPageTitle = resultPage.getBookTitle();
		String resultsPageAuthor = resultPage.getBookAuthor();
		Assert.assertEquals(resultsPageTitle,
			    "Harry Potter and the Sorcerer's Stone",
			    "Incorrect book title");
		Assert.assertTrue(resultsPageAuthor.contains("J. K. Rowling"),
			    "Incorrect book author"
			);
		BookDetailsPage detailsPage = resultPage.clickBookTitle();
		Assert.assertTrue(detailsPage.isBookDetailsPageDisplayed(), 
				"Book detailsPage does did not load");
		String detailsPageTitle = detailsPage.getBookDetailTitle();
		String detailsPageAuthor = detailsPage.getBookDetailAuthor();
		String detailsPageDescription =
		        detailsPage.getBookDescription();
		Assert.assertEquals(
			    detailsPageTitle,
			    resultsPageTitle,
			    "Details-page title does not match the results-page title");
			Assert.assertTrue(
			    detailsPageAuthor.contains("J. K. Rowling"),
			    "Details-page author is incorrect");
			Assert.assertFalse(
			    detailsPageDescription.trim().isEmpty(),
			    "Book description is empty");
	}
	
	@Test
	public void verifyNoResultsForInvalidBookTest() {
	    OpenLibraryHomePage homePage =
	            new OpenLibraryHomePage(driver);
	    Assert.assertTrue(homePage.isHomePageDisplayed(),
	        "Open Library did not load");
	    SearchBookPage searchBookPage = new SearchBookPage(driver);
	    searchBookPage.enterBookName(
	        "zzzzNonexistentBook987654321");
	    SearchResultPage resultPage = searchBookPage.clickButton();
	    Assert.assertFalse(resultPage.isAtLeastOneBookDisplayed(),
	        "Unexpected books appeared for an invalid search");
	}
}
