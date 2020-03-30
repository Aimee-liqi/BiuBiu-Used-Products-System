/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author NIIT
 */
@ManagedBean(name="serv")
@SessionScoped
public class MoreService {
    private String help;
    private String b_center;
    private String about;
    private String login;
    public String clickService()//placebo function
    {
        return null;//give a result for the form
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public String getB_center() {
        return b_center;
    }

    public void setB_center(String b_center) {
        this.b_center = b_center;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
