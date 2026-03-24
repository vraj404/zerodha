package com.zerodha.pages;

import com.zerodha.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.SQLOutput;

import static com.zerodha.util.util.clicker;

public class Home extends Base {
    @FindBy(xpath = "//button[contains(text(),\"I understand\")]")
    WebElement understandBtn;

    public Home(){
        PageFactory.initElements(driver,this);
    }
    public String validate(){
        return driver.getTitle();
    }
}
