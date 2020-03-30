/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.beans;

import com.biubiu.dao.ShowSellerDAO;
import com.biubiu.dao.ShowSellerOrderDAO;
import com.biubiu.model.Order;
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
@ManagedBean(name="showSellerOrder")
@SessionScoped
public class ShowSellerOrderBean {
    private ArrayList<Order> Order;

    public ArrayList<Order> getOrder() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(true);
        String sell_id=(String)session.getAttribute("Login_id");
        ArrayList<Seller> seller=new ArrayList<Seller>();
        ShowSellerDAO showdao=new ShowSellerDAO();
        seller=showdao.getSeller(sell_id);
        String sell_name=seller.get(0).getSell_name();
        
        ShowSellerOrderDAO orderDAO=new ShowSellerOrderDAO();
        Order=orderDAO.showOrder(sell_name);
        return Order;
    }

    public void setOrder(ArrayList<Order> Order) {
        this.Order = Order;
    }
}
