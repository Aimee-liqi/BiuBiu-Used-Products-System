/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.beans;

import com.biubiu.dao.ShowBuyInfoDAO;
import com.biubiu.dao.ShowSellerDAO;
import com.biubiu.dao.ShowSellerOrderDAO;
import com.biubiu.model.Order;
import com.biubiu.model.Seller;
import com.biubiu.model.payInfo;
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

@ManagedBean(name="showB")
@SessionScoped
public class ShowBuyerPayInfo {
    private ArrayList<payInfo> payinfo;
    
    FacesContext facescontext=FacesContext.getCurrentInstance();
    ExternalContext exContext=facescontext.getExternalContext();
    HttpSession session=(HttpSession)exContext.getSession(true);

    public ArrayList<payInfo> getPayinfo() {
        payinfo=null;
        String sell_id=(String)session.getAttribute("Login_id");
        ArrayList<Seller> seller=new ArrayList<Seller>();
        ShowSellerDAO showdao=new ShowSellerDAO();
        seller=showdao.getSeller(sell_id);
        String sell_name=seller.get(0).getSell_name();
        ArrayList<Order> Order=new ArrayList<Order>();
        ShowSellerOrderDAO orderDAO=new ShowSellerOrderDAO();
        if(orderDAO.showOrder(sell_name)!=null){
            Order=orderDAO.showOrder(sell_name);
            if(orderDAO.showOrder(sell_name)!=null){
                int ord_id=Order.get(0).getOrd_id();
            ShowBuyInfoDAO showbuydao=new ShowBuyInfoDAO();
            if(showbuydao.show(ord_id)!=null){
                payinfo=showbuydao.show(ord_id);
                return payinfo;
            }else{
                return null;
            }
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    public void setPayinfo(ArrayList<payInfo> payinfo) {
        this.payinfo = payinfo;
    }
    
}
