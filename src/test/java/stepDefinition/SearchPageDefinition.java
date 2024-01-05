package stepDefinition;

import Factory.DriverFactory;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.SearchResultsPage;

public class SearchPageDefinition {
WebDriver driver;
	HomePage homePage;
	SearchResultsPage searchResultsPage;
	private DriverFactory driverFactory;
	@Given("User has opened the application")
	public void user_has_opened_the_application() {
		driverFactory = new DriverFactory();
		driver = driverFactory.getDriver();
		homePage = new HomePage(driver);

	}

	@When("User has entered valid product {string} into the search box field")
	public void user_has_entered_valid_product_into_the_search_box_field(String validText) {
	    driver.findElement(By.name("search")).sendKeys(validText);
		//homePage = new HomePage(driver);
		homePage.enterValueinSearchBox(validText);
	}

	@When("User clicks on Search button")
	public void user_clicks_on_search_button() {
		searchResultsPage = homePage.clickOnSearchButton();
	    
	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
		// searchResultsPage = new SearchResultsPage(driver);

		Assert.assertTrue(searchResultsPage.verifySearchResult());
	}
	

	@When("User has entered invalid product {string} into the search box field")
	public void user_has_entered_invalid_product_into_the_search_box_field(String invalidText) {
		//homePage= new HomePage(driver);
		homePage.enterValueinSearchBox(invalidText);
	}

	@Then("User should get valid error message")
	public void user_should_get_valid_error_message() {


		Assert.assertEquals("There is no product that matches the search criteria.",searchResultsPage.verifyMessage());
	    	}


}
