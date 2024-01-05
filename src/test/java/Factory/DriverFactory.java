package Factory;

import Utils.CommonUtils;
import Utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Properties;

public class DriverFactory {

    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    private ConfigReader configReader;


    public WebDriver initializeBrowser(String browserName) {
        configReader = new ConfigReader();
        Properties prop = configReader.loadProperties();

        if (browserName.equalsIgnoreCase("chrome")) {
            threadLocalDriver.set(new ChromeDriver());
        } else if (browserName.equalsIgnoreCase("firefox")) {
            threadLocalDriver.set(new FirefoxDriver());
        }



        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));

        return getDriver();
    }

    public WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    public void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            threadLocalDriver.remove();
        }
    }
}
