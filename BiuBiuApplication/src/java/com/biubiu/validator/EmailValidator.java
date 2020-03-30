/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Annie
 */
@FacesValidator(value="EmailValidation")
public class EmailValidator implements Validator
{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException 
    {
       String regex = ".*@.*";
       String input=(String) value;
       if(!input.matches(regex))
       {
            System.err.println("error");
            FacesMessage message=new FacesMessage();
            message.setSummary("Invalid Input for ID");
            message.setDetail("The ID should be your email");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);//severity -> How bad is the error
            throw new ValidatorException(message);//the validation has this message
       } 
    }
    
}
