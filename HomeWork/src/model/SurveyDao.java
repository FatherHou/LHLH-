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
public class SurveyDao {
//	
	public Survey add(Survey survey) {

		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "insert into survey values(null,?,?,?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, survey.getTitle());
			ps.setString(2, survey.getDescription());
			ps.setInt(3, survey.getUser_id());
			ps.setString(4,survey.getState());
			ps.setString(5,survey.getLink());
			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				survey.setSurvey_id(id);
			}

			DBHelper.closeConnection(c, ps, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return survey;
	}
	public void update(Survey survey) {
		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "update survey set title= ?, description = ? where survey_id = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, survey.getTitle());
			ps.setString(2, survey.getDescription());
			ps.setInt(3, survey.getSurvey_id());

			ps.execute();

			DBHelper.closeConnection(c, ps, null);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void state(Survey survey) {
		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "update survey set state= ? where survey_id = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, survey.getState());
			ps.setInt(2, survey.getSurvey_id());

			ps.execute();

			DBHelper.closeConnection(c, ps, null);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
//	public void add(Survey survey){
//	try {
//		   Connection conn = JdbcUtil.getConnection();
//		   PreparedStatement pstmt = conn.prepareStatement("insert into survey(title,description,user_id) values(?,?,?)");
//		   pstmt.setString(1, survey.getTitle());
//			pstmt.setString(2, survey.getDescription());
//			pstmt.setInt(3, survey.getUser_id());
//		   pstmt.executeUpdate();
//		   ResultSet rs = pstmt.executeQuery();
//		   if (rs.next()){
//			  int id = rs.getInt(1);
//			  survey.setSurvey_id(id);
//		  }
//		  JdbcUtil.close(pstmt, conn);
//		   } catch (SQLException e) {
//		  e.printStackTrace();
//		  }
//		}
//	
	public int getTotal() {
		int total = 0;
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select count(*) from survey";

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
	public static List<Survey> list() {
		return list(0, Short.MAX_VALUE);
	}

	public static List<Survey> list(int start, int count) {
		List<Survey> questions = new ArrayList<Survey>();

		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "select * from survey order by survey_id desc limit ?,? ";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, count);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Survey question = new Survey();
				int id = rs.getInt("survey_id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				int user_id = rs.getInt("user_id");
				String state=rs.getString("state");
				String link = rs.getString("link");
				question.setTitle(title);
				question.setDescription(description);
				question.setUser_id(user_id);
				question.setSurvey_id(id);
				question.setState(state);
				question.setLink(link);
				questions.add(question);
			}
			DBHelper.closeConnection(c, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return questions;
	}
	/*

	 * @author Hou

	 */
	public static List<Survey> getByTitle(String title) {
		List<Survey> surveys = new ArrayList<Survey>();
		
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select * from survey where title like " + "'%"+title+"%';";

			ResultSet rs = s.executeQuery(sql);

			while(rs.next()) {
				Survey survey = new Survey();
				survey.setSurvey_id(rs.getInt("survey_id"));
				survey.setTitle(rs.getString("title"));
				survey.setDescription(rs.getString("description"));
				survey.setUser_id(rs.getInt("user_id"));
				survey.setState(rs.getString("state"));
				survey.setLink(rs.getString("link"));
				surveys.add(survey);
			}

			DBHelper.closeConnection(c, s, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return surveys;
	}
	/*

	 * @author Hou

	 */
	public static List<Survey> getByDescription(String des) {
		List<Survey> surveys = new ArrayList<Survey>();
		
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select * from survey where description like " + "'%"+des+"%';";

			ResultSet rs = s.executeQuery(sql);

			while(rs.next()) {
				Survey survey = new Survey();
				survey.setSurvey_id(rs.getInt("survey_id"));
				survey.setTitle(rs.getString("title"));
				survey.setDescription(rs.getString("description"));
				survey.setUser_id(rs.getInt("user_id"));
				survey.setState(rs.getString("state"));
				survey.setLink(rs.getString("link"));
				surveys.add(survey);
			}

			DBHelper.closeConnection(c, s, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return surveys;
	}
	/*

	 * @author Hou

	 */
	public static List<Survey> getByUserId(String uid) {
		List<Survey> surveys = new ArrayList<Survey>();
		
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select * from survey where user_id like " + "'%"+uid+"%';";

			ResultSet rs = s.executeQuery(sql);

			while(rs.next()) {
				Survey survey = new Survey();
				survey.setSurvey_id(rs.getInt("survey_id"));
				survey.setTitle(rs.getString("title"));
				survey.setDescription(rs.getString("description"));
				survey.setUser_id(rs.getInt("user_id"));
				survey.setState(rs.getString("state"));
				survey.setLink(rs.getString("link"));
				surveys.add(survey);
			}

			DBHelper.closeConnection(c, s, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return surveys;
	}
	/*

	 * @author Hou

	 */
	public static List<Survey> getById(String id) {
		List<Survey> surveys = new ArrayList<Survey>();
		
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select * from survey where survey_id like " + "'%"+id+"%';";

			ResultSet rs = s.executeQuery(sql);

			while(rs.next()) {
				Survey survey = new Survey();
				survey.setSurvey_id(rs.getInt("survey_id"));
				survey.setTitle(rs.getString("title"));
				survey.setDescription(rs.getString("description"));
				survey.setUser_id(rs.getInt("user_id"));
				survey.setState(rs.getString("state"));
				survey.setLink(rs.getString("link"));
				surveys.add(survey);
			}

			DBHelper.closeConnection(c, s, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return surveys;
	}
	/*

	 * @author Hou

	 */
	public static List<Survey> searchForKey(String key) {
		List<Survey> surveys = new ArrayList<Survey>();
		
		try {
			List<Survey> surveys1 = getById(key);
			for(Survey s : surveys1){
				surveys.add(s);
			}
			surveys1 = getByTitle(key);
			for(Survey s : surveys1){
				surveys.add(s);
			}
			surveys1 = getByDescription(key);
			for(Survey s : surveys1){
				surveys.add(s);
			}
			surveys1 = getByUserId(key);
			for(Survey s : surveys1){
				surveys.add(s);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return surveys;
	}

}
