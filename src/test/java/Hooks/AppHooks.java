package Hooks;

import Factory.DriverFactory;
import Utils.ConfigReader;
import io.cucumber.datatable.internal.difflib.Delta;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class AppHooks {
WebDriver driver;
private ConfigReader configReader;
    DriverFactory driverFactory;
    @Before
    public void setup()
    {
        ConfigReader configReader= new ConfigReader();
        Properties prop = configReader.loadProperties();
        driverFactory = new DriverFactory();
        driver = driverFactory.initializeBrowser(prop.getProperty("browser"));
        driver.get(prop.getProperty("url"));
    }

    @After
    public void teardown(Scenario scenario)
    {

        String scenarioName= scenario.getName().replaceAll("","_");
        if(scenario.isFailed())
        {
            byte[] src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(src,"image/png",scenarioName);
        }
        driver.quit();
    }
}
