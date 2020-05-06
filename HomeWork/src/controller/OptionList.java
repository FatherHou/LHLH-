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
import model.OptionDao;
import model.QuestionDao;

/**
 * Servlet implementation class OptionList
 */
public class OptionList extends HttpServlet {
	private OptionDao optiondao = new OptionDao();
		
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
			request.setAttribute("next", next);
			request.setAttribute("pre", pre);

			List<Option> student2 = optiondao.list(start, count);
			HttpSession session2 = request.getSession();
			session2.setAttribute("optionlist", student2);
			request.getRequestDispatcher("createquestion.jsp").forward(request, response);
		}

}
