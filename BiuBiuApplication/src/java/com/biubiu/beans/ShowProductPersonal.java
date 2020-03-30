/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.beans;

import com.biubiu.dao.ShowProductDAO;
import com.biubiu.model.Product;
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
@ManagedBean(name="showPP")
@SessionScoped
public class ShowProductPersonal {
    private ArrayList<Product> product;
    
    FacesContext facescontext=FacesContext.getCurrentInstance();
    ExternalContext exContext=facescontext.getExternalContext();
    HttpSession session=(HttpSession)exContext.getSession(true);
    public ArrayList<Product> getProduct() {
        String sell_id=(String)session.getAttribute("Login_id");
        ShowProductDAO showdao=new ShowProductDAO();
        product=showdao.getSellerProduct(sell_id);
        return product;
    }

    public void setProduct(ArrayList<Product> product) {
        this.product = product;
    }
}
