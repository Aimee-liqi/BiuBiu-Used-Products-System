/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.dao;

import com.biubiu.model.Buyer;
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
public class ShowBuyerDAO {
    public ArrayList<Buyer> getBuyer(String id){
        System.out.println("you have run the showSellerDAO()");
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        Session sess=sessFact.openSession();
        Transaction trans=sess.beginTransaction();
        String query="from Buyer where buy_id='"+id+"'";
        Query q=sess.createQuery(query);
        ArrayList<Buyer> buyer=new ArrayList<Buyer>();
        buyer=(ArrayList<Buyer>)q.list();
        trans.commit();
        return buyer;
    }
}
