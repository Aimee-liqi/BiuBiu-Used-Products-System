/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.service;

import com.biubiu.dao.LoginDAO;
import com.biubiu.model.Buyer;
import com.biubiu.model.Seller;

/**
 *
 * @author Annie
 */
public class LoginService 
{
    public Buyer check_buy(String buy_id,String buy_pass)
    {
        LoginDAO login=new LoginDAO();
        Buyer buy=login.getBuyer(buy_id);
        if(null!=buy&&(buy_pass.equals(buy.getBuy_pass())))
        {
            return buy;
        }
        else
        {
            return null;
        } 
    }
    public Seller check_sell(String sell_id,String sell_pass)
    {
        LoginDAO login=new LoginDAO();
        Seller sell=login.getSeller(sell_id);
        if(null!=sell&&(sell_pass.equals(sell.getSell_pass())))
        {
            return sell;
        }
        else
        {
            return null;
        } 
    }
}
