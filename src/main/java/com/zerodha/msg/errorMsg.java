package com.zerodha.msg;

public class errorMsg {
    //VPA error messages
    public String vpa_username_msg= "VPA username is required";
    public String vpa_handler_msg = "VPA handle is required";

    //Qnt error messages
    public String no_qnt_provided_msg = "Quantity is required";
    public String invalid_qnt_multiplier_msg = "Qty should be a multiple of 150";

    //Price error messages
    public String no_price_provided_msg = "Price is required";
    public String price_below_lLimit = "Price cannot be less than ";
    public String price_above_uLimit = "Price cannot be less than ";
}
