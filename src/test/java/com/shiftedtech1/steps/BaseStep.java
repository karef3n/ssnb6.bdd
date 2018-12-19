package com.shiftedtech1.steps;
import com.shiftedtech.framework.DriverFactory;
import com.shiftedtech.framework.PropertyReaderService;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static java.util.concurrent.TimeUnit.SECONDS;

public class BaseStep {

    protected static WebDriver driver = DriverFactory.getInstance(PropertyReaderService.getInstance().getProperty("BROWSER")).getDriver();

}
