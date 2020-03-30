/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.dao;

import com.biubiu.model.Feedback;
import com.biubiu.util.HibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author DELL-PC
 */
public class FeedbackDAO {
    public boolean insertFeedback(Feedback fd){
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        //use a session to open a new session
        Session sess=sessFact.openSession();
        Transaction trans=sess.beginTransaction();
        //save the new student
        Serializable obj=sess.save(fd);
        trans.commit();
        sess.close();
        if(obj!=null){
            return true;
        }
        return false;
    }
    
    public ArrayList<Feedback> getAllFeedback(String id){
        ArrayList<Feedback> feedback=new ArrayList<Feedback>();
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        Session sess=sessFact.openSession();
        Transaction trans=sess.beginTransaction();
        String query="from Feedback where id='"+id+"'";
        Query q=sess.createQuery(query);
        feedback=(ArrayList<Feedback>)q.list();
        trans.commit();
        sess.close();
        return feedback;
    }
}
