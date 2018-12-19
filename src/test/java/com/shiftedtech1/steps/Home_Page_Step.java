package com.shiftedtech1.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.startsWith;

public class Home_Page_Step extends BaseStep {

    @Then("^Spree home page should display$")
    public void spree_home_page_should_display() {
        String title = driver.getTitle();
        assertThat(title,startsWith("Spree Demo Site"));
    }

    @Then("^Home page should display$")
    public void home_page_should_display()  {
        String title = driver.getTitle();
        assertThat(title,startsWith("Spree Demo Site"));
    }
}
