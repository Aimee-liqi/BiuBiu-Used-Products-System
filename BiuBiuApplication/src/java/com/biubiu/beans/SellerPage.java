/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.beans;

import com.biubiu.dao.ContactDAO;
import com.biubiu.model.Contact_Buyer;
import com.biubiu.model.Contact_Seller;
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
 * @author Annie
 */
@ManagedBean(name="sell_page")
@SessionScoped 
public class SellerPage
//SellerPage
{
    private String sell_id;
    private String buy_id;
    private ArrayList<Contact_Seller> cs;
    String content;
    String time;
    
    FacesContext facescontext=FacesContext.getCurrentInstance();
    ExternalContext exContext=facescontext.getExternalContext();
    HttpSession session=(HttpSession)exContext.getSession(true);
    
    public void save(){
        sell_id=(String)session.getAttribute("Login_id");
        Contact_Buyer contact=new Contact_Buyer();
        contact.setBuy_id(buy_id);
        contact.setSell_id(sell_id);
        contact.setContent(content);
        time=setTime();
        contact.setSendtime(time);
        ContactDAO dao=new ContactDAO();
        dao.replyText(contact);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

       public void showSellerMessage()
    {
        sell_id=(String)session.getAttribute("Login_id");
        ContactDAO dao=new ContactDAO();
        cs=dao.getSellerMessage(sell_id);//Replace
    }
       public String setTime()
       {
           Date day=new Date();
           SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd HH:mm");
           String sendtime=f.format(day);
           return sendtime;
       }
    public String getSell_id() {
        sell_id=(String)session.getAttribute("Login_id");
        return sell_id;
    }

    public void setSell_id(String sell_id) {
        this.sell_id = sell_id;
    }

    public String getBuy_id() {
        return buy_id;
    }

    public void setBuy_id(String buy_id) {
        this.buy_id = buy_id;
    }

    public ArrayList<Contact_Seller> getCs() {
        return cs;
    }

    public void setCs(ArrayList<Contact_Seller> cs) {
        this.cs = cs;
    }
    
}
