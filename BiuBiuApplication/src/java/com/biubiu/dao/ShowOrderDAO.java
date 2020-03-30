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
 * @author Administrator
 */
public class ShowOrderDAO {
        public ArrayList<Order> getOrder(int ord_id){
        ArrayList<Order> order=new ArrayList<Order>();
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        Session sess=sessFact.openSession();
        Transaction trans=sess.beginTransaction();
        String query="from Order where ord_id="+ord_id;
        Query q=sess.createQuery(query);
        order=(ArrayList<Order>)q.list();
        System.out.println("you have search the orderlist");
        trans.commit();
        sess.close();
        return order;
    }
}
