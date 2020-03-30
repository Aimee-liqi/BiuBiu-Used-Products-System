package com.biubiu.beans;

import com.biubiu.dao.CommentDAO;
import com.biubiu.dao.ShowProductDAO;
import com.biubiu.model.Buyer;
import com.biubiu.model.Comment;
import com.biubiu.model.Product;
import com.biubiu.model.Seller;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NIIT
 */
@ManagedBean(name="Comment")
@SessionScoped
public class CommentBean 
{
    private String type;
    private String content;
    private String com_type;
    private float good_score;
    private float bad_score;
    private int times;
    private String b_level;
    private float score;
    private float good;
    private float bad;
    private String s_level;


    FacesContext facescontext=FacesContext.getCurrentInstance();
    ExternalContext exContext=facescontext.getExternalContext();
    HttpSession session=(HttpSession)exContext.getSession(true);

    public String submit(Comment c)
     {
         String text=(String)session.getAttribute("isLogined");
         if(text.equals("true")){
         CommentDAO dao=new CommentDAO();
         int pro_id=(int)session.getAttribute("pro_id");
         c.setPro_id(pro_id);
         dao.insertComment(c);
         String buy_id=(String)session.getAttribute("Login_id");
         Buyer buy=dao.getTimes(buy_id);//Replace This Parameter(Buy_id)
         times=buy.getBuy_times();
         times=times+1;
         dao.updateTimes(buy_id, times);//Replace This Parameter(Buy_id)
         compute(c);
            return "go on";
         }else{
              return "buyer login";
         }
     }

     public void compute(Comment c)
    {
        CommentDAO dao=new CommentDAO();
        int pro_id=(int)session.getAttribute("pro_id");
        System.out.println(pro_id);
        ArrayList<Product> product=new ArrayList<Product>();
        ShowProductDAO showdao=new ShowProductDAO();
        product=showdao.getProduct(pro_id);
        String sell_id=product.get(0).getSeller_id();
        Seller sell=dao.getScore(sell_id);//Replace This Parameter(Sell_id)
        if(c.com_type.equals("good"))
        {
           good_score=sell.getSell_good();
           good_score=good_score+1;
           dao.updateGoodScore(sell_id, good_score);//Replace This Parameter(Sell_id)
        }
        else if(c.com_type.equals("bad"))
        {
           bad_score=sell.getSell_bad();
           bad_score=bad_score+1;
           dao.updateBadScore(sell_id, bad_score);//Replace This Parameter(Sell_id)
        } 
        setBuyerLevel();
        setSellerLevel();
    }
     public void setBuyerLevel()
     {
         CommentDAO dao=new CommentDAO();
         String buy_id=(String)session.getAttribute("Login_id");
         Buyer buy=dao.getTimes(buy_id);//Replace This Parameter(Buy_id)
         times=buy.getBuy_times();
         if(times>=10)
         {
             b_level="SSR";
         }
         else if(times>=5&&times<10)
         {
             b_level="SR";
         }
         else
         {
             b_level="R";
         }
         dao.updateBuyerLevel(buy_id, b_level);//Replace This Parameter(Sell_id)
     }
     public void setSellerLevel()
     {
         int pro_id=(int)session.getAttribute("pro_id");
        ArrayList<Product> product=new ArrayList<Product>();
        ShowProductDAO showdao=new ShowProductDAO();
        product=showdao.getProduct(pro_id);
        String sell_id=product.get(0).getSeller_id();
        
         CommentDAO dao=new CommentDAO();
         Seller sell=dao.getScore(sell_id);//Replace This Parameter(Sell_id)
         
          bad=sell.getSell_bad();
          good=sell.getSell_good();
          score=good+bad;
          System.out.println(good/score);
          if(good/score>=0.95)
          {
              s_level="SSR";
          }
          else if(good/score>=0.9&&good/score<0.95)
          {
              s_level="SR";
          }
          else
          {
              s_level="R";
          }
          dao.updateSellerLevel(sell_id, s_level);//Replace This Parameter(Buy_id)
     }
     
   
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCom_type() {
        return com_type;
    }

    public void setCom_type(String com_type) {
        this.com_type = com_type;
    }

    public float getGood_score() {
        return good_score;
    }

    public void setGood_score(float good_score) {
        this.good_score = good_score;
    }

    public float getBad_score() {
        return bad_score;
    }

    public void setBad_score(float bad_score) {
        this.bad_score = bad_score;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public String getB_level() {
        return b_level;
    }

    public void setB_level(String b_level) {
        this.b_level = b_level;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public float getGood() {
        return good;
    }

    public void setGood(float good) {
        this.good = good;
    }

    public float getBad() {
        return bad;
    }

    public void setBad(float bad) {
        this.bad = bad;
    }

    public String getS_level() {
        return s_level;
    }

    public void setS_level(String s_level) {
        this.s_level = s_level;
    }


}
