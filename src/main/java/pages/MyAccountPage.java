package pages;

import Utils.CommonUtils;
import Utils.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    WebDriver driver;
    ElementUtils elementUtils;
    public MyAccountPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        elementUtils = new ElementUtils(driver);
    }

    @FindBy(linkText = "Edit your account information")
    private WebElement editYourAccountInformationLabel;

    public boolean checkEditYourAccountInfoLabelDisplayed()
    {

        return elementUtils.verifyElementIsDisplayed(editYourAccountInformationLabel, CommonUtils.EXPLICIT_WAIT_TIME);
    }
}
