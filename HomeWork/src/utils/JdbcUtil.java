package utils;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

import java.sql.DriverManager;

public class JdbcUtil {

	static{
		try {
		Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
		e.printStackTrace();
		}
		}
		public static Connection getConnection() throws SQLException{
		String dbUrl="jdbc:mysql://localhost:3306/lhh?useUnicode=true&characterEncoding=UTF-8";
		String dbUser="root";
		String dbPassword="root";
		return DriverManager.getConnection(dbUrl,dbUser,dbPassword);
		
		}

		public static void close(Statement stmt,Connection conn) throws SQLException{
		stmt.close();
		conn.close();
		}
}
