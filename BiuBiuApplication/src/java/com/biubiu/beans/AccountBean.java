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
@ManagedBean(name="account")
@SessionScoped
public class AccountBean {
    private String account;

    public String getAccount() {
        FacesContext facescontext=FacesContext.getCurrentInstance();
        ExternalContext exContext=facescontext.getExternalContext();
        HttpSession session=(HttpSession)exContext.getSession(true);
        if(session.getAttribute("isLogined")==null)
        {
            session.setAttribute("isLogined", "false");
            account="Account";
        }else if(((String)session.getAttribute("isLogined")).equals("false")){
            account="Account";
        }else{
            String login_id=(String)session.getAttribute("Login_id");
            String login_account=(String)session.getAttribute("Login_account");
            if(login_account.equals("buy")){
                ArrayList<Buyer> buyer=new ArrayList<Buyer>();
                ShowBuyerDAO showdao=new ShowBuyerDAO();
                buyer=showdao.getBuyer(login_id);
                account=buyer.get(0).getBuy_name();
            }else{
                ArrayList<Seller> seller=new ArrayList<Seller>();
                ShowSellerDAO showdao=new ShowSellerDAO();
                seller=showdao.getSeller(login_id);
                account=seller.get(0).getSell_name();
            }
        }
        return account;
    }
    
    public String logout(){
        FacesContext facescontext=FacesContext.getCurrentInstance();
        ExternalContext exContext=facescontext.getExternalContext();
        HttpSession session=(HttpSession)exContext.getSession(true);
        session.removeAttribute("Login_account");
        session.removeAttribute("Login_id");
        System.out.println("you have log out");
        session.setAttribute("isLogined", "false");
        return "Log out";
        
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
