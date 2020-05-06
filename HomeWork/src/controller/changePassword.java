package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Admin;
import domain.Survey;
import domain.User;
import model.AdminLoginDao;
import model.SurveyDao;
import model.UserLoginDao;

public class changePassword extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		Admin admin = (Admin)(request.getSession().getAttribute("admin"));
		String oldPassword = "";
		String newPassword = "";
		String pdagain="";
		int status=0;
		try{
			oldPassword = request.getParameter("OldPassword");
			newPassword = request.getParameter("NewPassword");
			pdagain = request.getParameter("NewPasswordAgain");
		}catch(NumberFormatException e){
		}
          if(pdagain.equals(newPassword)){
        	  if(oldPassword.equals(admin.getAdmin_password())){
        		  admin.setAdmin_password(newPassword);
        		  AdminLoginDao.update(admin);
            	  System.out.println("modify successfully!");
            	  status=1;
              }
              else{
            	  System.out.println("old password is error!");
            	  status=-1;
              }
          }
          request.setAttribute("status", status);
          int start=0;
  		 int count=50;
  		 List<Admin> admins=AdminLoginDao.list(start, count);	
  		 request.setAttribute("admins", admins);
  		List<User> userList=UserLoginDao.list(start, count);
		
		List<Admin> adminList=AdminLoginDao.list(start, count);
		
		List<Survey> surveyList=SurveyDao.list(start, count);
		
		request.setAttribute("surveyList", surveyList);
		
		request.setAttribute("adminList", adminList);
		
		request.setAttribute("userList", userList);
  		 request.setAttribute("admin", admin);
  		 request.getRequestDispatcher("Adminpage.jsp").forward(request, response);
	}

}
