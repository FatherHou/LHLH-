package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Question;
import model.QuestionDao;

/**
 * Servlet implementation class SetquestionServlet
 */
public class SetquestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	QuestionDao dao = new QuestionDao();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetquestionServlet() {
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
		String id=request.getParameter("question_id");
		int question_id =Integer.parseInt(id);
		questions.setQuestion(question);
		questions.setQuestion_id(question_id);
		System.out.println(question);
		System.out.println(question_id);
		dao.update(questions);

		request.getRequestDispatcher("QuestionList").forward(request, response);
	}

}
