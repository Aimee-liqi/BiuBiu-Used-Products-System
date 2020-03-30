/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.beans;

import com.biubiu.dao.ShowBuyerDAO;
import com.biubiu.dao.ShowSellerDAO;
import com.biubiu.model.Buyer;
import com.biubiu.model.Seller;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL-PC
 */
@ManagedBean(name="showP")
@SessionScoped
public class ShowPersonBean {
    private ArrayList<Buyer> buyer;
    private ArrayList<Seller> seller;

    FacesContext facescontext=FacesContext.getCurrentInstance();
    ExternalContext exContext=facescontext.getExternalContext();
    HttpSession session=(HttpSession)exContext.getSession(true);
    public ArrayList<Buyer> getBuyer() {
        String buy_id=(String)session.getAttribute("Login_id");
        ShowBuyerDAO showdao=new ShowBuyerDAO();
        buyer=showdao.getBuyer(buy_id);
        return buyer;
    }

    public void setBuyer(ArrayList<Buyer> buyer) {
        this.buyer = buyer;
    }

    public ArrayList<Seller> getSeller() {
        String sell_id=(String)session.getAttribute("Login_id");
        ShowSellerDAO showdao=new ShowSellerDAO();
        seller=showdao.getSeller(sell_id);
        return seller;
    }

    public void setSeller( ArrayList<Seller> seller) {
        this.seller = seller;
    }
    
}
