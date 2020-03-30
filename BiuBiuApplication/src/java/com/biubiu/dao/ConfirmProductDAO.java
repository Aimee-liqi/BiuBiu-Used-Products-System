/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.dao;

import com.biubiu.model.Buyer;
import com.biubiu.model.ConfirmProduct;
import com.biubiu.model.Product;
import java.util.ArrayList;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL-PC
 */
public class ConfirmProductDAO {
    public ConfirmProduct getConfirmProduct(){
            FacesContext facescontext=FacesContext.getCurrentInstance();
            ExternalContext exContext=facescontext.getExternalContext();
            HttpSession session=(HttpSession)exContext.getSession(true);
            int id=(int)session.getAttribute("pro_id");
            float buyPrice=(float) session.getAttribute("buyer_Price");
            
            
            ProductDAO productdao=new ProductDAO();
            Product product=new Product();
            product=productdao.getProduct(id);
            String pro_name=product.getPro_name();
            float pro_minPrice=product.getPro_minPrice();
            float pro_origPrice=product.getPro_origPrice();
            
            ConfirmProduct con_product=new ConfirmProduct();
            con_product.setPro_id(id);
            con_product.setPro_name(pro_name);
            con_product.setBuyPrice(buyPrice);
            con_product.setOrigPrice(pro_origPrice);
            con_product.setMinPrice(pro_minPrice);
            
            return con_product;
    }
}
