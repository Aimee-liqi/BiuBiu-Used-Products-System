/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.dao;

import com.biubiu.model.Comment;
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
public class ShowCommentDAO {
    public ArrayList<Comment> showComment(int id){
        ArrayList<Comment> comment=new ArrayList<Comment>();
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        Session sess=sessFact.openSession();
        Transaction trans=sess.beginTransaction();
        String query="from Comment where pro_id="+id;
        Query q=sess.createQuery(query);
        comment=(ArrayList<Comment>)q.list();
        trans.commit();
        return comment;
    }
}
