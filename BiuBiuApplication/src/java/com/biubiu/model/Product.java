/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.model;

/**
 *
 * @author DELL-PC
 */
public class Product {
    private int pro_id;
    private String pro_name;
    private String pro_type;
    private float pro_minPrice;
    private float pro_origPrice;
    private String pro_usetime;
    private String pro_expiry;
    private String pro_posttime;
    private String pro_details;
    private String pro_contactNum;
    private String seller_level;
    private String seller_id;
    private String pro_imgPath;
    
    public Product(){
        super();
    }
    
    public Product(int id,String name,String type,float minPrice,float origPrice,String usetime,String exipry,String posttime,String details,String contactNum,String level,String sid){
        pro_id=id;
        pro_name=name;
        pro_type=type;
        pro_minPrice=minPrice;
        pro_origPrice=origPrice;
        pro_usetime=usetime;
        pro_expiry=exipry;
        pro_posttime=posttime;
        pro_details=details;
        pro_contactNum=contactNum;
        seller_level=level;
        seller_id=sid;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public String getPro_type() {
        return pro_type;
    }

    public void setPro_type(String pro_type) {
        this.pro_type = pro_type;
    }

    public float getPro_minPrice() {
        return pro_minPrice;
    }

    public void setPro_minPrice(float pro_minPrice) {
        this.pro_minPrice = pro_minPrice;
    }

    public float getPro_origPrice() {
        return pro_origPrice;
    }

    public void setPro_origPrice(float pro_origPrice) {
        this.pro_origPrice = pro_origPrice;
    }

    public String getPro_usetime() {
        return pro_usetime;
    }

    public void setPro_usetime(String pro_usetime) {
        this.pro_usetime = pro_usetime;
    }

    public String getPro_expiry() {
        return pro_expiry;
    }

    public void setPro_expiry(String pro_expiry) {
        this.pro_expiry = pro_expiry;
    }

    public String getPro_posttime() {
        return pro_posttime;
    }

    public void setPro_posttime(String pro_posttime) {
        this.pro_posttime = pro_posttime;
    }

    public String getPro_details() {
        return pro_details;
    }

    public void setPro_details(String pro_details) {
        this.pro_details = pro_details;
    }

    public String getPro_contactNum() {
        return pro_contactNum;
    }

    public void setPro_contactNum(String pro_contactNum) {
        this.pro_contactNum = pro_contactNum;
    }

    public String getSeller_level() {
        return seller_level;
    }

    public void setSeller_level(String seller_level) {
        this.seller_level = seller_level;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public String getPro_imgPath() {
        return pro_imgPath;
    }

    public void setPro_imgPath(String pro_imgPath) {
        this.pro_imgPath = pro_imgPath;
    }
    
}
