/**
 * 
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import domain.*;
import utils.JdbcUtil;

/**
 * @author Lenovo
 *
 */
public class QuestionDao {
	

//		public void add(Question question){
//		try {
//		   Connection conn = JdbcUtil.getConnection();
//		   PreparedStatement pstmt = conn.prepareStatement("insert into question(question,type,survey_id) values(?,?,?)");
//		   pstmt.setString(1,question.getQuestion());
//		   pstmt.setString(2,question.getType());
//		   pstmt.setInt(3,question.getSurvey_id());
//		   pstmt.executeUpdate();
//		  JdbcUtil.close(pstmt, conn);
//		   } catch (SQLException e) {
//		  e.printStackTrace();
//		  }
//		}
		public Question add(Question question) {

			try {

				Connection c = DBHelper.getInstance().getConnection();

				String sql = "insert into question(question,type,survey_id) values(?,?,?)";
				PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				ps.setString(1,question.getQuestion());
				ps.setString(2,question.getType());
				ps.setInt(3,question.getSurvey_id());

				ps.execute();

				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					question.setQuestion_id(id);
				}

				DBHelper.closeConnection(c, ps, rs);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return question;
		}
		public List<Question> findquestion(int id){
			List<Question> list = new ArrayList<Question>();

			try{
			   Connection conn = JdbcUtil.getConnection();
			   PreparedStatement pstmt = conn.prepareStatement("select * from question where survey_id="+id);
			   ResultSet rs = pstmt.executeQuery();
			  while(rs.next()){
				 Question question = new Question();
				  question.setQuestion_id(rs.getInt(1));
				  question.setQuestion(rs.getString(2)); 
				  question.setType(rs.getString(3));
				  question.setSurvey_id(rs.getInt(4));
				  list.add(question);
			  }
			  JdbcUtil.close(pstmt, conn);
			  }catch(SQLException e){
			  e.printStackTrace();
			  throw new RuntimeException();
			   }
			   return list;
			 }
		public void update(Question question) {
			try {

				Connection c = DBHelper.getInstance().getConnection();

				String sql = "update question set question= ? where question_id = ?";
				PreparedStatement ps = c.prepareStatement(sql);
				ps.setString(1,question.getQuestion());
				ps.setInt(2,question.getQuestion_id());

				ps.execute();

				DBHelper.closeConnection(c, ps, null);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		public int getTotal() {
			int total = 0;
			try {

				Connection c = DBHelper.getInstance().getConnection();

				Statement s = c.createStatement();

				String sql = "select count(*) from question";

				ResultSet rs = s.executeQuery(sql);
				while (rs.next()) {
					total = rs.getInt(1);
				}

				System.out.println("total:" + total);

				DBHelper.closeConnection(c, s, rs);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return total;
		}
		public List<Question> list() {
			return list(0, Short.MAX_VALUE);
		}

		public List<Question> list(int start, int count) {
			List<Question> questions = new ArrayList<Question>();

			try {

				Connection c = DBHelper.getInstance().getConnection();

				String sql = "select * from question order by question_id desc limit ?,? ";

				PreparedStatement ps = c.prepareStatement(sql);
				ps.setInt(1, start);
				ps.setInt(2, count);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					Question question = new Question();
					int id = rs.getInt("question_id");
					String name = rs.getString("question");
					String type = rs.getString("type");
					int survey_id = rs.getInt("survey_id");
					question.setQuestion(name);
					question.setType(type);
					question.setSurvey_id(survey_id);
					question.setQuestion_id(id);
					questions.add(question);
				}
				DBHelper.closeConnection(c, ps, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return questions;
		}
			
}
