package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Answer;
import domain.Option;
import domain.Question;
import model.AnswerDao;
import model.OptionDao;

/**
 * Servlet implementation class AnswerServlet
 */
public class AnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    AnswerDao answerdao= new AnswerDao();
    OptionDao optiondao = new OptionDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnswerServlet() {
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
		String pid = request.getParameter("pid");
		String[] answer_text = request.getParameterValues("answer_text");
		String type=request.getParameter("type");
		String tt= request.getParameter("tt");
		System.out.println(tt);
		String textid=request.getParameter("textid");
		System.out.println(textid);
		String[] id=request.getParameterValues("option_id");
//		 if (id==""){
//				request.getRequestDispatcher("Notlogin.jsp").forward(request, response);
//				
//			}else{
		int[]option_id=new int[50];
//		int[] text_id=new int[50];
		for (int i=0;i<id.length;i++){
			option_id[i]=Integer.parseInt(id[i]);
		}
//		for (int x=0;x<textid.length;x++){
//			
//			if(textid[x]!=""){
			 int text_id=Integer.parseInt(textid);
//			}
//		}
		if(type.equals("text")){
		    Option option = new Option();
			option.setOption_text(tt);
			option.setQuestion_id(text_id);
    		optiondao.add(option);

	}
	   Answer answers=new Answer();	
		for (int j=0;j<id.length;j++){
		answers.setOption_id(option_id[j]);
         answerdao.add(answers);
	
			}
		request.getRequestDispatcher("info.jsp").forward(request, response);
//		response.sendRedirect("a.jsp");
	}

}
