package com.zerodha.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base {
    public static WebDriver driver;
    public static Properties prop;
    public Base (){
        try{
            prop = new Properties();
            FileInputStream ip = new FileInputStream("/home/viraj/IdeaProjects/Zerodha/src/main/java/com/zerodha/config/config.properties");
            prop.load(ip);
        }catch(FileNotFoundException foe){
            System.out.println(foe);
        }catch (IOException ioe){
            System.out.println(ioe);
        }
    }
    public static void init(){
        String browser = prop.getProperty("browser");
        if (browser.equals("Firefox")){
            driver = new FirefoxDriver();
        }
        else if (browser.equals("Chrome")) {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }
    public static String getOfferName(){
        return prop.getProperty("IPO");
    }
}
