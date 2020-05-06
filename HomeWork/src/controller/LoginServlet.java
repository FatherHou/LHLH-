package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;
import domain.*;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserLoginDao Dao = new UserLoginDao();
	private AdminLoginDao ADao = new AdminLoginDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String choice = request.getParameter("choice");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");

		boolean judge = true;
		boolean judge2 = true;
		Cookie cookies[] = request.getCookies();
		

		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("phone")) {
					cookies[i].setValue(phone);
					judge = false;
				}
				if (cookies[i].getName().equals("password")) {
					cookies[i].setValue(password);
					judge2 = false;
				}

			}
		}
		

		if (judge2) {
			
			Cookie cookie2 = new Cookie("password", password);
			// 不设置的话，则cookies不写入硬盘,而是写在内存,只在当前页面有用,以秒为单位
		
			cookie2.setMaxAge(24 * 60 * 60);

			
			response.addCookie(cookie2);

		}
		if (judge) {
			Cookie cookie = new Cookie("phone", phone);
		
			// 不设置的话，则cookies不写入硬盘,而是写在内存,只在当前页面有用,以秒为单位
			cookie.setMaxAge(24 * 60 * 60);
			
			response.addCookie(cookie);
			

		}
		String phonecook="";
        String passwordcook="";
        if(cookies!=null){
            for(Cookie cookie:cookies){
                if(cookie.getName().equals("phone")){
                    phonecook=cookie.getValue();
                }
                if(cookie.getName().equals("password")){
                    passwordcook=cookie.getValue();
                }
            }
           
        }
        HttpSession session1 = request.getSession();
        HttpSession session2 = request.getSession();
		session1.setAttribute("phonecook",phonecook);
        session2.setAttribute("passwordcook", passwordcook);
		Connection con=null;
		int start=0;
		int count=50;

		try {
			if(choice.equals("user")){

			User user = new User(phone,password);

			con = DBHelper.getInstance().getConnection();

			User currentUser = Dao.login(con, user);
			
			User users = Dao.find(phone);
			if (null == currentUser) {

				request.setAttribute("error", "用户账号或密码错误！");

				request.setAttribute("phone", phone);

				request.setAttribute("password", password);

				RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");

				dispatcher.forward(request, response);

			}else {
				//HttpSession session = request.getSession();
				//session.setAttribute("currentUser",currentUser);
				HttpSession session = request.getSession();
				session.setAttribute("users",users);
				response.sendRedirect("Usermain.jsp");
			}
			}else if(choice.equals("admin")){

				Admin admin = AdminLoginDao.getByPhone(phone);

				con = DBHelper.getInstance().getConnection();

				Admin current = ADao.login(con, admin);


				if (null == current) {

					request.setAttribute("error", "用户名或密码错误");
					
					request.setAttribute("choice",choice);

					request.setAttribute("phone", phone);

					request.setAttribute("password", password);

					RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");

					dispatcher.forward(request, response);

				}else {

					request.setAttribute("nowAdmin",admin);
					HttpSession session = request.getSession();
					session.setAttribute("admin",admin);
					
					List<Admin> admins=AdminLoginDao.list(start, count);
					
					List<User> userList=UserLoginDao.list(start, count);
					
					List<Admin> adminList=AdminLoginDao.list(start, count);
					
					List<Survey> surveyList=SurveyDao.list(start, count);
					
					request.setAttribute("surveyList", surveyList);
					
					request.setAttribute("adminList", adminList);
					
					request.setAttribute("userList", userList);
					
					request.setAttribute("admins", admins);

					request.getRequestDispatcher("Adminpage.jsp").forward(request, response);

				}
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		
	}
		

}
