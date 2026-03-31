package tests;

import com.zerodha.base.Base;
import com.zerodha.msg.errorMsg;
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
    errorMsg e;
    double uLimit;
    double lLimit;
    int qnt;
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
        e = new errorMsg();
        String range[] = of.priceRangeHandler(of.priceRange.getText());
        lLimit = Integer.valueOf(range[0].trim());
        uLimit = Integer.valueOf(range[1].trim());
        qnt = Integer.valueOf(of.lotSize.getText());

    }
    @Test(priority = 5)
    public void t5(){
        //Verifying if proper symbol is clicked
        String symbol = prop.getProperty("ipo");
        String symboln = of.symbol.getText();
        Assert.assertTrue(symbol.contains(symboln));
    }

    @Test(priority = 6)
    public void t6() {
        //Verifying scenario no data is entered
        //e = new errorMsg();
        u.hardClear(of.elements);
        u.clicker(of.submit);
        boolean condition = e.vpa_username_msg.equals(of.vpa_username_message.getText()) && e.no_qnt_provided_msg.equals(of.qnt_msg.getText()) && e.no_price_provided_msg.equals(of.price_msg.getText());
        Assert.assertTrue(condition);

    }
    @Test(priority = 7)
    public void t7(){
        //Verifying user enters qnt which is not multiple of lot size
        //u.hardClear(of.elements);
        of.placeOrder(qnt-1,lLimit);
        //e = new errorMsg();
        Assert.assertEquals(e.invalid_qnt_multiplier_msg,of.qnt_msg.getText());
    }
    @Test(priority = 8)
    public void t8(){
        //Verifying  user tries to place order outside the valid range
        //u.hardClear(of.elements);
        double price = lLimit-1;
        of.placeOrder(2*qnt,price);
        if(price<lLimit){
            Assert.assertEquals(e.price_below_lLimit + String.valueOf(lLimit),of.price_msg.getText());
        }else{
            Assert.assertEquals(e.price_above_uLimit + String.valueOf(uLimit),of.price_msg.getText());
        }
    }
    @AfterMethod
    public void tear(){
        driver.quit();
    }
}
