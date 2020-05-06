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

import domain.Admin;
import domain.User;
import utils.*;


/**
 * @author Lenovo
 *
 */
public class UserLoginDao {
	
	public User login(Connection con,User user) throws Exception{

		User resultUser = null;

		String sql = "select * from user where user_phone=? and user_password=?";

		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, user.getUser_phone());

		pstmt.setString(2, user.getUser_password());
		

		ResultSet rs =  pstmt.executeQuery();

		if (rs.next()) {

			resultUser = new User();

			resultUser.setUser_phone(rs.getString("user_phone"));

			resultUser.setUser_password(rs.getString("user_password"));
			
			
		}

		return resultUser;

	}
	public User find(String user_phone){
		User user=new User();
		try{
		   Connection conn = JdbcUtil.getConnection();
		   PreparedStatement pstmt = conn.prepareStatement("select * from user where user_phone="+user_phone);
		   ResultSet rs = pstmt.executeQuery();
		  if(rs.next()){
		   user.setUser_id(rs.getInt(1));
		   user.setUser_phone(rs.getString(2));
		   user.setUser_password(rs.getString(3));
		   user.setActor(rs.getString(4));
		   user.setUser_name(rs.getString(5));
		   user.setUser_bithday(rs.getString(6));
		   user.setUser_email(rs.getString(7));
		  }
		   JdbcUtil.close(pstmt, conn);
		  }catch(SQLException e){
		  e.printStackTrace();
		   throw new RuntimeException();
		  }
		 return user;
		}
	
	public static void update(User user) {

		try {



			Connection c = DBHelper.getInstance().getConnection();



			String sql = "update user set user_phone=?,user_password=?,actor=?,user_name=?,user_bithday=?,user_email=? where user_id = ?";

			

			PreparedStatement ps = c.prepareStatement(sql);

			ps.setString(1, user.getUser_phone());
			
			ps.setString(2, user.getUser_password());
			
			ps.setString(3, user.getActor());
			
			ps.setString(4, user.getUser_name());
			
			ps.setString(5, user.getUser_bithday());
			
			ps.setString(6, user.getUser_email());
			
			ps.setInt(7, user.getUser_id());
			
			ps.execute();

			DBHelper.closeConnection(c, ps, null);



		} catch (Exception e) {

			e.printStackTrace();

		}

	}
	/*

	 * @author Hou

	 */
	public static List<User> getById(String Id) {
		List<User> users = new ArrayList<User>();
		
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select * from user where user_id like " + "'%"+Id+"%';";

			ResultSet rs = s.executeQuery(sql);

			while(rs.next()) {
				User user = new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_phone(rs.getString("user_phone"));
				user.setUser_password(rs.getString("user_password"));
				user.setActor(rs.getString("actor"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_bithday(rs.getString("user_bithday"));
				user.setUser_email(rs.getString("user_email"));
				users.add(user);
			}

			DBHelper.closeConnection(c, s, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	/*

	 * @author Hou

	 */
	public static List<User> getByPhone(String Phone) {
		List<User> users = new ArrayList<User>();
		
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select * from user where user_phone like " + "'%"+Phone+"%';";

			ResultSet rs = s.executeQuery(sql);

			while(rs.next()) {
				User user = new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_phone(rs.getString("user_phone"));
				user.setUser_password(rs.getString("user_password"));
				user.setActor(rs.getString("actor"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_bithday(rs.getString("user_bithday"));
				user.setUser_email(rs.getString("user_email"));
				users.add(user);
			}

			DBHelper.closeConnection(c, s, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	/*

	 * @author Hou

	 */
	public static List<User> getByName(String Name) {
		List<User> users = new ArrayList<User>();
		
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select * from user where user_name like " + "'%"+Name+"%';";

			ResultSet rs = s.executeQuery(sql);

			while(rs.next()) {
				User user = new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_phone(rs.getString("user_phone"));
				user.setUser_password(rs.getString("user_password"));
				user.setActor(rs.getString("actor"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_bithday(rs.getString("user_bithday"));
				user.setUser_email(rs.getString("user_email"));
				users.add(user);
			}

			DBHelper.closeConnection(c, s, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	/*

	 * @author Hou

	 */
	public static List<User> getByBirthday(String birthday) {
		List<User> users = new ArrayList<User>();
		
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select * from user where user_bithday like " + "'%"+birthday+"%';";

			ResultSet rs = s.executeQuery(sql);

			while(rs.next()) {
				User user = new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_phone(rs.getString("user_phone"));
				user.setUser_password(rs.getString("user_password"));
				user.setActor(rs.getString("actor"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_bithday(rs.getString("user_bithday"));
				user.setUser_email(rs.getString("user_email"));
				users.add(user);
			}

			DBHelper.closeConnection(c, s, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	/*

	 * @author Hou

	 */
	public static List<User> getByEmail(String email) {
		List<User> users = new ArrayList<User>();
		
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select * from user where user_email like " + "'%"+email+"%';";

			ResultSet rs = s.executeQuery(sql);

			while(rs.next()) {
				User user = new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_phone(rs.getString("user_phone"));
				user.setUser_password(rs.getString("user_password"));
				user.setActor(rs.getString("actor"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_bithday(rs.getString("user_bithday"));
				user.setUser_email(rs.getString("user_email"));
				users.add(user);
			}

			DBHelper.closeConnection(c, s, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	/*

	 * @author Hou

	 */
	public static List<User> searchForKey(String key) {
		List<User> users = new ArrayList<User>();
		
		try {
			List<User> users1 = getByName(key);
			for(User u : users1){
				users.add(u);
			}
			users1 = getByPhone(key);
			for(User u : users1){
				users.add(u);
			}
			users1 = getByBirthday(key);
			for(User u : users1){
				users.add(u);
			}
			users1 = getByEmail(key);
			for(User u : users1){
				users.add(u);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	/*

	 * @author Hou 11.18

	 */

	public static List<User> list(int start, int count) {

		List<Admin> admins = new ArrayList<Admin>();
		List<User> users = new ArrayList<User>();



		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "select * from user limit ?,?";

			PreparedStatement ps = c.prepareStatement(sql);

			ps.setInt(1, start);

			ps.setInt(2, count);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				User user = new User();
				
				user.setUser_id(rs.getInt("user_id"));
				
				user.setUser_phone(rs.getString("user_phone"));
				
				user.setUser_password(rs.getString("user_password"));
				
				user.setActor(rs.getString("actor"));
				
				user.setUser_name(rs.getString("user_name"));
				
				user.setUser_bithday(rs.getString("user_bithday"));
				
				user.setUser_email(rs.getString("user_email"));

				users.add(user);

			}

			DBHelper.closeConnection(c, ps, rs);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return users;

	}
	/*
	 * author hou
	 */

	public static void add(User user) {



		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "insert into user(user_id,user_phone,user_password,actor,user_name,user_bithday,user_email) values(?,?,?,?,?,?,?)";

			PreparedStatement ps = c.prepareStatement(sql);

			ps.setInt(1, user.getUser_id());

			ps.setString(2, user.getUser_phone());
			
			ps.setString(3, user.getUser_password());

			ps.setString(4, user.getActor());

			ps.setString(5, user.getUser_name());

			ps.setString(6, user.getUser_bithday());
			
			ps.setString(7, user.getUser_email());

			ps.execute();

			DBHelper.closeConnection(c, ps, null);


		} catch (Exception e) {

			e.printStackTrace();

		}

	}
	/*

	 * @author hou

	 */

	public static void deleteById(String Id) {

		try {



			Connection c = DBHelper.getInstance().getConnection();



			Statement s = c.createStatement();



			String sql = "delete from user where user_id = " +"'"+Id+"';";



			s.execute(sql);



			DBHelper.closeConnection(c, s, null);



		} catch (Exception e) {

			e.printStackTrace();

		}

	}


}
