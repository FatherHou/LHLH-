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
public class OptionDao {
	
	public Option add(Option option1) {

		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "insert into options (question_id,option_text,sum) values (?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1,option1.getQuestion_id());
			ps.setString(2,option1.getOption_text());
			ps.setString(3, option1.getSum());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				option1.setOption_id(id);
			}

			DBHelper.closeConnection(c, ps, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return option1;
	}
	
	public List<Option> findoption(int id){
		List<Option> list = new ArrayList<Option>();

		try{
		   Connection conn = JdbcUtil.getConnection();
		   PreparedStatement pstmt = conn.prepareStatement("select * from options where question_id="+id);
		   ResultSet rs = pstmt.executeQuery();
		  while(rs.next()){
			 Option option1=new Option();
			  option1.setOption_id(rs.getInt(1));
			  option1.setQuestion_id(rs.getInt(2));
			  option1.setOption_text(rs.getString(3));
			  option1.setOption_no(rs.getInt(4));		  
			  list.add(option1);
		  }
		  JdbcUtil.close(pstmt, conn);
		  }catch(SQLException e){
		  e.printStackTrace();
		  throw new RuntimeException();
		   }
		   return list;
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
	public List<Option> list() {
		return list(0, Short.MAX_VALUE);
	}

	public List<Option> list(int start, int count) {
		List<Option> options = new ArrayList<Option>();

		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "select * from options order by option_id desc limit ?,? ";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, count);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Option option = new Option();
				int id = rs.getInt("option_id");
				int question_id = rs.getInt("question_id");
				
				String option_text = rs.getString("option_text");
				int option_no = rs.getInt("option_no");
				String sum = rs.getString("sum");
				option.setOption_id(id);
				option.setQuestion_id(question_id);
				option.setOption_text(option_text);
				option.setOption_no(option_no);
				option.setSum(sum);
				options.add(option);
			}
			DBHelper.closeConnection(c, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return options;
	}
	public void update(Option option2) {
		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "update options set option_text= ? where option_id = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1,option2.getOption_text());
			ps.setInt(2,option2.getOption_id());

			ps.execute();

			DBHelper.closeConnection(c, ps, null);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void upsum(Option option2) {
		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "update options set sum= ? where option_id = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1,option2.getSum());
			ps.setInt(2,option2.getOption_id());

			ps.execute();

			DBHelper.closeConnection(c, ps, null);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
