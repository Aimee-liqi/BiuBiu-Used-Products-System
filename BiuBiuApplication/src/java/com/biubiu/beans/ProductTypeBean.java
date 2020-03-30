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
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author Anasitasia
 */
@ManagedBean(name="type")
@SessionScoped
public class ProductTypeBean {
    
    private String proType;
    private String proName;
    private ArrayList<ArrayList> typeList;
    int flag=0;
    
     public void searchProType(ActionEvent event) {
        ProductDAO pro_dao = new ProductDAO();
        HtmlCommandLink source = (HtmlCommandLink) event.getSource();
        proType = (String) source.getValue();
        System.out.println(proType);
        typeList = pro_dao.getProductsType(proType);

    }
     
     public void searchTypeName(){
         ProductDAO pro_dao = new ProductDAO();
         String query = "from Product where pro_name like '%" +proName+ "%' and pro_type='"+proType+"'";
          typeList = pro_dao.getProducts(query);
        
     }
     
     public void priceAsc()
    {
       
        ProductDAO pro_dao=new ProductDAO();
        String query="from Product where pro_type='"+proType+"' order by minPrice asc";
        typeList=pro_dao.getProducts(query);
        flag=1;
    }
    
    public void priceDesc(){
       
        ProductDAO pro_dao=new ProductDAO();
        String query="from Product where pro_type='"+proType+"' order by minPrice desc";
        typeList=pro_dao.getProducts(query);
        flag=2;
    }
    
    public void rateAsc()
    {
        
        ProductDAO pro_dao=new ProductDAO();
        String query=" from Product where pro_type='"+proType+"' order by sell_level asc";
        typeList=pro_dao.getProducts(query);
        flag=3;
    }
    
    public void rateDesc(){
      
         ProductDAO pro_dao=new ProductDAO();
        String query="from Product where pro_type='"+proType+"' order by sell_level desc";
          typeList=pro_dao.getProducts(query);
          flag=4;
    }
    
    public void  postTimeAction(ValueChangeEvent event){
   
        ProductDAO pro_dao=new ProductDAO();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date day=new Date();
        String now=df.format(day);
        String value=event.getNewValue().toString();
        System.out.println(value);
         Calendar c = Calendar.getInstance();
        String before=df.format(c.getTime());
        System.out.println(now);
        
        if(value.compareTo("last1hour")==0){
            c.add(Calendar.HOUR_OF_DAY, -1);
            String after=df.format(c.getTime());
            System.out.println("1 hour"+after);
            System.out.println("1 hour now"+before);
            String sql=" from Product where pro_type='"+proType+"' and post_time between'"+after+"'  and '"+before+"'";
            System.out.println(sql);
            typeList=pro_dao.getProducts(sql);
            
            
       }
        else if(value.compareTo("last12hours")==0){
            c.add(Calendar.HOUR_OF_DAY, -12);
            String after=df.format(c.getTime());
            System.out.println("12 hour"+after);
            System.out.println("12 hour now"+before);
            String sql=" from Product where pro_type='"+proType+"' and post_time between'"+after +"' and '" +before+"'";
            System.out.println(sql);
            typeList=pro_dao.getProducts(sql);
           
       }
        else if(value.compareTo("today")==0){
            Date today=new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
            String tonow=sdf.format(today);
            tonow=tonow+"00:00:00";
            System.out.println("00: "+tonow);
            System.out.println("today : "+now);
            String sql=" from Product where pro_type='"+proType+"' and post_time between'"+tonow+"' and '"+now+"'";
            System.out.println(sql);
           typeList=pro_dao.getProducts(sql);
           
        }
        else if(value.compareTo("lastweek")==0){
             c.add(Calendar.WEEK_OF_MONTH, -1);
             String after=df.format(c.getTime());
              System.out.println("12 ww"+after);
            System.out.println("12 ww now "+before);
             String sql=" from    Product where pro_type='"+proType+"' and post_time  between'"+after+"'  and  '" +before+"'";
             System.out.println(sql);
            typeList=pro_dao.getProducts(sql);
           
       }
       
       
    } 

    public String getProType() {
        return proType;
    }

    public void setProType(String proType) {
        this.proType = proType;
    }

    public ArrayList<ArrayList> getTypeList() {
        return typeList;
    }

    public void setTypeList(ArrayList<ArrayList> typeList) {
        this.typeList = typeList;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }
}
