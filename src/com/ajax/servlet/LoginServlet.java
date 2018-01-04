package com.ajax.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ajax.dao.AccountModel;
import com.ajax.dto.User;


@WebServlet(
		description = "Login Servlet", 
		urlPatterns = { "/LoginServlet" }, 
		initParams = { 
        
		})
public class LoginServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
   
   public LoginServlet(){
	   super();
   }
   
   	@Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException 
   {
	   String action = request.getParameter("action");
	   HttpSession session = request.getSession();
	   if(action==null){
		   User user = checkCookie(request);
		   if(user == null)
			   request.getRequestDispatcher("login.jsp").forward(request, response);
		   else{
			   AccountModel accModel = new AccountModel();
			   if(accModel.login(user.getAd(), user.getSoyad())){
				   session.setAttribute("username", user.getAd());
				   request.getRequestDispatcher("ViewServlet").forward(request, response);
			   }else{
				   request.setAttribute("error", "Account invalid");
				   request.getRequestDispatcher("login.jsp").forward(request, response);
			   }
		   }
	   } else {
		   if(action.equalsIgnoreCase("logout")){
			   session.removeAttribute("username");
			   Cookie[] cookies = request.getCookies();
			   for(Cookie ck : cookies){
				   if(ck.getName().equalsIgnoreCase("username")){
					   ck.setMaxAge(0);
					   response.addCookie(ck);
				   }
				   if(ck.getName().equalsIgnoreCase("password")){
					   ck.setMaxAge(0);
					   response.addCookie(ck);
				   }
			   }
			   request.getRequestDispatcher("login.jsp").forward(request, response);
		   }
		   
	   }
   }
   private User checkCookie(HttpServletRequest request){
	   Cookie[] cookies = request.getCookies();
	   User user = null;
	   if(cookies == null)
		   return null;
	   else{
		   String username = "", password = "";
		   for(Cookie ck : cookies){
			   if(ck.getName().equalsIgnoreCase("username"))
				   username = ck.getValue();
			   if(ck.getName().equalsIgnoreCase("password"))
				   password = ck.getValue();
		   }
		   if(!username.isEmpty() && !password.isEmpty())
			   user = new User(0, username, password, password, password);    
	   }
	   return user;
   }
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException 
   {
       String action = request.getParameter("action");
       HttpSession session = request.getSession();
       AccountModel accModel = new AccountModel();
       if(action == null){
    	   String username = request.getParameter("username").trim();
    	   String password = request.getParameter("password").trim();
    	   boolean remember = request.getParameter("remember") != null;
    	   if(accModel.login(username, password)){
    		   session.setAttribute("username", username);
    		   if(remember){
    			   Cookie ckUsername = new Cookie("username", username);
    			   ckUsername.setMaxAge(3600);
    			   response.addCookie(ckUsername);
    			   Cookie ckPassword = new Cookie("password", password);
    			   ckPassword.setMaxAge(3600);
    			   response.addCookie(ckPassword);
    		   }
    		request.getRequestDispatcher("ViewServlet").forward(request, response);   
    	   
       }else{
    	   request.setAttribute("error", "Account invalid");
		   request.getRequestDispatcher("login.jsp").forward(request, response);
       }
       }else{
    	   
       }
   }
  }
   