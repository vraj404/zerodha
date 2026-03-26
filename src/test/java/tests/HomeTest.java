package tests;

import com.zerodha.base.Base;
import com.zerodha.pages.Home;
import com.zerodha.util.util;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomeTest extends Base {
    public HomeTest(){
        super(); // this calls the super class constructor
    }
    Home h;
    util u;
    String title;
    @BeforeClass
    public void setup(){
        init();
        h = new Home();
        u = new util();
        u.setUp();
    }
    @Test(priority = 1)
    public void t1(){
        //validate website
        title = h.validate();
        Assert.assertEquals(title,"Dashboard / Kite");
    }
    @Test(priority = 2)
    public void t2(){
        u = new util();
        u.clicker(h.bidsTab);
        title = h.validate();
        Assert.assertEquals(title,"Auctions / Kite");
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
