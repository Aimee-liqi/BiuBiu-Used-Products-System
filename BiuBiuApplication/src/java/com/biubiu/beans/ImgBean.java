/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biubiu.beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Anasitasia
 */

@ManagedBean(name="img")
@SessionScoped

public class ImgBean {
   
    private Part part;
    private String imgPath;
    private String pro_imgPath;
    String fileNameExtractorRegex = "filename=\".+\"";  
    String uploadFilePath;
    private static final String UPLOAD_DIR = "upload";
   


     
     
 public void submit() throws IOException{
        FacesContext facescontext = FacesContext.getCurrentInstance();
        ExternalContext exContext = facescontext.getExternalContext();
        String applicationPath= exContext.getRealPath("");//// gets absolute path of the web application
        System.out.println(applicationPath);
        // constructs path of the directory to save uploaded file
        uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
        String fileName = getFileName(part);
        System.out.println(fileName);
       imgPath= uploadFilePath + File.separator + fileName;
        System.out.println(imgPath);
        write(fileName, part);
        System.out.println("successfully");
        pro_imgPath="upload/"+fileName;
        System.out.println(pro_imgPath);
        HttpSession session = (HttpSession) exContext.getSession(true);
        session.setAttribute("path", pro_imgPath);
}

  

  public String getFileName(Part part) {
        String cotentDesc = part.getHeader("content-disposition");  
        String fileName = null;  
        Pattern pattern = Pattern.compile(fileNameExtractorRegex);  
        Matcher matcher = pattern.matcher(cotentDesc);  
        if(matcher.find()){  
            fileName = matcher.group();  
            fileName = fileName.substring(10, fileName.length()-1);  
        }  
        return fileName;  
    } 
  
      
 

    public void write(String fileName, Part part) {
             InputStream in = null;
        try {
            in = part.getInputStream();
            System.out.println(in);
           // OutputStream out = new FileOutputStream(uploadFilePath);
           OutputStream out = new FileOutputStream(new File(imgPath));
            byte[] buffer = new byte[1024];
            int length = -1;
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
            }   
            System.out.println("write");
            in.close();
            out.close();
        
        } catch (IOException ex) {
            Logger.getLogger(ImgBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(ImgBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

        
    
    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public String getImgPath() {
       
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        
      
        this.imgPath = imgPath;
    }

    public String getPro_imgPath() {
        return pro_imgPath;
    }

    public void setPro_imgPath(String pro_imgPath) {
        this.pro_imgPath = pro_imgPath;
    }
}
