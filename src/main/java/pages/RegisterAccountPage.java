package pages;

import Utils.CommonUtils;
import Utils.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.lang.model.element.Element;

public class RegisterAccountPage {
    WebDriver driver;
    ElementUtils elementUtils;
    public RegisterAccountPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        elementUtils = new ElementUtils(driver);

    }

    @FindBy(id="input-firstname")
    private WebElement firstNameField;

    @FindBy(id="input-lastname")
    private WebElement lastNameField;

    @FindBy(id="input-email")
    private WebElement emailField;

    @FindBy(id="input-telephone")
    private WebElement telephoneField;

    @FindBy(id="input-password")
    private WebElement passwordField;

    @FindBy(id="input-confirm")
    private WebElement confirmPasswordField;

    @FindBy(name = "agree")
    private WebElement privacyPolicy;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//div[contains(@class,'alert alert-danger alert-dismissible')]")
    private WebElement warningMessage;
    public void enterFirstName(String fName)
    {

        elementUtils.enterText(firstNameField,fName, CommonUtils.EXPLICIT_WAIT_TIME);
    }

    public void enterLastName(String lName)
    {

        elementUtils.enterText(lastNameField,lName,CommonUtils.EXPLICIT_WAIT_TIME);
    }

    public void enterEmail(String email)
    {

        elementUtils.enterText(emailField,email,CommonUtils.EXPLICIT_WAIT_TIME);

    }

    public void enterTelephone(String tel)
    {

        elementUtils.enterText(telephoneField,tel,CommonUtils.EXPLICIT_WAIT_TIME);
    }


    public void enterPassword(String pwd)
    {

        elementUtils.enterText(passwordField,pwd,CommonUtils.EXPLICIT_WAIT_TIME);
    }

    public void confirmPassword(String pwd)
    {

        elementUtils.enterText(confirmPasswordField,pwd,CommonUtils.EXPLICIT_WAIT_TIME);
    }

    public void agreePrivacyPolicy()
    {

        elementUtils.clickOnElement(privacyPolicy,CommonUtils.EXPLICIT_WAIT_TIME);
    }

    public AccountSuccessPage clickOnContinueButton()
    {

        elementUtils.clickOnElement(continueButton,CommonUtils.EXPLICIT_WAIT_TIME);
        return new AccountSuccessPage(driver);
    }

    public String getWarningMessageText()
    {

        return elementUtils.getElementText(warningMessage,CommonUtils.EXPLICIT_WAIT_TIME);
    }

}
