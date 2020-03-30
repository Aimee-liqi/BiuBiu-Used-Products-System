/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.beans;

import com.biubiu.dao.CreateOrderDAO;
import com.biubiu.dao.PayDAO;
import com.biubiu.dao.ProductDAO;
import com.biubiu.dao.ShowOrderDAO;
import com.biubiu.model.Order;
import com.biubiu.model.payInfo;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL-PC
 */
@ManagedBean(name="pay")
@SessionScoped
public class PayBean {
    private int pay_id;
    private int ord_id;
    private String first_name;
    private String last_name;
    private String address;
    private String mobile;
    private String ccNum;
    private String ccName;
    private int cvv;
    
     public String submit(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(true);
        int ord_id=(int)session.getAttribute("Ord_id");
        System.out.println(ord_id);
        
        payInfo info=new payInfo();
        info.setOrd_id(ord_id);
        info.setAddress(address);
        info.setCcName(ccName);
        info.setCcNum(ccNum);
        info.setCvv(cvv);
        info.setFirst_name(first_name);
        info.setLast_name(last_name);
        info.setMobile(mobile);
        
        PayDAO paydao=new PayDAO();
        System.out.println("payDAO()");
        paydao.submit(info);
        
        CreateOrderDAO createdao=new CreateOrderDAO();
        createdao.UpdateOrder(ord_id);
        
        ShowOrderDAO showDAO=new ShowOrderDAO();
        ArrayList<Order> order=new ArrayList<Order>();
        order=showDAO.getOrder(ord_id);
        int pro_id=order.get(0).getPro_id();
        ProductDAO pro=new ProductDAO();
        pro.DeleteProduct(pro_id);

        return "submit";
    }

    public int getPay_id() {
        return pay_id;
    }

    public void setPay_id(int pay_id) {
        this.pay_id = pay_id;
    }

    public int getOrd_id() {
        return ord_id;
    }

    public void setOrd_id(int ord_id) {
        this.ord_id = ord_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCcNum() {
        return ccNum;
    }

    public void setCcNum(String ccNum) {
        this.ccNum = ccNum;
    }

    public String getCcName() {
        return ccName;
    }

    public void setCcName(String ccName) {
        this.ccName = ccName;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
    

   
}
