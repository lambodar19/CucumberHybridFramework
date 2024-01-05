package pages;

import Utils.CommonUtils;
import Utils.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {
    WebDriver driver;
    ElementUtils elementUtils;
    public AccountSuccessPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        elementUtils = new ElementUtils(driver);
    }

    @FindBy(xpath = "//div[@id='content']//h1")
    private WebElement successMessage;


    public String checkAccountCreateSuccessMessage()
    {
        //return successMessage.getText();
        return elementUtils.getElementText(successMessage, CommonUtils.EXPLICIT_WAIT_TIME);
    }
}
