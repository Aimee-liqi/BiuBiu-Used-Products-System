/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.beans;

import com.biubiu.dao.RegisterDAO;
import com.biubiu.model.Buyer;
import com.biubiu.model.Seller;
import com.biubiu.service.LoginService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author asus
 */
@ManagedBean(name="Buyer")
@SessionScoped
public class BuyerBean 
{
    private String login_email;
    private String login_pass;
    Buyer buy;
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession session = (HttpSession) externalContext.getSession(true);
    
     public String register(Buyer b)
     {
         RegisterDAO dao=new RegisterDAO();
         Boolean flag=dao.insertBuyer(b);
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
    public String login()
    {
        LoginService service=new LoginService();
        buy=service.check_buy(login_email, login_pass);
        if(buy!=null)
        {
            System.out.println("Login Successful");
            session.setAttribute("isLogined", "true");
            session.setAttribute("Login_id", login_email);
            session.setAttribute("Login_account", "buy");
            return "success";
        }
        else
        {
            session.setAttribute("isLogined", "false");
            System.out.println("Buyer ID or Password   is not correct");
            return "error";
        }
    }

    public Buyer getBuy() {
        return buy;
    }

    public void setBuy(Buyer buy) {
        this.buy = buy;
    }
}
