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
 * @author DELL-PC
 */
@ManagedBean(name="feedback")
@SessionScoped

    public class Feedback {
    private String id;
    private String content;
    
    public Feedback(){
    
    }
    public Feedback(String f_id,String f_content){
        id=f_id;
        content=f_content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
