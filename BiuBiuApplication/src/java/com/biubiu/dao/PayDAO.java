/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.dao;

import com.biubiu.model.payInfo;
import com.biubiu.util.HibernateUtil;
import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author DELL-PC
 */
public class PayDAO {
    public void submit(payInfo info){
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        //use a session to open a new session
        Session sess=sessFact.openSession();
        Transaction trans=sess.beginTransaction();
        //save the new student
        Serializable obj=sess.save(info);
        System.out.println("you have save the pay");
        trans.commit();
        sess.close();
    }
}
