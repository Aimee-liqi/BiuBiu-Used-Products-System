/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.dao;

import com.biubiu.model.Buyer;
import com.biubiu.model.Seller;
import com.biubiu.util.HibernateUtil;
import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Annie
 */
public class RegisterDAO
{
    public boolean insertSeller(Seller s) 
    {
       //need a session factory
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        //use a session to open a new session
        Session sess=sessFact.openSession();
        Transaction trans=sess.beginTransaction();
        //save the new student
        Serializable obj=sess.save(s);
        trans.commit();
        sess.close();
        if(obj!=null){
            return true;
        }
        return false;
    }
     public boolean insertBuyer(Buyer b) 
    {
       //need a session factory
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        //use a session to open a new session
        Session sess=sessFact.openSession();
        Transaction trans=sess.beginTransaction();
        //save the new student
        Serializable obj=sess.save(b);
        trans.commit();
        sess.close();
        if(obj!=null){
            return true;
        }
        return false;
    }
        
}
        
