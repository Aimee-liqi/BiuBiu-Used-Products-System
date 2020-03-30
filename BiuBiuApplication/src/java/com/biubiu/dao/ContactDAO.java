/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.dao;


import com.biubiu.model.Contact_Buyer;
import com.biubiu.model.Contact_Seller;
import com.biubiu.util.HibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Annie
 */
public class ContactDAO
{
    public boolean sendText(Contact_Seller cs) 
    {
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        Session sess=sessFact.openSession();
        Transaction trans=sess.beginTransaction();
        Serializable obj=sess.save(cs);
        trans.commit();
        sess.close();
        if(obj!=null){
            return true;
        }
        return false;
    }
    public boolean replyText(Contact_Buyer cb) 
    {
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        Session sess=sessFact.openSession();
        Transaction trans=sess.beginTransaction();
        Serializable obj=sess.save(cb);
        trans.commit();
        sess.close();
        if(obj!=null){
            return true;
        }
        return false;
    }
     public ArrayList<Contact_Seller>  getSellerMessage(String sell_id)
    {
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        Session sess=sessFact.openSession();
        Transaction trans=sess.beginTransaction();
        String query="from Contact_Seller where sell_id='"+sell_id+"'";
        Query q=sess.createQuery(query);
        ArrayList<Contact_Seller> cs=new ArrayList<Contact_Seller>();
        cs=(ArrayList<Contact_Seller>)q.list();
        trans.commit();
        return cs;
    }
     public ArrayList<Contact_Buyer>  getBuyerMessage(String buy_id)
    {
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        Session sess=sessFact.openSession();
        Transaction trans=sess.beginTransaction();
        String query="from Contact_Buyer where buy_id='"+buy_id+"'";
        Query q=sess.createQuery(query);
        ArrayList<Contact_Buyer> cb=new ArrayList<Contact_Buyer>();
        cb=(ArrayList<Contact_Buyer>)q.list();
        trans.commit();
        return cb;
    }
}
