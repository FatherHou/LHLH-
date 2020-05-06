package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.DBHelper;

public class UserRegisterDao {
	
	public boolean IsRegister(String user_phone) {
		boolean returnValue = true;
		String sql = "SELECT * from user";
		try {
			Connection conn = DBHelper.getInstance().getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String userNameInDB = rs.getString("user_phone");
				if (userNameInDB.equals(user_phone)) {
					returnValue = false;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnValue;
	}
	
	public void addUser(String user_phone,String user_password,String user_name,String user_bithday,String user_email,String actor) {
		Connection connection = null;
		try {
			connection = model.DBHelper.getInstance().getConnection();

			String sql = "insert into user(user_phone,user_password,user_name,user_bithday,user_email,actor) values(?,?,?,?,?,?);";

			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, user_phone);
			ps.setString(2, user_password);
			ps.setString(3, user_name);
			
			ps.setString(4, user_bithday);
			ps.setString(5, user_email);
			ps.setString(6, actor);
			ps.executeUpdate();
			model.DBHelper.closeConnection(connection, ps, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
