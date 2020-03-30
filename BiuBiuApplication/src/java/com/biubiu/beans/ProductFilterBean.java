/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.beans;

import com.biubiu.dao.ProductDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author Anasitasia
 */
@ManagedBean(name="filter")
@SessionScoped
public class ProductFilterBean {
    private ArrayList<ArrayList> filterList;
    int flag=0;
    public String priceAsc()
    {
       
        ProductDAO pro_dao=new ProductDAO();
        String query="from Product order by minPrice asc";
        filterList=pro_dao.getProducts(query);
        flag=1;
        return "ok";
    }
    
    public String priceDesc(){
       
        ProductDAO pro_dao=new ProductDAO();
        String query="from Product order by minPrice desc";
         filterList=pro_dao.getProducts(query);
         flag=2;
         return "ok";
    }
    
    public String rateAsc()
    {
        
        ProductDAO pro_dao=new ProductDAO();
        String query=" from Product order by sell_level asc";
        filterList=pro_dao.getProducts(query);
        flag=3;
        return "ok";
    }
    
    public String rateDesc(){
      
         ProductDAO pro_dao=new ProductDAO();
        String query="from Product order by sell_level desc";
         filterList=pro_dao.getProducts(query);
         flag=4;
        return "ok";
    }
    
    
   public String  postTimeAction(ValueChangeEvent event){
   
        ProductDAO pro_dao=new ProductDAO();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date day=new Date();
        String now=df.format(day);
        String value=event.getNewValue().toString();//get the data from ui
        System.out.println(value);
       //time transform
         Calendar c = Calendar.getInstance();
        String before=df.format(c.getTime());
        System.out.println(now);
        
        if(value.compareTo("last1hour")==0){
            c.add(Calendar.HOUR_OF_DAY, -1);
            String after=df.format(c.getTime());
            System.out.println("1 hour"+after);
            System.out.println("1 hour now"+before);
            String sql=" from Product where post_time between'"+after+"'  and '"+before+"'";
            System.out.println(sql);
            filterList=pro_dao.getProducts(sql);
            flag=5;
            
            
       }
        else if(value.compareTo("last12hours")==0){
            c.add(Calendar.HOUR_OF_DAY, -12);
            String after=df.format(c.getTime());
            System.out.println("12 hour"+after);
            System.out.println("12 hour now"+before);
            String sql=" from Product where post_time between'"+after +"' and '" +before+"'";
            System.out.println(sql);
            filterList=pro_dao.getProducts(sql);
            flag=6;
           
       }
        else if(value.compareTo("today")==0){
            Date today=new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
            String tonow=sdf.format(today);
            tonow=tonow+"00:00:00";
            System.out.println("00: "+tonow);
            System.out.println("today : "+now);
            String sql=" from Product where post_time between'"+tonow+"' and '"+now+"'";
            System.out.println(sql);
           filterList=pro_dao.getProducts(sql);
           flag=7;
           
        }
        else if(value.compareTo("lastweek")==0){
             c.add(Calendar.WEEK_OF_MONTH, -1);
             String after=df.format(c.getTime());
              System.out.println("12 ww"+after);
            System.out.println("12 ww now "+before);
             String sql=" from    Product where post_time  between'"+after+"'  and  '" +before+"'";
             System.out.println(sql);
            filterList=pro_dao.getProducts(sql);
            flag=8;
           
       }
        System.out.println("ok");
       return "ok";
       
    } 

    public ArrayList<ArrayList> getFilterList() {
        return filterList;
    }

    public void setFilterList(ArrayList<ArrayList> filterList) {
        this.filterList = filterList;
    }
}
