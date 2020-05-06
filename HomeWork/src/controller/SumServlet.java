package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Option;
import model.OptionDao;

/**
 * Servlet implementation class SumServlet
 */
public class SumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OptionDao optiondao = new OptionDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SumServlet() {
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
		String[] id = request.getParameterValues("option_id");
		String[] sum = request.getParameterValues("sum");
		int[]option_id=new int[200];
		for (int i=0;i<id.length;i++){
			option_id[i]=Integer.parseInt(id[i]);
		}
		Option option = new Option();
		for (int j=0;j<sum.length;j++){
		option.setOption_id(option_id[j]);
		option.setSum(sum[j]);
		optiondao.upsum(option);
		}
		request.getRequestDispatcher("TJCG.jsp").forward(request, response);
		
	}

}
