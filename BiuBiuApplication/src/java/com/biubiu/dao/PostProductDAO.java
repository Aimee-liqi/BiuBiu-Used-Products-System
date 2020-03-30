/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.dao;

import com.biubiu.beans.ProductBean;
import com.biubiu.model.Product;
import com.biubiu.model.Seller;
import com.biubiu.util.HibernateUtil;
import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Anasitasia
 */
public class PostProductDAO {
    
    public boolean postProduct(Product p) 
    {
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        Session sess=sessFact.openSession();
        Transaction trans=sess.beginTransaction();
        Serializable obj=sess.save(p);
        trans.commit();
        sess.close();
        if(obj!=null){
            return true;
        }
        return false;
    }
    
    
}
