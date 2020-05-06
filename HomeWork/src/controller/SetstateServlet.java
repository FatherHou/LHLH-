package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Survey;
import model.SurveyDao;

/**
 * Servlet implementation class SetstateServlet
 */
public class SetstateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SurveyDao dao=new SurveyDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetstateServlet() {
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
		String id = request.getParameter("survey_id");
		String state=request.getParameter("state");
		int survey_id =Integer.parseInt(id);
		survey.setSurvey_id(survey_id);
		survey.setState(state);
		dao.state(survey);
		request.getRequestDispatcher("/ExaminaServlet").forward(request, response);
		
	}

}
