package com.cydeo.step_definitions;


import com.cydeo.pages.BasePage;
import com.cydeo.pages.FilesPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.Connection;


public class n {


    LoginPage loginPage=new LoginPage();
    BasePage basePage=new BasePage();
    FilesPage filesPage = new FilesPage();


    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {
        loginPage.login();
    }
    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String string) {
        basePage.navigateToModule(string);
    }


    @When("the user clicks the add icon on the top")
    public void the_user_clicks_the_add_icon_on_the_top() {
        BrowserUtils.waitForClickablility(filesPage.addIcon,5);
        BrowserUtils.highlight(filesPage.addIcon);
        filesPage.addIcon.click();
    }


    @When("user click \"new folder”")
    public void user_click_new_folder() {
//        filesPage.GoToMenuItemOption("New folder").click();
        BrowserUtils.waitForClickablility(filesPage.newFolderBtn,10);
        filesPage.newFolderBtn.click();
    }

    @When("user write a folder name")
    public void user_write_a_folder_name() {
        filesPage.newFolderInputBox.sendKeys("INFO");
    }

    @When("the user click submit icon")
    public void the_user_click_submit_icon() {
        BrowserUtils.waitForClickablility(filesPage.newFolderSubmitBtn,5);
        filesPage.newFolderSubmitBtn.click();
    }

    @Then("Verify the folder is displayed on the page")
    public void verify_the_folder_is_displayed_on_the_page() {
        BrowserUtils.waitForVisibility(filesPage.newFolderLocation,5);
        Assert.assertTrue(filesPage.newFolderLocation.isDisplayed());
    }





    @When("user choose a folder from the page")
    public void user_choose_a_folder_from_the_page() {
        BrowserUtils.waitForClickablility(filesPage.newFolderLocation,10);
        filesPage.newFolderLocation.click();
    }
    @When("the user uploads a file with the upload file option")
    public void the_user_uploads_a_file_with_the_upload_file_option() {



        String pathofObject = System.getProperty("user.dir");
        String path=pathofObject+"src/test/resources/files/coffee.jpg";
        filesPage.uploadFileBtn.sendKeys(path);
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.waitForClickablility(filesPage.addIcon,5);
        filesPage.addIcon.click();
    }
    @Then("Verify the file is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page() {
        BrowserUtils.waitForVisibility(filesPage.newFolderInsideNewFileLocation,10);
        Assert.assertTrue(filesPage.newFolderInsideNewFileLocation.isDisplayed());

        Driver.getDriver().navigate().back();
        BrowserUtils.waitForPageToLoad(5);
        filesPage.newFolder3Dots.click();
        BrowserUtils.hover(filesPage.deleteFolderBtn);
        filesPage.deleteFolderBtn.click();
    }



}