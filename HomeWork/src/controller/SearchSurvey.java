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

public class SearchSurvey extends HttpServlet {
       
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		Admin admin = (Admin)(request.getSession().getAttribute("admin"));
		String key="";
		int start=0;
		int count=50;
		try{
			key = request.getParameter("searchSurvey");
		}catch(NumberFormatException e){
			
		}
		if(key.isEmpty()!=true){
	//		System.out.println(key);
			List<Survey> surveyList = SurveyDao.searchForKey(key);
	//		System.out.println(surveyList.size());
			request.setAttribute("surveyList", surveyList);
		}else{
			List<Survey> surveyList = SurveyDao.list(start, count);
			request.setAttribute("surveyList", surveyList);
		}

		List<Admin> admins=AdminLoginDao.list(start, count);	
		request.setAttribute("admins", admins);
		List<User> userList=UserLoginDao.list(start, count);
		
		List<Admin> adminList=AdminLoginDao.list(start, count);
		
		request.setAttribute("adminList", adminList);
		
		request.setAttribute("userList", userList);
		request.setAttribute("admin", admin);
		request.getRequestDispatcher("searchSurvey.jsp").forward(request, response);

}

}
