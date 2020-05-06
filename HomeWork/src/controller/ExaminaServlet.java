package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Survey;
import domain.Question;
import model.OptionDao;
import model.SurveyDao;

/**
 * Servlet implementation class MySurveyServlet
 */
public class ExaminaServlet extends HttpServlet {
	private SurveyDao surveydao = new SurveyDao();
		
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

			int total = surveydao.getTotal();

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

			List<Survey> student1 = surveydao.list(start, count);
			HttpSession session1 = request.getSession();
			session1.setAttribute("mysurvey", student1);
			request.getRequestDispatcher("examine.jsp").forward(request, response);
		}

}
