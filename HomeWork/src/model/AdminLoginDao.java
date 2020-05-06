/**
 * 
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Admin;;

/**
 * @author Lenovo
 *
 */
public class AdminLoginDao {
	
	public Admin login(Connection con,Admin admin) throws Exception{

		Admin resultAdmin = null;

		String sql = "select * from admin where admin_phone=? and admin_password=?";

		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, admin.getAdmin_phone());

		pstmt.setString(2, admin.getAdmin_password());

		ResultSet rs =  pstmt.executeQuery();

		if (rs.next()) {

			resultAdmin  = new Admin ();

			resultAdmin .setAdmin_phone(rs.getString("admin_phone"));

			resultAdmin .setAdmin_password(rs.getString("admin_password"));
		}

		return resultAdmin;

	}
	/*

	 * @author Hou

	 */
	public static Admin getByPhone(String phone) {

		Admin admin = new Admin();

		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select * from admin where admin_phone = " + "'"+phone+"'";

			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {

				admin.setAdmin_id(rs.getInt("admin_id"));
				
				admin.setAdmin_phone(rs.getString("admin_phone"));
				
				admin.setAdmin_password(rs.getString("admin_password"));
				
				admin.setAdmin_name(rs.getString("admin_name"));
				
				admin.setActor(rs.getString("actor"));

			}

			DBHelper.closeConnection(c, s, rs);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return admin;

	}
	/*

	 * @author Hou

	 */

	public static List<Admin> list(int start, int count) {

		List<Admin> admins = new ArrayList<Admin>();



		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "select * from admin limit ?,?";

			PreparedStatement ps = c.prepareStatement(sql);

			ps.setInt(1, start);

			ps.setInt(2, count);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Admin admin = new Admin();
				
				admin.setAdmin_id(rs.getInt("admin_id"));
				
				admin.setAdmin_phone(rs.getString("admin_phone"));
				
				admin.setAdmin_password(rs.getString("admin_password"));
				
				admin.setAdmin_name(rs.getString("admin_name"));
				
				admin.setActor(rs.getString("actor"));

				admins.add(admin);

			}

			DBHelper.closeConnection(c, ps, rs);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return admins;

	}
	
	/*

	 * @author Hou

	 */
	public static void update(Admin admin) {

		try {



			Connection c = DBHelper.getInstance().getConnection();



			String sql = "update admin set admin_name=?,admin_phone=? ,admin_password = ?,actor=? where admin_id = ?";

			

			PreparedStatement ps = c.prepareStatement(sql);

			ps.setString(1, admin.getAdmin_name());
			
			ps.setString(2, admin.getAdmin_phone());
			
			ps.setString(3, admin.getAdmin_password());
			
			ps.setString(4, admin.getActor());
			
			ps.setInt(5, admin.getAdmin_id());
			
			ps.execute();

			DBHelper.closeConnection(c, ps, null);



		} catch (Exception e) {

			e.printStackTrace();

		}

	}
	
	/*

	 * @author Hou

	 */
	public static List<Admin> getById(String Id) {
		List<Admin> admins = new ArrayList<Admin>();
		
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select * from admin where admin_id like " + "'%"+Id+"%';";

			ResultSet rs = s.executeQuery(sql);

			while(rs.next()) {
				Admin admin = new Admin();
				admin.setAdmin_id(rs.getInt("admin_id"));
				admin.setAdmin_name(rs.getString("admin_name"));
				admin.setAdmin_password(rs.getString("admin_password"));
				admin.setAdmin_phone(rs.getString("admin_phone"));
				admin.setActor(rs.getString("actor"));
				admins.add(admin);
			}

			DBHelper.closeConnection(c, s, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return admins;
	}
	/*

	 * @author Hou

	 */
	public static List<Admin> getByName(String Name) {
		List<Admin> admins = new ArrayList<Admin>();
		
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select * from admin where admin_name like " + "'%"+Name+"%';";

			ResultSet rs = s.executeQuery(sql);

			while(rs.next()) {
				Admin admin = new Admin();
				admin.setAdmin_id(rs.getInt("admin_id"));
				admin.setAdmin_name(rs.getString("admin_name"));
				admin.setAdmin_password(rs.getString("admin_password"));
				admin.setAdmin_phone(rs.getString("admin_phone"));
				admin.setActor(rs.getString("actor"));
				admins.add(admin);
			}

			DBHelper.closeConnection(c, s, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return admins;
	}
	/*

	 * @author Hou

	 */
	public static List<Admin> sgetByPhone(String Phone) {
		List<Admin> admins = new ArrayList<Admin>();
		
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select * from admin where admin_phone like " + "'%"+Phone+"%';";

			ResultSet rs = s.executeQuery(sql);

			while(rs.next()) {
				Admin admin = new Admin();
				admin.setAdmin_id(rs.getInt("admin_id"));
				admin.setAdmin_name(rs.getString("admin_name"));
				admin.setAdmin_password(rs.getString("admin_password"));
				admin.setAdmin_phone(rs.getString("admin_phone"));
				admin.setActor(rs.getString("actor"));
				admins.add(admin);
			}

			DBHelper.closeConnection(c, s, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return admins;
	}

	/*

	 * @author Hou

	 */
	public static List<Admin> searchForKey(String key) {
		List<Admin> admins = new ArrayList<Admin>();
		
		try {
			List<Admin> admins1 = getByName(key);
			for(Admin a : admins1){
				admins.add(a);
			}
			admins1 = sgetByPhone(key);
			for(Admin a : admins1){
				admins.add(a);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return admins;
	}

}
