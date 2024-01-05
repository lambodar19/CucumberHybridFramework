package pages;

import Utils.CommonUtils;
import Utils.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
    WebDriver driver;
    ElementUtils elementUtils;


   public SearchResultsPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        elementUtils= new ElementUtils(driver);
    }

    @FindBy(linkText = "HP LP3065")
    private WebElement validProduct;

   @FindBy(xpath = "//input[@id='button-search']//following-sibling::p")
   private WebElement invalidProductMessage;
   public boolean verifySearchResult()
   {

       return elementUtils.verifyElementIsDisplayed(validProduct,CommonUtils.EXPLICIT_WAIT_TIME);
   }

   public String verifyMessage()
   {

       return elementUtils.getElementText(invalidProductMessage, CommonUtils.EXPLICIT_WAIT_TIME);

   }

}
