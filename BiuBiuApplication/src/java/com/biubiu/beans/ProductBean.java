/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.beans;

import com.biubiu.dao.PostProductDAO;
import com.biubiu.dao.ShowSellerDAO;
import com.biubiu.model.Product;
import com.biubiu.model.Seller;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Anasitasia
 */
@ManagedBean(name="pro")
@SessionScoped
public class ProductBean {
    private int pro_id;
    private String pro_name;
    private String pro_type;
    private float pro_minPrice;
    private float pro_origPrice;
    private String pro_usetime;
    private String pro_expiry;
    private String pro_posttime;
    private String pro_details;
    private String pro_contactNum;
    private String pro_imgPath;
    private String seller_level;
    private String seller_id;
    
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession session = (HttpSession) externalContext.getSession(true);
    
     public String post()
     {
         pro_posttime=transPost_time();
         pro_expiry=transPro_expire();
         pro_imgPath= transPro_imgPath();
         seller_id=(String)session.getAttribute("Login_id");
         ArrayList<Seller> seller=new ArrayList<Seller>();
         ShowSellerDAO showdao=new ShowSellerDAO();
         seller=showdao.getSeller(seller_id);
         seller_level=seller.get(0).getSell_level();
         
         Product p=new Product();
         p.setPro_id(pro_id); 
         p.setPro_name(pro_name);
         p.setPro_type(pro_type);
         p.setPro_origPrice(pro_origPrice);
         p.setPro_minPrice(pro_minPrice);
         p.setPro_posttime(pro_posttime);
         p.setPro_usetime(pro_usetime);
         p.setPro_expiry(pro_expiry);
         p.setPro_details(pro_details);
         p.setPro_contactNum(pro_contactNum);
         p.setPro_imgPath(pro_imgPath);
         p.setSeller_id(seller_id);
         p.setSeller_level(seller_level);
         
         PostProductDAO dao=new PostProductDAO();
         Boolean flag=dao.postProduct(p);
         if(flag==true)
         {
             System.out.println("Post Successfully");
         }
         else
         {
             System.out.println("Unsuccessfully");
         }
         return "post";
     }

   
    public String transPro_expire()
     {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        System.out.println("now:" + df.format(c.getTime()));
        c.add(Calendar.DAY_OF_MONTH, 10);
        System.out.println("after" + df.format(c.getTime()));
        String expiry = df.format(c.getTime());
        return expiry;
    }
    
    public String transPost_time()
    {
        Date day = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String  posttime = f.format(day);
        System.out.println(pro_posttime);
        return posttime;
    }
    
    public String transPro_imgPath()
      {
        FacesContext facescontext = FacesContext.getCurrentInstance();
        ExternalContext exContext = facescontext.getExternalContext();
        HttpSession session = (HttpSession) exContext.getSession(true);
        String imgPath=(String) session.getAttribute("path");    
        return imgPath;     
      }
    
    

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public String getPro_type() {
        return pro_type;
    }

    public void setPro_type(String pro_type) {
        this.pro_type = pro_type;
    }

    public float getPro_minPrice() {
        return pro_minPrice;
    }

    public void setPro_minPrice(float pro_minPrice) {
        this.pro_minPrice = pro_minPrice;
    }

    public float getPro_origPrice() {
        return pro_origPrice;
    }

    public void setPro_origPrice(float pro_origPrice) {
        this.pro_origPrice = pro_origPrice;
    }

    public String getPro_usetime() {
        return pro_usetime;
    }

    public void setPro_usetime(String pro_usetime) {
        this.pro_usetime = pro_usetime;
    }

    public String getPro_expiry() {
        return pro_expiry;
    }

    public void setPro_expiry(String pro_expiry) {
        
        this.pro_expiry = pro_expiry;
    }

    public String getPro_posttime() {
        return pro_posttime;
    }

    public void setPro_posttime(String pro_posttime) {

        this.pro_posttime = pro_posttime;
    }

    public String getPro_details() {
        return pro_details;
    }

    public void setPro_details(String pro_details) {
        this.pro_details = pro_details;
    }

    public String getPro_contactNum() {
        return pro_contactNum;
    }

    public void setPro_contactNum(String pro_contactNum) {
        this.pro_contactNum = pro_contactNum;
    }

    public String getSeller_level() {
        return seller_level;
    }

    public void setSeller_level(String seller_level) {
        this.seller_level = seller_level;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public String getPro_imgPath() {
      
        return pro_imgPath;
    }
 
    public void setPro_imgPath(String pro_imgPath) {
       
        this.pro_imgPath = pro_imgPath;
    }
}
