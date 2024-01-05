package Utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementUtils {

    WebDriver driver;
    public ElementUtils(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElement(WebElement ele, long durationInSeconds)
    {
        WebElement webElement= null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
             webElement = wait.until(ExpectedConditions.elementToBeClickable(ele));

        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }
        return webElement;
    }
    public void clickOnElement(WebElement ele, long durationInSeconds)
    {

        WebElement webElement = waitForElement(ele,durationInSeconds);
        webElement.click();
    }

    public void enterText(WebElement ele, String input, long durationInSeconds)
    {
        WebElement webElement = waitForElement(ele,durationInSeconds);
        webElement.clear();
        webElement.sendKeys(input);
    }

    public void selectOptionFromDropDown(WebElement ele, String option, long durationInSeconds)
    {
        WebElement webElement = waitForElement(ele,durationInSeconds);
        Select select = new Select(ele);
        select.selectByVisibleText(option);
    }

    public void acceptAlert(WebElement ele, long durationInSeconds)
    {
        Alert alert= waitForAlert(durationInSeconds);
        alert.accept();

    }
    public Alert waitForAlert(long durationInSeconds)
    {

        Alert alert =null;
           try
           {
               WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
                alert = webDriverWait.until(ExpectedConditions.alertIsPresent());
           }
           catch(Throwable e)
           {
               e.printStackTrace();
           }
            return alert;

    }

    public void mouseHoverAndClick(WebElement ele)
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(ele).click().build();

    }

    public String getElementText(WebElement ele, long durationInSeconds)
    {
        waitForElementTobeVisible(ele,durationInSeconds);
        return ele.getText();
    }

    public boolean verifyElementIsDisplayed(WebElement ele, long durationInSeconds)
    {
        waitForElementTobeVisible(ele,durationInSeconds);
        return ele.isDisplayed();
    }

    public void waitForElementTobeVisible(WebElement ele, long durationInSeconds)
    {
        try
        {
            WebDriverWait webDriverWait =  new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
            webDriverWait.until(ExpectedConditions.visibilityOf(ele));
        }
        catch(Throwable e)
        {
            e.printStackTrace();
        }

    }
}
