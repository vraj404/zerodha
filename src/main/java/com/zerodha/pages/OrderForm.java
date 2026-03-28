package com.zerodha.pages;

import com.zerodha.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class OrderForm extends Base {

    @FindBy(xpath = "//div[@class=\"instrument-symbol\"]/div[@class=\"symbol\"]/h2")
    public WebElement symbol;

    @FindBy(xpath = "//div[@class=\"row\"]/div[ contains(text(),\"₹\")]")
    public WebElement priceRange;

    @FindBy(xpath = "//div[@class=\"instrument-details\"]/div[@class=\"row\"][5]/div[@class=\"six columns value\"]")
    public WebElement lotSize;

    public String[] priceRangeHandler(String s){
        s = s.replace("₹","");
        s = s.trim();
        return s.split("–");
    }

    @FindBy(xpath = "//div[contains(@class,\"vpa-username\")]/input[@label=\"UPI ID\"]")
    public WebElement upiID;

    @FindBy(xpath = "//input[@label=\"Qty.\"]")
    public WebElement qty;

    @FindBy(xpath = "//input[@label=\"Price\"]")
    public WebElement price;

    public OrderForm(){
        PageFactory.initElements(driver,this);
    }
}
