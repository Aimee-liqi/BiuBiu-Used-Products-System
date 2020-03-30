/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.dao;

import com.biubiu.model.payInfo;
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
public class ShowBuyInfoDAO {
    public ArrayList<payInfo>show(int ord_id){
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        Session sess=sessFact.openSession();
        Transaction trans=sess.beginTransaction();
        String query="from payInfo where ord_id="+ord_id;
        Query q=sess.createQuery(query);
        ArrayList<payInfo> payinfo=new ArrayList<payInfo>();
        payinfo=(ArrayList<payInfo>)q.list();
        return payinfo;
    }
}
