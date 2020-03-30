/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.dao;

import com.biubiu.model.Seller;
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
public class ShowSellerDAO {
    public ArrayList<Seller> getSeller(String id){
        System.out.println("you have run the showSellerDAO()");
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        Session sess=sessFact.openSession();
        Transaction trans=sess.beginTransaction();
        String query="from Seller where sell_id='"+id+"'";
        Query q=sess.createQuery(query);
        ArrayList<Seller> seller=new ArrayList<Seller>();
        seller=(ArrayList<Seller>)q.list();
        trans.commit();
        return seller;
    }
}
