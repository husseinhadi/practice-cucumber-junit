package com.cydeo.step_definitions;

import com.cydeo.pages.LoginPage;
import com.cydeo.pages.TalksPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.*;
import org.bouncycastle.crypto.agreement.srp.SRP6Client;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class US11 {

    TalksPage talksPage = new TalksPage();
LoginPage loginPage=new LoginPage();
    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {
       loginPage .login();
    }

    @When("user search {string} user from the search box")
    public void user_search_user_from_the_search_box(String user) {
        BrowserUtils.highlight(talksPage.searchInput);
        talksPage.searchInput.sendKeys(user+ Keys.ENTER);

       WebElement conversation = Driver.getDriver().findElement(By.xpath("//a[@aria-label='Conversation, "+user+"']"));
       BrowserUtils.highlight(conversation);
        conversation.click();
    }

    @When("user write a {string} to the message")
    public void user_write_a_to_the_message(String string) {
        String message = string + " - " + Driver.getDriver();
        BrowserUtils.highlight(talksPage.messageInput);
        talksPage.messageInput.sendKeys(message);
    }

    @When("user clicks to submit button")
    public void user_clicks_to_submit_button() {
        BrowserUtils.highlight(talksPage.submitBtn);
        talksPage.submitBtn.click();
    }

    @Then("the user should be able to see the {string} message is displayed on the conversation log")
    public void the_user_should_be_able_to_see_the_message_is_displayed_on_the_conversation_log(String string) {
        String message = string + " - " + Driver.getDriver();
        WebElement postedMessage = Driver.getDriver().findElement(By.xpath("//*[.='"+message+"']"));
        //BrowserUtils.highlight(postedMessage);
       Assert.assertTrue(postedMessage.isDisplayed());
    }

    @Then("verify the page title is {string}")
    public void verifyThePageTitleIs(String arg0) {


    }
}



