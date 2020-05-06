package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.*;
import domain.*;
import model.QuestionDao;

/**
 * Servlet implementation class QuestionServlet
 */
public class QuestionText extends HttpServlet {
	private static final long serialVersionUID = 1L;
    QuestionDao dao= new QuestionDao();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionText() {
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
		Question questions=new Question();
		String question= request.getParameter("question");
		String type = request.getParameter("type");
		String id=request.getParameter("survey_id");
		 if (id==""){
				request.getRequestDispatcher("Notlogin.jsp").forward(request, response);
				
			}else{
		int survey_id =Integer.parseInt(id);
		questions.setQuestion(question);
		questions.setType(type);
		questions.setSurvey_id(survey_id);
		Question q=dao.add(questions);
		HttpSession session = request.getSession();
		session.setAttribute("q", q);
		request.getRequestDispatcher("createtextquestion.jsp").forward(request, response);
	}
	}
}
