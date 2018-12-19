package com.shiftedtech1.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.startsWith;

public class Login_Page_Step extends BaseStep{
       @When("^User click login link$")
    public void user_click_login_link()  {
        driver.findElement(By.linkText("Login")).click();
    }

    @Then("^Browser display Login page$")
    public void browser_display_Login_page() {
        String title = driver.getTitle();
        assertThat(title,startsWith("Login - Spree Demo Site"));
    }

    @When("^User enter user email as \"([^\"]*)\"$")
    public void user_enter_user_email_as(String email) {
        driver.findElement(By.id("spree_user_email")).sendKeys(email);
    }

    @When("^User enter password as \"([^\"]*)\"$")
    public void user_enter_password_as(String password){
        driver.findElement(By.id("spree_user_password")).sendKeys(password);
    }

    @When("^User click login button$")
    public void user_click_login_button() {
        driver.findElement(By.name("commit")).click();
    }
    @Then("^Login success message display$")
    public void login_success_message_display()  {
        String msg= driver.findElement(By.cssSelector(".alert.alert-success")).getText();
        assertThat(msg,startsWith("Logged in successfully"));
    }
}
