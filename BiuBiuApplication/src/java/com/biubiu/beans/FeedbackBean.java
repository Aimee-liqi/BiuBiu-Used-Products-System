/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.beans;

import com.biubiu.dao.FeedbackDAO;
import com.biubiu.model.Feedback;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author DELL-PC
 */
@ManagedBean(name="feedbackbean")
@SessionScoped

public class FeedbackBean {
    
    
    
    public String submit(Feedback feedback){
        FeedbackDAO feed_dao=new FeedbackDAO();
        System.out.println("You have run the submit()");
        boolean flag=feed_dao.insertFeedback(feedback);
        if(flag==true)
        {
            System.out.println("You have insert the feedback into the database");
        }else{
            System.out.println("Fail to insert the feed");
        }
        return "Submitted";
    }
    
    
}
