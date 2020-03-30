/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.beans;

import com.biubiu.dao.ConfirmProductDAO;
import com.biubiu.model.ConfirmProduct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author DELL-PC
 */
@ManagedBean(name="confirm")
@SessionScoped
public class ConfirmProductBean {
    private ConfirmProduct con_product;

    public ConfirmProduct getCon_product() {
        ConfirmProductDAO con_productDAO=new ConfirmProductDAO();
        con_product=con_productDAO.getConfirmProduct();
        return con_product;
    }

    public void setCon_product(ConfirmProduct con_product) {
        this.con_product = con_product;
    }
}
