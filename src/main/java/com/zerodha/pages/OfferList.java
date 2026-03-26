package com.zerodha.pages;

import com.zerodha.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OfferList extends Base {

    @FindBy(xpath = "//input[@placeholder=\"Search table\"]")
    WebElement search;

    @FindBy(xpath = "//a[@data-balloon=\"Apply as Individual investor\"]")
    WebElement apply;

    public OfferList(){
        PageFactory.initElements(driver,this);
    }
}
