package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.*;
import model.SurveyDao;
import controller.*;

/**
 * Servlet implementation class SurveyServlet
 */
public class SurveyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SurveyDao dao=new SurveyDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SurveyServlet() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		Survey survey=new Survey();
		String title= request.getParameter("title");
		String description = request.getParameter("description");
		String id=request.getParameter("user_id");
		String state="´ýÉóºË";
		String link="http://localhost:8080/HomeWork/LinkServlet";
		 if (id==""){
				request.getRequestDispatcher("Notlogin.jsp").forward(request, response);
				
			}else{
		int user_id =Integer.parseInt(id);
		survey.setTitle(title);
		survey.setDescription(description);
		survey.setUser_id(user_id);
		survey.setState(state);
		survey.setLink(link);
		Survey survey1=dao.add(survey);
		HttpSession session = request.getSession();
		session.setAttribute("survey", survey1);
		request.getRequestDispatcher("question.jsp").forward(request, response);
		}
		
	}

}
