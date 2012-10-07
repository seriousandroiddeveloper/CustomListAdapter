package com.ultraneo.in.customerlistadapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;



public class Order {
   
    private String orderName;
    private String orderStatus;
    private int bmp;
    public String getOrderName() {
        return orderName;
    }
    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
    
    public void setbitMAP(int bmp) {
       this.bmp = bmp;
        	
    }
    
    
    public String getOrderStatus() {
        return orderStatus;
    }
    
    public int getbitMAP() {
        return bmp;
    }
    
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}