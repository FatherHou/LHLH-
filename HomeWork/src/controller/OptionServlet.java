package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.*;
import model.OptionDao;

/**
 * Servlet implementation class OptionServlet
 */
public class OptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OptionDao optiondao = new OptionDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OptionServlet() {
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
		response.setCharacterEncoding("utf-8");
		Option option=new Option();
		String option_text= request.getParameter("option_text");
		String id = request.getParameter("question_id");
		 if (id==""){
				request.getRequestDispatcher("Notlogin.jsp").forward(request, response);
				
			}else{
		int question_id =Integer.parseInt(id);
		option.setQuestion_id(question_id);
		option.setOption_text(option_text);
		optiondao.add(option);
//		Question q=dao.add(questions);
//		HttpSession session = request.getSession();
//		session.setAttribute("q", q);
         optiondao.findoption(question_id);
		List <Option> optionlist=optiondao.findoption(question_id);
		HttpSession session = request.getSession();
		session.setAttribute("optionlist",optionlist);
	
		request.getRequestDispatcher("OptionList").forward(request, response);
	}

}
}
