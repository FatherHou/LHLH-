package controller;

import java.io.IOException;
import java.io.PrintWriter;
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


public class UserDetail extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
				
			String user_id = request.getParameter("user_id");
			List<User> users = UserLoginDao.getById(user_id);
			User user = users.get(0);
			request.setAttribute("user", user);
			int start = 0;
			int count = 50;
			List<User> userList=UserLoginDao.list(start, count);
			
			List<Admin> adminList=AdminLoginDao.list(start, count);
			
			List<Survey> surveyList=SurveyDao.list(start, count);
			
			request.setAttribute("surveyList", surveyList);
			
			request.setAttribute("adminList", adminList);
			
			request.setAttribute("userList", userList);
//			int st = book.getStatus();
//			if(st == 0) {
//				request.setAttribute("status", "can be borrowed");
//			} else {
//				request.setAttribute("status", "can not be borrowed");
//			}
			
			
		} catch (NumberFormatException e){
			
		}
		
		request.getRequestDispatcher("UserDetailPage.jsp").forward(request, response);

	}

}
