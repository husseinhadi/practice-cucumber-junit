package com.cydeo.step_definitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// http://qa2.trycloud.net/index.php/apps/dashboard/
public class hhhh {

    @FindBy(css = "#appmenu li[data-id='files'] svg")
    public WebElement elementSvg;

    public hhhh(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}