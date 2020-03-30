/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.beans;

import com.biubiu.dao.CreateOrderDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.event.ActionEvent;

/**
 *
 * @author DELL-PC
 */

@ManagedBean(name="createorder")
@SessionScoped
public class CreateOrderBean {
    public void createOrder(ActionEvent event){
        HtmlCommandButton source=(HtmlCommandButton)event.getSource();
        int bidp_id=Integer.parseInt(source.getTitle());
        System.out.println(bidp_id);
        CreateOrderDAO createdao=new CreateOrderDAO();
        createdao.createNewOrder(bidp_id);
    }
}
