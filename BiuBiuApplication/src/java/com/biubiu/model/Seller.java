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
@ManagedBean(name="Sell")
@SessionScoped
public class Seller 
{
    private String sell_id ;
    private String sell_name;
    private String sell_pass;
    private String sell_level;
    private String sell_contact;
    private float sell_good;
    private float sell_bad;

    public Seller(){
        
    }
    public Seller(String id,String name,String pass,String level,String contact)
    {
        sell_id=id;
        sell_name=name;
        sell_pass=pass;
        sell_level=level;
        sell_contact=contact;
    }
    public String getSell_id() {
        return sell_id;
    }

    public void setSell_id(String sell_id) {
        this.sell_id = sell_id;
    }

    public String getSell_name() {
        return sell_name;
    }

    public void setSell_name(String sell_name) {
        this.sell_name = sell_name;
    }

    public String getSell_pass() {
        return sell_pass;
    }

    public void setSell_pass(String sell_pass) {
        this.sell_pass = sell_pass;
    }

    public String getSell_level() {
        return sell_level;
    }

    public void setSell_level(String sell_level) {
        this.sell_level = sell_level;
    }

    public String getSell_contact() {
        return sell_contact;
    }

    public void setSell_contact(String sell_contact) {
        this.sell_contact = sell_contact;
    }

    public float getSell_good() {
        return sell_good;
    }

    public void setSell_good(float sell_good) {
        this.sell_good = sell_good;
    }

    public float getSell_bad() {
        return sell_bad;
    }

    public void setSell_bad(float sell_bad) {
        this.sell_bad = sell_bad;
    }

}