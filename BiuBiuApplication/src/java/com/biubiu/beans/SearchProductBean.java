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
@ManagedBean(name="search")
@SessionScoped
public class SearchProductBean {
        private String proName;
        private ArrayList<ArrayList> searchList;
        
    
    public String searchProduct()
    {
        ProductDAO pro_dao=new ProductDAO();
        searchList=pro_dao.searchName(proName);
        return "search";
    }

    
public void priceAsc()
    {
       
        ProductDAO pro_dao=new ProductDAO();
        String query="from Product where pro_name like '%" + proName + "%' order by minPrice asc";
        searchList=pro_dao.getProducts(query);
    
    }
    
    public void priceDesc(){
       
       ProductDAO pro_dao=new ProductDAO();
        String query="from Product where pro_name like '%" + proName + "%' order by minPrice desc";
        searchList=pro_dao.getProducts(query);
    }
    
    public void rateAsc()
    {
        
        ProductDAO pro_dao=new ProductDAO();
         String query="from Product where pro_name like '%" + proName + "%' order by sell_level asc";
       searchList=pro_dao.getProducts(query);
    }
    
    public void rateDesc(){
      
         ProductDAO pro_dao=new ProductDAO();
          String query="from Product where pro_name like '%" + proName + "%' order by sell_level desc";
        searchList=pro_dao.getProducts(query);
    }
    
    
   public void  postTimeAction(ValueChangeEvent event){
   
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
            String sql=" from Product where pro_name like '%" + proName + "%' and post_time between'"+after+"'  and '"+before+"'";
            System.out.println(sql);
            searchList=pro_dao.getProducts(sql);
            
            
       }
        else if(value.compareTo("last12hours")==0){
            c.add(Calendar.HOUR_OF_DAY, -12);
            String after=df.format(c.getTime());
            System.out.println("12 hour"+after);
            System.out.println("12 hour now"+before);
            String sql=" from Product where pro_name like '%" + proName + "%' and post_time between'"+after +"' and '" +before+"'";
            System.out.println(sql);
            searchList=pro_dao.getProducts(sql);
           
       }
        else if(value.compareTo("today")==0){
            Date today=new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
            String tonow=sdf.format(today);
            tonow=tonow+"00:00:00";
            System.out.println("00: "+tonow);
            System.out.println("today : "+now);
            String sql=" from Product where pro_name like '%" + proName + "%' and post_time between'"+tonow+"' and '"+now+"'";
            System.out.println(sql);
           searchList=pro_dao.getProducts(sql);
           
        }
        else if(value.compareTo("lastweek")==0){
             c.add(Calendar.WEEK_OF_MONTH, -1);
             String after=df.format(c.getTime());
              System.out.println("12 ww"+after);
            System.out.println("12 ww now "+before);
             String sql=" from    Product where pro_name like '%" + proName + "%' and post_time  between'"+after+"'  and  '" +before+"'";
             System.out.println(sql);
            searchList=pro_dao.getProducts(sql);
           
       }
       
       
    } 
    
     public String getProName() 
    {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public ArrayList<ArrayList> getSearchList() {
        return searchList;
    }

    public void setSearchList(ArrayList<ArrayList> searchList) {
        this.searchList = searchList;
    }
}
