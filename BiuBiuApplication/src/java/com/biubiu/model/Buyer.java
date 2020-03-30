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
@ManagedBean(name="Buy")
@SessionScoped
public class Buyer 
{
    private String buy_id; 
    private String buy_name;
    private String buy_pass;
    private String buy_level; 
    private int buy_times;
    
    public String getBuy_id() {
        return buy_id;
    }

    public void setBuy_id(String buy_id) {
        this.buy_id = buy_id;
    }

    public String getBuy_name() {
        return buy_name;
    }

    public void setBuy_name(String buy_name) {
        this.buy_name = buy_name;
    }

    public String getBuy_pass() {
        return buy_pass;
    }

    public void setBuy_pass(String buy_pass) {
        this.buy_pass = buy_pass;
    }

    public String getBuy_level() {
        return buy_level;
    }

    public void setBuy_level(String buy_level) {
        this.buy_level = buy_level;
    }

    public int getBuy_times() {
        return buy_times;
    }

    public void setBuy_times(int buy_times) {
        this.buy_times = buy_times;
    }
}
