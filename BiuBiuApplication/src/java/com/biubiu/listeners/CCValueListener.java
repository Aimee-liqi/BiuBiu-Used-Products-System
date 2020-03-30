/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.listeners;

import javax.faces.component.html.HtmlInputText;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

/**
 *
 * @author NIIT
 */
public class CCValueListener implements ValueChangeListener{
    //The event is ValueChangeEvent
    @Override
    public void processValueChange(ValueChangeEvent event) throws AbortProcessingException {
        //what to do when the value changes
        //I want to check the length of input
        //I need the UI component
        HtmlInputText ui=(HtmlInputText)event.getSource();
        //Type cast the object to HtmlInputtext
        String value=event.getNewValue().toString();//the present value in the UI component
        if(value.length()==16){
            ui.setStyle("color:green");
        }
        else{
            ui.setStyle("color:red");
        }
        
    }
    
}
