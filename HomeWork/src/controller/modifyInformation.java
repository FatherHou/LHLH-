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

public class modifyInformation extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		Admin admin = (Admin)(request.getSession().getAttribute("admin"));
		String name = "";
		String phone = "";
		try{
			name = request.getParameter("Name");
			phone = request.getParameter("Phone");
		}catch(NumberFormatException e){
			
		}
		System.out.println("name="+name);
		System.out.println("phone"+phone);
		admin.setAdmin_name(name);
		admin.setAdmin_phone(phone);
//		System.out.println("actor1:"+admin.getActor());
		AdminLoginDao.update(admin);
//		System.out.println("name:"+admin.getAdmin_name());
//		System.out.println("actor2:"+admin.getActor());
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
