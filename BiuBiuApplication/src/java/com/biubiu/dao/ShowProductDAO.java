/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.dao;

import com.biubiu.model.Product;
import com.biubiu.util.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author DELL-PC
 */
public class ShowProductDAO {
    public ArrayList<Product> getProduct(int id){
        System.out.println("you have run the showProductDAO()");
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        Session sess=sessFact.openSession();
        Transaction trans=sess.beginTransaction();
        String query="from Product where pro_id="+""+id+"";
        Query q=sess.createQuery(query);
        ArrayList<Product> product=new ArrayList<Product>();
        product=(ArrayList<Product>)q.list();
        return product;
    }
        public ArrayList<Product> getSellerProduct(String sell_id){
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        Session sess=sessFact.openSession();
        Transaction trans=sess.beginTransaction();
        String query="from Product where sell_id='"+sell_id+"'";
        Query q=sess.createQuery(query);
        ArrayList<Product> product=new ArrayList<Product>();
        product=(ArrayList<Product>)q.list();
        return product;
    }
}
