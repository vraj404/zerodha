package com.zerodha.util;

import com.zerodha.pages.Home;
import com.zerodha.pages.OrderForm;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import static com.zerodha.base.Base.driver;

public class util {

    OrderForm of;
    public void clicker(WebElement element){
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
        w.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }
    public void waiter(WebDriver driver, WebElement element, int time){
         new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.visibilityOf(element));
    }
    public void waiter(WebDriver driver,int time){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }
    public void setUp(){
        waiter(driver,2);
        Home h = new Home();
        clicker(h.understandBtn);
        waiter(driver,2);
        if(h.popUpClose.isDisplayed()){
            clicker(h.popUpClose);
        }
    }
    public void clear(ArrayList<WebElement> elements){
        for(WebElement e : elements){
            e.clear();
        }
    }

    public void hardClear(ArrayList<WebElement> elements){
        for(WebElement e : elements){
            e.clear();
            e.sendKeys("e");
            e.sendKeys(Keys.BACK_SPACE);

        }
    }

    public void sender(WebElement element ,String s){
        waiter(driver,2);
        element.sendKeys(s);
    }
}
