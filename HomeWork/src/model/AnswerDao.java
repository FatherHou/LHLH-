package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Answer;
import domain.Option;

public class AnswerDao {
	public Answer add(Answer answer) {

		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "insert into answer (answer_text,option_id) values (?,?)";
			PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,answer.getAnswer_text());
			ps.setInt(2,answer.getOption_id());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				answer.setAnswer_id(id);
			}

			DBHelper.closeConnection(c, ps, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return answer;
	}
	public int getTotal() {
		int total = 0;
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select count(*) from answer";

			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				total = rs.getInt(1);
			}

			

			DBHelper.closeConnection(c, s, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
	public List<Answer> list() {
		return list(0, Short.MAX_VALUE);
	}

	public List<Answer> list(int start, int count) {
		List<Answer> options = new ArrayList<Answer>();

		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "select * from answer order by answer_id desc limit ?,? ";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, count);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Answer answer = new Answer();
				int id = rs.getInt("answer_id");	
				String answer_text = rs.getString("answer_text");
				int option_id = rs.getInt("option_id");
				answer.setAnswer_id(id);
				answer.setAnswer_text(answer_text);
				answer.setOption_id(option_id);
				options.add(answer);
			}
			DBHelper.closeConnection(c, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return options;
	}

}
