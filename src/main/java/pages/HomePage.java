package pages;

import Utils.CommonUtils;
import Utils.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	 WebDriver driver;
	 private ElementUtils elementUtils;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUtils = new ElementUtils(driver);
	}
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccount;

	@FindBy(linkText = "Login")
	private WebElement loginLink;

	@FindBy(linkText = "Register")
	private WebElement registerUserLink;

	@FindBy (name="search")
	private WebElement searchBox;

	@FindBy(xpath = "//button[contains(@class,'btn btn-default btn-lg')]")
	private WebElement searchButton;
	public void clickOnMyAccount()
	{

		elementUtils.clickOnElement(myAccount, CommonUtils.EXPLICIT_WAIT_TIME);
	}

	public LoginPage clickOnLogin()
	{
		//loginLink.click();
		elementUtils.clickOnElement(loginLink,CommonUtils.EXPLICIT_WAIT_TIME);
		return new LoginPage(driver);
	}

	public RegisterAccountPage clickOnRegister()
	{
		//registerUserLink.click();
		elementUtils.clickOnElement(registerUserLink,CommonUtils.EXPLICIT_WAIT_TIME);
		return new RegisterAccountPage(driver);
	}

	public void enterValueinSearchBox(String product)
	{
		//searchBox.clear();
		elementUtils.enterText(searchBox,product,CommonUtils.EXPLICIT_WAIT_TIME);
		//searchBox.sendKeys(product);
	}

	public SearchResultsPage clickOnSearchButton()
	{
		//searchButton.click();
		elementUtils.clickOnElement(searchButton,CommonUtils.EXPLICIT_WAIT_TIME);
		return new SearchResultsPage(driver);
	}

}
