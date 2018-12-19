package com.shiftedtech1.steps;

import com.shiftedtech.framework.DriverFactory;
import com.shiftedtech.framework.PropertyReaderService;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;


import static java.util.concurrent.TimeUnit.SECONDS;

public class SpreeCommon extends BaseStep {


    @Before
    public void setUp(){

        driver.manage().timeouts().implicitlyWait(10,SECONDS);
    }
    @After
    public void tearDown(){
        DriverFactory.getInstance().removeDriver();


    }


    @Given("^Not a validated user$")
    public void not_a_validated_user()  {
        driver.manage().deleteAllCookies();
    }

    @When("^User browse to the site$")
    public void user_browse_to_the_site()
    {
        driver.navigate().to(PropertyReaderService.getInstance().getProperty("APP_URL")) ;   }
}
