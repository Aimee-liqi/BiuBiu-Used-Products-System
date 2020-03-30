/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.dao;

import com.biubiu.model.BidProduct;
import com.biubiu.model.Buyer;
import com.biubiu.model.Product;
import com.biubiu.util.HibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author DELL-PC
 */

public class BidDAO {
    public void bid(){
            FacesContext facescontext=FacesContext.getCurrentInstance();
            ExternalContext exContext=facescontext.getExternalContext();
            HttpSession session=(HttpSession)exContext.getSession(true);
            int pro_id=(int) session.getAttribute("pro_id");
            float buy_price=(float)session.getAttribute("buyer_Price");
            String buy_id=(String)session.getAttribute("Login_id");
            ArrayList<Buyer> buy=new ArrayList<Buyer>();
            ShowBuyerDAO showDAO=new ShowBuyerDAO();
            buy=showDAO.getBuyer(buy_id);
            String buy_name=buy.get(0).getBuy_name();
            
            ProductDAO productdao=new ProductDAO();
            Product product=new Product();
            product=productdao.getProduct(pro_id);
            String pro_name=product.getPro_name();
            float pro_minPrice=product.getPro_minPrice();
            String sell_id=product.getSeller_id();
            System.out.println(pro_id);
            System.out.println(pro_name);
            System.out.println(buy_price);
            System.out.println(pro_minPrice);
            
            BidProduct b_product=new BidProduct();
            b_product.setPro_id(pro_id);
            b_product.setPro_name(pro_name);
            b_product.setBuy_price(buy_price);
            b_product.setPro_minPrice(pro_minPrice);
            b_product.setBuy_id(buy_id);
            b_product.setBuy_name(buy_name);
            b_product.setSell_id(sell_id);
            
            SessionFactory sessFact=HibernateUtil.getSessionFactory();
            Session sess=sessFact.openSession();
            Transaction trans=sess.beginTransaction();
            Serializable obj=sess.save(b_product);
            trans.commit();
            
            sess.close();
            
            
    }
    
    public void delete(int pro_id){
        System.out.println(pro_id);
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        Session sess=sessFact.openSession();
        Transaction trans=sess.beginTransaction();
        String query="Delete FROM BidProduct Where pro_id="+pro_id;
        sess.createQuery(query).executeUpdate();
        
        trans.commit();
        sess.close();
    }
}
