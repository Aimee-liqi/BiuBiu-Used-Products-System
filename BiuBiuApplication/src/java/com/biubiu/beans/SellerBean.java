/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.beans;

import com.biubiu.dao.RegisterDAO;
import com.biubiu.model.Seller;
import com.biubiu.service.LoginService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Annie
 */
@ManagedBean(name="Seller")
@SessionScoped
public class SellerBean 
{
    private String login_email;
    private String login_pass;
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession session = (HttpSession) externalContext.getSession(true);
    Seller sell;
    public String login()
    {
        LoginService service=new LoginService();
        sell=service.check_sell(login_email, login_pass);
        if(sell!=null)
        {
            System.out.println("Login Successful");
            session.setAttribute("isLogined", "true");
            session.setAttribute("Login_id", login_email);
            session.setAttribute("Login_account", "sell");
            return "success";
        }
        else
        {
            System.out.println("ID or Password is not correct");
            return "error";
        }
    }
     public String register(Seller s)
     {
         RegisterDAO dao=new RegisterDAO();
         Boolean flag=dao.insertSeller(s);
         if(flag==true)
         {
              return "success";
         }
         else
         {
             return "error";
         }
     }
    public String getLogin_email() {
        return login_email;
    }

    public void setLogin_email(String login_email) {
        this.login_email = login_email;
    }

    public String getLogin_pass() {
        return login_pass;
    }

    public void setLogin_pass(String login_pass) {
        this.login_pass = login_pass;
    }

    public Seller getSell() {
        return sell;
    }

    public void setSell(Seller sell) {
        this.sell = sell;
    }

   
}
