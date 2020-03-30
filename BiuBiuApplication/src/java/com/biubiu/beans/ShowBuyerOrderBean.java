/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.beans;

import com.biubiu.dao.ShowBuyerOrderDAO;
import com.biubiu.dao.ShowSellerOrderDAO;
import com.biubiu.model.Order;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL-PC
 */
@ManagedBean(name="showBuyerOrder")
@SessionScoped
public class ShowBuyerOrderBean {
    private ArrayList<Order> Order;
    ArrayList<Order> confirmOrder;
    private boolean show;


    
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession session = (HttpSession) externalContext.getSession(true);
    
    public void getID(ActionEvent event){
        HtmlCommandButton source=(HtmlCommandButton)event.getSource();
        int ord_id=Integer.parseInt(source.getTitle());
        session.setAttribute("Ord_id", ord_id);
        System.out.println(ord_id);
    }

    public ArrayList<Order> getOrder() {
        String buy_id=(String)session.getAttribute("Login_id");
        ShowBuyerOrderDAO showdao=new ShowBuyerOrderDAO();
        Order=showdao.showOrder(buy_id);
        show=false;
        return Order;
        
    }

    public void setOrder(ArrayList<Order> Order) {
        this.Order = Order;
    }
    
        public ArrayList<Order> getConfirmOrder() {
        ShowBuyerOrderDAO showdao=new ShowBuyerOrderDAO();
        int ord_id=(int)session.getAttribute("Ord_id");
        System.out.println(ord_id);
        confirmOrder=showdao.showOrder(ord_id);
        return confirmOrder;
    }

    public void setConfirmOrder(ArrayList<Order> confirmOrder) {
        this.confirmOrder = confirmOrder;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}
