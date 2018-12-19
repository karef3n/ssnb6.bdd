package com.shiftedtech.framework;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class DriverFactory {

    private ThreadLocal<WebDriver> driverCollection = new ThreadLocal<WebDriver>();
    private static String LOCAL_GRID_URL = "http://192.168.0.4:4455/wd/hub";
    public static  final String CLOUD_USERNAME = "sumonarefin1";
    public static final String CLOUD_AUTOMATE_KEY = "pg2p7AxYNvpGzs78fdnW";
    public static final String CLOUD_URL = "https://" + CLOUD_USERNAME + ":" + CLOUD_AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    private static DriverFactory instance = null;

    private DriverFactory() {
    }
        public static DriverFactory getInstance(){
        return getInstance(null);
    }
      public static  DriverFactory getInstance(String browser) {
          if (instance == null) {
              instance = new DriverFactory();
          }
          if (browser == null) {
              browser = "";
          }

         if (instance.driverCollection.get() == null)
             if (browser.toUpperCase().contentEquals("CLOUD-CH")){

              DesiredCapabilities caps = new DesiredCapabilities();
              caps.setCapability("browser", "Chrome");
              caps.setCapability("browser_version", "54.0");
              caps.setCapability("os", "Windows");
              caps.setCapability("os_version", "8.1");
              caps.setCapability("resolution", "1440x900");
              try {
                  WebDriver driver = new RemoteWebDriver(new URL(CLOUD_URL), caps);
                  instance.driverCollection.set(driver);
              }catch(MalformedURLException e){
                  e.printStackTrace();

              }
          }
          else if(browser.toUpperCase().contentEquals("CH")){
              ChromeDriverManager.getInstance().arch64().setup();
              WebDriver driver = new ChromeDriver();
              instance.driverCollection.set(driver);
          }

            else if (browser.toUpperCase().contentEquals("FF")){
                 System.setProperty("webdriver.gecko.driver","C:\\Devtools\\MyDevelopments\\ssnb6bdd\\geckodriver.exe");
             FirefoxDriverManager.getInstance().arch64().setup();
             WebDriver driver = new FirefoxDriver();
             instance.driverCollection.set(driver);
         }

        else if (browser.toUpperCase().contentEquals("IE")){
                InternetExplorerDriverManager.getInstance().arch32().setup();

            WebDriver driver = new InternetExplorerDriver();
            instance.driverCollection.set(driver);
        }

         else if (browser.toUpperCase().contentEquals("CLOUD-CH")){

             DesiredCapabilities caps = new DesiredCapabilities();
             caps.setCapability("browser", "Chrome");
             caps.setCapability("browser_version", "54.0");
             caps.setCapability("os", "Windows");
             caps.setCapability("os_version", "8.1");
             caps.setCapability("resolution", "1440x900");
            try {
                WebDriver driver = new RemoteWebDriver(new URL(CLOUD_URL), caps);
                instance.driverCollection.set(driver);
            }catch(MalformedURLException e){
                e.printStackTrace();

            }
         }
        else {
            ChromeDriverManager.getInstance().arch64().setup();
            WebDriver driver = new ChromeDriver();
            instance.driverCollection.set(driver);
        }

          return instance;
      }
    public WebDriver getDriver(){
        return driverCollection .get();
    }
    public void removeDriver(){

        driverCollection.get().quit();
        driverCollection.remove();
    }
}
