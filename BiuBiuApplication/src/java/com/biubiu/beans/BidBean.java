/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.beans;

import com.biubiu.dao.BidDAO;
import com.biubiu.model.Buyer;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL-PC
 */

@ManagedBean(name="bid")
@SessionScoped
public class BidBean {
    private float price;
    private boolean result=false;
    String value;
    Buyer buyer;
    private String showValue;

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }
    
    public void bidPrice(ValueChangeEvent event){
        HtmlInputText source=(HtmlInputText)event.getSource();
        price=Float.parseFloat((String)event.getNewValue());
        FacesContext facescontext=FacesContext.getCurrentInstance();
        ExternalContext exContext=facescontext.getExternalContext();
        HttpSession session=(HttpSession)exContext.getSession(true);
        session.setAttribute("buyer_Price", price);
        float minPrice=(float)session.getAttribute("pro_minPrice");
        System.out.println(price);
        
            if(price>=minPrice)
            {
                if(price>99999999){
                    result=true;
                    value="the price is low";
                    showValue="the price is so expensive";
                }else{
                    String text=(String)session.getAttribute("isLogined");
                    if(text.equals("true")){
                        result=false;
                        value="shopping confirm";

                    }else{
                        result=false;
                        value="buyer login";
                    }
                }
            }else{
                result=true;
                value="the price is low";
                showValue="the price is low";
                System.out.println(result);
                }
    }
    
    
    public String cancel(){
        return "cancel the shopping";
    }
    
    public String confirm(){
        BidDAO bidDAO=new BidDAO();
        bidDAO.bid();
        FacesContext facescontext=FacesContext.getCurrentInstance();
        ExternalContext exContext=facescontext.getExternalContext();
        HttpSession session=(HttpSession)exContext.getSession(true);
        session.invalidate();
        return "confirm the shopping";
    }
    
    public String operation(){
        return value;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getShowValue() {
        return showValue;
    }

    public void setShowValue(String showValue) {
        this.showValue = showValue;
    }
}
