package com.ultraneo.in.customerlistadapter;

import java.util.ArrayList;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SoftwarePassionView extends ListActivity{
   
    private ProgressDialog m_ProgressDialog = null;
    private ArrayList<Order> m_orders = null;
    private OrderAdapter m_adapter;
    private Runnable viewOrders;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.main);
        m_orders = new ArrayList<Order>();
        this.m_adapter = new OrderAdapter(this, R.layout.rowxinside, m_orders);
        setListAdapter(this.m_adapter);
       
        viewOrders = new Runnable(){
            @Override
            public void run() {
                getOrders();
            }
        };
        Thread thread =  new Thread(null, viewOrders, "MagentoBackground");
        thread.start();
        m_ProgressDialog = ProgressDialog.show(SoftwarePassionView.this,    
              "Please wait...", "Retrieving data ...", true);
    }
    private Runnable returnRes = new Runnable() {

        @Override
        public void run() {
            if(m_orders != null && m_orders.size() > 0){
                m_adapter.notifyDataSetChanged();
                for(int i=0;i<m_orders.size();i++)
                m_adapter.add(m_orders.get(i));
            }
            m_ProgressDialog.dismiss();
            m_adapter.notifyDataSetChanged();
        }
    };
    private void getOrders(){
          try{
              m_orders = new ArrayList<Order>();
              Order o1 = new Order();
              o1.setOrderName("Locator Setting");
              o1.setOrderStatus("Change Location determination Hardware");
              o1.setbitMAP(android.R.drawable.ic_menu_compass);
              
              Order o2 = new Order();
              o2.setOrderName("Change Pin");
              o2.setOrderStatus("Change Security Pin");
              o2.setbitMAP(R.drawable.lock);
              
              Order o3 = new Order();
              o3.setOrderName("Enable/Disable Latitude");
              o3.setOrderStatus("");
              o3.setbitMAP(android.R.drawable.ic_menu_myplaces);
              
              Order o4 = new Order();
              o4.setOrderName("Enable/Disable satellite Mode");
              o4.setOrderStatus("");
              o4.setbitMAP(android.R.drawable.ic_menu_mapmode);
              
              
              Order o5 = new Order();
              o5.setOrderName("About Us");
              o5.setOrderStatus("UltraNEO Inc. (Moderated By :C.NARAYANAN)");
              o5.setbitMAP(android.R.drawable.ic_menu_info_details);
              
              m_orders.add(o1);
              m_orders.add(o2);
              m_orders.add(o3);
              m_orders.add(o4);
              m_orders.add(o5);
           
              Log.i("ARRAY", ""+ m_orders.size());
            } catch (Exception e) {
              Log.e("BACKGROUND_PROC", e.getMessage());
            }
            runOnUiThread(returnRes);
        }
    
}