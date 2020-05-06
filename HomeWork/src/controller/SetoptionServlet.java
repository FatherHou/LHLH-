package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Option;
import model.*;

/**
 * Servlet implementation class SetoptionServlet
 */
public class SetoptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OptionDao dao = new OptionDao();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetoptionServlet() {
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
		Option options=new Option();
		String option_text= request.getParameter("option_text");
		String id=request.getParameter("option_id");
		int option_id =Integer.parseInt(id);
		options.setOption_text(option_text);
		options.setOption_id(option_id);
		dao.update(options);

		request.getRequestDispatcher("QuestionList").forward(request, response);
	}

}
