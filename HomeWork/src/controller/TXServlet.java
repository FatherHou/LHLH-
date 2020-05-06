package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Option;
import domain.Question;
import domain.*;
import model.*;

/**
 * Servlet implementation class QuestionList
 */
public class TXServlet extends HttpServlet {
	private SurveyDao surveydao =new SurveyDao();
	private QuestionDao questiondao = new QuestionDao();
	private OptionDao optiondao = new OptionDao();
	private AnswerDao answerdao = new AnswerDao();
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

		int start = 0;
		int count = 10000;

		try {
			start = Integer.parseInt(request.getParameter("start"));
		} catch (NumberFormatException e) {
	
		}

		int next = start + count;
		int pre = start - count;

		int total = questiondao.getTotal();

		int last;
		if (0 == total % count)
			last = total - count;
		else
			last = total - total % count;

		pre = pre < 0 ? 0 : pre;
		next = next > last ? last : next;

		request.setAttribute("next", next);
		request.setAttribute("pre", pre);
		request.setAttribute("last", last);

		List<Option> student = optiondao.list(start, count);

		
		HttpSession session = request.getSession();
		session.setAttribute("student", student);
		
		request.getRequestDispatcher("b.jsp").forward(request, response);

	}

}