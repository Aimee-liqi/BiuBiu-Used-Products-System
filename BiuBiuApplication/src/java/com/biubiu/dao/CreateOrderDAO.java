/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.dao;

import com.biubiu.model.BidProduct;
import com.biubiu.model.Order;
import com.biubiu.model.Product;
import com.biubiu.model.Seller;
import com.biubiu.util.HibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author DELL-PC
 */
public class CreateOrderDAO {
    public void createNewOrder(int bidp_id){
        System.out.println("You have run createOrderDAO");
        ArrayList<BidProduct> bid_product=new ArrayList<BidProduct>();
        ShowBidProductDAO showDAO=new ShowBidProductDAO();
        bid_product=showDAO.getBidProduct(bidp_id);
        ArrayList<Seller> seller=new ArrayList<Seller>();
        ShowSellerDAO showselldao=new ShowSellerDAO();
        seller=showselldao.getSeller(bid_product.get(0).getSell_id());
        String sell_name=seller.get(0).getSell_name();
        
        Order order=new Order();
        order.setBidp_id(bidp_id);
        order.setBuy_id(bid_product.get(0).getBuy_id());
        order.setBuy_price(bid_product.get(0).getBuy_price());
        order.setPro_id(bid_product.get(0).getPro_id());
        order.setPro_name(bid_product.get(0).getPro_name());
        order.setSell_price(bid_product.get(0).getPro_minPrice());
        order.setSell_name(sell_name);
        order.setOrd_state("unpaid");
        
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        Session sess=sessFact.openSession();
        Transaction trans=sess.beginTransaction();
        Serializable obj=sess.save(order);
        trans.commit();
        
        BidDAO bidDAO=new BidDAO();
        bidDAO.delete(bid_product.get(0).getPro_id());
        System.out.println("you have delete");
            
        sess.close();
    }
    public void UpdateOrder(int ord_id){
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        Session sess=sessFact.openSession();
        Transaction trans=sess.beginTransaction();
        String query="Update Order set ord_state='paid' where ord_id="+ord_id;
        sess.createQuery(query).executeUpdate();
        System.out.println("you have update the orderlist");
        trans.commit();
        sess.close();
    }
}
