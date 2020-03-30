/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.dao;

import com.biubiu.model.Product;
import com.biubiu.util.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author DELL-PC
 */
public class ProductDAO {
    Product product;


    public ArrayList<ArrayList>getAllProducts(){
        System.out.println("you have run the getAllProduct()");
        ArrayList<ArrayList> infoList = new ArrayList<ArrayList>();
        ArrayList<Product> proList = new ArrayList<Product>();
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        //use a session to open a new session
        Session sess=sessFact.openSession();
        Transaction trans=sess.beginTransaction();
        String level="SSR";
        String query="from Product where sell_level='"+level+"'";
        Query q=sess.createQuery(query);
        proList=(ArrayList<Product>)q.list();
        int k = 0;
        int result = (int) Math.ceil(proList.size() / 3.0);
        System.out.println(result);
        for (int i = 0; i < result; i++) {
            ArrayList<Product> info = new ArrayList<Product>();
            for (int j = 0; j < 3; j++) {
                    if (k < proList.size()) 
                    {  
                            info.add(proList.get(k));
                            k++;
                    } else {
                        break;
                    }
            }
            infoList.add(info);

        }
        return infoList;

    }
    
        public Product getProduct(int id) {
            SessionFactory sessFact=HibernateUtil.getSessionFactory();
            Session sess=sessFact.openSession();
            Product product=(Product)sess.get(Product.class, id);
            sess.close();
            return product;
    }
        
        public ArrayList<ArrayList>getProducts(String query){
        
        ArrayList<ArrayList> infoList = new ArrayList<ArrayList>();
        ArrayList<Product> proList = new ArrayList<Product>();
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        Session sess=sessFact.openSession();
        Transaction trans=sess.beginTransaction();
        Query q=sess.createQuery(query);
        proList=(ArrayList<Product>)q.list();
        infoList=transList( proList);
        return infoList;

       }
        public ArrayList<ArrayList> transList(ArrayList<Product> proList)
    {
        ArrayList<ArrayList> infoList = new ArrayList<ArrayList>();
        int k = 0;
        int result = (int) Math.ceil(proList.size() / 3.0);
        System.out.println(result);
        for (int i = 0; i < result; i++) {
            ArrayList<Product> info = new ArrayList<Product>();
            for (int j = 0; j < 3; j++) {
                    if (k < proList.size()) 
                    {  
                            info.add(proList.get(k));
                            k++;
                    } else {
                        break;
                    }
            }
            infoList.add(info);
            
        }
        return infoList;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    public ArrayList<ArrayList>getProductsType(String value){
        
        ArrayList<ArrayList> infoList = new ArrayList<ArrayList>();
        ArrayList<Product> proList = new ArrayList<Product>();
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        Session sess=sessFact.openSession();
        Transaction trans=sess.beginTransaction();
        String query="from Product where pro_type=:value"; 
        Query q=sess.createQuery(query);
        q.setString("value", value);
        proList=(ArrayList<Product>)q.list();
        infoList=transList( proList);
        return infoList;

       }
    
    public ArrayList<ArrayList> searchName(String name) {
        ArrayList<ArrayList> infoList = new ArrayList<ArrayList>();
        ArrayList<Product> proList = new ArrayList<Product>();
        SessionFactory sessFact = HibernateUtil.getSessionFactory();
        Session sess = sessFact.openSession();
        Transaction trans = sess.beginTransaction();
        String query = "from Product where pro_name like '%" + name + "%'";
        Query q = sess.createQuery(query);
        proList = (ArrayList<Product>) q.list();
        infoList = transList(proList);
        return infoList;

    }
    
        public void DeleteProduct(int pro_id){
        SessionFactory sessFact=HibernateUtil.getSessionFactory();
        Session sess=sessFact.openSession();
        Transaction trans=sess.beginTransaction();
        String query="Delete from Product where pro_id="+pro_id;
        sess.createQuery(query).executeUpdate();
        System.out.println("you have delete the orderlist");
        trans.commit();
        sess.close();
    }
}
