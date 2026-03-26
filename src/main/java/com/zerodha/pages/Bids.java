package com.zerodha.pages;

import com.zerodha.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Bids extends Base {
    @FindBy(xpath = "//a[@href=\"/bids/ipo\"]")
    public WebElement IPO;

    @FindBy(xpath = "//span[contains(text(),\"Apply\")]")
    public WebElement apply;

    @FindBy(xpath = "//input[@placeholder=\"Search\"]")
    public WebElement searchBox;

    public Bids(){
        PageFactory.initElements(driver,this);
    }
}
