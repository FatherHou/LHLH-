package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
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


public class SearchHou extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		Admin admin = (Admin)(request.getSession().getAttribute("admin"));
		String key="";
		int start=0;
		int count=50;
		try{
			key = request.getParameter("searchAdmin");
		}catch(NumberFormatException e){
			
		}
		if(key.isEmpty()!=true){
			List<Admin> adminList = AdminLoginDao.searchForKey(key);
			request.setAttribute("adminList", adminList);
		}else{
			List<Admin> adminList = AdminLoginDao.list(start, count);
			request.setAttribute("adminList", adminList);
		}
		List<Admin> admins=AdminLoginDao.list(start, count);	
		request.setAttribute("admins", admins);
		List<User> userList=UserLoginDao.list(start, count);
		
		List<Survey> surveyList=SurveyDao.list(start, count);
		
		request.setAttribute("surveyList", surveyList);
		
		request.setAttribute("userList", userList);
		request.setAttribute("admin", admin);
		request.getRequestDispatcher("searchAdmin.jsp").forward(request, response);

}
}
