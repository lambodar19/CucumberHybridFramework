package stepDefinition;

import Factory.DriverFactory;
import Utils.CommonUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterAccountPage;

import java.util.Map;

public class RegisterPageDefinition {
WebDriver driver;
private HomePage homePage;

private RegisterAccountPage registerAccountPage;
private AccountSuccessPage accountSuccessPage;
private CommonUtils commonUtils;
	private DriverFactory driverFactory;
	@Given("User has navigated to Register Account Page")
	public void user_has_navigated_to_register_account_page() {
		driverFactory= new DriverFactory();
		driver = driverFactory.getDriver();
		homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		registerAccountPage= homePage.clickOnRegister();
		commonUtils = new CommonUtils();

	}

	@When("User enters the below details in below fields")
	public void user_enters_the_below_details_in_below_fields(DataTable dataTable) {
	   Map<String, String> dataMap=  dataTable.asMap(String.class,String.class);
	   //commonUtils = new CommonUtils();
	  //registerAccountPage = new RegisterAccountPage(driver);
	  registerAccountPage.enterFirstName(dataMap.get("firstname"));
	  registerAccountPage.enterLastName(dataMap.get("lastname"));
	  registerAccountPage.enterEmail(commonUtils.generateRandomEmail());
	  registerAccountPage.enterTelephone(dataMap.get("telephone"));
	  registerAccountPage.enterPassword(dataMap.get("password"));
	  registerAccountPage.confirmPassword(dataMap.get("passwordConfirmation"));


	}

	@When("User selects Privacy Policy")
	public void user_selects_privacy_policy() {
	   registerAccountPage.agreePrivacyPolicy();
	}

	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		 accountSuccessPage = registerAccountPage.clickOnContinueButton();
	}

	@Then("User account should be created successfully")
	public void user_account_should_be_created_successfully() {

	   Assert.assertEquals("Your Account Has Been Created!",accountSuccessPage.checkAccountCreateSuccessMessage());
	}

	@When("User enters the below details in below fields with duplicate email")
	public void user_enters_the_below_details_in_below_fields_with_duplicate_email(DataTable dataTable) {
		Map<String, String> dataMap=  dataTable.asMap(String.class,String.class);

		registerAccountPage.enterFirstName(dataMap.get("firstname"));
		registerAccountPage.enterLastName(dataMap.get("lastname"));
		registerAccountPage.enterEmail(dataMap.get("email"));
		registerAccountPage.enterTelephone(dataMap.get("telephone"));
		registerAccountPage.enterPassword(dataMap.get("password"));
		registerAccountPage.confirmPassword(dataMap.get("passwordConfirmation"));

	}

	@Then("User receives error message")
	public void user_receives_error_message() {
	   Assert.assertEquals("Warning: E-Mail Address is already registered!",registerAccountPage.getWarningMessageText());
	}


	@When("User enters firstname {string}")
	public void userEntersFirstnameFirstName(String firstName) {
		registerAccountPage.enterFirstName(firstName);

	}

	@And("User enters lastname {string}")
	public void userEntersLastnameLastName(String lastName) {
		registerAccountPage.enterLastName(lastName);
	}

	@And("User enters unique email address")
	public void userEntersUniqueEmailAddress() {
		//commonUtils = new CommonUtils();
		registerAccountPage.enterEmail(commonUtils.generateRandomEmail());
	}

	@And("User enters telephone {string}")
	public void userEntersTelephoneTelephone(String num) {
		registerAccountPage.enterTelephone(num);
	}

	@And("User enters password {string}")
	public void userEntersPasswordPassword(String password) {
		registerAccountPage.enterPassword(password);
	}

	@And("User enters confirm password {string}")
	public void userEntersConfirmPasswordConfirmationPassword(String confirmPassword) {
		registerAccountPage.confirmPassword(confirmPassword);
	}
}
