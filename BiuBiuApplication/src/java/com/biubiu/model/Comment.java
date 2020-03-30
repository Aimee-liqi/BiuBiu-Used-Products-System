/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Annie
 */
@ManagedBean(name="Com")
@SessionScoped
public class Comment 
{
    private int com_id;
    private int pro_id;
    private String com_detail;
    public String com_type;
    

    public String getCom_detail() {
        return com_detail;
    }

    public void setCom_detail(String com_detail) {
        this.com_detail = com_detail;
    }


    public int getCom_id() {
        return com_id;
    }

    public void setCom_id(int com_id) {
        this.com_id = com_id;
    }

    public String getCom_type() {
        return com_type;
    }

    public void setCom_type(String com_type) {
        this.com_type = com_type;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }


}
