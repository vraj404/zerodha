package tests;

import com.zerodha.base.Base;
import com.zerodha.pages.Bids;
import com.zerodha.pages.Home;
import com.zerodha.util.util;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BidsTest extends Base {
    public BidsTest(){
        super();
    }
    Bids b;
    util u;
    Home h;
    String ee;
    @BeforeClass
    public void setup(){
        init();
        u = new util();
        u.setUp();
        b = new Bids();
        h = new Home();
        u.clicker(h.bidsTab);
    }
    @Test(priority = 3)
    public void t3(){
        u = new util();
        u.clicker(b.IPO);
        Assert.assertEquals(driver.getCurrentUrl(),"https://kite-demo.zerodha.com/bids/ipo");
    }
    @Test(priority = 4)
    public void t4(){
        String  s = prop.getProperty("ipo");
        u.sender(b.searchBox,s);
       ee = driver.findElement(By.xpath("//td[@class=\"col-symbol\"]/div[1]")).getText();
    }

    @AfterClass
    public void tear(){
        driver.close();
    }
}
