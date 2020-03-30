package com.biubiu.dao;

import com.biubiu.beans.CommentBean;
import com.biubiu.model.Buyer;
import com.biubiu.model.Comment;
import com.biubiu.model.Seller;
import com.biubiu.util.HibernateUtil;
import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NIIT
 */
public class CommentDAO
{
    public boolean insertComment(Comment c) 
    {
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        Session sess=sessFact.openSession();
        Transaction trans=sess.beginTransaction();
        Serializable obj=sess.save(c);
        trans.commit();
        sess.close();
        if(obj!=null){
            return true;
        }
        return false;
    }
   public void updateGoodScore(String sell_id,float good_score)
        {
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        Session sess=sessFact.openSession();
        Transaction trans=sess.beginTransaction();
        Seller s =(Seller)sess.load(Seller.class,sell_id);
        //s.setSell_good();
        s.setSell_good(good_score);
        sess.update(s);
        trans.commit();
        sess.close();
        }
   
      public void updateBadScore(String sell_id,float bad_score)
        {
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        Session sess=sessFact.openSession();
        Transaction trans=sess.beginTransaction();
        Seller s =(Seller)sess.load(Seller.class,sell_id);
        //s.setSell_good();
        s.setSell_bad(bad_score);
        sess.update(s);
        trans.commit();
        sess.close();
        }
     public Seller getScore(String sell_id)
    {
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        Session sess=sessFact.openSession();
        Seller sell= (Seller) sess.get(Seller.class, sell_id);
        sess.close();
        return sell;
    }
      public void updateTimes(String buy_id,int times)
        {
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        Session sess=sessFact.openSession();
        Transaction trans=sess.beginTransaction();
        Buyer b =(Buyer)sess.load(Buyer.class,buy_id);
        //s.setSell_good();
        b.setBuy_times(times);
        sess.update(b);
        trans.commit();
        sess.close();
        }
      public Buyer getTimes(String buy_id)
    {
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        Session sess=sessFact.openSession();
        Buyer buy= (Buyer) sess.get(Buyer.class, buy_id);
        sess.close();
        return buy;
    }
      public void updateBuyerLevel(String buy_id,String level)
        {
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        Session sess=sessFact.openSession();
        Transaction trans=sess.beginTransaction();
        Buyer b =(Buyer)sess.load(Buyer.class,buy_id);
        //s.setSell_good();
        b.setBuy_level(level);
        sess.update(b);
        trans.commit();
        sess.close();
        }
      public void updateSellerLevel(String sell_id,String level)
        {
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        Session sess=sessFact.openSession();
        Transaction trans=sess.beginTransaction();
        Seller s =(Seller)sess.load(Seller.class,sell_id);
        //s.setSell_good();
        s.setSell_level(level);
        sess.update(s);
        trans.commit();
        sess.close();
        }
}
