/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.convertor;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.servlet.http.HttpSession;

/**
 *
 * @author NIIT
 */
@FacesConverter(value="CreditConverter")

public class CCConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        //what to do?
        //How to convert the value
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(true);
        if(value.length()!=16)
        {
        //Type cast the object to HtmlInputtext
            if(value.contains("-"))
            {
                return value;
                
            }
            FacesMessage message=new FacesMessage();
            message.setSummary("Invalid Credit Card Number");
            message.setDetail("The Entered Credit Card Number Seems to be Invalid");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(message);
        }
        else{//convert to a valid credit card number in correct card number
            String p1,p2,p3,p4;
            StringBuilder build=new StringBuilder();
            p1=value.substring(0,4);
            p2=value.substring(4,8);
            p3=value.substring(8,12);
            p4=value.substring(12,16);
            build.append(p1).append("-").append(p2).append("-").append(p3).append("-").append(p4);
            return build.toString();
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value.toString();
    }
    
}
