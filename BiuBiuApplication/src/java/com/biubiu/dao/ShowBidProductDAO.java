/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.dao;

import com.biubiu.model.BidProduct;
import com.biubiu.model.Product;
import com.biubiu.util.HibernateUtil;
import java.util.ArrayList;
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
public class ShowBidProductDAO {
    public ArrayList<BidProduct> getAllBidProduct(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(true);
        String account=(String)session.getAttribute("Login_account");
        String id=(String)session.getAttribute("Login_id");
        ArrayList<BidProduct> bidList = new ArrayList<BidProduct>();
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        //use a session to open a new session
        Session sess=sessFact.openSession();
        Transaction trans=sess.beginTransaction();
        String query="from BidProduct where "+account+"_id='"+id+"'";
        Query q=sess.createQuery(query);
        bidList=(ArrayList<BidProduct>)q.list();
        trans.commit();
        sess.close();
        return bidList;
    }
    
    public ArrayList<BidProduct>getBidProduct(int bid_id){
        ArrayList<BidProduct> bidList = new ArrayList<BidProduct>();
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        //use a session to open a new session
        Session sess=sessFact.openSession();
        Transaction trans=sess.beginTransaction();
        String query="from BidProduct where id="+bid_id;
        Query q=sess.createQuery(query);
        bidList=(ArrayList<BidProduct>)q.list();
        trans.commit();
        sess.close();
        return bidList;
    }
}
