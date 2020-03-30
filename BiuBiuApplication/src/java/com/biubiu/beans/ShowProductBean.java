/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.beans;

import com.biubiu.dao.ShowBuyerDAO;
import com.biubiu.dao.ShowCommentDAO;
import com.biubiu.dao.ShowProductDAO;
import com.biubiu.dao.ShowSellerDAO;
import com.biubiu.model.Buyer;
import com.biubiu.model.Comment;
import com.biubiu.model.Product;
import com.biubiu.model.Seller;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL-PC
 */
@ManagedBean(name="showPro")
@SessionScoped
public class ShowProductBean {
    private int pro_id;
    ArrayList<Product> product;
    ArrayList<Seller> seller;
    private boolean show=false;
    private ArrayList<Comment> comment;
    
    
    FacesContext facescontext=FacesContext.getCurrentInstance();
    ExternalContext exContext=facescontext.getExternalContext();
    HttpSession session=(HttpSession)exContext.getSession(true);
    
    public void showProduct(ActionEvent event){
         HtmlCommandLink source=(HtmlCommandLink)event.getSource();
         pro_id=Integer.parseInt(source.getTitle());
         session.setAttribute("pro_id", pro_id);
         ArrayList<Product> product=new ArrayList<Product>();
         ShowProductDAO showDAO=new ShowProductDAO();
         product=showDAO.getProduct(pro_id);
         float minPrice=product.get(0).getPro_minPrice();
         session.setAttribute("pro_minPrice", minPrice);
         System.out.println("You have run the showProduct "+pro_id);
    }

    public int getPro_id() {
        return pro_id;
    }
    
    public ArrayList<Seller> getSeller() {
        System.out.println("you have run the getSeller()");
         ShowProductDAO productdao=new ShowProductDAO();
         ArrayList<Product> prod=new ArrayList<Product>();
         prod=productdao.getProduct(pro_id);
         String sell_id=prod.get(0).getSeller_id();
         ShowSellerDAO showsellerdao=new ShowSellerDAO();
         seller=showsellerdao.getSeller(sell_id);
         if(session.getAttribute("isLogined").equals("true")&&session.getAttribute("Login_account").equals("buy")){    
         String buy_id=(String)session.getAttribute("Login_id");
         ArrayList<Buyer> buyer=new ArrayList<Buyer>();
         ShowBuyerDAO showbuyer=new ShowBuyerDAO();
         buyer=showbuyer.getBuyer(buy_id);
          if(buyer.get(0).getBuy_level()==null){
             show=false;
         }else if(buyer.get(0).getBuy_level().equals("R")){
             show=false;
         }else{
             show=true;
         }
         }else{
             show=false;
         }
        return seller;
    }

    public void setSeller(ArrayList<Seller> seller) {
        this.seller = seller;
    }
    
        public ArrayList<Product> getProduct() {
        ShowProductDAO productdao=new ShowProductDAO();
        product=productdao.getProduct(pro_id);
        return product;
    }

    public void setProduct(ArrayList<Product> product) {
        this.product = product;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public ArrayList<Comment> getComment() {
        int id=(int)session.getAttribute("pro_id");
        ShowCommentDAO showdao=new ShowCommentDAO();
        comment=showdao.showComment(id);
        return comment;
    }

    public void setComment(ArrayList<Comment> comment) {
        this.comment = comment;
    }
}
