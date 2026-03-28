package tests;

import com.zerodha.base.Base;
import com.zerodha.pages.Bids;
import com.zerodha.pages.Home;
import com.zerodha.pages.OrderForm;
import com.zerodha.util.util;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrderTest extends Base {
    Bids b;
    Home h;
    util u;
    OrderForm of;
    String uLimit;
    String lLimit;
    @BeforeMethod
    public void setup(){
        init();
        u = new util();
        u.setUp();
        h = new Home();
        u.clicker(h.bidsTab);
        b = new Bids();
        u.clicker(b.IPO);
        u.clicker(b.apply);
        of = new OrderForm();
        String range[] = of.priceRangeHandler(of.priceRange.getText());
        lLimit = range[0];
        uLimit = range[1];

    }
    @Test(priority = 5)
    public void t5(){
        String symbol = prop.getProperty("ipo");
        String symboln = of.symbol.getText();
        Assert.assertTrue(symbol.contains(symboln));
    }

    @Test(priority = 6)
    public void t6() {
        //u.sender(of.upiID,prop.getProperty("upi"));
    }
    @AfterMethod
    public void tear(){
        driver.quit();
    }
}
