/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.dao;

import com.biubiu.model.Order;
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
public class ShowSellerOrderDAO {
    public ArrayList<Order> showOrder(String name){
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        Session sess=sessFact.openSession();
        Transaction trans=sess.beginTransaction();
        String query="from Order where sell_name='"+name+"'";
        Query q=sess.createQuery(query);
        ArrayList<Order> order=new ArrayList<Order>();
        order=(ArrayList<Order>)q.list();
        return order;
    }
}
