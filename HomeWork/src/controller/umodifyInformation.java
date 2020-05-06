package controller;

import java.io.IOException;
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

public class umodifyInformation extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		Admin admin = (Admin)(request.getSession().getAttribute("admin"));
		String name = "";
		String phone = "";
		String password = "";
		String birthday = "";
		String email = "";
		String id = "";
		String actor = "";
		try{
			name = request.getParameter("Name");
			phone = request.getParameter("Phone");
			password = request.getParameter("Password");
			birthday = request.getParameter("Birthday");
			email = request.getParameter("Email");
			id = request.getParameter("Id");
			actor = request.getParameter("Actor");
		}catch(NumberFormatException e){
			
		}
		List<User> users = UserLoginDao.getById(id);
		User user = users.get(0);
		int nowid = Integer.parseInt(id);
		user.setUser_id(nowid);
		user.setUser_name(name);
		user.setUser_phone(phone);
		user.setUser_password(password);
		user.setUser_bithday(birthday);
		user.setUser_email(email);
		user.setActor(actor);
		UserLoginDao.update(user);
		request.setAttribute("user", user);
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
		request.getRequestDispatcher("searchUser.jsp").forward(request, response);
	
	}


}
