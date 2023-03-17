package com.cydeo.step_definitions;

import com.cydeo.pages.FidexioHomePage;
import com.cydeo.pages.FidexioLoginPage;
import com.cydeo.pages.FidexioSessionExpiredPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LogoutFunctionalityStepDefinitions {

    FidexioHomePage fidexioHomePage = new FidexioHomePage();
    FidexioLoginPage fidexioLoginPage = new FidexioLoginPage();

    FidexioSessionExpiredPage fidexioSessionExpiredPage = new FidexioSessionExpiredPage();

    @Given("user is already logged in")
    public void user_is_already_logged_in() {

        Driver.getDriver().get("https://qa.fidexio.com/");
        fidexioLoginPage.emailBox.sendKeys(ConfigurationReader.getProperty("smEmail"));
        fidexioLoginPage.passwordBox.sendKeys(ConfigurationReader.getProperty("smPassword"));
        fidexioLoginPage.loginButton.click();

        Assert.assertTrue(fidexioLoginPage.congratsOnHomepage.isDisplayed());
    }

    @When("user clicks the logout button")
    public void user_clicks_the_logout_button() {

        fidexioHomePage.username.click();
        BrowserUtils.sleep(1);
        fidexioHomePage.logoutButton.click();
        BrowserUtils.sleep(1);
    }

    @Then("user should land on to the login page")
    public void user_should_land_on_to_the_login_page() {

        Assert.assertTrue(fidexioLoginPage.signInButton.isDisplayed());
        BrowserUtils.sleep(2);
    }




    @Given("user has logged out")
    public void user_has_logged_out() {

        fidexioHomePage.username.click();
        fidexioHomePage.logoutButton.click();
        Assert.assertTrue(fidexioLoginPage.signInButton.isDisplayed());
    }

    @When("user presses the backward button after logging out")
    public void user_presses_the_backward_button_after_logging_out() {

        Driver.getDriver().navigate().back();
    }

    @Then("user cannot go back to the homepage")
    public void user_cannot_go_back_to_the_homepage() {

        Assert.assertTrue(fidexioSessionExpiredPage.sessionExpiredMsg.isDisplayed());
        BrowserUtils.sleep(2);
    }



}
