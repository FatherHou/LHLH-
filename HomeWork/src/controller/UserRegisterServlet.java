package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import model.UserRegisterDao;

/**
 * Servlet implementation class UserRegisterServlet
 */
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String user_phone=request.getParameter("user_phone");
		String user_password = request.getParameter("user_password");
		String user_name=request.getParameter("user_name");
		String user_bithday =request.getParameter("user_bithday");
		String user_email = request.getParameter("user_email");
		String actor=request.getParameter("actor");
		UserRegisterDao phone=new UserRegisterDao();
		boolean can = phone.IsRegister(user_phone);
		if(can){
			UserRegisterDao userregisterdao = new UserRegisterDao();

			userregisterdao.addUser(user_phone,user_password, user_name, user_bithday, user_email, actor);
		
			response.sendRedirect("RegisterSuccess.jsp?info=yes");
		}else{
			
			response.sendRedirect("RegisterSuccess.jsp?info=no");
		}
		
			
			
		
		
	}

}
