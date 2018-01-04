package com.ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajax.dao.EditDAO;
import com.ajax.dto.User;


@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
    public EditServlet2() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  
        PrintWriter out=response.getWriter();  
        
        
        int id=Integer.parseInt(request.getParameter("id"));
        String ad = request.getParameter("ad");  
        String soyad = request.getParameter("soyad");  
        String yas = request.getParameter("yas");  
        String sehir = request.getParameter("sehir");  
          
        User user=new User();  
        user.setId(id);  
        user.setAd(ad);  
        user.setSoyad(soyad);  
        user.setYas(yas);  
        user.setSehir(sehir);  
          
        int status = EditDAO.duzenle(user);
        
        if(status>0){  
            response.sendRedirect("ViewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}  
