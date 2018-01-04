package com.ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LogoutServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");  
         
		 response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out=response.getWriter();  
           
         request.getRequestDispatcher("login.jsp").include(request, response);  
           
         HttpSession session=request.getSession();  
         session.invalidate();  
         out.print("<h3>");  
         out.print("Baþarýyla çýkýþ yaptýnýz...!");  
         out.print("</h3>");  
         out.close();  
 }  
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
