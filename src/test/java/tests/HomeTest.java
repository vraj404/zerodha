package tests;

import com.zerodha.base.Base;
import com.zerodha.pages.Home;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeTest extends Base {
    public HomeTest(){
        super();
    }
    Home h;
    @BeforeMethod
    public void setup(){
        init();
        h = new Home();
    }
    @Test
    public void t1(){
        //validate website
        String title = h.validate();
        Assert.assertEquals(title,"Dashboard / Kite");

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
