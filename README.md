# Open Library Selenium Automation Project

This project automates book-search functionality on the real
[Open Library](https://openlibrary.org/) website using Selenium WebDriver.

## Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model
- ChromeDriver
- Git and GitHub

## Test Scenarios

### Positive Test: Verify Harry Potter Book Details

1. Open the Open Library homepage.
2. Verify that the homepage loads.
3. Search for `Harry Potter and the Sorcerer's Stone`.
4. Submit the search.
5. Verify that search results appear.
6. Verify that at least one book result exists.
7. Locate the correct book result.
8. Capture the title and author from the results page.
9. Verify the title is `Harry Potter and the Sorcerer's Stone`.
10. Verify the author contains `J. K. Rowling`.
11. Open the book-details page.
12. Capture the details-page title, author, and description.
13. Compare the details-page title with the search-results title.
14. Verify that the details-page author contains `J. K. Rowling`.
15. Verify that the description is not empty.

### Negative Test: Invalid Book Search

1. Search for a nonexistent book title.
2. Submit the search.
3. Verify that no book-result cards appear.

## Framework Structure

- `BasePage` provides reusable Selenium methods and explicit waits.
- `BaseTest` manages WebDriver setup and cleanup.
- `OpenLibraryHomePage` represents the homepage.
- `SearchBookPage` handles the search modal and Shadow DOM.
- `SearchResultPage` handles result verification and book selection.
- `BookDetailsPage` captures book details.
- `OpenLibraryTest` contains the positive and negative TestNG tests.

## Skills Demonstrated

- Page Object Model design
- Selenium locators using CSS selectors and XPath
- Explicit waits
- Shadow DOM interaction
- JavaScript click handling
- Positive and negative testing
- TestNG assertions
- Maven dependency management
- Git version control

## Test Evidence

Test screenshots are available in:

```text
resources/screenshots
