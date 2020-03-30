/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.beans;

import com.biubiu.dao.ShowBidProductDAO;
import com.biubiu.model.BidProduct;
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
@ManagedBean(name="showBid")
@SessionScoped
public class ShowBidProduct {
    private ArrayList<BidProduct> bidproduct;
    private boolean show;

    public ArrayList<BidProduct> getBidproduct() {
        ShowBidProductDAO sbpdao=new ShowBidProductDAO();
        bidproduct=sbpdao.getAllBidProduct();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(true);
        String account=(String)session.getAttribute("Login_account");
        if(account.equals("buy")){
            show=false;
        }else{
            show=true;
        }
        return bidproduct;
    }

    public void setBidproduct(ArrayList<BidProduct> bidproduct) {
        this.bidproduct = bidproduct;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}
