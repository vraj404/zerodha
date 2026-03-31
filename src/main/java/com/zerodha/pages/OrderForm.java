package com.zerodha.pages;

import com.zerodha.base.Base;
import com.zerodha.util.util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class OrderForm extends Base {
    util u;
    OrderForm of;

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


    public void placeOrder(int qnt, double price){
        u = new util();
        of = new OrderForm();
        u.hardClear(elements);
        u.sender(upiID,prop.getProperty("upi"));
        u.sender(qty,String.valueOf(qnt));
        u.sender(pricei,String.valueOf(price));
        of.submit.click();
    }

    @FindBy(xpath = "//div[contains(@class,\"vpa-username\")]/input[@label=\"UPI ID\"]")
    public WebElement upiID;

    @FindBy(xpath = "//input[@label=\"Qty.\"]")
    public WebElement qty;

    @FindBy(xpath = "//input[@label=\"Price\"]")
    public WebElement pricei;

    public ArrayList<WebElement> elements = new ArrayList<>();

    //Error messages

    @FindBy(css = ".vpa-username > span:nth-child(3)")
    public WebElement vpa_username_message;

    @FindBy(xpath="vpa-handle")
    public WebElement vpa_handler_msg;

    @FindBy(css = ".five > div:nth-child(1) > span:nth-child(3)")
    public WebElement qnt_msg;

    @FindBy(css = ".ipo-bid > div:nth-child(2) > div:nth-child(1) > span:nth-child(3)")
    public WebElement price_msg;

    @FindBy(xpath = "//span[contains(text(),\"Submit\")]")
    public WebElement submit;

    public OrderForm(){
        PageFactory.initElements(driver,this);
        elements.add(upiID);
        elements.add(qty);
        elements.add(pricei);
    }
}
