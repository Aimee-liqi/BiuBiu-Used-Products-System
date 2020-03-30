/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.beans;

import com.biubiu.dao.ShowProductDAO;
import com.biubiu.dao.ShowSellerDAO;
import com.biubiu.model.Product;
import com.biubiu.model.Seller;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL-PC
 */
@ManagedBean(name="showSeller")
@SessionScoped
public class ShowSellerBean {
    ArrayList<Seller> seller;
    String sell_id;
    
        public ArrayList<Seller> getSeller() {
         FacesContext facescontext=FacesContext.getCurrentInstance();
         ExternalContext exContext=facescontext.getExternalContext();
         HttpSession session=(HttpSession)exContext.getSession(true);
         int pro_id=(Integer)session.getAttribute("pro_id");
         ShowProductDAO productdao=new ShowProductDAO();
         ArrayList<Product> product=new ArrayList<Product>();
         product=productdao.getProduct(pro_id);
         sell_id=product.get(1).getSeller_id();
         System.out.println(sell_id);
            ShowSellerDAO showsellerdao=new ShowSellerDAO();
            seller=showsellerdao.getSeller(sell_id);
             return seller;
    }

    public void setSeller(ArrayList<Seller> seller) {
        this.seller = seller;
    }
        public String getSell_id() {
        return sell_id;
    }

    public void setSell_id(String sell_id) {
        this.sell_id = sell_id;
    }
}
