package com.cydeo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// http://qa2.trycloud.net/index.php/apps/dashboard/
public class he {

    @FindBy(css = "#appmenu li[data-id='files'] svg")
    public WebElement elementSvg;

    @FindBy(css = ".new")
    public WebElement buttonLink;

    @FindBy(css = ".icon-add")
    public WebElement iconSpan;

    public he(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}