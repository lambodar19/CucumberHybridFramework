package stepDefinition;

import Factory.DriverFactory;
import Utils.CommonUtils;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

public class LoginPageStepDefinition {

	WebDriver driver;
	private LoginPage loginPage;
	private MyAccountPage myAccountPage;

	private CommonUtils commonUtils;
	private DriverFactory driverFactory;

	/*	public LoginPageStepDefinition(WebDriver driver) {
            this.driver = driver;
            loginPage = new LoginPage(driver);
        }*/
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		driverFactory = new DriverFactory();
		driver = driverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		loginPage = homePage.clickOnLogin();

		//loginPage = new LoginPage(driver);
	}

	@When("User enters valid email address {string} into email field")
	public void user_enters_valid_email_address_into_email_field(String email) {

		//loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(email);
	}

	@And("User enters valid password {string} into password field")
	public void user_enters_valid_password_into_password_field(String password) {
		//loginPage = new LoginPage(driver);
		loginPage.enterPassword(password);
	}

	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {
		//loginPage = new LoginPage(driver);
		myAccountPage = loginPage.clickOnLoginButton();
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		//myAccountPage = new MyAccountPage(driver);
		Assert.assertTrue(myAccountPage.checkEditYourAccountInfoLabelDisplayed());
	}

	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
		//LoginPage loginPage = new LoginPage(driver);
		commonUtils = new CommonUtils();
		loginPage.enterEmailAddress(commonUtils.generateRandomEmail());
	}

	@And("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidPassword) {
		//LoginPage loginPage = new LoginPage(driver);
		loginPage.enterPassword(invalidPassword);
	}

	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
		Assert.assertTrue(loginPage.getWarningMessage().contains("Warning: No match for E-Mail Address and/or Password."));

	}

	@When("User does not enter email address into email field")
	public void user_does_not_enter_email_address_into_email_field() {

	}

	@And("User does not enter password into password field")
	public void user_does_not_enter_password_into_password_field() {

	}





}
