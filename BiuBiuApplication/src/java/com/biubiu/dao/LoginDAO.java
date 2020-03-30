/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.dao;

import com.biubiu.model.Buyer;
import com.biubiu.model.Seller;
import com.biubiu.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;





/**
 *
 * @author asus
 */
public class LoginDAO 
{
     public Buyer getBuyer(String buy_id)
    {
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        Session sess=sessFact.openSession();
        Buyer buy = (Buyer) sess.get(Buyer.class, buy_id);
        sess.close();
        return buy;
    }
     public Seller getSeller(String sell_id)
     {
         SessionFactory sessFact=HibernateUtil.getSessionFactory();
         Session sess=sessFact.openSession();
         Seller sell = (Seller) sess.get(Seller.class, sell_id);
         sess.close();
         return sell;
     }

}
