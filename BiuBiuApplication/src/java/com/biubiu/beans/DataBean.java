/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.beans;

import com.biubiu.dao.FeedbackDAO;
import com.biubiu.dao.ProductDAO;
import com.biubiu.model.Feedback;
import com.biubiu.model.Product;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL-PC
 */
@ManagedBean(name="data")
@SessionScoped
public class DataBean {
    private boolean show;
    private ArrayList<ArrayList> infoList,typeList,filterList;
    private ArrayList<Feedback> feedlist;
    
    public String emptyaction()
    {
       
        return "ok";
    }   
    
public String priceAsc()
    {
       
        ProductDAO pro_dao=new ProductDAO();
        String query="from Product order by minPrice asc";
        filterList=pro_dao.getProducts(query);
        return "ok";
    }
    
    public String priceDesc(){
       
        ProductDAO pro_dao=new ProductDAO();
        String query="from Product order by minPrice desc";
         filterList=pro_dao.getProducts(query);
         return "ok";
    }
    
    public String rateAsc()
    {
        
        ProductDAO pro_dao=new ProductDAO();
        String query=" from Product order by sell_level asc";
        filterList=pro_dao.getProducts(query);
        return "ok";
    }
    
    public String rateDesc(){
      
         ProductDAO pro_dao=new ProductDAO();
        String query="from Product order by sell_level desc";
         filterList=pro_dao.getProducts(query);
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
            
            
       }
        else if(value.compareTo("last12hours")==0){
            c.add(Calendar.HOUR_OF_DAY, -12);
            String after=df.format(c.getTime());
            System.out.println("12 hour"+after);
            System.out.println("12 hour now"+before);
            String sql=" from Product where post_time between'"+after +"' and '" +before+"'";
            System.out.println(sql);
            filterList=pro_dao.getProducts(sql);
           
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
           
        }
        else if(value.compareTo("lastweek")==0){
             c.add(Calendar.WEEK_OF_MONTH, -1);
             String after=df.format(c.getTime());
              System.out.println("12 ww"+after);
            System.out.println("12 ww now "+before);
             String sql=" from    Product where post_time  between'"+after+"'  and  '" +before+"'";
             System.out.println(sql);
            filterList=pro_dao.getProducts(sql);
           
       }
        System.out.println("ok");
       return "ok";
       
    } 
  
      
   
    
    public void searchProType(ActionEvent event) {
        ProductDAO pro_dao = new ProductDAO();
        HtmlCommandLink source = (HtmlCommandLink) event.getSource();
        String value = (String) source.getValue();
        System.out.println(value);
        typeList = pro_dao.getProductsType(value);

    }

    public ArrayList<ArrayList> getInfoList() {
        infoList = null;
        ProductDAO pro_dao = new ProductDAO();
        String query = "from Product where sell_level in ('SSR' , 'SR')";
        infoList = pro_dao.getProducts(query);
        return infoList;
    }

    public void setInfoList(ArrayList<ArrayList> infoList) {
        this.infoList = infoList;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
    public ArrayList<ArrayList> getTypeList() {
        return typeList;
    }

    public void setTypleLIst(ArrayList<ArrayList> typeLIst) {
        this.typeList = typeLIst;
    }

    public ArrayList<ArrayList> getFilterList() {
        return filterList;
    }

    public void setFilterList(ArrayList<ArrayList> filterList) {
        this.filterList = filterList;
    }

    public ArrayList<Feedback> getFeedlist() {
        FacesContext facescontext=FacesContext.getCurrentInstance();
        ExternalContext exContext=facescontext.getExternalContext();
        HttpSession session=(HttpSession)exContext.getSession(true);
        String id=(String)session.getAttribute("Login_id");
        FeedbackDAO fdao=new FeedbackDAO();
        feedlist=fdao.getAllFeedback(id);
        return feedlist;
    }

    public void setFeedlist(ArrayList<Feedback> feedlist) {
        this.feedlist = feedlist;
    }
}
