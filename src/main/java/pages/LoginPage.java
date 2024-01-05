package pages;

import Utils.CommonUtils;
import Utils.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    ElementUtils elementUtils;
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        elementUtils = new ElementUtils(driver);
    }


    @FindBy(name="email")
    private WebElement emailField;

    @FindBy(name="password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;

    @FindBy (xpath = "//div[contains(@class,'alert alert-danger alert-dismissible')]")
    private WebElement warningMessage;
    public void enterEmailAddress(String email)
    {

        elementUtils.enterText(emailField,email, CommonUtils.EXPLICIT_WAIT_TIME);
    }

    public void enterPassword(String password)
    {

       elementUtils.enterText(passwordField,password,CommonUtils.EXPLICIT_WAIT_TIME);
    }

    public MyAccountPage clickOnLoginButton()
    {

        elementUtils.clickOnElement(loginButton,CommonUtils.EXPLICIT_WAIT_TIME);
        return new MyAccountPage(driver);
    }

    public String getWarningMessage()
    {

        return elementUtils.getElementText(warningMessage,CommonUtils.EXPLICIT_WAIT_TIME);
    }
}
