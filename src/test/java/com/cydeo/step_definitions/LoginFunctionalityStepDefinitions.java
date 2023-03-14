package com.cydeo.step_definitions;

import com.cydeo.pages.FidexioLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.*;
import io.cucumber.messages.types.Examples;
import io.cucumber.plugin.event.Node;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class LoginFunctionalityStepDefinitions {

    FidexioLoginPage fidexioLoginPage = new FidexioLoginPage();

    @Given("User is on Fidexio log in page")
    public void userIsOnFidexioLogInPage() {
        Driver.getDriver().get("https://qa.fidexio.com/");
    }


    @When("User enters an email {string}")
    public void userEntersAnEmail(String arg0) {
        fidexioLoginPage.emailBox.sendKeys(arg0 + Keys.TAB);
    }

    @And("User enters a password {string}")
    public void userEntersAPassword(String pass) {
        fidexioLoginPage.passwordBox.sendKeys(pass);
    }


    @And("User clicks the login button")
    public void userClicksTheLoginButton() {
        fidexioLoginPage.loginButton.click();
    }

    @Then("User should successfully log in to the homepage")
    public void userShouldSuccessfullyLogInToTheHomepage() {
        BrowserUtils.sleep(5);
        BrowserUtils.verifyTitle("#Inbox - Odoo");

    }


    @Then("User should see the {string} message")
    public void userShouldSeeTheMessage(String arg0) {

        if (fidexioLoginPage.emailBox.getAttribute("value").isEmpty()){
            System.out.println("fidexioLoginPage.emailBox.getText() = " + fidexioLoginPage.emailBox.getText());
            Assert.assertEquals("Please fill in this field.", fidexioLoginPage.emailBox.getAttribute("validationMessage"));
        }

        if (fidexioLoginPage.passwordBox.getAttribute("value").isEmpty()){
            System.out.println("fidexioLoginPage.passwordBox.getText() = " + fidexioLoginPage.passwordBox.getText());
            Assert.assertEquals("Please fill in this field.", fidexioLoginPage.passwordBox.getAttribute("validationMessage"));
        }

    }


    @Then("The User should see the message {string}")
    public void theUserShouldSeeTheMessage(String arg0) {

        Assert.assertTrue(fidexioLoginPage.wrongLoginPasswordDisplay.isDisplayed());
    }
}


//    @When("User enters the correct SalesManager credentials")
//    public void userEntersTheCorrectSalesManagerCredentials() {
//        fidexioLoginPage.emailBox.sendKeys("salesmanager15@info.com" + Keys.TAB);
//        fidexioLoginPage.passwordBox.sendKeys("salesmanager" + Keys.ENTER);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }


//    @When("User enters the correct PosManager credentials")
//    public void userEntersTheCorrectPosManagerCredentials() {
//        fidexioLoginPage.emailBox.sendKeys("posmanager10@info.com" + Keys.TAB);
//        fidexioLoginPage.passwordBox.sendKeys("posmanager" + Keys.ENTER);
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    @Then("User should successfully log in to the homepage")
//    public void userShouldSuccessfullyLogInToTheHomepage() {
//        String expectedUrl = "https://qa.fidexio.com/web?#menu_id=115&action=120&active_id=channel_inbox";
//        String actualUrl = Driver.getDriver().getCurrentUrl();
//        Assert.assertEquals(actualUrl,expectedUrl);
//    }
